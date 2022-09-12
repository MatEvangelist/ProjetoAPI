package steps;

import api.ApiHeaders;
import api.ApiRequest;

import com.github.javafaker.Faker;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import io.cucumber.messages.internal.com.google.gson.Gson;
import org.json.JSONException;

import org.json.JSONObject;
import user.Users;
import user.UsersGettersAndSetters;
import user.UsersLombok;
import user.UsersRecord;
import utils.JsonUtils;
import utils.PropertiesUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GoRestSteps extends ApiRequest {

    PropertiesUtils properties = new PropertiesUtils();
    JsonUtils jsonUtils = new JsonUtils();
    ApiHeaders apiHeaders = new ApiHeaders();
    Faker faker = new Faker();
    Map<String, String> jsonValues = new HashMap<>();
    UsersLombok userRequest, userResponse;

    @Dado("que possuo um token valido")
    public void que_possuo_um_token_valido() {
        super.token = properties.getProp("token_gorest");
    }


    /*
    Step com a geração do body da requisição a partir de um arquivo do tipo Json
     */
//    @Quando("envio um request de cadastro de usuario com dados validos")
//    public void envio_um_request_de_cadastro_de_usuario_com_dados_validos() throws IOException, JSONException {
//        super.url = properties.getProp("url_gorest");
//        super.headers = apiHeaders.goRestHeaders(super.token);
//        super.body = jsonUtils.setJsonValues(jsonUtils.parseJSONFile("create_user"), setValues());
////        super.body = jsonUtils.updateJSON(
////                jsonUtils.parseJSONFile("create_user"), "email", faker.internet().emailAddress());
////        super.body.put("email", faker.internet().emailAddress());
//        super.POST();
//    }

//    private Map<String, String> setValues() {
//        jsonValues.put("email", faker.internet().emailAddress());
//        jsonValues.put("name", faker.name().fullName());
//        jsonValues.put("gender", "Female");
//        jsonValues.put("status", "Inactive");
//        return  jsonValues;
//    }


    /*
    Step com a geração do body a partir de um objeto usando o construtor de uma classe Java
     */
//    @Quando("envio um request de cadastro de usuario com dados validos")
//    public void envio_um_request_de_cadastro_de_usuario_com_dados_validos() throws IOException, JSONException {
//        super.url = properties.getProp("url_gorest");
//        super.headers = apiHeaders.goRestHeaders(super.token);
//        super.body = new UsersConstructor(faker.internet().emailAddress(), "Female", faker.funnyName().name(), "active").getJson();
//        super.POST();
//    }

    /*
    Step com a geração do body a partir de um objeto usando os setters de uma classe Java
     */
//    @Quando("envio um request de cadastro de usuario com dados validos")
//    public void envio_um_request_de_cadastro_de_usuario_com_dados_validos() throws IOException, JSONException {
//        super.url = properties.getProp("url_gorest");
//        super.headers = apiHeaders.goRestHeaders(super.token);
//        UsersGettersAndSetters usersGettersAndSetters = new UsersGettersAndSetters();
//        usersGettersAndSetters.setEmail(faker.internet().emailAddress());
//        usersGettersAndSetters.setGender("Male");
//        usersGettersAndSetters.setName(faker.name().fullName());
//        usersGettersAndSetters.setStatus("Inactive");
//        body = usersGettersAndSetters.getJson();
//        super.POST();
//    }

    /*
    Step com a geração do body usando os builders do Lombok
     */
//    @Quando("envio um request de cadastro de usuario com dados validos")
//    public void envio_um_request_de_cadastro_de_usuario_com_dados_validos() throws IOException, JSONException {
//        super.url = properties.getProp("url_gorest");
//        super.headers = apiHeaders.goRestHeaders(super.token);
//        body = new JSONObject(new Gson().toJson(UsersLombok.builder()
//                .email(faker.internet().emailAddress())
//                .gender("Female")
//                .name(faker.name().fullName())
//                .status("Active")
//                .build()));
//        super.POST();
//    }

    /*
    Step com a geração do body usando os builders do Lombok com valores default de inicialização
    */
//    @Quando("envio um request de cadastro de usuario com dados validos")
//    public void envio_um_request_de_cadastro_de_usuario_com_dados_validos() throws IOException, JSONException {
//        super.url = properties.getProp("url_gorest");
//        super.headers = apiHeaders.goRestHeaders(super.token);
//        body = new JSONObject(new Gson().toJson(UsersLombok.builder().build()));
//        super.POST();
//    }

    /*
    Step com a geração do body usando a classe record do Java (só funciona na SDK 15 ou superiores)
     */
//    @Quando("envio um request de cadastro de usuario com dados validos")
//    public void envio_um_request_de_cadastro_de_usuario_com_dados_validos() throws IOException, JSONException {
//        super.url = properties.getProp("url_gorest");
//        super.headers = apiHeaders.goRestHeaders(super.token);
//        super.body = new UsersRecord(
//                faker.internet().emailAddress(),
//                faker.funnyName().name(),
//                "Male",
//                "Active").getJson();
//        super.POST();
//    }

    /*
    Step com a geração do body como XML usando a classe record do Java (só funciona na SDK 15 ou superiores)
     */
//    @Quando("envio um request de cadastro de usuario com dados validos")
//    public void envio_um_request_de_cadastro_de_usuario_com_dados_validos() throws IOException, JSONException {
//        super.url = properties.getProp("url_gorest");
//        super.headers = apiHeaders.goRestHeaders(super.token);
//        String xmlBody = new UsersRecord(
//                faker.internet().emailAddress(),
//                faker.funnyName().name(),
//                "Male",
//                "Active").getXML();
//        System.out.println(xmlBody);
//
//        super.POST();
//    }

    /*
    Step com a geração do body como XML usando o Lombok
     */
//    @Quando("envio um request de cadastro de usuario com dados validos")
//    public void envio_um_request_de_cadastro_de_usuario_com_dados_validos() throws IOException, JSONException {
//        super.url = properties.getProp("url_gorest");
//        super.headers = apiHeaders.goRestHeaders(super.token);
//
//        UsersLombok user = UsersLombok.builder().build();
//        super.body = user.getJson();
//        String xml = user.getXML();
//        System.out.println(body);
//        System.out.println(xml);
//
//        super.POST();
//    }

    @Quando("envio um request de cadastro de usuario com dados validos")
    public void envio_um_request_de_cadastro_de_usuario_com_dados_validos() {
        super.url = properties.getProp("url_gorest");
        super.headers = apiHeaders.goRestHeaders(super.token);
        userRequest = UsersLombok.builder().build();
        super.body = userRequest.getJson();

        super.POST();
    }

//    @Então("o usuario deve ser criado corretamente")
//    public void o_usuario_deve_ser_criado_corretamente() {
//        assertEquals(super.body.getString("email"), super.response.jsonPath().getString("data.email"));
//        assertEquals(super.body.getString("name"), super.response.jsonPath().getString("data.name"));
//        assertEquals(super.body.getString("name"), super.response.jsonPath().getString("data.gender"));
//        assertEquals(super.body.getString("name"), super.response.jsonPath().getString("data.status"));
//        assertTrue(super.body.getString("name").equalsIgnoreCase("data.name"));
//    }

    /*
    Comparação de objetos
     */
    @Então("o usuario deve ser criado corretamente")
    public void o_usuario_deve_ser_criado_corretamente() {
        userResponse = response.jsonPath().getObject("data", UsersLombok.class);
        assertEquals(userRequest, userResponse);
    }

    @Então("o status code do request deve ser {int}")
    public void o_status_code_do_request_deve_ser(int statusCode) {
        assertEquals("Status code diferente do esperado!", statusCode, super.response.statusCode());
    }
}
