package dados.banco.fundamento.shopee_fbd.domain;

import static javax.persistence.GenerationType.IDENTITY;

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
@EqualsAndHashCode(of = "idCliente")
@Getter
@Setter
public class Cliente {

  @Id
  @GeneratedValue(strategy = IDENTITY)
  private int idCliente;
  
  private String nome;
  private String email;
  private String senha;
  private char cpf;

  @Column(name = "id_carrinho")
  private int idCarrinho;
}
