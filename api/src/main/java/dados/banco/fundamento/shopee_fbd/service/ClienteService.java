package dados.banco.fundamento.shopee_fbd.service;

import javax.transaction.Transactional;

import dados.banco.fundamento.shopee_fbd.controller.request.LoginRequest;
import dados.banco.fundamento.shopee_fbd.controller.request.PedidoRequest;
import dados.banco.fundamento.shopee_fbd.controller.response.*;
import dados.banco.fundamento.shopee_fbd.domain.CarrinhoProduto;
import dados.banco.fundamento.shopee_fbd.domain.Pedido;
import dados.banco.fundamento.shopee_fbd.domain.PedidoProduto;
import dados.banco.fundamento.shopee_fbd.mapper.*;
import dados.banco.fundamento.shopee_fbd.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dados.banco.fundamento.shopee_fbd.domain.Cliente;

import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Long.valueOf;

@Service
public class ClienteService {

  @Autowired
  private ClienteRepository clienteRepository;

  @Autowired
  private TransportadoraRepository transportadoraRepository;

  @Autowired
  private CupomRepository cupomRepository;

  @Autowired
  private ProdutoRepository produtoRepository;

  @Autowired
  private PedidoRepository pedidoRepository;

  @Autowired
  private PedidoProdutoRepository pedidoProdutoRepository;

  @Autowired
  private CarrinhoProdutoRepository carrinhoProdutoRepository;

  @Transactional
  public List<ClienteResponse> dados(Long idCliente) {
    return clienteRepository.encontrarClientePorId(idCliente).stream().map(ClienteMapper::toResponse).collect(Collectors.toList());
  }

  public List<ClienteCartaoResponse> listarCartoesCreditoCliente(Long idCliente) {
    return clienteRepository.listaCartoesDeCreditoDoCliente(idCliente).stream().map(ClienteCartaoMapper::toResponse).collect(Collectors.toList());
  }

  public List<EnderecoResponse> listarEnderecosCliente(Long idCliente) {
    return clienteRepository.listaEnderecosDoCliente(idCliente).stream().map(EnderecoMapper::toResponse).collect(Collectors.toList());
  }

  public List<ProdutoCarrinhoResponse> listarProdutosCarrinhoCliente(Long idCarrinho) {
    return clienteRepository.listaProdutosCarrinhoDoCliente(idCarrinho).stream().map(ProdutoCarrinhoMapper::toResponse).collect(Collectors.toList());
  }

  public List<PedidoClienteResponse> listarPedidosCliente(Long idCliente) {
    return clienteRepository.listaPedidosDoCliente(idCliente).stream().map(PedidoClienteMapper::toResponse).collect(Collectors.toList());
  }

  public List<PedidoDetalheResponse> detalharPedido(Long idPedido) {
    return clienteRepository.detalhaPedidoDoCliente(idPedido).stream().map(PedidoDetalheClienteMapper::toResponse).collect(Collectors.toList());
  }

  public List<DetalheCarrinhoResponse> listarDetalhesCarrinho(Long idCliente) {
    return clienteRepository.quantidadeValorCarrinhoDoCliente(idCliente).stream().map(DetalheCarrinhoMapper::toResponse).collect(Collectors.toList());
  }

  public List<ClienteParaAdminResponse> listarClientesCadastroIncompleto() {
    return clienteRepository.listaClientesCadastroIncompleto().stream().map(ClienteParaAdminMapper::toResponse).collect(Collectors.toList());
  }

  public List<ClienteParaAdminResponse> listarClientesSemPedido() {
    return clienteRepository.listaClientesAindaNaoRealizaramPedido().stream().map(ClienteParaAdminMapper::toResponse).collect(Collectors.toList());
  }

  public List<ClienteResponse> efetuarLoginCliente(LoginRequest request) {
    Cliente cliente = ClienteMapper.toEntity(request);

    return clienteRepository.loginCliente(cliente.getEmail(), cliente.getSenha()).stream().map(ClienteMapper::toResponse).collect(Collectors.toList());
  }

  public boolean pesquisarClientePorEmail(String email) {
    return clienteRepository.pesquisaClientePorEmail(email);
  }

  public List<TransportadoraResponse> listaTransportadoras() {
    return transportadoraRepository.listaTransportadoras().stream().map(TransportadoraMapper::toResponse).collect(Collectors.toList());
  }

  public List<CupomResponse> retornaCupomFrete() {
    return cupomRepository.cupomFreteGratis().stream().map(CupomMapper::toResponse).collect(Collectors.toList());

  }

  public List<CupomResponse> retornaCupomVinte() {
    return cupomRepository.cupomMaisDeVintePorcento().stream().map(CupomMapper::toResponse).collect(Collectors.toList());
  }

  public List<CupomResponse> retornaCupomDez() {
    return cupomRepository.cupomMaisDeDezPorcento().stream().map(CupomMapper::toResponse).collect(Collectors.toList());
  }

  public void fazerPedido(PedidoRequest request) {
    Pedido pedido = PedidoMapper.toEntity(request);

    pedidoRepository.save(pedido);

    for(int i : request.getProdutos()) {
      PedidoProduto pedidoProduto = new PedidoProduto();

      pedidoProduto.setIdProduto(i);
      pedidoProduto.setIdPedido(pedido.getIdPedido());

      pedidoProdutoRepository.save(pedidoProduto);
      produtoRepository.updateEstoque(valueOf(i));
    }
  }

  public void adicionaProdutoCarrinho(int idCarrinho, int idProduto) {
    CarrinhoProduto carrinhoProduto = new CarrinhoProduto();

    carrinhoProduto.setIdCarrinho(idCarrinho);
    carrinhoProduto.setIdProduto(idProduto);

    carrinhoProdutoRepository.save(carrinhoProduto);
  }
}
