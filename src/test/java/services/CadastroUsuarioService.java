package services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.CadastroUsuarioModel;

import static io.restassured.RestAssured.given;

public class CadastroUsuarioService {

    final CadastroUsuarioModel cadastroUsuarioModel = new CadastroUsuarioModel();
    public final Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create();
    public Response response;
    String baseUrl = "http://localhost:8080";

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
}
