import React, { useState } from "react";
import Footer from "../../layout/Footer";
import Header from '../../layout/Header';
import Options from '../../layout/Options';
import BottomMenu from '../../layout/BottomMenu';
import FooterF from "../../layout/RodaPe";
import { Link } from 'react-router-dom';
import './registrar.css';

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

    // Verifica se o usuário já está cadastrado
    const storedUsers = JSON.parse(localStorage.getItem("usuarios")) || [];
    const existingUser = storedUsers.find(user => user.usuario === formData.usuario);

    if (existingUser) {
      setErrorMessage("Usuário já existe. Tente um nome de usuário diferente.");
      setShowErrorPopup(true);
      return;
    }

    // Montar o novo objeto de dados do usuário
    const newUser = {
      usuario: formData.usuario,
      senha: formData.senha,
      endereco: {
        rua: formData.endereco,
        numero: formData.numero,
        cep: formData.cep
      }
    };

    // Adiciona o novo usuário ao array de usuários no localStorage
    storedUsers.push(newUser);
    localStorage.setItem("usuarios", JSON.stringify(storedUsers));

    setShowSuccessPopup(true); // Exibe a pop-up de sucesso
  };

  const closeSuccessPopup = () => {
    setShowSuccessPopup(false);
  };

  const closeErrorPopup = () => {
    setShowErrorPopup(false);
  };

  return (
    <div>
      <Footer nome="FRETE GRÁTIS EM COMPRAS A PARTIR DE R$ 199,00" />
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
