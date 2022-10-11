package dados.banco.fundamento.shopee_fbd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dados.banco.fundamento.shopee_fbd.domain.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
  
}
