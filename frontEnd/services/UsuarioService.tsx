import { axiosInstance } from './axiosInstance'; // Se estiver usando axios instance

export class UsuarioService {
  cadastrarUsuario(usuarioData) {
    // Faz a requisição POST para cadastrar o usuário
    return axiosInstance.post("/usuario", usuarioData);
  }

  listarTodos() {
    return axiosInstance.get("/usuario");
  }
}
