package dados.banco.fundamento.shopee_fbd.controller.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.math.BigDecimal;
import java.math.BigInteger;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VendedorMetricaResponse {
    private BigInteger quantidadeVendas;
    private BigDecimal valorTotal;
}
