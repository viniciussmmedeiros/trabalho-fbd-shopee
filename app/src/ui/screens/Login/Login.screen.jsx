import "./Login.style.css";
import { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import ShoppeLogo248 from "../../../assets/shopee-icon-240.svg";
import PasswordHidden from "../../../assets/eye-closed-icon.svg";
import PasswordVisible from "../../../assets/eye-open-icon.svg";
import { SimplifiedHeader, Footer } from "../../components";

export const LoginScreen = () => {
  const navigate = useNavigate();
  const [isPasswordHidden, setIsPasswordHidden] = useState(true);

  const handleRegistration = (event) => {
    event.preventDefault();

    alert("parabéns, você logou!");
    navigate("/user/home");
  };

  return (
    <section className="login-screen-wrapper">
      <SimplifiedHeader />
      <div className="login-form-wrapper">
        <div className="login-form-logo-wrapper">
          <img src={ShoppeLogo248} alt="Logo" />
          <h2>ShopeeFBD</h2>
        </div>
        <form onSubmit={handleRegistration}>
          <label htmlFor="">Email</label>
          <input type="text" />
          <label htmlFor="">Senha</label>
          <div className="password-wrapper">
            <input type={isPasswordHidden ? "password" : "text"} />
            <button
              type="button"
              onClick={() => setIsPasswordHidden(!isPasswordHidden)}
              className="password-toggle-visibility-button"
            >
              <img
                src={isPasswordHidden ? PasswordHidden : PasswordVisible}
                alt="Password view"
              />
            </button>
          </div>
          <button type="submit" className="login-button">
            Logar
          </button>
          <span>
            Novo na ShopeeFBD ?{" "}
            <Link to="/registration" className="login-registration-button">
              Cadastrar
            </Link>
          </span>
        </form>
      </div>
      {/* <Footer /> */}
    </section>
  );
};
