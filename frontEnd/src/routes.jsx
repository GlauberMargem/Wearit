import { BrowserRouter, Route, Routes } from "react-router-dom";
import Home from "./pages/Home/home";
import Masculino from "./pages/Masculino/masculino";
import Feminino from "./pages/Feminino/feminino";
import Contatos from "./pages/Contatos/contatos";
import Roupas from "./pages/Roupas/roupas";
import Login from "./pages/Login/login";
import Registrar from "./pages/Register/registrar";
import Produtos from "./pages/Produtos/produtos";

function AppRoutes() {
    return (
        <BrowserRouter>
            <Routes>
                <Route path="/" element={<Home />} /> {/* Página inicial */}
                <Route path="/roupas" element={<Roupas />} /> {/* Página de roupas */}
                <Route path="/masculino" element={<Masculino />} /> {/* Página masculina */}
                <Route path="/feminino" element={<Feminino />} /> {/* Página feminina */}
                <Route path="/contatos" element={<Contatos />} /> {/* Página de contatos */}
                <Route path="/login" element={<Login />} /> {/* Página de login */}
                <Route path="/registrar" element={<Registrar />} /> {/* Página de registro */}
                <Route path="/produtos" element={<Produtos />} /> {/* Página de produtos */}
            </Routes>
        </BrowserRouter>
    );
}

export default AppRoutes;
