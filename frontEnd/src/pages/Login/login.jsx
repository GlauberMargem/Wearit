import Footer from "../../layout/footer"
import Header from '../../layout/Header';
import Options from '../../layout/Options';
import BottomMenu from '../../layout/BottomMenu';
import FooterF from "../../layout/RodaPe";
import React from 'react';
import './Login.css';
import { Link } from 'react-router-dom';


function Login() {
    return (
        <div>
          <Footer nome="FRETE GRÁTIS ACIMA DE R$ 199" />
          <Header />
          <div>
            <Options />
          </div>
            <div className="login-container">
            <h1>Login</h1>
            <form className="login-form">
                <label htmlFor="usuario">Usuário</label>
                <input type="usuario" id="usuario" name="usuario" placeholder="Digite seu nome de usuário" />
                <label htmlFor="password">Senha</label>
                <input type="password" id="password" name="password" placeholder="Digite sua senha" />

                <div className="buttons">
                    <button type="submit" className="login-button">Entrar</button>
                    <Link to="/registrar" className="signup-button-link">
                      Inscreva-se
                    </Link>
                </div>
            </form>
        </div>
        <FooterF />
        <BottomMenu/> 
        </div>
        
      );
    }

export default Login