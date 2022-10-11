import { useState, useEffect } from "react";
import { useUsuarioGlobal } from "../../../context";
import { useCustomerApi } from "../../../hooks/api/use-customer-api.hook";
import { SimplifiedHeader } from "../../components";
import "./CustomerProfile.style.css";

export const CustomerProfileScreen = () => {
  const customerApi = useCustomerApi();
  const usuarioGlobal = useUsuarioGlobal();
  const [customerData, setCustomerData] = useState(null);
  const [customerCreditCard, setCustomerCreditCard] = useState(null);
  const [customerAddress, setCustomerAddress] = useState(null);
  const [customerOrders, setCustomerOrders] = useState(null);
  const [customerOrderDetails, setCustomerOrderDetails] = useState(null);

  useEffect(() => {
    const fetchCustomerData = async () => {
      const customerDataResponse = await customerApi.getCustomerData(
        usuarioGlobal[0].id
      );

      setCustomerData(customerDataResponse[0]);
    };

    fetchCustomerData();

    //eslint-disable-next-line
  }, [customerApi]);

  useEffect(() => {
    const fetchCustomerCreditCard = async () => {
      const customerCreditCardResponse =
        await customerApi.getCustomerCreditCard(usuarioGlobal[0].id);

      setCustomerCreditCard(customerCreditCardResponse);
    };

    fetchCustomerCreditCard();

    //eslint-disable-next-line
  }, [customerApi]);

  useEffect(() => {
    const fetchCustomerAddress = async () => {
      const customerAddressResponse = await customerApi.getCustomerAddress(
        usuarioGlobal[0].id
      );

      setCustomerAddress(customerAddressResponse);
    };

    fetchCustomerAddress();

    //eslint-disable-next-line
  }, [customerApi]);

  useEffect(() => {
    const fetchCustomerOrders = async () => {
      const customerOrdersResponse = await customerApi.getCustomerOrders(
        usuarioGlobal[0].id
      );

      setCustomerOrders(customerOrdersResponse);
    };

    fetchCustomerOrders();

    //eslint-disable-next-line
  }, [customerApi]);

  const fetchOrderDetails = async (orderId) => {
    const customerOrderDetailsResponse =
      await customerApi.getCustomerOrderDetails(orderId);

    setCustomerOrderDetails(customerOrderDetailsResponse);
  };

  return (
    <div className="customer-profile-wrapper">
      <SimplifiedHeader />
      <div className="customer-profile-info _container">
        <h1>Seu perfil</h1>
        <div className="customer-info">
          {customerData && (
            <>
              <span>Seu nome:{customerData.nome}</span>
              <span>Seu email:{customerData.email}</span>
              <span>Seu cpf:{customerData.cpf}</span>
            </>
          )}
        </div>
        <div className="customer-credit-cards">
          <span>Seus cartões:</span>
          {customerCreditCard &&
            customerCreditCard.map((card) => (
              <div className="customer-credit-card-card" key={card.id}>
                <p>Nome: {card.nome}</p>
                <p>Número: {card.numero}</p>
                <p>Data de vencimento: {card.dataVencimento}</p>
                <p>CVV: {card.cvv}</p>
              </div>
            ))}
        </div>
        <div className="customer-addresses">
          <span>Seus endereços:</span>
          {customerAddress &&
            customerAddress.map((address) => (
              <div className="customer-address-card" key={address.id}>
                <p>UF: {address.uf}</p>
                <p>Cidade: {address.cidade}</p>
                <p>Logradouro: {address.logradouro}</p>
                <p>Numero: {address.numero}</p>
                {address?.complemento && (
                  <p>Complemento: {address.complemento}</p>
                )}
              </div>
            ))}
        </div>
        <div className="customer-orders">
          <span>Seus pedidos:</span>
          {customerOrders &&
            customerOrders.map((order) => (
              <div
                className="customer-order-card"
                key={order.id}
                onClick={() => fetchOrderDetails(order.id)}
              >
                <span>Transportadora: {order.nomeTransportadora}</span>
                <div>
                  <span>Cartão utilizado:</span>
                  <span>{order.nomeCartao} </span>
                  <span>{order.numeroCartao}</span>
                </div>
                <div>
                  <span>Endereço utilizado:</span>
                  <span>{order.cidade} </span>
                  <span>{order.uf} </span>
                  <span>{order.logradouro} </span>
                  <span>{order.numero}</span>
                </div>
              </div>
            ))}
        </div>
        <div className="customer-order-details">
          <h2>Detalhes do pedido:</h2>
          {customerOrderDetails &&
            customerOrderDetails.map((detail) => (
              <div key={detail.id} className="order-detail-card">
                <span>Vendedor: {detail.nomeVendedor}</span>
                <img src={detail.imagemUrl} alt="" />
                <span>{detail.nomeProduto}</span>
                <span>R${detail.preco}</span>
              </div>
            ))}
        </div>
      </div>
    </div>
  );
};
