import React, { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import Header from '../../layout/Header';
import Footer from '../../layout/Footer';
import FooterF from "../../layout/RodaPe";
import BottomMenu from '../../layout/BottomMenu';
import qrCode from '../../images/qr_code.png'
import './finalizar.css'; // Você pode estilizar como quiser

function FinalizarCompra() {
    const navigate = useNavigate();
    const [formaPagamento, setFormaPagamento] = useState("pix");

    // Verifica se o usuário está logado
    useEffect(() => {
        const nomeUsuario = localStorage.getItem("nomeUsuario");
        if (!nomeUsuario) {
            alert("Você precisa estar logado para finalizar a compra.");
            navigate("/login");
        }
    }, []);

    const handlePagamento = () => {
        alert(`Compra finalizada com ${formaPagamento.toUpperCase()}!`);
        // Aqui você poderia limpar o carrinho ou redirecionar
    };

    return (
        <div className="finalizar-container">
            <Header />
            <div class="containerFinalizarcompra">
                <h2>Finalizar Compra</h2>

                <div className="formapagamento-opcoes">
                    <label>
                        <input
                            type="radio"
                            name="pagamento"
                            value="pix"
                            checked={formaPagamento === "pix"}
                            onChange={() => setFormaPagamento("pix")}
                        />
                        PIX
                    </label>
                    <label>
                        <input
                            type="radio"
                            name="pagamento"
                            value="cartao"
                            checked={formaPagamento === "cartao"}
                            onChange={() => setFormaPagamento("cartao")}
                        />
                        Cartão de Crédito
                    </label>
                </div>

                {formaPagamento === "pix" && (
                    <div className="pagamento-pix">
                        <p>Chave PIX: 123.456.789-00</p>
                        <img src={qrCode} alt="QR Code PIX" style={{ width: "200px" }} />
                    </div>
                )}

                {formaPagamento === "cartao" && (
                    <div className="pagamento-cartao">
                        <input type="text" placeholder="Número do Cartão" required />
                        <input type="text" placeholder="Nome no Cartão" required />
                        <input type="text" placeholder="Validade (MM/AA)" required />
                        <input type="text" placeholder="CVV" required />
                    </div>
                )}

                <button onClick={handlePagamento} className="botao-finalizar">
                    Finalizar Compra
                </button>
            </div>
            <FooterF />
            <BottomMenu />
        </div>
    );
}

export default FinalizarCompra;
