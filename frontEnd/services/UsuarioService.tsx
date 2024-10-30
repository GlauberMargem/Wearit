// src/services/UsuarioService.jsx
import { axiosInstance } from './axiosInstance'; // Se estiver usando axios instance

export class UsuarioService {
  cadastrarUsuario(usuarioData) {
    // Faz a requisição POST para cadastrar o usuário
    return axiosInstance.post("/usuario", usuarioData);
  }

  listarTodos() {
    return axiosInstance.get("/usuario");
  }

  // Método para autenticar o usuário
  async login(credentials) {
    try {
      const response = await axiosInstance.post("/auth/login", credentials);
      return response.data; // Retorna os dados da resposta, se o login for bem-sucedido
    } catch (error) {
      console.error("Erro ao fazer login:", error.response ? error.response.data : error.message);
      throw error; // Lança o erro para ser tratado no componente que chama o login
    }
  }
}



