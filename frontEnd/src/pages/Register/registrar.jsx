import React, { useState } from "react";
import Footer from "../../layout/footer";
import Header from '../../layout/Header';
import Options from '../../layout/Options';
import BottomMenu from '../../layout/BottomMenu';
import FooterF from "../../layout/RodaPe";
import { UsuarioService } from "../../../services/UsuarioService";
import './registrar.css';

function Registrar() {
  const [formData, setFormData] = useState({
    usuario: "",
    endereco: "",
    numero: "",
    cep: "",
    senha: ""
  });

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
      usu_nome: formData.usuario,
      usu_senha: formData.senha,
      usu_adm: "1", // Enviar como string
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
        // Redirecionar ou mostrar uma mensagem de sucesso
      })
      .catch((error) => {
        console.error("Erro ao cadastrar o usuário", error);
        // Mostrar uma mensagem de erro
      });
  };

  return (
    <div>
<Footer nome="FRETE GRÁTIS ACIMA DE R$ 199" />      
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
          />

          <label htmlFor="endereco">Endereço</label>
          <input
            type="text"
            id="endereco"
            name="endereco"
            placeholder="Digite seu Endereço"
            value={formData.endereco}
            onChange={handleChange}
          />

          <label htmlFor="numero">Número</label>
          <input
            type="text"
            id="numero"
            name="numero"
            placeholder="Digite o Número da residência"
            value={formData.numero}
            onChange={handleChange}
          />

          <label htmlFor="cep">Cep</label>
          <input
            type="text"
            id="cep"
            name="cep"
            placeholder="Digite o cep"
            value={formData.cep}
            onChange={handleChange}
          />

          <label htmlFor="senha">Senha</label>
          <input
            type="password"
            id="senha"
            name="senha"
            placeholder="Digite sua senha"
            value={formData.senha}
            onChange={handleChange}
          />

          <div className="button-group">
            <button type="submit" className="cadastrar-button">
              Cadastrar
            </button>
            <button type="button" className="login-button">
              Login
            </button>
          </div>
        </form>
      </div>
      <FooterF />
      <BottomMenu />
    </div>
  );
}

export default Registrar;
