import React, { useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import Footer from "../../layout/footer";
import Header from '../../layout/Header';
import Options from '../../layout/Options';
import BottomMenu from '../../layout/BottomMenu';
import FooterF from "../../layout/RodaPe";
import './Login.css';
import { UsuarioService } from '../../../services/UsuarioService';

const usuarioService = new UsuarioService();

function Login() {
  const [popupMessage, setPopupMessage] = useState(null);
  const navigate = useNavigate();

  const handleLogin = async (event) => {
    event.preventDefault();
    const usuario = event.target.usuario.value;
    const senha = event.target.password.value;

    try {
      const response = await usuarioService.login({ usuNome: usuario, senha });

      if (response.message) {
        setPopupMessage(response.message);
        setTimeout(() => navigate("/home"), 2000); // Redireciona após 2 segundos
      } else {
        setPopupMessage("Credenciais inválidas. Tente novamente.");
      }
    } catch (error) {
      console.error("Erro ao fazer login:", error);
      setPopupMessage(error.response ? error.response.data.error : "Erro ao conectar com o servidor.");
    }
  };

  const closePopup = () => {
    setPopupMessage(null);
  };

  return (
    <div>
            <Footer nome="FRETE GRÁTIS ACIMA DE R$ 199" />
      <Header />
      <div>
        <Options />
      </div>
      <div className="login-container">
        <h1>Login</h1>
        <form className="login-form" onSubmit={handleLogin}>
          <label htmlFor="usuario">Usuário</label>
          <input type="text" id="usuario" name="usuario" placeholder="Digite seu nome de usuário" required />
          <label htmlFor="password">Senha</label>
          <input type="password" id="password" name="password" placeholder="Digite sua senha" required />

          <div className="buttons">
            <Link to= "/" type="submit" className="login-button">Entrar</Link>
            <Link to="/registrar" className="signup-button-link">Inscreva-se</Link>
          </div>
        </form>
      </div>
      <FooterF />
      <BottomMenu />

      {popupMessage && (
        <div className="popup">
          <div className="popup-content">
            <h2>{popupMessage}</h2>
            <button onClick={closePopup} className="close-button">Fechar</button>
          </div>
        </div>
      )}
    </div>
  );
}

export default Login;
