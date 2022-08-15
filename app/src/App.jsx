import { Routes, Route } from "react-router-dom";
import {
  HomeScreen,
  LoginScreen,
  RegistrationScreen,
  LoginRegistrationScreen,
} from "./ui/screens";

function App() {
  return (
    <>
      <Routes>
        <Route path="/" element={<LoginRegistrationScreen />} />
        <Route path="/login" element={<LoginScreen />} />
        <Route path="/registration" element={<RegistrationScreen />} />
        <Route path="/user/home" element={<HomeScreen />} />
        <Route path="/public/home" element={<HomeScreen />} />
      </Routes>
    </>
  );
}

export default App;
