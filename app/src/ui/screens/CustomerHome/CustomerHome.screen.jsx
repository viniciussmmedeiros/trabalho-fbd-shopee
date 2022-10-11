import "./CustomerHome.style.css";
import { useState } from "react";
import { ProductsScreen } from "..";
import { HeaderHome, Categories } from "../../components";
import { useProductApi } from "../../../hooks/api";

export const CustomerHomeScreen = () => {
  const productApi = useProductApi();
  const [productsSearch, setProductsSearch] = useState(null);
  const [productsFilter, setProductsFilter] = useState(0);
  const [currentPage, setCurrentPage] = useState(0);
  const [searchText, setSearchText] = useState("");

  const handlePesquisa = () => {
    const fetchSearchResults = async () => {
      const searchResponse = await productApi.getProductsSearch(
        currentPage,
        searchText
      );

      setProductsSearch(searchResponse.content);
    };

    fetchSearchResults();
  };

  return (
    <>
      <HeaderHome
        searchText={searchText}
        setSearchText={setSearchText}
        handlePesquisa={handlePesquisa}
      />
      <Categories setProductsFilter={setProductsFilter} />
      <ProductsScreen
        productsSearch={productsSearch}
        productsFilter={productsFilter}
        setCurrentPageSearch={setCurrentPage}
      />
    </>
  );
};
