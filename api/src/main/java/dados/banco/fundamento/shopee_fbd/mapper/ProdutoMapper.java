package dados.banco.fundamento.shopee_fbd.mapper;

import static lombok.AccessLevel.PRIVATE;

import dados.banco.fundamento.shopee_fbd.controller.response.ProdutoComCategoriaResponse;
import dados.banco.fundamento.shopee_fbd.controller.response.ProdutoGeralResponse;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor(access = PRIVATE)
public class ProdutoMapper {

 public static ProdutoGeralResponse toResponseTodos(Object[] entity) {
     return ProdutoGeralResponse.builder()
       .id((int) entity[0])
       .nome((String) entity[1])
       .descricao((String) entity[2])
       .imagemUrl((String) entity[3])
       .preco((BigDecimal) entity[4])
       .idVendedor((int) entity[5])
       .nomeVendedor((String) entity[6])
       .vendedorNota((BigDecimal) entity[7])
       .nomeCategoria((String) entity[8])
       .descricaoCategoria((String) entity[9])
       .build();
 }

 public static ProdutoComCategoriaResponse toResponseComCategoria(Object[] entity) {
   return ProdutoComCategoriaResponse.builder()
       .id((int) entity[0])
       .nome((String) entity[1])
       .descricao((String) entity[2])
       .imagemUrl((String) entity[3])
       .preco((BigDecimal) entity[4])
       .idVendedor((int) entity[5])
       .nomeVendedor((String) entity[6])
       .vendedorNota((BigDecimal) entity[7])
       .nomeCategoria((String) entity[8])
       .descricaoCategoria((String) entity[9])
       .build();
 }
}
