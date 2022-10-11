package dados.banco.fundamento.shopee_fbd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dados.banco.fundamento.shopee_fbd.domain.Transportadora;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransportadoraRepository extends JpaRepository<Transportadora, Long> {

    @Query(value = "SELECT id_transportadora, " +
            "nome " +
            "FROM transportadora;", nativeQuery = true)
    List<Object[]> listaTransportadoras();
}
