package dados.banco.fundamento.shopee_fbd.domain;

import static javax.persistence.GenerationType.IDENTITY;

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
@EqualsAndHashCode(of = "idEndereco")
@Getter
@Setter
public class Endereco {

  @Id
  @GeneratedValue(strategy = IDENTITY)
  private int idEndereco;
  
  private String logradouro;
  private int numero;
  private String cidade;
  private String uf;
  private String complemento;
}
