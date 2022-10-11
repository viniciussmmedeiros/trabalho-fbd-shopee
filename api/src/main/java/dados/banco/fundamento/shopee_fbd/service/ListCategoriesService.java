package dados.banco.fundamento.shopee_fbd.service;

import dados.banco.fundamento.shopee_fbd.controller.response.ProductCategoryResponse;
import dados.banco.fundamento.shopee_fbd.mapper.ProductCategoryMapper;
import dados.banco.fundamento.shopee_fbd.repository.CategoriaProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ListCategoriesService {

    @Autowired
    private CategoriaProdutoRepository categoriaProdutoRepository;

    public Page<ProductCategoryResponse> list(Pageable pageable) {

        return categoriaProdutoRepository.todasCategorias(pageable).map(category -> ProductCategoryMapper.toResponse(category));
    }
}
