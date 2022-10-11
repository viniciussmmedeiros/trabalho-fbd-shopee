package dados.banco.fundamento.shopee_fbd.repository;

import dados.banco.fundamento.shopee_fbd.domain.PedidoProduto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoProdutoRepository extends JpaRepository<PedidoProduto, Long> {
}
