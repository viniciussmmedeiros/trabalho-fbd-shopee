import "./SellerHome.style.css";
import { useState, useEffect } from "react";
import { useSellerApi } from "../../../hooks/api";
import { useUsuarioGlobal } from "../../../context";
import { SimplifiedHeader } from "../../components";

export const SellerHomeScreen = () => {
  const sellerApi = useSellerApi();
  const usuario = useUsuarioGlobal();
  const [amountOfSells, setAmountOfSells] = useState(null);
  const [sellerMetricsResult, setSellerMetricsResult] = useState(null);
  const [metricsSearchData, setMetricsSearchData] = useState({
    startDate: null,
    endDate: null,
  });
  const [addresses, setAddresses] = useState(null);
  const [sellerOrders, setSellerOrders] = useState(null);

  const fetchMetrics = async () => {
    const metricsResponse = await sellerApi.getMetrics(
      usuario[0].id,
      metricsSearchData.startDate,
      metricsSearchData.endDate
    );

    setSellerMetricsResult(metricsResponse[0]);
  };

  useEffect(() => {
    const fetchSellerAddresses = async () => {
      const addressesResponse = await sellerApi.getAddresses(usuario[0].id);

      setAddresses(addressesResponse);
    };

    fetchSellerAddresses();

    //eslint-disable-next-line
  }, [sellerApi]);

  useEffect(() => {
    const fetchSellerOrders = async () => {
      const sellerOrdersResponse = await sellerApi.getOrders(usuario[0].id);

      setSellerOrders(sellerOrdersResponse);
    };

    fetchSellerOrders();

    //eslint-disable-next-line
  }, [sellerApi]);

  useEffect(() => {
    const fetchAmountOfSells = async () => {
      const amountOfSellsResponse = await sellerApi.getAmountOfSells(
        usuario[0].id
      );

      setAmountOfSells(amountOfSellsResponse);
    };

    fetchAmountOfSells();
    //eslint-disable-next-line
  }, [sellerApi]);

  const handleMetricsSearch = (event) => {
    const { name, value } = event.target;

    setMetricsSearchData((previousValues) => ({
      ...previousValues,
      [name]: value,
    }));
  };

  return (
    <div className="seller-home-wrapper">
      <SimplifiedHeader />
      <div className="seller-home-content">
        <h1>Ol??, {usuario[0].nome}</h1>
        {amountOfSells && <span>N??mero total de vendas: {amountOfSells}</span>}
        <span>
          Sua avalia????o:{" "}
          {usuario[0].nota === 0 ? "Ainda n??o avaliado" : usuario[0].nota}
        </span>
        <div className="seller-metrics">
          <h2>Pesquise n??mero de vendas e valor total por per??odo</h2>
          <span>Data in??cio</span>
          <input
            type="date"
            name="startDate"
            onChange={(event) => handleMetricsSearch(event)}
          ></input>
          <span>Data fim</span>
          <input
            type="date"
            name="endDate"
            onChange={(event) => handleMetricsSearch(event)}
          ></input>
          <button onClick={() => fetchMetrics()}>Pesquisar</button>
        </div>
        <div>
          {sellerMetricsResult && (
            <div className="seller-metrics-result">
              <h2>Resultado:</h2>
              <span>
                N??mero de vendas no per??odo:{" "}
                {sellerMetricsResult.quantidadeVendas}
              </span>
              <span>
                Valor total vendido no per??odo: R${" "}
                {sellerMetricsResult.valorTotal}
              </span>
            </div>
          )}
        </div>
        <div className="seller-addresses">
          <h2>Seus endere??os:</h2>
          {addresses &&
            addresses.map((address) => (
              <div className="customer-address-card" key={address.id}>
                <p>UF: {address.uf}</p>
                <p>Cidade: {address.cidade}</p>
                <p>Logradouro: {address.logradouro}</p>
                <p>Numero: {address.numero}</p>
                {address?.complemento && (
                  <p>Complemento: {address.complemento}</p>
                )}
              </div>
            ))}
        </div>
        <div className="seller-orders">
          <h2>Seus pedidos:</h2>
          {sellerOrders &&
            sellerOrders.map((order) => (
              <div className="seller-order-card" key={Date.now}>
                <div>
                  <span>{order.nomeProduto}</span>
                  <img src={order.imagemUrl} alt="" />
                </div>
                <div>
                  <span>Cliente: {order.nomeCliente}</span>
                </div>
                <span>Transportadora: {order.nomeTransportadora}</span>
                <p>Data realiza????o: {order.dataRealizacao}</p>
              </div>
            ))}
        </div>
      </div>
    </div>
  );
};
