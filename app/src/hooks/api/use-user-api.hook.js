import { useMemo } from "react";
import { BASE_URL } from "../../constants";
import { useHttp } from "./use-http.hook";

export const useUserApi = () => {
  const instance = useHttp(BASE_URL);

  const getSellerData = (sellerId) => {
    return instance.get(`usuarios/${sellerId}/dados`);
  };

  const getRecentOrdersSeller = (sellerId) => {
    return instance.get(`usuarios/${sellerId}/pedidos-recentes`);
  };

  const getSellerHistoryOrders = (sellerId) => {
    return instance.get(`usuarios/${sellerId}/historico-pedidos`);
  };

  return useMemo(
    () => ({
      getSellerData,
      getRecentOrdersSeller,
      getSellerHistoryOrders,
    }),
    //eslint-disable-next-line
    []
  );
};
