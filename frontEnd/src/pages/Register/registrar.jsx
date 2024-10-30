import React, { useState } from "react";
import Footer from "../../layout/footer";
import Header from '../../layout/Header';
import Options from '../../layout/Options';
import BottomMenu from '../../layout/BottomMenu';
import FooterF from "../../layout/RodaPe";
import { UsuarioService } from "../../../services/UsuarioService";
import './registrar.css';
import { Link } from 'react-router-dom';

function Registrar() {
  const [formData, setFormData] = useState({
    usuario: "",
    endereco: "",
    numero: "",
    cep: "",
    senha: ""
  });
  // Estado para controlar a exibição da pop-up de sucesso
  const [showSuccessPopup, setShowSuccessPopup] = useState(false);
  // Estado para controlar a exibição da pop-up de erro
  const [showErrorPopup, setShowErrorPopup] = useState(false);
  // Mensagem de erro
  const [errorMessage, setErrorMessage] = useState("");

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((prevData) => ({
      ...prevData,
      [name]: value
    }));
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    
    // Montar o corpo da requisição com base nos dados do formulário
    const usuarioData = {
      usuNome: formData.usuario,
      usuSenha: formData.senha,
      usuAdm: false,
      endereco: {
        end_rua: formData.endereco,
        end_numero: formData.numero,
        end_cep: formData.cep
      }
    };
    

    // Chamar o serviço para cadastrar o usuário
    const usuarioService = new UsuarioService();
    usuarioService
      .cadastrarUsuario(usuarioData)
      .then((response) => {
        console.log("Usuário cadastrado com sucesso!", response.data);
        setShowSuccessPopup(true); // Exibe a pop-up de confirmação
      })
      .catch((error) => {
        console.error("Erro ao cadastrar o usuário", error);
        // Verifica se o erro é devido a um usuário já existente
        if (error.response && error.response.status === 500) {
          setErrorMessage("Usuário já existe. Tente um nome de usuário diferente.");
          setShowErrorPopup(true); // Exibe a pop-up de erro
        } else {
          setErrorMessage("Ocorreu um erro ao cadastrar o usuário. Tente novamente mais tarde.");
          setShowErrorPopup(true);
        }
      });
  };

  const closeSuccessPopup = () => {
    setShowSuccessPopup(false);
  };

  const closeErrorPopup = () => {
    setShowErrorPopup(false);
  };

  return (
    <div>
      <Footer nome="SIGA-NOS NO INSTAGRAM @WEARIT." />
      <Header />
      <div>
        <Options />
      </div>
      <div className="inscrever-container">
        <h1>Inscreva-se</h1>
        <form onSubmit={handleSubmit}>
          <label htmlFor="usuario">Usuário</label>
          <input
            type="text"
            id="usuario"
            name="usuario"
            placeholder="Digite seu usuário"
            value={formData.usuario}
            onChange={handleChange}
            required
          />

          <label htmlFor="endereco">Endereço</label>
          <input
            type="text"
            id="endereco"
            name="endereco"
            placeholder="Digite seu Endereço"
            value={formData.endereco}
            onChange={handleChange}
            required
          />

          <label htmlFor="numero">Número</label>
          <input
            type="text"
            id="numero"
            name="numero"
            placeholder="Digite o Número da residência"
            value={formData.numero}
            onChange={handleChange}
            required
          />

          <label htmlFor="cep">Cep</label>
          <input
            type="text"
            id="cep"
            name="cep"
            placeholder="Digite o cep"
            value={formData.cep}
            onChange={handleChange}
            required
          />

          <label htmlFor="senha">Senha</label>
          <input
            type="password"
            id="senha"
            name="senha"
            placeholder="Digite sua senha"
            value={formData.senha}
            onChange={handleChange}
            required
          />

          <div className="button-group">
            <button type="submit" className="cadastrar-button">Cadastrar</button>
            <Link to="/login"><button type="button" className="login-button">Login</button></Link>
          </div>
        </form>
      </div>

      {showSuccessPopup && (
        <div className="popup">
          <div className="popup-content">
            <h2>Registro Confirmado!</h2>
            <p>Seu registro foi realizado com sucesso.</p>
            <button onClick={closeSuccessPopup}>Fechar</button>
          </div>
        </div>
      )}

      {showErrorPopup && (
        <div className="popup">
          <div className="popup-content">
            <h2>Erro ao Registrar!</h2>
            <p>{errorMessage}</p>
            <button onClick={closeErrorPopup}>Fechar</button>
          </div>
        </div>
      )}

      <FooterF />
      <BottomMenu />
    </div>
  );
}

export default Registrar;
