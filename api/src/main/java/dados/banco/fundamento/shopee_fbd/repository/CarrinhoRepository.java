package dados.banco.fundamento.shopee_fbd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dados.banco.fundamento.shopee_fbd.domain.Carrinho;

public interface CarrinhoRepository extends JpaRepository<Carrinho, Long> {
  
}
