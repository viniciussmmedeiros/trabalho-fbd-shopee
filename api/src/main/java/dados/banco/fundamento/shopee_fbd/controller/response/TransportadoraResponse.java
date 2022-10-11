package dados.banco.fundamento.shopee_fbd.controller.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TransportadoraResponse {
    private int id;
    private String nome;
}
