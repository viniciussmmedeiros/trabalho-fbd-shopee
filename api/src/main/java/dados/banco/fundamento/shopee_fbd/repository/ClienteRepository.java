package dados.banco.fundamento.shopee_fbd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dados.banco.fundamento.shopee_fbd.domain.Cliente;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

  @Query(value = "SELECT cliente.id_cliente, " +
          "nome, " +
          "email, " +
          "cpf, " +
          "id_carrinho " +
          "FROM cliente WHERE id_cliente = ?1", nativeQuery = true)
  List<Object[]> encontrarClientePorId(Long idCliente);

  @Query(value = "SELECT id_cartao_credito," +
          "nome," +
          "numero," +
          "data_vencimento," +
          "cvv " +
          "FROM cartao_credito " +
          "JOIN cartao_credito_cliente USING (id_cartao_credito) " +
          "WHERE id_cliente = ?1", nativeQuery = true)
  List<Object[]> listaCartoesDeCreditoDoCliente(Long idCliente);

  @Query(value = "SELECT id_cliente_vendedor_endereco, " +
          "logradouro, " +
          "endereco.numero, " +
          "cidade, " +
          "uf, " +
          "complemento " +
          "FROM cliente " +
          "NATURAL JOIN cliente_vendedor_endereco " +
          "NATURAL JOIN endereco " +
          "WHERE id_cliente = ?1", nativeQuery = true)
  List<Object[]> listaEnderecosDoCliente(Long idCliente);

  @Query(value = "SELECT produto.id_produto, " +
          "produto.nome as nome_produto, " +
          "imagem_url, " +
          "descricao, " +
          "preco, " +
          "vendedor.nome as nome_vendedor " +
          "FROM produto " +
          "JOIN carrinho_produto USING (id_produto) " +
          "JOIN vendedor ON (produto.id_vendedor = vendedor.id_vendedor) " +
          "WHERE id_carrinho = ?1", nativeQuery = true)
  List<Object[]> listaProdutosCarrinhoDoCliente(Long idCarrinho);

  @Query(value = "SELECT id_pedido, " +
          "data_realizacao, " +
          "transportadora.nome as nome_transportadora, " +
          "endereco.logradouro, " +
          "endereco.numero as endereco_numero, " +
          "endereco.cidade, " +
          "endereco.uf, " +
          "endereco.complemento, " +
          "cartao_credito.nome as nome_cartao_credito, " +
          "cartao_credito.numero as cartao_numero " +
          "FROM ClientePedido " +
          "INNER JOIN cartao_credito USING (id_cartao_credito) " +
          "INNER JOIN endereco USING (id_endereco) " +
          "INNER JOIN transportadora USING (id_transportadora) " +
          "WHERE id_cliente = ?1", nativeQuery = true)
  List<Object[]> listaPedidosDoCliente(Long idCliente);

  @Query(value = "SELECT id_produto, " +
          "vendedor.nome as nome_vendedor, " +
          "imagem_url, " +
          "produto.nome as nome_produto, " +
          "preco " +
          "FROM ClientePedido " +
          "INNER JOIN pedido_produto USING (id_pedido) " +
          "INNER JOIN produto USING (id_produto) " +
          "INNER JOIN vendedor ON (produto.id_vendedor = vendedor.id_vendedor) " +
          "WHERE id_pedido = ?1", nativeQuery = true)
  List<Object[]> detalhaPedidoDoCliente(Long idPedido);

  @Query(value = "SELECT COUNT(*) qtde, " +
          "SUM(preco) valor_total " +
          "FROM cliente " +
          "NATURAL JOIN carrinho " +
          "NATURAL JOIN carrinho_produto " +
          "INNER JOIN produto USING (id_produto) " +
          "GROUP BY id_carrinho, id_cliente " +
          "HAVING id_cliente = ?1", nativeQuery = true)
  List<Object[]> quantidadeValorCarrinhoDoCliente(Long idCliente);

  @Query(value = "SELECT id_cliente, " +
          "nome, " +
          "email " +
          "FROM cliente " +
          "WHERE id_cliente IN (SELECT id_cliente " +
          "FROM cliente_vendedor_endereco " +
          "WHERE id_endereco is null " +
          "UNION " +
          "SELECT id_cliente " +
          "FROM cartao_credito_cliente " +
          "WHERE id_cartao_credito is null)", nativeQuery = true)
  List<Object[]> listaClientesCadastroIncompleto();

  @Query(value = "SELECT id_cliente, " +
          "nome, " +
          "email " +
          "FROM cliente " +
          "WHERE NOT EXISTS (SELECT * " +
          "FROM pedido " +
          "WHERE cliente.id_cliente = pedido.id_cliente)", nativeQuery = true)
  List<Object[]> listaClientesAindaNaoRealizaramPedido();

  @Query(value = "SELECT cliente.id_cliente, " +
          "nome, " +
          "email, " +
          "cpf, " +
          "id_carrinho " +
          "FROM cliente" +
          " WHERE email = ?1 AND senha = ?2", nativeQuery = true)
  List<Object[]> loginCliente(String email, String senha);

  @Query(value = "SELECT count(*) > 0 " +
          "FROM cliente " +
          "WHERE email = ?1", nativeQuery = true)
  Boolean pesquisaClientePorEmail(String email);
}
