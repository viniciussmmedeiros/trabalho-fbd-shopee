package dados.banco.fundamento.shopee_fbd.controller.request;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PedidoRequest {
    private Timestamp dataRealizacao;
    private int idCliente;
    private int idTransportadora;
    private int idEndereco;
    private int idCartaoCredito;
    private List<Integer> produtos = new ArrayList<Integer>();;
}
