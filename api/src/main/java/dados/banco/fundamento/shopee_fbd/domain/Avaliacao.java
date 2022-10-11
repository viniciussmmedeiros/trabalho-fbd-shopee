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
@EqualsAndHashCode(of = "idAvaliacao")
@Getter
@Setter
public class Avaliacao {

  @Id
  @GeneratedValue(strategy = IDENTITY)
  @Column(name="id_avaliacao")
  private int idAvaliacao;
  
  private BigDecimal nota;
  private String imagemUrl;
  private String comentario;

  @ManyToOne
  @JoinColumn(name = "id_produto")
  private Produto produto;
}
