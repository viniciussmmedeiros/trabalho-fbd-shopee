import "./Products.style.css";
import { ProductCard } from "../../components";
import { useState, useEffect } from "react";
import { useProductApi } from "../../../hooks/api";

export const ProductsScreen = ({
  productsSearch,
  productsFilter,
  setCurrentPageSearch,
}) => {
  const productApi = useProductApi();
  const [products, setProducts] = useState(productsSearch || null);
  const [currentPage, setCurrentPage] = useState(0);
  const [isPreviousDisabled, setIsPreviousDisabled] = useState(false);
  const [isNextDisabled, setIsNextDisabled] = useState(false);

  useEffect(() => {
    const fetchProducts = async () => {
      const productsResponse = await productApi.getProducts(
        currentPage,
        productsFilter
      );

      setProducts(productsResponse.content);
      setIsNextDisabled(false);
      setIsPreviousDisabled(false);

      if (productsResponse.empty) {
        setIsNextDisabled(true);
      }

      if (currentPage === 0) {
        setIsPreviousDisabled(true);
      }
    };

    fetchProducts();
  }, [productApi, productsFilter, currentPage]);

  useEffect(() => {
    setCurrentPage(0);
    setCurrentPageSearch(0);
  }, [productsFilter, setCurrentPageSearch]);

  const handlePreviousPage = () => {
    setCurrentPage((currentPage) => currentPage - 1);
    setCurrentPageSearch((currentPage) => currentPage - 1);
  };

  const handleNextPage = () => {
    setCurrentPage((currentPage) => currentPage + 1);
    setCurrentPageSearch((currentPage) => currentPage + 1);
  };

  return (
    <section className="products-wrapper _container">
      {products && (
        <>
          <button
            className={`products-previous-page-button products-disabled-${isPreviousDisabled}`}
            disabled={isPreviousDisabled}
            onClick={handlePreviousPage}
          ></button>
          {products?.length === 0 && <h2>Nenhum resultado encontrado.</h2>}
          {productsSearch?.length === 0 && (
            <h2>Nenhum resultado encontrado.</h2>
          )}
          {productsSearch?.length > 0
            ? productsSearch.map((product) => (
                <ProductCard key={product.id} product={product} />
              ))
            : products.map((product) => (
                <ProductCard key={product.id} product={product} />
              ))}
          <button
            className={`products-next-page-button products-disabled-${isNextDisabled}`}
            disabled={isNextDisabled}
            onClick={handleNextPage}
          ></button>
        </>
      )}
    </section>
  );
};
