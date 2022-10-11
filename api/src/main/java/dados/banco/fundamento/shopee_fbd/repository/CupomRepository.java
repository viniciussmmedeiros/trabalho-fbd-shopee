package dados.banco.fundamento.shopee_fbd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dados.banco.fundamento.shopee_fbd.domain.Cupom;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CupomRepository extends JpaRepository<Cupom, Long> {

    @Query(value = "SELECT * " +
            "FROM cupom " +
            "WHERE porcentagem_desconto IS NULL " +
            "LIMIT(1)", nativeQuery = true)
    List<Object[]> cupomFreteGratis();

    @Query(value = "SELECT * " +
            "FROM cupom " +
            "WHERE porcentagem_desconto > 0.20 " +
            "LIMIT (1)", nativeQuery = true)
    List<Object[]> cupomMaisDeVintePorcento();

    @Query(value = "SELECT * " +
            "  FROM cupom " +
            "  WHERE porcentagem_desconto >= 0.10 AND porcentagem_desconto <= 0.20 " +
            "  LIMIT (1)", nativeQuery = true)
    List<Object[]> cupomMaisDeDezPorcento();
}
