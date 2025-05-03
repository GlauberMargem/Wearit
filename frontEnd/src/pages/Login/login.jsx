import React, { useState, useEffect } from 'react';
import Header from '../../layout/Header';
import Options from '../../layout/Options';
import Footer from "../../layout/Footer";
import BottomMenu from '../../layout/BottomMenu';
import FooterF from "../../layout/RodaPe";
import { Link, useNavigate } from 'react-router-dom';
import './Login.css';

function Login() {
  const [popupMessage, setPopupMessage] = useState("");
  const [isLoggedIn, setIsLoggedIn] = useState(false);  // Estado para verificar se o usuário está logado
  const navigate = useNavigate();

  // Verifica se o usuário já está logado ao carregar o componente
  useEffect(() => {
    const nome = localStorage.getItem("nomeUsuario");
    if (nome) {
      setIsLoggedIn(true);  // Se o usuário estiver logado, atualiza o estado
      setPopupMessage("Você já está logado."); // Mensagem de usuário já logado
    }
  }, []);  // Esta função não deve depender de nenhuma alteração externa

  // Função para lidar com o login
  const handleLogin = (event) => {
    event.preventDefault();
    const usuario = event.target.usuario.value;
    const senha = event.target.password.value;

    // Recupera os dados de usuários cadastrados no localStorage
    const storedUsers = JSON.parse(localStorage.getItem("usuarios")) || [];

    // Verifica se o nome de usuário e senha são válidos
    const user = storedUsers.find(u => u.usuario === usuario);

    if (!user) {
      setPopupMessage("Usuário não encontrado.");
      return;
    }

    if (user.senha !== senha) {
      setPopupMessage("Senha incorreta.");
      return;
    }

    // Se o login for bem-sucedido, armazene uma flag de login no localStorage
    localStorage.setItem("nomeUsuario", usuario);
    localStorage.setItem("isLoggedIn", true); // Armazenando o estado de login

    setIsLoggedIn(true);
    setPopupMessage("Login bem-sucedido!");

    // Redireciona para a página inicial ou qualquer página desejada
    setTimeout(() => {
      navigate("/"); // Alterar para a página de destino após o login
    }, 2000);
  };

  return (
    <div>
      <Footer nome="FRETE GRÁTIS EM COMPRAS A PARTIR DE R$ 199,00" />
      <Header />
      <div>
        <Options />
      </div>
      <div className="login-container">
        {/* Se o usuário estiver logado, exibe a mensagem permanente */}
        {isLoggedIn && (
          <div className="logged-in-message">
            {popupMessage}
          </div>
        )}
        {/* Formulário de login sempre visível, mas desabilitado se já estiver logado */}
        <form onSubmit={handleLogin} className="login-form">
          <h2>Login</h2>
          <input
            type="text"
            name="usuario"
            placeholder="Nome de Usuário"
            required
            disabled={isLoggedIn} // Desabilita o campo se já estiver logado
          />
          <input
            type="password"
            name="password"
            placeholder="Senha"
            required
            disabled={isLoggedIn} // Desabilita o campo se já estiver logado
          />
          <div className="button-group">
            <button
              type="submit"
              className="cadastrar-button"
              disabled={isLoggedIn} // Desabilita o botão "Entrar" se já estiver logado
            >
              Entrar
            </button>
            <Link to="/registrar">
              <button type="button" className="login-button" disabled={isLoggedIn}>
                Cadastrar
              </button>
            </Link>
          </div>
          {popupMessage && !isLoggedIn && (
            <div className={`popup-message ${popupMessage.includes("Credenciais inválidas") ? 'error' : 'success'}`}>
              {popupMessage}
            </div>
          )}
        </form>
      </div>
      <FooterF />
      <BottomMenu />
    </div>
  );
}

export default Login;
