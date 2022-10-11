import "./ProductCard.style.css";
import { useNavigate } from "react-router-dom";

export const ProductCard = ({ product }) => {
  const navigate = useNavigate();

  return (
    <div
      className="product-card"
      onClick={() => navigate("/produto", { state: { product } })}
    >
      <img src={product.imagemUrl} alt="" />
      <div className="product-card-info">
        <span>{product.nome}</span>
        <p>{product.descricao}</p>
        <span>Preço: R$ {product.preco}</span>
        <span className="product-card-seller-name">
          Vendedor: {product.nomeVendedor}
        </span>
      </div>
    </div>
  );
};
