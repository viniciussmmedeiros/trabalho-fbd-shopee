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

import java.sql.Timestamp;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "idPedido")
@Getter
@Setter
public class Pedido {

  @Id
  @GeneratedValue(strategy = IDENTITY)
  private int idPedido;

  @Column(name = "data_realizacao")
  private Timestamp dataRealizacao;

  @Column(name = "id_cliente")
  private int idCliente;

  @Column(name = "id_transportadora")
  private int idTransportadora;

  @Column(name = "id_endereco")
  private int idEndereco;

  @Column(name = "id_cartao_credito")
  private int idCartaoCredito;
}
