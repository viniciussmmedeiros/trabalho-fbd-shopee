package dados.banco.fundamento.shopee_fbd.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
@EqualsAndHashCode(of = "idCarrinho")
@Getter
@Setter
public class Carrinho {

  @Id
  @GeneratedValue(strategy = IDENTITY)
  private int idCarrinho;

  @Column(name = "id_cupom")
  private int idCupom;

  private BigDecimal valorTotal;
}
