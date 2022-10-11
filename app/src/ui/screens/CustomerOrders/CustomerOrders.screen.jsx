import "./CustomerOrders.style.css";
import { useState, useEffect } from "react";
import { useUserApi } from "../../../hooks/api";
import { useUsuarioGlobal } from "../../../context";
import { SimplifiedHeader } from "../../components";
import { useCustomerApi } from "../../../hooks/api/use-customer-api.hook";

export const CustomerOrdersScreen = () => {
  const userApi = useUserApi();
  const customerApi = useCustomerApi();
  const usuario = useUsuarioGlobal();
  const [cartProducts, setCartProducts] = useState(null);
  const [cartDetails, setCartDetails] = useState(null);
  const [customerAddress, setCustomerAddress] = useState(null);
  const [customerCreditCard, setCustomerCreditCard] = useState(null);
  const [shipping, setShipping] = useState(null);
  const [cupomFrete, setCupomFrete] = useState(null);
  const [cupomDez, setCupomDez] = useState(null);
  const [cupomVinte, setCupomVinte] = useState(null);
  const [makeOrder, setMakeOrder] = useState(false);
  const [choosenShipping, setChoosenShipping] = useState(null);
  const [choosenCard, setChoosenCard] = useState(null);
  const [choosenAddress, setChoosenAddress] = useState(null);

  useEffect(() => {
    const fetchCartProducts = async () => {
      const cartProductsResponse = await customerApi.getCustomerCartProducts(
        usuario[0].idCarrinho
      );

      setCartProducts(cartProductsResponse);
    };

    fetchCartProducts();

    //eslint-disable-next-line
  }, [userApi]);

  useEffect(() => {
    const fetchCartDetails = async () => {
      const cartDetailsResponse = await customerApi.getCustomerCartDetails(
        usuario[0].id
      );

      setCartDetails(cartDetailsResponse[0]);
    };

    fetchCartDetails();

    //eslint-disable-next-line
  }, [userApi]);

  const handleEfetuarPedido = async () => {
    const customerAddresses = await customerApi.getCustomerAddress(
      usuario[0].id
    );
    const customerCards = await customerApi.getCustomerCreditCard(
      usuario[0].id
    );
    const shipping = await customerApi.getShipping();
    const cupomFrete = await customerApi.getCupomFrete();
    const cupomVinte = await customerApi.getCupomVinte();
    const cupomDez = await customerApi.getCupomDez();

    setCustomerAddress(customerAddresses);
    setCustomerCreditCard(customerCards);
    setShipping(shipping);
    setCupomFrete(cupomFrete[0]);
    setCupomVinte(cupomVinte[0]);
    setCupomDez(cupomDez[0]);
    setMakeOrder(true);
  };

  const handleFinishOrder = async () => {
    await customerApi.finishOrder({
      dataRealizacao: Date.now(),
      idCliente: usuario[0].id,
      idTransportadora: choosenShipping,
      idEndereco: choosenAddress,
      idCartaoCredito: choosenCard,
      produtos: cartProducts.reduce((prev, curr) => {
        return [...prev, curr.id];
      }, []),
    });

    alert("Pedido efetuado com sucesso.");
  };

  return (
    <div className="customer-cart-wrapper">
      <SimplifiedHeader />
      <div className="cart-content">
        <h1>Seu carrinho</h1>

        {cartProducts ? (
          cartProducts.map((product) => (
            <div className="cart-product" key={product.id}>
              <div>
                <span>{product.nome}</span>
                <img src={product.imagemUrl} alt="" />
              </div>
              <p>Descrição: {product.descricao}</p>
              <span>R$ {product.preco}</span>
              <span>Vendedor: {product.nomeVendedor}</span>
            </div>
          ))
        ) : (
          <p>Não há produtos aqui.</p>
        )}

        {cartDetails && (
          <div className="cart-details">
            <span>Quantidade de produtos: {cartDetails.quantidade}</span>
            <span>Valor total: R$ {cartDetails.valorTotal}</span>
          </div>
        )}

        <button onClick={() => handleEfetuarPedido()}>Efetuar pedido</button>

        {makeOrder && (
          <>
            <h3>Escolha uma transportadora:</h3>
            {shipping &&
              shipping.map((shippingCompany) => (
                <div
                  key={shippingCompany.id}
                  className={`shipping-card active-${
                    shippingCompany.id === choosenShipping
                  }`}
                  onClick={() => setChoosenShipping(shippingCompany.id)}
                >
                  <span>{shippingCompany.nome}</span>
                </div>
              ))}
            <h3>Escolha um endereço:</h3>
            {customerAddress &&
              customerAddress.map((address) => (
                <div
                  key={address.id}
                  className={`address-card active-${
                    address.id === choosenAddress
                  }`}
                  onClick={() => setChoosenAddress(address.id)}
                >
                  <span>{address.uf}</span>
                  <span>{address.cidade}</span>
                  <span>{address.logradouro}</span>
                  <span>{address.numero}</span>
                </div>
              ))}
            <h3>Escolha um cartão de crédito:</h3>
            {customerCreditCard &&
              customerCreditCard.map((card) => (
                <div
                  key={card.id}
                  className={`card-card active-${card.id === choosenCard}`}
                  onClick={() => setChoosenCard(card.id)}
                >
                  <span>{card.nome}</span>
                  <span>{card.numero}</span>
                  <span>{card.dataVencimento}</span>
                  <span>{card.cvv}</span>
                </div>
              ))}
            <h3>Você pode escolher um cupom:</h3>
            <input type="text" />
            <div className="cupom-card">
              {cupomFrete && (
                <>
                  <span>{cupomFrete.codigo}</span>
                </>
              )}
            </div>
            <div className="cupom-card">
              {cupomVinte && (
                <>
                  <span>{cupomVinte.codigo}</span>
                  <span> -- {cupomVinte.porcentagem * 100}%</span>
                </>
              )}
            </div>
            <div className="cupom-card">
              {cupomDez && (
                <>
                  <span>{cupomDez.codigo}</span>
                  <span> -- {cupomDez.porcentagem * 100}%</span>
                </>
              )}
            </div>
            <button onClick={() => handleFinishOrder()}>Concluir</button>
          </>
        )}
      </div>
    </div>
  );
};
