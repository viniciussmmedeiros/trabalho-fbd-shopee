package dados.banco.fundamento.shopee_fbd.mapper;

import dados.banco.fundamento.shopee_fbd.controller.response.TransportadoraResponse;

public class TransportadoraMapper {
    public static TransportadoraResponse toResponse(Object[] entity) {
        return TransportadoraResponse.builder()
                .id((int) entity[0])
                .nome((String) entity[1])
                .build();
    }
}
