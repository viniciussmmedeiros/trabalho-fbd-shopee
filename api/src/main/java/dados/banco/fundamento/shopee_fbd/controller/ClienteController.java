package dados.banco.fundamento.shopee_fbd.controller;

import javax.validation.Valid;

import dados.banco.fundamento.shopee_fbd.controller.request.LoginRequest;
import dados.banco.fundamento.shopee_fbd.controller.request.PedidoRequest;
import dados.banco.fundamento.shopee_fbd.controller.response.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import dados.banco.fundamento.shopee_fbd.service.ClienteService;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
  
  @Autowired
  private ClienteService clienteService;

  @GetMapping("/dados/{idCliente}")
  public List<ClienteResponse> dadosCliente(@Valid @PathVariable Long idCliente) {
    
    return clienteService.dados(idCliente);
  }

  @GetMapping("/cartoes-credito/{idCliente}")
  public List<ClienteCartaoResponse> cartoesCreditoCliente(@Valid @PathVariable Long idCliente) {

    return clienteService.listarCartoesCreditoCliente(idCliente);
  }

  @GetMapping("/enderecos/{idCliente}")
  public List<EnderecoResponse> enderecosCliente(@Valid @PathVariable Long idCliente) {

    return clienteService.listarEnderecosCliente(idCliente);
  }

  @GetMapping("/produtos-carrinho/{idCarrinho}")
  public List<ProdutoCarrinhoResponse> produtosCarrinhoCliente(@Valid @PathVariable Long idCarrinho) {

    return clienteService.listarProdutosCarrinhoCliente(idCarrinho);
  }

  @GetMapping("/pedidos/{idCliente}")
  public List<PedidoClienteResponse> pedidosCliente(@Valid @PathVariable Long idCliente) {

    return clienteService.listarPedidosCliente(idCliente);
  }

  @GetMapping("/pedido/detalhe/{idPedido}")
  public List<PedidoDetalheResponse> pedidoDetalheCliente(@Valid @PathVariable Long idPedido) {

    return clienteService.detalharPedido(idPedido);
  }

  @GetMapping("/detalhes-carrinho/{idCliente}")
  public List<DetalheCarrinhoResponse> detalhesCarrinhoCliente(@Valid @PathVariable Long idCliente) {

    return clienteService.listarDetalhesCarrinho(idCliente);
  }

  @GetMapping("/clientes-cadastro-incompleto")
  public List<ClienteParaAdminResponse> clientesCadastroIncompleto() {

    return clienteService.listarClientesCadastroIncompleto();
  }

  @GetMapping("/clientes-sem-pedido")
  public List<ClienteParaAdminResponse> clientesSemPedido() {

    return clienteService.listarClientesSemPedido();
  }

  @PostMapping("/login")
  public List<ClienteResponse> loginCliente(@RequestBody LoginRequest request) {

    return clienteService.efetuarLoginCliente(request);
  }

  @GetMapping("/verifica-email/{email}")
  public boolean emailCadastroVerificacao(@PathVariable String email) {

    return clienteService.pesquisarClientePorEmail(email);
  }

  @GetMapping("/transportadoras")
  public List<TransportadoraResponse> listaTransportadoras() {

    return clienteService.listaTransportadoras();
  }

  @GetMapping("/cupom-frete")
  public List<CupomResponse> retornaCupomFrete() {

    return clienteService.retornaCupomFrete();
  }

  @GetMapping("/cupom-vinte")
  public List<CupomResponse> retornaCupomVinte() {

    return clienteService.retornaCupomVinte();
  }

  @GetMapping("/cupom-dez")
  public List<CupomResponse> retornaCupomDez() {

    return clienteService.retornaCupomDez();
  }

  @PostMapping("/fazer-pedido")
  public void fazerPedido(@RequestBody PedidoRequest request) {

    clienteService.fazerPedido(request);
  }

  @PostMapping("/adiciona-produto-carrinho/{idCarrinho}/{idProduto}")
  public void adicionaProdutoCarrinho(@PathVariable int idCarrinho, @PathVariable int idProduto) {

    clienteService.adicionaProdutoCarrinho(idCarrinho, idProduto);
  }
}
