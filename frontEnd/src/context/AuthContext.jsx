import React, { createContext, useState, useContext } from 'react';

// Criando o contexto para autenticação
const AuthContext = createContext();

// Provedor do AuthContext
export const AuthProvider = ({ children }) => {
  // Estado de autenticação, que pode ser manipulado conforme a lógica de login/logout
  const [isAuthenticated, setIsAuthenticated] = useState(false);

  // Funções para login e logout
  const login = () => setIsAuthenticated(true);
  const logout = () => setIsAuthenticated(false);

  return (
    <AuthContext.Provider value={{ isAuthenticated, login, logout }}>
      {children}
    </AuthContext.Provider>
  );
};

// Hook para acessar o AuthContext em qualquer lugar
export const useAuth = () => {
  return useContext(AuthContext);
};
