package com.example.consumingsoapwebservices;

import correio.wsdl.CServico;
import correio.wsdl.CalcPrecoPrazo;
import correio.wsdl.CalcPrecoPrazoResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import java.math.BigDecimal;
import java.util.List;

public class CorreioClient extends WebServiceGatewaySupport {

    private final String URL_CORREIOS = "http://ws.correios.com.br/calculador/CalcPrecoPrazo.asmx";

    public CalcPrecoPrazoResponse calcula() {
        CalcPrecoPrazoResponse c =  (CalcPrecoPrazoResponse) getWebServiceTemplate()
                    .marshalSendAndReceive(getRequestParams(), new SoapActionCallback("http://tempuri.org/CalcPrecoPrazo"));

        List<CServico> cServico = c.getCalcPrecoPrazoResult().getServicos().getCServico();
        cServico.forEach(s-> System.out.println(s.getCodigo()));
        System.out.println(c.getCalcPrecoPrazoResult().getServicos().getCServico());
        return c;
    }

    private CalcPrecoPrazo getRequestParams(){
        CalcPrecoPrazo params =  new CalcPrecoPrazo();
        params.setNCdEmpresa("17251184");
        params.setSDsSenha("1767");
        params.setNCdServico("04170");
        params.setSCepOrigem("86610000");
        params.setSCepDestino("05568010");
        params.setNVlPeso("0.100");
        params.setNCdFormato(1);
        params.setNVlComprimento(new BigDecimal(16));
        params.setNVlAltura(new BigDecimal(10));
        params.setNVlLargura(new BigDecimal(18));
        params.setNVlDiametro(new BigDecimal(1));
        params.setSCdMaoPropria("N");
        params.setNVlValorDeclarado(new BigDecimal(20));
        params.setSCdAvisoRecebimento("N");
        return params;
    }
}
