import { BrowserRouter, Route, Routes } from "react-router-dom";
import Home from "./pages/Home/home";
import Masculino from "./pages/Masculino/masculino";
import Feminino from "./pages/Feminino/feminino";
import Contatos from "./pages/Contatos/contatos";
import Roupas from "./pages/Roupas/roupas";
import Login from "./pages/Login/Login";
import Registrar from "./pages/Register/registrar";
import Produtos from "./pages/Produtos/produtos";

function AppRoutes() {
    return (
        <BrowserRouter>
            <Routes>
                <Route path="/" element={<Home />}></Route>
                <Route path="/roupas" element={<Roupas/>}></Route>
                <Route path="/masculino" element={<Masculino/>}></Route>
                <Route path="/feminino" element={<Feminino/>}></Route>
                <Route path="/contatos" element={<Contatos/>}></Route>
                <Route path="/login" element={<Login/>}></Route>
                <Route path="/registrar" element={<Registrar/>}></Route>   
                <Route path="/produtos" element={<Produtos/>}></Route> 

             </Routes>
        </BrowserRouter>
    )
}

export default AppRoutes