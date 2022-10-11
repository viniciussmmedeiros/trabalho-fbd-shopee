package dados.banco.fundamento.shopee_fbd.mapper;

import dados.banco.fundamento.shopee_fbd.controller.response.AvaliacaoResponse;

import java.math.BigDecimal;

public class AvaliacaoMapper {

    public static AvaliacaoResponse toResponse(Object[] entity) {
        return AvaliacaoResponse.builder()
                .id((int) entity[0])
                .nota((BigDecimal) entity[1])
                .imagemUrl((String) entity[2])
                .comentario((String) entity[3])
                .build();
    }
}
