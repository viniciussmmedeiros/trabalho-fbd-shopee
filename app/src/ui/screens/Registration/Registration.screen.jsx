import "./Registration.style.css";
import { useState } from "react";

export const RegistrationScreen = () => {
  const [isPasswordHidden, setIsPasswordHidden] = useState(false);

  return (
    <>
      <form action="">
        <label htmlFor="">Email</label>
        <input type="text" />
        <div className="password-wrapper">
          <label htmlFor="">Senha</label>
          <input type={isPasswordHidden ? "password" : "text"} />
          <button>
            <img src="" alt="Password view" />
          </button>
        </div>
        <div className="password-wrapper">
          <label htmlFor="">Confirmação da senha</label>
          <input type={isPasswordHidden ? "password" : "text"} />
          <button>
            <img src="" alt="Password view" />
          </button>
        </div>
        <button type="submit">Registrar</button>
      </form>
    </>
  );
};
