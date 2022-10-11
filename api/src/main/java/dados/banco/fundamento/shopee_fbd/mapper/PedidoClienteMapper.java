package dados.banco.fundamento.shopee_fbd.mapper;

import dados.banco.fundamento.shopee_fbd.controller.response.PedidoClienteResponse;

import java.sql.Timestamp;

public class PedidoClienteMapper {
    public static PedidoClienteResponse toResponse(Object[] entity) {
        return PedidoClienteResponse.builder()
                .id((int) entity[0])
                .dataRealizacao((Timestamp) entity[1])
                .nomeTransportadora((String) entity[2])
                .logradouro((String) entity[3])
                .numero((int) entity[4])
                .cidade((String) entity[5])
                .uf((String) entity[6])
                .complemento((String) entity[7])
                .nomeCartao((String) entity[8])
                .numeroCartao((String) entity[9])
                .build();
    }
}
