package dados.banco.fundamento.shopee_fbd.controller.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CupomResponse {
    private int id;
    private String codigo;
    private BigDecimal porcentagem;
}
