import React, { useState } from 'react';
import Header from '../../layout/Header';
import Options from '../../layout/Options';
import Footer from "../../layout/Footer";
import BottomMenu from '../../layout/BottomMenu';
import FooterF from "../../layout/RodaPe";
import { Link } from 'react-router-dom';
import { useNavigate } from 'react-router-dom';
import { UsuarioService } from '../../../services/UsuarioService'; // Supondo que o caminho esteja correto
import './Login.css';


function Login() {
  const [popupMessage, setPopupMessage] = useState("");
  const navigate = useNavigate();

  // Função para lidar com o login
  const handleLogin = async (event) => {
    event.preventDefault();
    const usuario = event.target.usuario.value;
    const senha = event.target.password.value;

    try {
      const response = await new UsuarioService().login({ usuNome: usuario, senha });

      if (response.message) {
        setPopupMessage(response.message);
        setTimeout(() => {
          // Armazenando o nome do usuário no localStorage
          localStorage.setItem("nomeUsuario", usuario);
          navigate("/"); // Redireciona para a página inicial
        }, 2000);
      } else {
        setPopupMessage("Credenciais inválidas. Tente novamente.");
      }
    } catch (error) {
      console.error("Erro ao fazer login:", error);
      setPopupMessage(error.response ? error.response.data.error : "Erro ao conectar com o servidor.");
    }
  };

  return (
    <div>
      <Footer nome="FRETE GRÁTIS EM COMPRAS A PARTIR DE R$ 199,00" />
      <Header />
      <div>
        <Options />
      </div>
      <div className="login-container">
        <form onSubmit={handleLogin} className="login-form">
          <h2>Login</h2>
          <input
            type="text"
            name="usuario"
            placeholder="Nome de Usuário"
            required
          />
          <input
            type="password"
            name="password"
            placeholder="Senha"
            required
          />
          <div className="button-group">
            <button type="submit" className="cadastrar-button">Entrar</button>
            <Link to="/registrar"><button type="button" className="login-button">Cadastrar</button></Link>
          </div>
          {popupMessage && <p className="popup-message">{popupMessage}</p>}
        </form>
      </div>
      <FooterF />
      <BottomMenu />
    </div>
  );
}

export default Login;
