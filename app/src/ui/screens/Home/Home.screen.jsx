import "./Home.style.css";

import { ProductsScreen } from "../../screens";
import { Header, Categories } from "../../components";

export const HomeScreen = () => {
  return (
    <>
      <Header />
      <Categories />
      <ProductsScreen />
    </>
  );
};
