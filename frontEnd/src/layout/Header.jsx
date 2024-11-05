import React, { useState } from 'react';
import './Header.css';
import Logo from "../images/logo.png";
import Search from "../images/pesquisa.png";
import miniBar from "../images/mini-bar.svg";
import closeIcon from "../images/fechar.svg"; 
import user from "../images/usuario.svg";
import sacola from "../images/sacola1.png";
import { Link } from 'react-router-dom';

function Header() {
  const [menuOpen, setMenuOpen] = useState(false); 

  const toggleMenu = () => {
    setMenuOpen(!menuOpen); // Alterna o estado do menu
  };

  return (
    <>
      <header>
        <div>
        <button className="mini-bar" onClick={toggleMenu}>
          <img src={miniBar} alt="Menu" />
        </button>
        </div>
        <div> 
          <Link to="/" className="logo">
            <img src={Logo} alt="Logo" />
          </Link>
        </div>
        <div>
          <input className='typeSearch' type="text" placeholder="Pesquisar" />
          <div className="search">
            <img src={Search} alt="Search" />
          </div>
          <Link to="/login" className='user'>
            <img src={user} alt="Usuario" />
          </Link>
          <div className='sacola'>
            <img src={sacola} alt="Sacola" />
          </div>
        </div>
        
      </header>

      {/* Menu lateral */}
      <div className={`side-menu ${menuOpen ? 'open' : ''}`}>
        <img 
          src={closeIcon} 
          alt="Close" 
          className="close-icon" 
          onClick={toggleMenu} // Fecha o menu ao clicar no ícone de fechar
        />
        <ul className="menu-options">
          <li className="menu-item">
            <Link to="/roupas">
              <span>ROUPAS</span>
            </Link>
            <div className="menu-line"></div>
          </li>
          <li className="menu-item">
            <Link to="/masculino">
              <span>MASCULINO</span>
            </Link>
            <div className="menu-line"></div>
          </li>
          <li className="menu-item">
            <Link to="/feminino">
              <span>FEMININO</span>
            </Link>
            <div className="menu-line"></div>
          </li>
          <li className="menu-item">
            <Link to="/contatos">
              <span>CONTATO</span>
            </Link>
            <div className="menu-line"></div>
          </li>
        </ul>
      </div>
    </>
  );
}

export default Header;
