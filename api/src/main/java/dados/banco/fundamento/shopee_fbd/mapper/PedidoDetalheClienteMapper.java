package dados.banco.fundamento.shopee_fbd.mapper;

import dados.banco.fundamento.shopee_fbd.controller.response.PedidoDetalheResponse;

import java.math.BigDecimal;

public class PedidoDetalheClienteMapper {
    public static PedidoDetalheResponse toResponse(Object[] entity) {
        return PedidoDetalheResponse.builder()
                .id((int) entity[0])
                .nomeVendedor((String) entity[1])
                .imagemUrl((String) entity[2])
                .nomeProduto((String) entity[3])
                .preco((BigDecimal) entity[4])
                .build();
    }
}
