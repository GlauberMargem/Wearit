// src/services/UsuarioService.jsx
import { axiosInstance } from './axiosInstance';

export class UsuarioService {
  cadastrarUsuario(usuarioData) {
    return axiosInstance.post("/usuario", usuarioData);
  }

  listarTodos() {
    return axiosInstance.get("/usuario");
  }

  async login(credentials) {
    try {
      const response = await axiosInstance.post("/auth/login", credentials);
      return response.data;
    } catch (error) {
      console.error("Erro ao fazer login:", error.response ? error.response.data : error.message);
      throw error;
    }
  }
}





