package dados.banco.fundamento.shopee_fbd.repository;

import dados.banco.fundamento.shopee_fbd.domain.CarrinhoProduto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarrinhoProdutoRepository extends JpaRepository<CarrinhoProduto, Long> {
}
