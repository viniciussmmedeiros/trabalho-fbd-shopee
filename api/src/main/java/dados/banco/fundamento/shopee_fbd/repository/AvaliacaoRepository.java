package dados.banco.fundamento.shopee_fbd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dados.banco.fundamento.shopee_fbd.domain.Avaliacao;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long>{

    @Query(value = "SELECT avaliacao.id_avaliacao, " +
            "nota," +
            "imagem_url," +
            "comentario " +
            "FROM avaliacao " +
            "WHERE id_produto = ?1", nativeQuery = true)
    List<Object[]> todasAvaliacoesDoProduto(long idProduto);
}
