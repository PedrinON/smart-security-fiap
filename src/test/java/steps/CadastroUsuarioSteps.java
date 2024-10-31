package steps;

import com.networknt.schema.ValidationMessage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Quando;
import io.cucumber.java.pt.Então;
import model.ErrorMessageModel;
import org.junit.Assert;
import services.CadastroUsuarioService;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CadastroUsuarioSteps {

    CadastroUsuarioService cadastroUsuarioService = new CadastroUsuarioService();

    @Dado("que eu tenha os seguintes dados da entrega:")
    public void queEuTenhaOsSeguintesDadosDaEntrega(List<Map<String, String>> rows) {
        for(Map<String, String> columns : rows) {
            cadastroUsuarioService.setFieldsDelivery(columns.get("campo"),  columns.get("valor"));
        }
    }

    @Quando("eu enviar a requisição para o endpoint {string} de cadastro de entregas")
    public void euEnviarARequisicaoParaOEndpointDeCadastroDeEntregas(String endPoint) {
        cadastroUsuarioService.createDelivery(endPoint);
    }

    @Então("o status code da resposta deve ser {int}")
    public void oStatusDaRespostaDeveSer(int statusCode) {
        Assert.assertEquals(statusCode, cadastroUsuarioService.response.statusCode());
    }

    @E("o corpo de resposta de erro da api deve retornar a mensagem {string}")
    public void oCorpoDeRespostaDeErroDaApiDeveRetornarAMensagem(String message) {
        ErrorMessageModel errorMessageModel = cadastroUsuarioService.gson.fromJson(
                cadastroUsuarioService.response.jsonPath().prettify(), ErrorMessageModel.class);
        Assert.assertEquals(message, errorMessageModel.getMessage());
    }

    @E("que o arquivo de contrato esperado é o {string}")
    public void queOArquivoDeContratoEsperadoEO(String contract) throws IOException {
        cadastroUsuarioService.setContract(contract);
    }

    @Então("a resposta da requisição deve estar em conformidade com o contrato selecionado")
    public void aRespostaDaRequisicaoDeveEstarEmConformidadeComOContratoSelecionado() throws IOException {
        Set<ValidationMessage> validateResponse = cadastroUsuarioService.validateResponseAgainstSchema();
        Assert.assertTrue("O contrato está inválido. Erros encontrados: " + validateResponse, validateResponse.isEmpty());
    }
}
