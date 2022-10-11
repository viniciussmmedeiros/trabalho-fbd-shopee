package dados.banco.fundamento.shopee_fbd.mapper;

import dados.banco.fundamento.shopee_fbd.controller.response.CupomResponse;

import java.math.BigDecimal;

public class CupomMapper {
    public static CupomResponse toResponse(Object[] entity) {
        return CupomResponse.builder()
                .id((int) entity[0])
                .codigo((String) entity[1])
                .porcentagem((BigDecimal) entity[2])
                .build();
    }
}
