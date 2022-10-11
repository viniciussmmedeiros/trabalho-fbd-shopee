package dados.banco.fundamento.shopee_fbd.mapper;

import dados.banco.fundamento.shopee_fbd.controller.response.DetalheCarrinhoResponse;

import java.math.BigDecimal;
import java.math.BigInteger;

public class DetalheCarrinhoMapper {
    public static DetalheCarrinhoResponse toResponse(Object[] entity) {
        return DetalheCarrinhoResponse.builder()
                .quantidade((BigInteger) entity[0])
                .valorTotal((BigDecimal) entity[1])
                .build();
    }
}
