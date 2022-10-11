package dados.banco.fundamento.shopee_fbd.mapper;

import dados.banco.fundamento.shopee_fbd.controller.response.ClienteCartaoResponse;

import java.util.Date;

public class ClienteCartaoMapper {
    public static ClienteCartaoResponse toResponse(Object[] entity) {
        return ClienteCartaoResponse.builder()
                .id((int) entity[0])
                .nome((String) entity[1])
                .numero((String) entity[2])
                .dataVencimento((Date) entity[3])
                .cvv((String) entity[4])
                .build();
    }
}
