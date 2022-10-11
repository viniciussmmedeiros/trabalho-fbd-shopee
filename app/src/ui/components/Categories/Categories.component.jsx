import "./Categories.style.css";
import { useState, useEffect } from "react";
import { CategoryCard } from "../index";
import { useProductApi } from "../../../hooks/api";

export const Categories = ({ setProductsFilter }) => {
  const productApi = useProductApi();
  const [categories, setCategories] = useState(null);
  const [currentPage, setCurrentPage] = useState(0);
  const [isPreviousDisabled, setIsPreviousDisabled] = useState(false);
  const [isNextDisabled, setIsNextDisabled] = useState(false);

  useEffect(() => {
    const fetchCategories = async () => {
      const categoriesResponse = await productApi.getCategories(currentPage);

      setCategories(categoriesResponse.content);

      setIsNextDisabled(false);
      setIsPreviousDisabled(false);

      if (categoriesResponse.last) {
        setIsNextDisabled(true);
      }

      if (categoriesResponse.first) {
        setIsPreviousDisabled(true);
      }
    };

    fetchCategories();
  }, [productApi, currentPage]);

  const handlePreviousPage = () => {
    setCurrentPage((currentPage) => currentPage - 1);
  };

  const handleNextPage = () => {
    setCurrentPage((currentPage) => currentPage + 1);
  };

  return (
    <section className="categories-wrapper">
      <CategoryCard
        key={0}
        category={{ id: 0, nome: "Geral" }}
        setProductsFilter={setProductsFilter}
      />
      <div className="categories">
        <button
          className={`previous-page-button disabled-${isPreviousDisabled}`}
          disabled={isPreviousDisabled}
          onClick={handlePreviousPage}
        ></button>
        {categories &&
          categories.map((category) => (
            <CategoryCard
              key={category.id}
              category={category}
              setProductsFilter={setProductsFilter}
            />
          ))}
        <button
          className={`next-page-button disabled-${isNextDisabled}`}
          disabled={isNextDisabled}
          onClick={handleNextPage}
        ></button>
      </div>
    </section>
  );
};
