
import React, { useState } from 'react';
import { useLocation, useNavigate } from 'react-router-dom'; // Alterado aqui
import Footer from "../../layout/Footer";
import Header from '../../layout/Header';
import Options from '../../layout/Options';
import BottomMenu from '../../layout/BottomMenu';
import FooterF from "../../layout/RodaPe";
import { useCart } from '../../context/CartContext'; // Importe o contexto do carrinho
import './produtos.css';

function Produtos() {
  const location = useLocation();
  const navigate = useNavigate();

  const { imageUrl, description, price } = location.state || {};

  const [selectedSize, setSelectedSize] = useState(null);
  const [isPopupVisible, setIsPopupVisible] = useState(false);

  const { addToCart } = useCart(); // Acesso à função addToCart do contexto do carrinho

  const handleSizeSelect = (size) => {
    setSelectedSize(size);
  };

  const handleAddToCart = () => {
    if (selectedSize) {
      const product = {
        imageUrl,
        description,
        price,
        size: selectedSize,
      };
      addToCart(product); // Adiciona o produto ao carrinho
      setIsPopupVisible(true); // Exibe o popup
    } else {
      alert("Por favor, selecione um tamanho antes de adicionar ao carrinho.");
    }
  };

  const handleContinueShopping = () => {
    setIsPopupVisible(false);
  };

  const handleGoToCart = () => {
    setIsPopupVisible(false);
    navigate('/carrinho'); // Navega para a página de carrinho
  };

  return (
    <div>
      <Footer nome="FRETE GRÁTIS EM COMPRAS A PARTIR DE R$ 199,00" />
      <Header />
      <Options />

      {isPopupVisible && (
        <div className="carrinho_popup">
          <h2 className="header_carrinho">ADICIONADO COM SUCESSO</h2>
          <hr className="popup-divider" />
          <div className="descricao_popup">
            <img src={imageUrl} alt={description} className="imagem_popup" />
            <div className="class-descricao">
              <p>{description}</p>
              <p>{price}</p>
            </div>
          </div>
          <hr className="popup-divider" />
          <div className="popup-actions">
            <button onClick={handleGoToCart} className="go-to-cart, cart-botton">IR PARA O CARRINHO</button>
            <button onClick={handleContinueShopping} className="continue-shopping, cart-botton">CONTINUE COMPRANDO</button>
          </div>
        </div>
      )}

      <div className="produto-container">
        <div>
          <img src={imageUrl} alt={description} className="produto-imagem" />
        </div>
        <div className="produto-descricao">
          <h2>{description}</h2>
          <p>{price}</p>

          <div className="produto-tamanhos">
            {['P', 'M', 'G', 'GG'].map(size => (
              <div
                key={size}
                className={`tamanho-item ${selectedSize === size ? 'selected' : ''}`}
                onClick={() => handleSizeSelect(size)}
              >
                {size}
              </div>
            ))}
          </div>

          <button onClick={handleAddToCart} className="add-carrinho">
            ADICIONE AO CARRINHO
          </button>
        </div>
      </div>

      <BottomMenu />
      <FooterF />
    </div>
  );
}

export default Produtos;
