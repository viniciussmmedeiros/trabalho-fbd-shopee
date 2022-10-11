package dados.banco.fundamento.shopee_fbd.controller.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VendedorPedidoResponse {
    private Timestamp dataRealizacao;
    private String nomeProduto;
    private String imagemUrl;
    private String nomeTransportadora;
    private String nomeCliente;
}
