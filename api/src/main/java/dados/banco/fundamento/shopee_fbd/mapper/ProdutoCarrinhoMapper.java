package dados.banco.fundamento.shopee_fbd.mapper;

import dados.banco.fundamento.shopee_fbd.controller.response.ProdutoCarrinhoResponse;

import java.math.BigDecimal;

public class ProdutoCarrinhoMapper {
    public static ProdutoCarrinhoResponse toResponse(Object[] entity) {
        return ProdutoCarrinhoResponse.builder()
                .id((int) entity[0])
                .nome((String) entity[1])
                .imagemUrl((String) entity[2])
                .descricao((String) entity[3])
                .preco((BigDecimal) entity[4])
                .nomeVendedor((String) entity[5])
                .build();
    }
}
