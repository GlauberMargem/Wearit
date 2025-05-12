// ModalCompraSucesso.jsx
import React from 'react';
import './modalSucesso.css';

function ModalCompraSucesso({ onClose }) {
    return (
        <div className="modal-overlay">
            <div className="modal-conteudo">
                <h2>Compra bem sucedida!</h2>
                <p>Obrigado por comprar com a gente 😄</p>
                <button onClick={onClose}>Voltar ao início</button>
            </div>
        </div>
    );
}

export default ModalCompraSucesso;
