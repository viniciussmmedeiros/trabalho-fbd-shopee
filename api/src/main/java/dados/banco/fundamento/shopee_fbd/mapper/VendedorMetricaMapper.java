package dados.banco.fundamento.shopee_fbd.mapper;

import dados.banco.fundamento.shopee_fbd.controller.response.VendedorMetricaResponse;

import java.math.BigDecimal;
import java.math.BigInteger;

public class VendedorMetricaMapper {
    public static VendedorMetricaResponse toResponse(Object[] entity) {
        return VendedorMetricaResponse.builder()
                .quantidadeVendas((BigInteger) entity[0])
                .valorTotal((BigDecimal) entity[1])
                .build();
    }
}
