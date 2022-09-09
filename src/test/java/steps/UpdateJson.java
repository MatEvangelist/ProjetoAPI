package steps;

import org.json.JSONObject;
import org.junit.Test;
import utils.JsonUtils;

import java.io.IOException;

public class UpdateJson {

    JsonUtils jsonUtils = new JsonUtils();

    @Test
    public void updateJson() throws IOException {
        JSONObject jsonObject = jsonUtils.parseJSONFile("json_update");
        System.out.println(jsonUtils.updateJSON(jsonObject, "type", "999"));
    }

}
