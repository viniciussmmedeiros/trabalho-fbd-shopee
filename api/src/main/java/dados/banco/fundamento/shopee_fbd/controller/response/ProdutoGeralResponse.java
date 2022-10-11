package dados.banco.fundamento.shopee_fbd.controller.response;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProdutoGeralResponse {
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
