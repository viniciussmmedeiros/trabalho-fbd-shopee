package dados.banco.fundamento.shopee_fbd.mapper;

import dados.banco.fundamento.shopee_fbd.controller.request.LoginRequest;
import dados.banco.fundamento.shopee_fbd.controller.response.ClienteResponse;
import dados.banco.fundamento.shopee_fbd.domain.Cliente;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ClienteMapper {

  public static ClienteResponse toResponse(Object[] entity) {
    return ClienteResponse.builder()
      .id((int) entity[0])
      .nome((String) entity[1])
      .email((String) entity[2])
      .cpf((String) entity[3])
      .idCarrinho((int) entity[4])
      .build();
  }

    public static Cliente toEntity(LoginRequest request) {
      Cliente cliente = new Cliente();
      cliente.setEmail(request.getEmail());
      cliente.setSenha(request.getSenha());

      return cliente;
    }
}
