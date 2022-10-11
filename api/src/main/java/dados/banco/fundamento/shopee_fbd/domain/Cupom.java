package dados.banco.fundamento.shopee_fbd.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.math.BigDecimal;

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
@EqualsAndHashCode(of = "idCupom")
@Getter
@Setter
public class Cupom {

  @Id
  @GeneratedValue(strategy = IDENTITY)
  private int idCupom;
  
  private String codigo;
  private BigDecimal porcentagemDesconto;
}
