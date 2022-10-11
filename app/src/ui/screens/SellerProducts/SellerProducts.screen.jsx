import "./SellerProducts.style.css";
import { useLocation } from "react-router-dom";
import { useState, useEffect } from "react";
import { useProductApi } from "../../../hooks/api";
import { ProductCard, SimplifiedHeader } from "../../components";

export const SellerProductsScreen = () => {
  const { state } = useLocation();
  const productApi = useProductApi();
  const [sellerProducts, setSellerProducts] = useState(null);
  const [currentPage, setCurrentPage] = useState(0);
  const [isPreviousDisabled, setIsPreviousDisabled] = useState(false);
  const [isNextDisabled, setIsNextDisabled] = useState(false);

  useEffect(() => {
    const fetchSellerProducts = async () => {
      const sellerProductsResponse = await productApi.getSellerProducts(
        currentPage,
        state.idVendedor
      );

      setSellerProducts(sellerProductsResponse.content);

      setIsNextDisabled(false);
      setIsPreviousDisabled(false);

      if (sellerProductsResponse.empty) {
        setIsNextDisabled(true);
      }

      if (currentPage === 0) {
        setIsPreviousDisabled(true);
      }
    };

    fetchSellerProducts();
  }, [productApi, state.idVendedor, currentPage]);

  const handlePreviousPage = () => {
    setCurrentPage((currentPage) => currentPage - 1);
  };

  const handleNextPage = () => {
    setCurrentPage((currentPage) => currentPage + 1);
  };

  return (
    <div className="seller-products-wrapper">
      <SimplifiedHeader />
      <div>
        <div className="seller-products-info">
          <span>Vendedor: {state.nomeVendedor}</span>
          <span>
            NotaVendedor: {state.notaVendedor || "Vendedor ainda não avaliado"}
          </span>
          <span>Quantidade de vendas: {state.quantidadeVendas}</span>
        </div>
        <div className="products-wrapper _container">
          <button
            className={`products-previous-page-button products-disabled-${isPreviousDisabled}`}
            disabled={isPreviousDisabled}
            onClick={handlePreviousPage}
          ></button>

          {sellerProducts &&
            sellerProducts.map((sellerProduct) => (
              <ProductCard key={sellerProduct.id} product={sellerProduct} />
            ))}

          <button
            className={`products-next-page-button products-disabled-${isNextDisabled}`}
            disabled={isNextDisabled}
            onClick={handleNextPage}
          ></button>
        </div>
      </div>
    </div>
  );
};
