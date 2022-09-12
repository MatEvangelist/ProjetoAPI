package user;

import io.cucumber.messages.internal.com.google.gson.Gson;
import org.json.JSONObject;
import org.json.XML;

public class Users {

    public JSONObject getJson() {
        return new JSONObject(new Gson().toJson(this));
    }

    public String getXML() {
        return XML.toString(getJson());
    }
}
