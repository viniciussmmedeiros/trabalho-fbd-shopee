package dados.banco.fundamento.shopee_fbd.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "idProduto")
@Getter
@Setter
public class PedidoProduto {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int idPedidoProduto;

    @Column(name = "id_pedido")
    private int idPedido;

    @Column(name = "id_produto")
    private int idProduto;
}
