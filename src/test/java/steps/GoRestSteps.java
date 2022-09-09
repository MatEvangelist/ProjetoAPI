package steps;

import api.ApiHeaders;
import api.ApiRequest;

import com.github.javafaker.Faker;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.json.JSONException;

import org.junit.Assert;
import utils.JsonUtils;
import utils.PropertiesUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class GoRestSteps extends ApiRequest {

    PropertiesUtils properties = new PropertiesUtils();
    JsonUtils jsonUtils = new JsonUtils();
    ApiHeaders apiHeaders = new ApiHeaders();
    Faker faker = new Faker();
    Map<String, String> jsonValues = new HashMap<>();

    @Dado("que possuo um token valido")
    public void que_possuo_um_token_valido() {
        super.token = properties.getProp("token_gorest");
    }

    @Quando("envio um request de cadastro de usuario com dados validos")
    public void envio_um_request_de_cadastro_de_usuario_com_dados_validos() throws IOException, JSONException {
        super.url = properties.getProp("url_gorest");
        super.headers = apiHeaders.goRestHeaders(super.token);
        super.body = jsonUtils.setJsonValues(jsonUtils.parseJSONFile("create_user"), setValues());
//        super.body = jsonUtils.updateJSON(
//                jsonUtils.parseJSONFile("create_user"), "email", faker.internet().emailAddress());
//        super.body.put("email", faker.internet().emailAddress());
        super.POST();
    }

    private Map<String, String> setValues() {
        jsonValues.put("email", faker.internet().emailAddress());
        jsonValues.put("name", faker.name().fullName());
        jsonValues.put("gender", "Female");
        jsonValues.put("status", "Inactive");
        return  jsonValues;
    }

    @Então("o usuario deve ser criado corretamente")
    public void o_usuario_deve_ser_criado_corretamente() {
        assertEquals(super.body.getString("email"), super.response.jsonPath().getString("data.email"));
        assertEquals(super.body.getString("name"), super.response.jsonPath().getString("data.name"));
    }

    @Então("o status code do request deve ser {int}")
    public void o_status_code_do_request_deve_ser(int statusCode) {
        assertEquals("Status code diferente do esperado!", statusCode, super.response.statusCode());
    }
}
