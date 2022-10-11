package dados.banco.fundamento.shopee_fbd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dados.banco.fundamento.shopee_fbd.domain.Pedido;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    @Query(value = "SELECT  data_realizacao, " +
            "produto.nome as nome_produto, " +
            "imagem_url, " +
            "transportadora.nome as nome_transportadora, " +
            "ClientePedido.nome as nome_cliente " +
            "FROM ClientePedido " +
            "INNER JOIN pedido_produto USING (id_pedido) " +
            "INNER JOIN produto USING (id_produto) " +
            "INNER JOIN vendedor ON (produto.id_vendedor = vendedor.id_vendedor) " +
            "INNER JOIN transportadora USING (id_transportadora) " +
            "WHERE vendedor.id_vendedor = ?1", nativeQuery = true)
    List<Object[]> todosPedidosDoVendedor(Long idVendedor);

    @Query(value = "SELECT COUNT(*) " +
            "FROM pedido_produto " +
            "JOIN produto ON (produto.id_produto = pedido_produto.id_produto) " +
            "WHERE produto.id_vendedor = ?1", nativeQuery = true)
    Long quantidadeVendasDoVendedor(Long sellerId);
}
