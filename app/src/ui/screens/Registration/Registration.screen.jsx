import "./Registration.style.css";
import { useState } from "react";
import ShoppeLogo248 from "../../../assets/shopee-icon-240.svg";
import PasswordHidden from "../../../assets/eye-closed-icon.svg";
import PasswordVisible from "../../../assets/eye-open-icon.svg";
import { CUSTOMER_LOGIN, SELLER_LOGIN } from "../../../constants";
import { SimplifiedHeader } from "../../components";
import { useCustomerApi } from "../../../hooks/api/use-customer-api.hook";
import { useSellerApi } from "../../../hooks/api";

export const RegistrationScreen = () => {
  const sellerApi = useSellerApi();
  const customerApi = useCustomerApi();
  const [isPasswordHidden, setIsPasswordHidden] = useState(false);
  const [isPasswordConfirmationHidden, setIsPasswordConfirmationHidden] =
    useState(false);
  const [loginChoice, setLoginChoice] = useState(CUSTOMER_LOGIN);
  const [emailValue, setEmailValue] = useState(null);

  const handleRegistration = async (event) => {
    event.preventDefault();
    if (loginChoice === CUSTOMER_LOGIN) {
      const cadastroResponse = await customerApi.findByEmail(emailValue);

      if (cadastroResponse) {
        alert("Este email já está cadastrado!");
      } else {
        alert("Email disponível.");
      }
    } else if (loginChoice === SELLER_LOGIN) {
      const cadastroResponse = await sellerApi.findByEmail(emailValue);

      if (cadastroResponse) {
        alert("Este email já está cadastrado!");
      } else {
        alert("Email disponível.");
      }
    }
  };

  return (
    <div className="registration-screen-wrapper">
      <SimplifiedHeader />
      <section className="registration-wrapper">
        <div className="login-form-logo-wrapper">
          <img src={ShoppeLogo248} alt="Logo" />
          <h2>ShopeeFBD</h2>
        </div>
        <form onSubmit={handleRegistration}>
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
          <label htmlFor="">Nome</label>
          <input type="text" />
          <label htmlFor="">Email</label>
          <input
            type="text"
            onChange={(event) => setEmailValue(event.target.value)}
          />
          {loginChoice === CUSTOMER_LOGIN ? (
            <>
              <label htmlFor="">CPF</label>
              <input type="text" />
            </>
          ) : (
            <>
              <label htmlFor="">CNPJ</label>
              <input type="text" />
            </>
          )}
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
          <label htmlFor="">Confirmação da senha</label>
          <div className="password-wrapper">
            <input type={isPasswordConfirmationHidden ? "password" : "text"} />
            <button
              type="button"
              onClick={() =>
                setIsPasswordConfirmationHidden(!isPasswordConfirmationHidden)
              }
              className="password-toggle-visibility-button"
            >
              <img
                src={
                  isPasswordConfirmationHidden
                    ? PasswordHidden
                    : PasswordVisible
                }
                alt="Password view"
              />
            </button>
          </div>
          <button type="submit" className="registration-button">
            Registrar
          </button>
        </form>
      </section>
    </div>
  );
};
