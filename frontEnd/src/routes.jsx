import { BrowserRouter, Route, Routes } from "react-router-dom";
import Home from "./pages/Home/home";
import Masculino from "./pages/Masculino/masculino";
import Feminino from "./pages/Feminino/feminino";
import Roupas from "./pages/Roupas/roupas";
import Login from "./pages/Login/login";
import Registrar from "./pages/Register/registrar";
import Produtos from "./pages/Produtos/produtos";
import Carrinho from "./pages/Carrinho/carrinho";
import { CartProvider } from './context/CartContext'; // Importe o CartProvider

function AppRoutes() {
    return (
        <CartProvider> {/* Envolva todas as rotas com o CartProvider */}
            <BrowserRouter>
                <Routes>
                    <Route path="/" element={<Home />} /> {/* Página inicial */}
                    <Route path="/roupas" element={<Roupas />} /> {/* Página de roupas */}
                    <Route path="/masculino" element={<Masculino />} /> {/* Página masculina */}
                    <Route path="/feminino" element={<Feminino />} /> {/* Página feminina */}
                    <Route path="/login" element={<Login />} /> {/* Página de login */}
                    <Route path="/registrar" element={<Registrar />} /> {/* Página de registro */}
                    <Route path="/produtos" element={<Produtos />} /> {/* Página de produtos */}
                    <Route path="/carrinho" element={<Carrinho />} /> {/* Página de carrinho */}
                </Routes>
            </BrowserRouter>
        </CartProvider>
    );
}

export default AppRoutes;