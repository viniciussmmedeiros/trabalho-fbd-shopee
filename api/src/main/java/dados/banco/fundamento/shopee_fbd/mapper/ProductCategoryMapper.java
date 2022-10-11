package dados.banco.fundamento.shopee_fbd.mapper;

import dados.banco.fundamento.shopee_fbd.controller.response.ProductCategoryResponse;
import dados.banco.fundamento.shopee_fbd.domain.CategoriaProduto;

public class ProductCategoryMapper {
    public static ProductCategoryResponse toResponse(CategoriaProduto category) {
        return ProductCategoryResponse.builder()
                .id(category.getIdCategoriaProduto())
                .nome(category.getNome())
                .descricao(category.getDescricao())
                .build();
    }
}
