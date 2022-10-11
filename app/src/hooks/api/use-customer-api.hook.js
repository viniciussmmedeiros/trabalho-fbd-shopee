import { useMemo } from "react";
import { BASE_URL } from "../../constants";
import { useHttp } from "./index";

export const useCustomerApi = () => {
  const instance = useHttp(BASE_URL);

  const login = (request) => {
    return instance.post(`clientes/login`, request);
  };

  const getCustomerData = (customerId) => {
    return instance.get(`clientes/dados/${customerId}`);
  };

  const getCustomerCreditCard = (customerId) => {
    return instance.get(`clientes/cartoes-credito/${customerId}`);
  };

  const getCustomerAddress = (customerId) => {
    return instance.get(`clientes/enderecos/${customerId}`);
  };

  const getCustomerCartProducts = (cartId) => {
    return instance.get(`clientes/produtos-carrinho/${cartId}`);
  };

  const getCustomerCartDetails = (customerId) => {
    return instance.get(`clientes/detalhes-carrinho/${customerId}`);
  };

  const getCustomerOrders = (customerId) => {
    return instance.get(`clientes/pedidos/${customerId}`);
  };

  const getCustomerOrderDetails = (orderId) => {
    return instance.get(`clientes/pedido/detalhe/${orderId}`);
  };

  const findByEmail = (email) => {
    return instance.get(`clientes/verifica-email/${email}`);
  };

  const getShipping = () => {
    return instance.get(`clientes/transportadoras`);
  };

  const getCupomFrete = () => {
    return instance.get(`clientes/cupom-frete`);
  };

  const getCupomVinte = () => {
    return instance.get(`clientes/cupom-vinte`);
  };

  const getCupomDez = () => {
    return instance.get(`clientes/cupom-dez`);
  };

  const finishOrder = (request) => {
    return instance.post(`clientes/fazer-pedido`, request);
  };

  const addProductToCart = (cartId, productId) => {
    return instance.post(
      `clientes/adiciona-produto-carrinho/${cartId}/${productId}`
    );
  };

  return useMemo(
    () => ({
      login,
      getCustomerData,
      getCustomerCreditCard,
      getCustomerAddress,
      getCustomerCartProducts,
      getCustomerOrders,
      getCustomerOrderDetails,
      getCustomerCartDetails,
      findByEmail,
      getShipping,
      getCupomFrete,
      getCupomVinte,
      getCupomDez,
      finishOrder,
      addProductToCart,
    }),
    //eslint-disable-next-line
    []
  );
};
