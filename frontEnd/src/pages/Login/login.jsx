import React, { useState, useEffect } from 'react';
import Header from '../../layout/Header';
import Options from '../../layout/Options';
import Footer from "../../layout/Footer";
import BottomMenu from '../../layout/BottomMenu';
import FooterF from "../../layout/RodaPe";
import { Link, useNavigate } from 'react-router-dom';
import { UsuarioService } from '../../../services/UsuarioService'; // Supondo que o caminho esteja correto
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
  const handleLogin = async (event) => {
    event.preventDefault();
    const usuario = event.target.usuario.value;
    const senha = event.target.password.value;

    try {
      // Limpa qualquer mensagem anterior antes de tentar o login
      setPopupMessage("");

      const response = await new UsuarioService().login({ usuNome: usuario, senha });

      if (response.message) {
        setPopupMessage(response.message);
        setTimeout(() => {
          // Armazenando o nome do usuário no localStorage
          localStorage.setItem("nomeUsuario", usuario);
          setIsLoggedIn(true);  // Marca como logado após o sucesso do login
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
