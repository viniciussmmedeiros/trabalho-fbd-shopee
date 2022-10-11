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
@EqualsAndHashCode(of = "idCarrinhoProduto")
@Getter
@Setter
public class CarrinhoProduto {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int idCarrinhoProduto;

    @Column(name = "id_carrinho")
    private int idCarrinho;

    @Column(name = "id_produto")
    private int idProduto;
}
