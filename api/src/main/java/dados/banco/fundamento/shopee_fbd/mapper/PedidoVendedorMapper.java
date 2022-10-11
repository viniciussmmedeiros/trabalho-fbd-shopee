package dados.banco.fundamento.shopee_fbd.mapper;

import dados.banco.fundamento.shopee_fbd.controller.response.VendedorPedidoResponse;

import java.sql.Timestamp;

public class PedidoVendedorMapper {
    public static VendedorPedidoResponse toResponse(Object[] entity) {
        return VendedorPedidoResponse.builder()
                .dataRealizacao((Timestamp) entity[0])
                .nomeProduto((String) entity[1])
                .imagemUrl((String) entity[2])
                .nomeTransportadora((String) entity[3])
                .nomeCliente((String) entity[4])
                .build();
    }
}
