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
public class ProdutoComCategoriaResponse {
  private int id;
  private String nome;
  private String descricao;
  private String imagemUrl;
  private BigDecimal preco;
  private int idVendedor;
  private String nomeVendedor;
  private BigDecimal vendedorNota;
  private String nomeCategoria;
  private String descricaoCategoria;
}
