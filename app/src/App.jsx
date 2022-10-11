import { Routes, Route } from "react-router-dom";
import {
  LoginScreen,
  RegistrationScreen,
  LoginRegistrationScreen,
  CustomerHomeScreen,
  SellerHomeScreen,
  CustomerDataScreen,
  CustomerOrdersScreen,
  ProductScreen,
  SellerProductsScreen,
  CustomerProfileScreen,
  AdminHomeScreen,
} from "./ui/screens";

function App() {
  return (
    <>
      <Routes>
        <Route path="/" element={<LoginRegistrationScreen />} />
        <Route path="/admin/home" element={<AdminHomeScreen />} />
        <Route path="/login" element={<LoginScreen />} />
        <Route path="/cadastro" element={<RegistrationScreen />} />
        <Route path="/cliente/meu-perfil" element={<CustomerProfileScreen />} />
        <Route path="/cliente/home" element={<CustomerHomeScreen />} />
        <Route path="/produto" element={<ProductScreen />} />
        <Route
          path="/produto/produtos-vendedor"
          element={<SellerProductsScreen />}
        />
        <Route path="/vendedor/home" element={<SellerHomeScreen />} />
        <Route path="/cliente/info" element={<CustomerDataScreen />} />
        <Route path="/cliente/carrinho" element={<CustomerOrdersScreen />} />
      </Routes>
    </>
  );
}

export default App;
