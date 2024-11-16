import { axiosInstance } from './axiosInstance'; // Certifique-se de que o axiosInstance esteja correto

export class UsuarioService {
  // Método para cadastrar o usuário
  cadastrarUsuario(usuarioData) {
    return axiosInstance.post("/usuario", usuarioData);
  }

  // Método para listar todos os usuários
  listarTodos() {
    return axiosInstance.get("/usuario");
  }

  // Método para realizar o login
  async login(credentials) {
    try {
      const response = await axiosInstance.post("/auth/login", credentials);
      return response.data; // Retorna os dados de resposta, como o token de autenticação
    } catch (error) {
      console.error("Erro ao fazer login:", error.response ? error.response.data : error.message);
      throw error; // Lança o erro para ser tratado no componente onde foi chamado
    }
  }
}






