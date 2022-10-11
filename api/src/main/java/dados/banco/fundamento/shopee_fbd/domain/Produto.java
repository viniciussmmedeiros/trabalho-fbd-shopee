package dados.banco.fundamento.shopee_fbd.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.math.BigDecimal;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "idProduto")
@Getter
@Setter
public class Produto {

  @Id
  @GeneratedValue(strategy = IDENTITY)
  private int idProduto;

  private String nome;
  private String imagemUrl;
  private String descricao;
  private int estoque;
  private BigDecimal preco;

  @ManyToOne
  @JoinColumn(name = "id_vendedor")
  private Vendedor vendedor;
}
