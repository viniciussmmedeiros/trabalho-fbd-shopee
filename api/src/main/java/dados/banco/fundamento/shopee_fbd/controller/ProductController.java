package dados.banco.fundamento.shopee_fbd.controller;

import dados.banco.fundamento.shopee_fbd.controller.response.AvaliacaoResponse;
import dados.banco.fundamento.shopee_fbd.controller.response.ProductCategoryResponse;
import dados.banco.fundamento.shopee_fbd.controller.response.ProdutoComCategoriaResponse;
import dados.banco.fundamento.shopee_fbd.service.ListCategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dados.banco.fundamento.shopee_fbd.service.ListaProdutoService;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ListaProdutoService listaProdutoService;

    @Autowired
    private ListCategoriesService listCategoriesService;

    @GetMapping("/categoria/{idFiltro}")
    public Page<?> listaProdutos(@PathVariable Long idFiltro, Pageable pageable) {

        if(idFiltro == 0) {
            return listaProdutoService.listarGeral(pageable);
        }

        return listaProdutoService.listarComCategoria(idFiltro, pageable);
    }

    @GetMapping("/categorias")
    public Page<ProductCategoryResponse> listCategories(Pageable pageable) {

        return listCategoriesService.list(pageable);
    }

    @GetMapping("/pesquisa/{textoPesquisa}")
    public Page<ProdutoComCategoriaResponse> listaProdutosPesquisa(@PathVariable String textoPesquisa, Pageable pageable) {
        return listaProdutoService.listarPesquisa(textoPesquisa, pageable);
    }

    @GetMapping("/vendedor/{idVendedor}")
    public Page<ProdutoComCategoriaResponse> listaProdutosVendedor(@PathVariable Long idVendedor, Pageable pageable) {
        return listaProdutoService.listarProdutosVendedor(idVendedor, pageable);
    }

    @GetMapping("/{idProduto}/avaliacoes")
    public List<AvaliacaoResponse> listaAvaliacoesProduto(@PathVariable Long idProduto) {
        return listaProdutoService.listarAvaliacoesProduto(idProduto);
    }

}
