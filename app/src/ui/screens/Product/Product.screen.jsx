import "./Product.style.css";
import { useLocation, useNavigate } from "react-router-dom";
import { useState, useEffect } from "react";
import { ReviewCard, SimplifiedHeader } from "../../components";
import { useProductApi, useSellerApi } from "../../../hooks/api";
import { useCustomerApi } from "../../../hooks/api/use-customer-api.hook";
import { useUsuarioGlobal } from "../../../context";

export const ProductScreen = () => {
  const navigate = useNavigate();
  const { state } = useLocation();
  const productApi = useProductApi();
  const customerApi = useCustomerApi();
  const sellerApi = useSellerApi();
  const [reviews, setReviews] = useState(null);
  const [amountOfSells, setAmountOfSells] = useState(null);
  const usuario = useUsuarioGlobal();

  useEffect(() => {
    const fetchProductReviews = async () => {
      const reviewsResponse = await productApi.getReviews(state.product.id);

      setReviews(reviewsResponse);
    };

    fetchProductReviews();
  }, [productApi, state.product.id]);

  useEffect(() => {
    const fetchAmountOfSells = async () => {
      const amountOfSellsResponse = await sellerApi.getAmountOfSells(
        state.product.idVendedor
      );
      setAmountOfSells(amountOfSellsResponse);
    };

    fetchAmountOfSells();
  }, [sellerApi, state.product.idVendedor]);

  const addToCart = async () => {
    await customerApi.addProductToCart(usuario[0].idCarrinho, state.product.id);
    alert("Produto adicionado ao carrinho!");
  };

  return (
    <div className="product-screen-wrapper">
      <SimplifiedHeader />
      <div className="_container">
        <section className="product-screen-section-info">
          <img src={state.product.imagemUrl} alt="" />
          <div className="product-screen-info">
            <h2>{state.product.nome}</h2>
            <span>R$ {state.product.preco}</span>
            <button onClick={() => addToCart()}>Adicionar ao carrinho</button>
          </div>
        </section>
        <section className="product-screen-section-seller">
          <span>Vendedor: {state.product.nomeVendedor}</span>
          <span>
            NotaVendedor: {state.product.nota || "Vendedor ainda não avaliado"}
          </span>
          <span>Quantidade de vendas: {amountOfSells}</span>
          <button
            onClick={() =>
              navigate("produtos-vendedor", {
                state: {
                  idVendedor: state.product.idVendedor,
                  nomeVendedor: state.product.nomeVendedor,
                  notaVendedor: state.product.nota,
                  quantidadeVendas: amountOfSells,
                },
              })
            }
          >
            Ver outros produtos do vendedor
          </button>
        </section>
        <section className="product-screen-section-details">
          <p>Descrição do produto: {state.product.descricao}</p>
          <span>Categoria: {state.product.nomeCategoria}</span>
          <span>
            Descrição da categoria: {state.product.descricaoCategoria}
          </span>
        </section>
        <section className="product-screen-section-reviews">
          <h3>Avaliações</h3>
          {reviews ? (
            reviews.map((review) => (
              <ReviewCard key={review.id} review={review} />
            ))
          ) : (
            <p>Ainda não há avaliações.</p>
          )}
        </section>
      </div>
    </div>
  );
};
