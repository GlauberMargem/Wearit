import { useLocation } from 'react-router-dom';
import Footer from "../../layout/footer";
import Header from '../../layout/Header';
import Options from '../../layout/Options';
import BottomMenu from '../../layout/BottomMenu';
import FooterF from "../../layout/RodaPe";
import './produtos.css';

function Produtos() {
  const location = useLocation();
  const { imageUrl, description, price } = location.state || {};  // Pega os dados do produto

  return (
    <div>
    <Footer nome="FRETE GRÁTIS ACIMA DE R$ 199" />           
      <Header />
      <div>
        <Options />
      </div>
      <div className="produto-container">
        <div>
          <img 
            src={imageUrl} 
            alt={description} 
            className="produto-imagem"
          />
        </div>
        <div className="produto-descricao">
          <h2>{description}</h2>
          <p>{price}</p>
          
          <div className="produto-tamanhos">
            {['P', 'M', 'G', 'GG'].map(size => (
              <div key={size} className="tamanho-item">
                {size}
              </div>
            ))}
          </div>
          <button className="add-carrinho">
            ADICIONE AO CARRINHO
          </button>
        </div>
      </div>
      <FooterF />
      <BottomMenu /> 
    </div>
  );
}

export default Produtos;