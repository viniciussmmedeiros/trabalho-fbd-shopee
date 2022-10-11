import "./Login.style.css";
import { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import ShoppeLogo248 from "../../../assets/shopee-icon-240.svg";
import PasswordHidden from "../../../assets/eye-closed-icon.svg";
import PasswordVisible from "../../../assets/eye-open-icon.svg";
import { SimplifiedHeader } from "../../components";
import { CUSTOMER_LOGIN, SELLER_LOGIN } from "../../../constants";
import { useSellerApi } from "../../../hooks/api";
import { useToastService } from "../../../hooks/service";
import { useCustomerApi } from "../../../hooks/api/use-customer-api.hook";
import { useUsuarioGlobal } from "../../../context";

export const LoginScreen = () => {
  const navigate = useNavigate();
  const sellerApi = useSellerApi();
  const [, setUsuarioGlobal] = useUsuarioGlobal();
  const customerApi = useCustomerApi();
  const { setErrorToast } = useToastService();
  const [isPasswordHidden, setIsPasswordHidden] = useState(true);
  const [loginChoice, setLoginChoice] = useState(CUSTOMER_LOGIN);
  const [loginData, setLoginData] = useState({ email: null, senha: null });

  const handleLogin = async (event) => {
    event.preventDefault();

    try {
      if (loginChoice === CUSTOMER_LOGIN) {
        const loginResponse = await customerApi.login(loginData);
        setUsuarioGlobal(loginResponse[0]);
        navigate("/cliente/home");
      } else if (loginChoice === SELLER_LOGIN) {
        const loginResponse = await sellerApi.login(loginData);
        setUsuarioGlobal(loginResponse[0]);
        navigate("/vendedor/home");
      }
    } catch (error) {
      setErrorToast(error);
    }
  };

  const handleInput = (event) => {
    const { name, value } = event.target;

    setLoginData((previousValues) => ({
      ...previousValues,
      [name]: value,
    }));
  };

  return (
    <section className="login-screen-wrapper">
      <SimplifiedHeader />
      <div className="login-form-wrapper">
        <div className="login-form-logo-wrapper">
          <img src={ShoppeLogo248} alt="Logo" />
          <h2>ShopeeFBD</h2>
        </div>
        <form onSubmit={handleLogin}>
          <div className="login-choice-buttons">
            <span
              className={`${loginChoice === CUSTOMER_LOGIN && "selected"}`}
              onClick={() => setLoginChoice(CUSTOMER_LOGIN)}
            >
              Cliente
            </span>
            <span
              className={`${loginChoice === SELLER_LOGIN && "selected"}`}
              onClick={() => setLoginChoice(SELLER_LOGIN)}
            >
              Vendedor
            </span>
          </div>
          <label htmlFor="">Email</label>
          <input
            name="email"
            type="text"
            onChange={(event) => handleInput(event)}
          />
          <label htmlFor="">Senha</label>
          <div className="password-wrapper">
            <input
              name="senha"
              onChange={(event) => handleInput(event)}
              type={isPasswordHidden ? "password" : "text"}
            />
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
            Novo na ShopeeFBD ?
            <Link to="/registration" className="login-registration-button">
              Cadastrar
            </Link>
          </span>
        </form>
      </div>
    </section>
  );
};
