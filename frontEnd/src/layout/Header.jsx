import React, { useState, useEffect } from 'react';
import './Header.css';
import Logo from "../images/logo.png";
import miniBar from "../images/mini-bar.svg";
import closeIcon from "../images/fechar.svg";
import user from "../images/usuario.svg";
import sacola from "../images/sacola1.png";
import { Link } from 'react-router-dom';

function Header() {
  const [menuOpen, setMenuOpen] = useState(false);
  const [nomeUsuario, setNomeUsuario] = useState("");
  const [logoutVisible, setLogoutVisible] = useState(false); // Estado para controlar visibilidade do logout

  useEffect(() => {
    const nome = localStorage.getItem("nomeUsuario");
    if (nome) {
      setNomeUsuario(nome);
    }
  }, []);

  const toggleMenu = () => {
    setMenuOpen(!menuOpen);
  };

  const toggleLogout = () => {
    setLogoutVisible(!logoutVisible); // Alterna a visibilidade do botão de logout
  };

  const handleLogout = () => {
    localStorage.removeItem("nomeUsuario");
    setNomeUsuario(""); // Limpa o nome do usuário
    setLogoutVisible(false); // Esconde o botão de logout após o logout
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
        <div className="user-info">
          <span className="username">
            <Link to="/login" className="user">
              {nomeUsuario || "FAÇA LOGIN"}
            </Link>
          </span>
          <Link to="/login" className="user">
            <img src={user} alt="Usuario" />
          </Link>
          <div className="sacola">
            <img src={sacola} alt="Sacola" />
          </div>

          {/* Mostrar o botão de logout apenas quando nomeUsuario estiver definido */}
          {nomeUsuario && (
            <button onClick={handleLogout} className="logout-button">
              LOGOUT
            </button>
          )}
        </div>
      </header>


      {/* Menu lateral */}
      <div className={`side-menu ${menuOpen ? 'open' : ''}`}>
        <img
          src={closeIcon}
          alt="Close"
          className="close-icon"
          onClick={toggleMenu}
        />
        {nomeUsuario && (
          <div className="side-menu-username">
            <span className='nome-usu'> USUÁRIO: {nomeUsuario}</span>
          </div>
        )}
        <ul className="menu-options">
          <li className="menu-item">
            <Link to="/roupas">
              <div>ROUPAS</div>
              <hr />
            </Link>
          </li>

          <li className="menu-item">
            <Link to="/masculino">
              <div>MASCULINO</div>
              <hr />
            </Link>
          </li>

          <li className="menu-item">
            <Link to="/feminino">
              <div>FEMININO</div>
              <hr />
            </Link>
          </li>

          <li className="menu-item">
            <Link to="/contatos">
              <div>CONTATO</div>
              <hr />
            </Link>
          </li>

          {nomeUsuario && (
            <li className="menu-item">
              <button onClick={handleLogout} className="side-menu-logout">
                LOGOUT
              </button>
            </li>
          )}
        </ul>
      </div>
    </>
  );
}

export default Header;
