package utils;

import io.cucumber.messages.internal.com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Map;

public class JsonUtils {

    public JSONObject parseJSONFile(String jsonFile) throws IOException, JSONException {
        String content = new String(Files.readAllBytes(Paths.get("src/test/resources/jsons/" + jsonFile + ".json")));
        return new JSONObject(content);
    }

    public JSONObject updateJSON(JSONObject object, String keyMain, String newValue) {
        Iterator iterator = object.keys();
        String key = null;
        while (iterator.hasNext()) {
            key = (String) iterator.next();

            if ((object.optJSONArray(key) == null) && (object.optJSONObject(key) == null)) {
                if (key.equals(keyMain)) {
                    object.put(key, newValue);
                    return object;
                }
            }

            if (object.optJSONObject(key) != null) {
                updateJSON(object.getJSONObject(key), keyMain, newValue);
            }

            if (object.optJSONArray(key) != null) {
                JSONArray jsonArray = object.getJSONArray(key);
                for (int i = 0; i < jsonArray.length(); i++) {
                    updateJSON(jsonArray.getJSONObject(i), keyMain, newValue);
                }
            }
        }

        return object;
    }

    public JSONObject setJsonValues(JSONObject jsonObject, Map<String, String> values) {
        JSONObject newJson = null;
        for (Map.Entry<String, String> entry: values.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            try {
                newJson = updateJSON(jsonObject, key, value);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return newJson;
    }

}
