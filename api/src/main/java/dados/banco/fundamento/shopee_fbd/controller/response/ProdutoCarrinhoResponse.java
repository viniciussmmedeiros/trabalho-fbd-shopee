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
public class ProdutoCarrinhoResponse {
    private int id;
    private String nome;
    private String imagemUrl;
    private String descricao;
    private BigDecimal preco;
    private String nomeVendedor;
}
