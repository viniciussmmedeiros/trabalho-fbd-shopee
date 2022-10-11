import "./HeaderHome.style.css";
import { Link } from "react-router-dom";
import { images } from "../../../assets";

export const HeaderHome = ({ searchText, setSearchText, handlePesquisa }) => {
  return (
    <header className="header-wrapper _container">
      <div className="header-logo-wrapper">
        <img src={images.shopeeIcon} alt="Header logo" />
        <span>ShopeeFBD</span>
      </div>
      <div className="header-search-wrapper">
        <input
          type="text"
          value={searchText}
          placeholder="Buscar na ShopeeFBD"
          onChange={(e) => setSearchText(e.target.value)}
        />
        <button onClick={handlePesquisa}>
          <img src={images.searchIcon} alt="Search icon" />
        </button>
      </div>

      <div className="user-btns">
        <Link to="/cliente/meu-perfil" className="user-button">
          <img src={images.user} alt="user account" />
        </Link>

        <Link to="/cliente/carrinho" className="shopping-cart-button">
          <img src={images.shoppingCart} alt="shooping cart" />
        </Link>
      </div>
    </header>
  );
};
