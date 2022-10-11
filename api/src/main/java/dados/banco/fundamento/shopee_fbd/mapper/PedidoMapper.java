package dados.banco.fundamento.shopee_fbd.mapper;

import dados.banco.fundamento.shopee_fbd.controller.request.PedidoRequest;
import dados.banco.fundamento.shopee_fbd.domain.Pedido;

public class PedidoMapper {
    public static Pedido toEntity(PedidoRequest request) {
        Pedido pedido = new Pedido();
        pedido.setDataRealizacao(request.getDataRealizacao());
        pedido.setIdCliente(request.getIdCliente());
        pedido.setIdTransportadora(request.getIdTransportadora());
        pedido.setIdCartaoCredito(request.getIdCartaoCredito());
        pedido.setIdEndereco(request.getIdEndereco());

        return pedido;
    }
}
