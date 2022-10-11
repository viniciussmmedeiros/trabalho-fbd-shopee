import { useMemo } from "react";
import { BASE_URL } from "../../constants";
import { useHttp } from "./index";

export const useAdminApi = () => {
  const instance = useHttp(BASE_URL);

  const getSellersNoSellLast30Days = () => {
    return instance.get(`sellers/no-sells-last-30-days`);
  };

  const getCustomersNoOrder = () => {
    return instance.get(`clientes/clientes-sem-pedido`);
  };

  const getCustomersIncompleteRegistration = () => {
    return instance.get(`clientes/clientes-cadastro-incompleto`);
  };

  return useMemo(
    () => ({
      getSellersNoSellLast30Days,
      getCustomersNoOrder,
      getCustomersIncompleteRegistration,
    }),
    //eslint-disable-next-line
    []
  );
};
