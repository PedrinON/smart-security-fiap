package services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import com.networknt.schema.ValidationMessage;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.CadastroUsuarioModel;
import net.minidev.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Set;

import static io.restassured.RestAssured.given;

public class CadastroUsuarioService {

    final CadastroUsuarioModel cadastroUsuarioModel = new CadastroUsuarioModel();
    public final Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create();
    public Response response;
    String baseUrl = "http://localhost:8080";
    String schemasPath = "src/main/resources/schemas/";
    JSONObject jsonSchema;
    private final ObjectMapper mapper = new ObjectMapper();

    public void setFieldsDelivery(String field, String value) {
        switch (field) {
            case "idUsuario" -> cadastroUsuarioModel.setIdUsuario(Long.parseLong(value));
            case "nome" -> cadastroUsuarioModel.setNome(value);
            case "email" -> cadastroUsuarioModel.setEmail(value);
            case "senha" -> cadastroUsuarioModel.setSenha(value);
            case "role" -> cadastroUsuarioModel.setRole(value);
            default -> throw new IllegalStateException("Unexpected feld" + field);
        }
    }

    public void createDelivery(String endPoint) {
        String url = baseUrl + endPoint;
        String bodyToSend = gson.toJson(cadastroUsuarioModel);
        response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(bodyToSend)
                .when()
                .post(url)
                .then()
                .extract()
                .response();
    }

    private JSONObject loadJsonFromFile(String filePath) throws IOException {
        try (InputStream inputStream = Files.newInputStream(Paths.get(filePath))) {
            JSONTokener tokener = new JSONTokener(inputStream.toString());
            return new JSONObject((Map<String, ?>) tokener);
        }
    }
    public void setContract(String contract) throws IOException {
        switch (contract) {
            case "Cadastro bem-sucedido do usuario" -> jsonSchema = loadJsonFromFile(schemasPath + "cadastro-bem-sucedido-do-usuario.json");
            default -> throw new IllegalStateException("Unexpected contract" + contract);
        }
    }
    public Set<ValidationMessage> validateResponseAgainstSchema() throws IOException
    {
        JSONObject jsonResponse = new JSONObject(Integer.parseInt(response.getBody().asString()));
        JsonSchemaFactory schemaFactory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V4);
        JsonSchema schema = schemaFactory.getSchema(jsonSchema.toString());
        JsonNode jsonResponseNode = mapper.readTree(jsonResponse.toString());
        Set<ValidationMessage> schemaValidationErrors = schema.validate(jsonResponseNode);
        return schemaValidationErrors;
    }
}
