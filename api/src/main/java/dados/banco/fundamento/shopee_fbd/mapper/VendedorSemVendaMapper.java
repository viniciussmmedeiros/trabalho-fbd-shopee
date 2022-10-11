package dados.banco.fundamento.shopee_fbd.mapper;

import dados.banco.fundamento.shopee_fbd.controller.response.VendedorSemVendaResponse;

public class VendedorSemVendaMapper {

    public static VendedorSemVendaResponse toResponse(Object[] entity) {
        return VendedorSemVendaResponse.builder()
                .idVendedor((int) entity[0])
                .nome((String) entity[1])
                .email((String) entity[2])
                .build();
    }
}
