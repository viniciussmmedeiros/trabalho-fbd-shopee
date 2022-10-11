package dados.banco.fundamento.shopee_fbd.mapper;

import dados.banco.fundamento.shopee_fbd.controller.response.ClienteParaAdminResponse;

public class ClienteParaAdminMapper {
    public static ClienteParaAdminResponse toResponse(Object[] entity) {
        return ClienteParaAdminResponse.builder()
                .id((int) entity[0])
                .nome((String) entity[1])
                .email((String) entity[2])
                .build();
    }
}
