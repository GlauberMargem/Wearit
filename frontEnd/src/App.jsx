import React from "react";
import AppRoutes from "./routes"; // Certifique-se de que o caminho para o arquivo de rotas está correto
import { AuthProvider } from "./context/AuthContext"; // Importe o AuthProvider
import { CartProvider } from "./context/CartContext"; // Importe o CartProvider

function App() {
  return (
    <div className="App">
      <AuthProvider>
        <CartProvider>
          <AppRoutes /> {/* Renderiza as rotas do aplicativo */}
        </CartProvider>
      </AuthProvider>
    </div>
  );
}

export default App;
