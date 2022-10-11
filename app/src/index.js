import React from "react";
import ReactDOM from "react-dom/client";
import "./index.css";
import App from "./App";
import { BrowserRouter } from "react-router-dom";
import { UsuarioGlobalProvider } from "./context";

const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(
  <UsuarioGlobalProvider>
    <BrowserRouter>
      <App />
    </BrowserRouter>
  </UsuarioGlobalProvider>
);
