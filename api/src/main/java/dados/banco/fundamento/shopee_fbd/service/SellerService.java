package dados.banco.fundamento.shopee_fbd.service;

import dados.banco.fundamento.shopee_fbd.controller.request.LoginRequest;
import dados.banco.fundamento.shopee_fbd.controller.response.*;
import dados.banco.fundamento.shopee_fbd.domain.Vendedor;
import dados.banco.fundamento.shopee_fbd.mapper.*;
import dados.banco.fundamento.shopee_fbd.repository.PedidoRepository;
import dados.banco.fundamento.shopee_fbd.repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SellerService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private VendedorRepository vendedorRepository;

    public Long retornaQuantidadeVendas(Long sellerId) {
        return pedidoRepository.quantidadeVendasDoVendedor(sellerId);
    }

    public List<SellerResponse> efetuarLoginVendedor(LoginRequest request) {

        Vendedor vendedor = VendedorMapper.toEntity(request);

        return vendedorRepository.loginVendedor(vendedor.getEmail(), vendedor.getSenha()).stream().map(VendedorMapper::toResponse).collect(Collectors.toList());
    }

    public List<VendedorMetricaResponse> retornaMetricasVendedor(Long sellerId, Timestamp dataInicio, Timestamp dataFim) {
        return vendedorRepository.quantidadeValorVendasDoVendedor(sellerId, dataInicio, dataFim).stream().map(VendedorMetricaMapper::toResponse).collect(Collectors.toList());
    }

    public List<EnderecoResponse> listarEnderecosVendedor(Long idVendedor) {
        return vendedorRepository.listaEnderecosDoVendedor(idVendedor).stream().map(EnderecoMapper::toResponse).collect(Collectors.toList());
    }

    public List<VendedorPedidoResponse> listarPedidosVendedor(Long sellerId) {
        return pedidoRepository.todosPedidosDoVendedor(sellerId).stream().map(PedidoVendedorMapper::toResponse).collect(Collectors.toList());
    }

    public List<VendedorSemVendaResponse> listarVendedoresSemPedido() {
        return vendedorRepository.listaVendedoresSemVendasUltimosTrintaDias().stream().map(VendedorSemVendaMapper::toResponse).collect(Collectors.toList());
    }

    public boolean pesquisarVendedorPorEmail(String email) {
        return vendedorRepository.pesquisaVendedorPorEmail(email);
    }
}
