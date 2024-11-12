import React from 'react';
import './RodaPe.css'; // Importe o CSS

const FooterF = () => {
    return (
            <div className="footer-content">
                <div className="footer-logo">
                    <img src="/icons/logo2.png" alt="Logo da Loja" className="logo" />
                </div>
                <div className="footer-description">
                    <p><strong>WEARIT</strong> é uma marca de streetwear brasileira, nascida em Paulo Afonso-BA. Com um design inovador e de alta performance, criamos peças exclusivas que unem qualidade e estilo. Nossa estética é marcada pela fusão da urbanidade com a funcionalidade, criando roupas que não apenas acompanham, mas impulsionam seu estilo de vida. Continue avançando. <strong>Conquiste tudo</strong>.</p>
                </div>
                <div className="footer-socials">
                    <img src="/icons/insta.png" alt="Instagram" className="social-icon" />
                    <img src="/icons/whats.png" alt="WhatsApp" className="social-icon" />
                    <img src="/icons/tiktok.png" alt="TikTok" className="social-icon" />
                </div>
            </div>
    );
};

export default FooterF;
