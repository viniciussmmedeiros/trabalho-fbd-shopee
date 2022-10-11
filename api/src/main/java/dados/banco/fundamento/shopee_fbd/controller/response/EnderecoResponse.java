package dados.banco.fundamento.shopee_fbd.controller.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EnderecoResponse {
    private int id;
    private String logradouro;
    private int numero;
    private String cidade;
    private String uf;
    private String complemento;
}
