package api;

import io.restassured.response.Response;
import org.json.JSONObject;
import utils.LogUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class ApiUtils extends LogUtils {

    protected Response response;
    protected JSONObject body;
    protected String url;
    protected Map<String, String> headers = new HashMap<>();
    protected Map<String, String> params = new HashMap<>();
    protected String token;

    public void log(String verbo) {
        super.logInfo("****** Dados Enviados no Request ******");
        super.logInfo(verbo + " " + url);
        super.logInfo("Body: \n" + body);
        super.logInfo("Headers: " + headers);
        super.logInfo("Params: " + params);

        super.logInfo("*********** Dados Recebidos ***********");
        super.logInfo("Status code: " + response.getStatusCode());
        super.logInfo("Payload recebido: \n" + response.asPrettyString());
        super.logInfo("Tempo de resposta: " + response.timeIn(TimeUnit.MILLISECONDS));
    }
}
