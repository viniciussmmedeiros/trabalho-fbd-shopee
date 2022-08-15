import "./SimplifiedHeader.style.css";
import ColorizedLogo from "../../../assets/shopee-icon-colorized-240.svg";

export const SimplifiedHeader = () => {
  return (
    <header className="simplified-header-wrapper simplified-header-container">
      <div className="simplified-header-logo-wrapper">
        <img src={ColorizedLogo} alt="Logo" />
        <h2>ShopeeFBD</h2>
      </div>
      <p>Precisa de ajuda ?</p>
    </header>
  );
};
