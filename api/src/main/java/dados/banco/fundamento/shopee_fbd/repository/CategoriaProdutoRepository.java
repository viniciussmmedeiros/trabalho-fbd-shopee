package dados.banco.fundamento.shopee_fbd.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import dados.banco.fundamento.shopee_fbd.domain.CategoriaProduto;
import org.springframework.data.jpa.repository.Query;

public interface CategoriaProdutoRepository extends JpaRepository<CategoriaProduto, Long> {

    @Query(value = "SELECT * " +
            "FROM categoria_produto", nativeQuery = true)
    Page<CategoriaProduto> todasCategorias(Pageable pageable);
}
