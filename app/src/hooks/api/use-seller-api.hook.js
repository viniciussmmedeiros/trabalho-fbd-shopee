import { useMemo } from "react";
import { BASE_URL } from "../../constants";
import { useHttp } from "./index";

export const useSellerApi = () => {
  const instance = useHttp(BASE_URL);

  const login = (request) => {
    return instance.post(`sellers/login`, request);
  };

  const getAmountOfSells = (idSeller) => {
    return instance.get(`sellers/${idSeller}/quantidade-vendas`);
  };

  const getMetrics = (sellerId, startDate, endDate) => {
    return instance.get(`sellers/${sellerId}/metricas/${startDate}/${endDate}`);
  };

  const getAddresses = (idSeller) => {
    return instance.get(`sellers/enderecos/${idSeller}`);
  };

  const getOrders = (idSeller) => {
    return instance.get(`sellers/${idSeller}/pedidos`);
  };

  const findByEmail = (email) => {
    return instance.get(`sellers/verifica-email/${email}`);
  };

  return useMemo(
    () => ({
      login,
      getAmountOfSells,
      getMetrics,
      getAddresses,
      getOrders,
      findByEmail,
    }),
    //eslint-disable-next-line
    []
  );
};
