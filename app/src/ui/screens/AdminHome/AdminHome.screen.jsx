import "./AdminHome.style.css";
import { useAdminApi } from "../../../hooks/api";
import { useState, useEffect } from "react";
import { SimplifiedHeader } from "../../components";

export const AdminHomeScreen = () => {
  const adminApi = useAdminApi();
  const [sellersNoSell, setSellersNoSell] = useState(null);
  const [customersNoOrder, setCustomersNoOrder] = useState(null);
  const [customersIncompleteRegistration, setCustomersIncompleteRegistration] =
    useState(null);

  useEffect(() => {
    const fetchSellersNoSell = async () => {
      const sellersNoSellResponse = await adminApi.getSellersNoSellLast30Days();

      setSellersNoSell(sellersNoSellResponse);
    };

    fetchSellersNoSell();
  }, [adminApi]);

  useEffect(() => {
    const fetchCustomersNoOrder = async () => {
      const customersNoOrderResponse = await adminApi.getCustomersNoOrder();

      setCustomersNoOrder(customersNoOrderResponse);
    };

    fetchCustomersNoOrder();
  }, [adminApi]);

  useEffect(() => {
    const fetchCustomersIncompleteRegistration = async () => {
      const customersIncompleteRegistrationResponse =
        await adminApi.getCustomersIncompleteRegistration();

      setCustomersIncompleteRegistration(
        customersIncompleteRegistrationResponse
      );
    };

    fetchCustomersIncompleteRegistration();
  }, [adminApi]);

  return (
    <div className="admin-screen-wrapper">
      <SimplifiedHeader />
      <div className="admin-screen-content">
        <h1>Tela de Admin</h1>
        <div className="admin-no-sells-sellers">
          {sellersNoSell && sellersNoSell.length > 0 ? (
            <>
              <h3>Vendedores que não realizaram vendas nos últimos 30 dias:</h3>
              <div className="no-sells-content">
                {sellersNoSell.map((seller) => (
                  <div key={seller.idVendedor} className="seller-no-sell-card">
                    <span>Nome do vendedor: {seller.nome}</span>
                    <span>Email do vendedor: {seller.email}</span>
                  </div>
                ))}
              </div>
            </>
          ) : (
            <p>Todos os vendedores da plataforma já realizaram alguma venda!</p>
          )}
        </div>

        <div className="admin-customers-no-order">
          {customersNoOrder && customersNoOrder.length > 0 ? (
            <>
              <h3>Clientes que ainda não efetuaram pedido:</h3>
              <div className="no-order-content">
                {customersNoOrder.map((customer) => (
                  <div
                    key={customer.idVendedor}
                    className="customer-no-order-card"
                  >
                    <span>Nome do cliente: {customer.nome}</span>
                    <span>Email do cliente: {customer.email}</span>
                  </div>
                ))}
              </div>
            </>
          ) : (
            <p>Todos os clientes da plataforma já realizaram algum pedido!</p>
          )}
        </div>

        <div className="admin-customers-incomplete">
          {customersIncompleteRegistration &&
          customersIncompleteRegistration.length > 0 ? (
            <>
              <h3>
                Clientes que ainda não registraram endereço e/ou cartão de
                crédito:
              </h3>
              <div className="incomplete-content">
                {customersIncompleteRegistration.map((customer) => (
                  <div
                    key={customer.idVendedor}
                    className="customer-incomplete-card"
                  >
                    <span>Nome do cliente: {customer.nome}</span>
                    <span>Email do cliente: {customer.email}</span>
                  </div>
                ))}
              </div>
            </>
          ) : (
            <p>Todos os clientes da plataforma já completaram cadastro!</p>
          )}
        </div>
      </div>
    </div>
  );
};
