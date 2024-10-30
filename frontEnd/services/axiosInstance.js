// src/services/axiosInstance.js
import axios from 'axios';

export const axiosInstance = axios.create({
  baseURL: 'http://localhost:8080' // Certifique-se de que o backend esteja rodando aqui
});
