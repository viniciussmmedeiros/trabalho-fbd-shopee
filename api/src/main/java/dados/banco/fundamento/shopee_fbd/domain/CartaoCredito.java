package dados.banco.fundamento.shopee_fbd.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.time.LocalDate;

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
@EqualsAndHashCode(of = "idCartaoCredito")
@Getter
@Setter
public class CartaoCredito {

  @Id
  @GeneratedValue(strategy = IDENTITY)
  private int idCartaoCredito;
  
  private String nome;
  private String numero;
  private LocalDate dataVencimento;
  private String cvv;
}
