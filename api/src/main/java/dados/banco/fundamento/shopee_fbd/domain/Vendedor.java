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
@EqualsAndHashCode(of = "idVendedor")
@Getter
@Setter
public class Vendedor {

  @Id
  @GeneratedValue(strategy = IDENTITY)
  private int idVendedor;
  
  private String nome;
  private String email;
  private String senha;
  private char cnpj;
}
