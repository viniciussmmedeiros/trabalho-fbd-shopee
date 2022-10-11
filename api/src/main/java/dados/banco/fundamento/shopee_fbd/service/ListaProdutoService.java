package dados.banco.fundamento.shopee_fbd.service;

import dados.banco.fundamento.shopee_fbd.controller.response.AvaliacaoResponse;
import dados.banco.fundamento.shopee_fbd.controller.response.ProdutoComCategoriaResponse;
import dados.banco.fundamento.shopee_fbd.mapper.AvaliacaoMapper;
import dados.banco.fundamento.shopee_fbd.repository.AvaliacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import dados.banco.fundamento.shopee_fbd.controller.response.ProdutoGeralResponse;
import dados.banco.fundamento.shopee_fbd.mapper.ProdutoMapper;
import dados.banco.fundamento.shopee_fbd.repository.ProdutoRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListaProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    @Transactional
    public Page<ProdutoGeralResponse> listarGeral(Pageable pageable) {
       return produtoRepository.todosProdutosDisponiveis(pageable).map(ProdutoMapper::toResponseTodos);
    }

    @Transactional
    public Page<ProdutoComCategoriaResponse> listarComCategoria(Long idFiltro, Pageable pageable) {
        return produtoRepository.produtosDisponiveisPorCategoria(idFiltro, pageable).map(ProdutoMapper::toResponseComCategoria);
    }

    @Transactional
    public Page<ProdutoComCategoriaResponse> listarPesquisa(String textoPesquisa, Pageable pageable) {
        return produtoRepository.produtosPorPesquisa(textoPesquisa, pageable).map(ProdutoMapper::toResponseComCategoria);
    }

    @Transactional
    public Page<ProdutoComCategoriaResponse> listarProdutosVendedor(Long idVendedor, Pageable pageable) {
        return produtoRepository.produtosDoVendedor(idVendedor, pageable).map(ProdutoMapper::toResponseComCategoria);
    }

    @Transactional
    public List<AvaliacaoResponse> listarAvaliacoesProduto(Long idProduto) {
        return avaliacaoRepository.todasAvaliacoesDoProduto(idProduto).stream().map(AvaliacaoMapper::toResponse).collect(Collectors.toList());
    }
}
