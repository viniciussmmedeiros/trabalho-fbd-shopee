package dados.banco.fundamento.shopee_fbd.mapper;

import dados.banco.fundamento.shopee_fbd.controller.response.EnderecoResponse;

public class EnderecoMapper {
    public static EnderecoResponse toResponse(Object[] entity) {
        return EnderecoResponse.builder()
                .id((int) entity[0])
                .logradouro((String) entity[1])
                .numero((int) entity[2])
                .cidade((String) entity[3])
                .uf((String) entity[4])
                .complemento((String) entity[5])
                .build();
    }
}
