package dados.banco.fundamento.shopee_fbd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dados.banco.fundamento.shopee_fbd.domain.Vendedor;
import org.springframework.data.jpa.repository.Query;

import java.sql.Timestamp;
import java.util.List;

public interface VendedorRepository extends JpaRepository<Vendedor, Long> {

    @Query(value = "SELECT  id_cliente_vendedor_endereco, " +
            "logradouro, " +
            "endereco.numero, " +
            "cidade, " +
            "uf, " +
            "complemento " +
            "FROM vendedor " +
            "NATURAL JOIN cliente_vendedor_endereco " +
            "NATURAL JOIN endereco " +
            "WHERE id_vendedor = ?1", nativeQuery = true)
    List<Object[]> listaEnderecosDoVendedor(Long idVendedor);

    @Query(value = "SELECT COUNT(*) qtde_vendas, " +
            "SUM(preco) valor_arrecadado " +
            "FROM pedido_produto NATURAL JOIN " +
            "produto NATURAL JOIN " +
            "pedido " +
            "WHERE data_realizacao >= ?2 AND data_realizacao <= ?3 " +
            "GROUP BY id_vendedor " +
            "HAVING id_vendedor = ?1", nativeQuery = true)
    List<Object[]> quantidadeValorVendasDoVendedor(Long idVendedor, Timestamp dataInicio, Timestamp dataFim);

    @Query(value = "SELECT  id_vendedor, " +
            "nome, " +
            "email " +
            "FROM vendedor " +
            "WHERE id_vendedor NOT IN (SELECT id_vendedor " +
            "FROM pedido NATURAL JOIN " +
            "pedido_produto NATURAL JOIN " +
            "produto " +
            "WHERE data_realizacao > NOW() - INTERVAL '30 DAYS')", nativeQuery = true)
    List<Object[]> listaVendedoresSemVendasUltimosTrintaDias();

    @Query(value = "SELECT * " +
            "FROM vendedor " +
            "WHERE email = ?1 and senha = ?2", nativeQuery = true)
    List<Object[]> loginVendedor(String email, String senha);

    @Query(value = "SELECT count(*) > 0 " +
            "FROM vendedor " +
            "WHERE email = ?1", nativeQuery = true)
    Boolean pesquisaVendedorPorEmail(String email);
}
