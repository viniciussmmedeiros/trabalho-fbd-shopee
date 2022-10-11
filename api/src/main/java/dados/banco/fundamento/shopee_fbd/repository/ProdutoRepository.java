package dados.banco.fundamento.shopee_fbd.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import dados.banco.fundamento.shopee_fbd.domain.Produto;

import javax.transaction.Transactional;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

  @Query(value="SELECT produto.id_produto, " +
          "produto.nome as produto_nome, " +
          "produto.descricao, " +
          "imagem_url, " +
          "preco, " +
          "vendedor.id_vendedor, " +
          "vendedor.nome as vendedor_nome, " +
          "vendedor.nota, " +
          "categoria_produto.nome as categoria_nome, " +
          "categoria_produto.descricao as categoria_descricao " +
          "FROM categoria_produto " +
          "INNER JOIN produto ON (categoria_produto.id_categoria_produto = produto.id_categoria) " +
          "INNER JOIN vendedor USING (id_vendedor) " +
          "WHERE estoque > 0",
          countQuery="SELECT count(*)",
          nativeQuery = true)
  Page<Object[]> todosProdutosDisponiveis(Pageable pageable);

  @Query(value = "SELECT produto.id_produto, " +
          "produto.nome as produto_nome, " +
          "produto.descricao, " +
          "imagem_url, " +
          "preco, " +
          "vendedor.id_vendedor, " +
          "vendedor.nome as vendedor_nome, " +
          "vendedor.nota, " +
          "categoria_produto.nome as categoria_nome, " +
          "categoria_produto.descricao as categoria_descricao " +
          "FROM categoria_produto " +
          "INNER JOIN produto ON (categoria_produto.id_categoria_produto = produto.id_categoria) " +
          "INNER JOIN vendedor USING (id_vendedor) " +
          "WHERE categoria_produto.id_categoria_produto = ?1 AND estoque > 0",
          countQuery="SELECT count(*)",
          nativeQuery = true)
  Page<Object[]> produtosDisponiveisPorCategoria(Long filter, Pageable pageable);

  @Query(value = "SELECT  produto.id_produto, " +
          "produto.nome as produto_nome, " +
          "produto.descricao, " +
          "imagem_url, " +
          "preco, " +
          "vendedor.id_vendedor, " +
          "vendedor.nome as vendedor_nome, " +
          "vendedor.nota, " +
          "categoria_produto.nome as categoria_nome, " +
          "categoria_produto.descricao as categoria_descricao " +
          "FROM categoria_produto " +
          "INNER JOIN produto ON (categoria_produto.id_categoria_produto = produto.id_categoria) " +
          "INNER JOIN vendedor USING (id_vendedor) " +
          "WHERE LOWER(produto.nome) LIKE LOWER(CONCAT('%', ?1, '%')) AND estoque > 0", nativeQuery = true)
  Page<Object[]> produtosPorPesquisa(String textoPesquisa, Pageable pageable);

  @Query(value = "SELECT  produto.id_produto, " +
          "produto.nome as produto_nome, " +
          "produto.descricao, " +
          "imagem_url, " +
          "preco, " +
          "vendedor.id_vendedor, " +
          "vendedor.nome as vendedor_nome, " +
          "vendedor.nota, " +
          "categoria_produto.nome as categoria_nome, " +
          "categoria_produto.descricao as categoria_descricao " +
          "FROM categoria_produto " +
          "INNER JOIN produto ON (categoria_produto.id_categoria_produto = produto.id_categoria) " +
          "INNER JOIN vendedor USING (id_vendedor) " +
          "WHERE vendedor.id_vendedor = ?1 and estoque > 0",
          countQuery="SELECT count(*)",
          nativeQuery = true)
  Page<Object[]> produtosDoVendedor(Long idVendedor, Pageable pageable);

  @Transactional
  @Modifying
  @Query(value = "UPDATE produto SET estoque = estoque - 1 where id_produto = ?1",
          nativeQuery = true)
  void updateEstoque(Long i);
}
