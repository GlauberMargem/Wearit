// src/pages/Login/login.jsx
import Footer from "../../layout/footer";
import Header from '../../layout/Header';
import Options from '../../layout/Options';
import BottomMenu from '../../layout/BottomMenu';
import FooterF from "../../layout/RodaPe";
import React, { useState } from 'react';
import './Login.css';
import { Link } from 'react-router-dom';
import { UsuarioService } from '../../../services/UsuarioService'; // Ajuste o caminho do import

const usuarioService = new UsuarioService(); // Instância do serviço

function Login() {
  const [popupMessage, setPopupMessage] = useState(null);

  const handleLogin = async (event) => {
    event.preventDefault();
    const usuario = event.target.usuario.value;
    const senha = event.target.password.value;

    try {
      const response = await usuarioService.login({ nomeUsuario: usuario, senha }); // Use o método de login

      // Verifique a estrutura da resposta aqui
      if (response && response.status === 200) {
        setPopupMessage("Login realizado com sucesso!");
        // Redirecionar ou realizar outra ação após o login bem-sucedido
      } else {
        setPopupMessage("Credenciais inválidas. Tente novamente.");
      }
    } catch (error) {
      console.error("Erro ao fazer login:", error); // Log do erro para ajudar na depuração
      setPopupMessage("Credenciais inválidas. Tente novamente.");
    }
  };

  const closePopup = () => {
    setPopupMessage(null);
  };

  return (
    <div>
      <Footer nome="SIGA-NOS NO INSTAGRAM @WEARIT." />
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
            <button type="submit" className="login-button">Entrar</button>
            <Link to="/registrar" className="signup-button-link">
              Inscreva-se
            </Link>
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
