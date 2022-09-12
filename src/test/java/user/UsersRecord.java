package user;

import io.cucumber.messages.internal.com.google.gson.Gson;
import org.json.JSONObject;
import org.json.XML;

/*
    record é um tipo de classe que só funciona a partir da versão 14 do Java,
    ele funciona como o lombok gerando construtores e getters  e porém
    deixando implícita no código. Um malefício é o fato de que os atributos
    são todos final e portanto não é possível utilizar os setters para
    alteração.
 */
public record UsersRecord(String email,
                          String name,
                          String gender,
                          String status)  {

    public JSONObject getJson() {
        return new JSONObject(new Gson().toJson(this));
    }

    public String getXML() {
        return XML.toString(getJson());
    }
}
