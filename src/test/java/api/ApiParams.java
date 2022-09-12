package api;

import java.util.HashMap;
import java.util.Map;

public class ApiParams {

    Map<String, String> params = new HashMap<>();

    public Map<String, String> correiosParams() {
        params.put("StrRetorno", "xml");
        params.put("nCdServico", "04510");
        params.put("sCepOrigem", "74371520");
        params.put("sCepDestino", "13175613");
        params.put("nVlPeso", "1.00");
        params.put("nVlComprimento", "36.00");
        params.put("nVlAltura", "18.00");
        params.put("nVlLargura", "12.00");
        return params;
    }

    public Map<String, String> setDataParams(Map<String, String> map) {
        params.clear();
        params.put("StrRetorno", "xml");
        params.put("nCdServico", "04510");

//        for (Map.Entry<String, String> e : map.entrySet()) {
//            params.put(e.getKey(), e.getValue());
//        }

        map.entrySet().stream().forEach(e -> params.put(e.getKey(), e.getValue()));
        return params;
    }
}
