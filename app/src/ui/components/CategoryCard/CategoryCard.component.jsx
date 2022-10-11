import "./CategoryCard.style.css";

export const CategoryCard = ({ category, setProductsFilter }) => {
  return (
    <div
      className="category-card"
      onClick={() => setProductsFilter(category.id)}
    >
      <span>{category.nome}</span>
    </div>
  );
};
