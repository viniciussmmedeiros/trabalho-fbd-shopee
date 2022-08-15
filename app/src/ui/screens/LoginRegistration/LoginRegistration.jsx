import "./LoginRegistration.style.css";
import { Link } from "react-router-dom";
import ShoppeLogo248 from "../../../assets/shopee-icon-240.svg";

export const LoginRegistrationScreen = () => {
  return (
    <section className="home-screen-wrapper">
      <div className="shopee-logo-wrapper">
        <img src={ShoppeLogo248} alt="Shopee Logo" />
        <h1>ShopeeFBD</h1>
      </div>
      <div className="buttons-wrapper">
        <Link to="/login">Logar</Link>
        <Link to="/registration">Registrar</Link>
      </div>
      <Link to="/public/home" className="continue-without-registration-button">
        Continuar sem registro
      </Link>
    </section>
  );
};
