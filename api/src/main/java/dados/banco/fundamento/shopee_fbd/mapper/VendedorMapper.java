package dados.banco.fundamento.shopee_fbd.mapper;

import dados.banco.fundamento.shopee_fbd.controller.request.LoginRequest;
import dados.banco.fundamento.shopee_fbd.controller.response.SellerResponse;
import dados.banco.fundamento.shopee_fbd.domain.Vendedor;

import java.math.BigDecimal;

public class VendedorMapper {
    public static Vendedor toEntity(LoginRequest request) {
        Vendedor vendedor = new Vendedor();
        vendedor.setEmail(request.getEmail());
        vendedor.setSenha(request.getSenha());

        return vendedor;
    }

    public static SellerResponse toResponse(Object[] entity) {
        if(entity[5] == null) {
            entity[5] = BigDecimal.ZERO;
        }

        return SellerResponse.builder()
                .id((int) entity[0])
                .nome((String) entity[1])
                .email((String) entity[2])
                .cnpj((String) entity[4])
                .nota((BigDecimal) entity[5])
                .build();
    }
}
