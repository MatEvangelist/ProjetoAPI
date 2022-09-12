package steps;

import api.ApiParams;
import api.ApiRequest;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.bs.A;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import utils.PropertiesUtils;

public class CorreiosSteps extends ApiRequest {

    PropertiesUtils propertiesUtils = new PropertiesUtils();
    ApiParams apiParams = new ApiParams();

    @Dado("que possou um token valido")
    public void que_possou_um_token_valido() {
        System.out.println("API não requer token");
    }
    @Quando("envio um request com dados validos")
    public void envio_um_request_com_dados_validos() {
        super.url = propertiesUtils.getProp("url_correios");
        super.params = apiParams.correiosParams();
        super.GET();
    }
    @Então("o valor do frete deve ser calculado")
    public void o_valor_do_frete_deve_ser_calculado() {
        Assert.assertTrue(Float.parseFloat(response.xmlPath().getString("Servicos.cServico.Valor").replace(",", ".")) > 0);
    }
    @Então("o status code deve ser {int}")
    public void o_status_code_deve_ser(int statusCodeEsperado) {
        Assert.assertEquals("Status code diferente do esperado", statusCodeEsperado, response.statusCode());

    }

    @Quando("envio um request com dados validos datatable")
    public void envioUmRequestComDadosValidosDatatable(DataTable dataTable) {
        super.url = propertiesUtils.getProp("url_correios");
        super.params = apiParams.setDataParams(dataTable.asMaps().get(0)); //pegar os valores da primeira linha de valores na datatable
        super.GET();
    }

    @Então("o valor do frete deve ser {string}")
    public void oValorDoFreteDeveSer(String valorEsperado) {
        Assert.assertEquals(valorEsperado, response.xmlPath().getString("Servicos.cServico.Valor"));

    }

    @Quando("envio um request com dados {string}, {string}")
    public void envioUmRequestComDados(String cepOrigem, String cepDestino) {
        super.url = propertiesUtils.getProp("url_correios");
        super.params = apiParams.correiosParams();
        super.params.put("sCepOrigem", cepOrigem);
        super.params.put("sCepDestino", cepDestino);
        super.GET();
    }

    @Então("deve ser exibida a mensagem {string}")
    public void deveSerExibidaAMensagem(String mensagemEsperada) {
        Assert.assertEquals(mensagemEsperada, response.xmlPath().getString("Servicos.cServico.MsgErro"));
    }
}
