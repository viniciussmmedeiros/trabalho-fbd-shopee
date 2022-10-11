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
public class PedidoClienteResponse {
    private int id;
    private Timestamp dataRealizacao;
    private String nomeTransportadora;
    private String logradouro;
    private int numero;
    private String cidade;
    private String uf;
    private String complemento;
    private String nomeCartao;
    private String numeroCartao;
}
