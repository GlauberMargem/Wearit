import React from 'react';
import './RodaPe.css'; // Importe o CSS

const FooterF = () => {
    return (
        <footer className="footer">
            <div className="footer-content">
                <div className="footer-logo">
                    <img src="/icons/logo2.png" alt="Logo da Loja" className="logo" />
                </div>
                <div className="footer-socials">
                    <img src="/icons/insta.png" alt="Instagram" className="social-icon" />
                    <img src="/icons/whats.png" alt="WhatsApp" className="social-icon" />
                    <img src="/icons/tiktok.png" alt="TikTok" className="social-icon" />
                </div>
            </div>
            <div className="footer-description">
                <p>WEARIT,  (Continue Avançando e Conquiste Tudo) é uma marca de roupas streetwear brasileira, com sede em Paulo Afonso (Bahia). Através do design inteligente a marca desenvolve itens de alta qualidade, exclusivos e tecnológicos. Conectados à uma estética urbana e funcional.</p>
            </div>
        </footer>
    );
};

export default FooterF;
