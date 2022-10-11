package dados.banco.fundamento.shopee_fbd.controller;

import dados.banco.fundamento.shopee_fbd.controller.request.LoginRequest;
import dados.banco.fundamento.shopee_fbd.controller.response.*;
import dados.banco.fundamento.shopee_fbd.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/sellers")
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @PostMapping("/login")
    public List<SellerResponse> loginVendedor(@RequestBody LoginRequest request) {

        return sellerService.efetuarLoginVendedor(request);
    }

    @GetMapping("/{sellerId}/quantidade-vendas")
    public Long quantidadeVendas(@PathVariable Long sellerId) {
        return sellerService.retornaQuantidadeVendas(sellerId);
    }

    @GetMapping("/{sellerId}/metricas/{dataInicio}/{dataFim}")
    public List<VendedorMetricaResponse> quantidadeVendas(@PathVariable Long sellerId, @PathVariable String dataInicio, @PathVariable String dataFim) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date parsedStartDate = dateFormat.parse(dataInicio);
            Date parsedEndDate = dateFormat.parse(dataFim);
            Timestamp timestampStart = new java.sql.Timestamp(parsedStartDate.getTime());
            Timestamp timestampEnd = new java.sql.Timestamp(parsedEndDate.getTime());

            return sellerService.retornaMetricasVendedor(sellerId, timestampStart, timestampEnd);
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    @GetMapping("/enderecos/{sellerId}")
    public List<EnderecoResponse> enderecosCliente(@Valid @PathVariable Long sellerId) {

        return sellerService.listarEnderecosVendedor(sellerId);
    }

    @GetMapping("/{sellerId}/pedidos")
    public List<VendedorPedidoResponse> pedidosVendedor(@Valid @PathVariable Long sellerId) {

        return sellerService.listarPedidosVendedor(sellerId);
    }

    @GetMapping("/no-sells-last-30-days")
    public List<VendedorSemVendaResponse> vendedoresSemVendasUltimos30Dias() {

        return sellerService.listarVendedoresSemPedido();
    }

    @GetMapping("/verifica-email/{email}")
    public boolean emailCadastroVerificacao(@PathVariable String email) {

        return sellerService.pesquisarVendedorPorEmail(email);
    }
}
