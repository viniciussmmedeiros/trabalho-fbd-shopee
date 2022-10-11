import { useMemo } from "react";
import { BASE_URL, SIZE_PAGINATION } from "../../constants";
import { useHttp } from "./index";

export const useProductApi = () => {
  const instance = useHttp(BASE_URL);

  const getCategories = (page) => {
    return instance.get(
      `products/categorias?page=${page}&size=${SIZE_PAGINATION.CATEGORIES}`
    );
  };

  const getProducts = async (page, filter = 0) => {
    return instance.get(
      `products/categoria/${filter}?page=${page}&size=${SIZE_PAGINATION.PRODUCTS}`
    );
  };

  const getSellerProducts = async (page, idVendedor) => {
    return instance.get(
      `products/vendedor/${idVendedor}?page=${page}&size=${SIZE_PAGINATION.PRODUCTS}`
    );
  };

  const getProductsSearch = async (page, searchText) => {
    return instance.get(
      `products/pesquisa/${searchText}?page=${page}&size=${SIZE_PAGINATION.PRODUCTS}`
    );
  };

  const getReviews = async (idProduct) => {
    return instance.get(`products/${idProduct}/avaliacoes`);
  };

  return useMemo(
    () => ({
      getCategories,
      getProducts,
      getProductsSearch,
      getReviews,
      getSellerProducts,
    }),
    //eslint-disable-next-line
    []
  );
};
