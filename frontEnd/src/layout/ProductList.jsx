import { useNavigate } from 'react-router-dom';
import './ProductList.css';

const products = [
  { imageUrl: '/images/roupa1.png', description: 'Moletom Wearit. Branco', price: 'R$ 199,00', category: ['NEW', 'FEMININO', 'ROUPAS'] },
  { imageUrl: '/images/roupa2.png', description: 'Moletom Wearit. Preto', price: 'R$ 199,00', category: ['POPULARES', 'FEMININO', 'ROUPAS', 'MASCULINO'] },
  { imageUrl: '/images/roupa3.png', description: 'Camiseta Garoto Wearit. Preta', price: 'R$ 84,99', category: ['NEW', 'ROUPAS', 'VERÃO', 'MASCULINO'] },
  { imageUrl: '/images/roupa4.png', description: 'Camiseta Wearit Joker. Branca', price: 'R$ 89,90', category: ['NEW', 'FEMININO','MASCULINO', 'ROUPAS', 'VERÃO'] },
  { imageUrl: '/images/roupa5.png', description: 'Camiseta Wearit. Rosa', price: 'R$ 84,99', category: ['POPULARES', 'FEMININO', 'ROUPAS', 'VERÃO'] },
  { imageUrl: '/images/roupa6.png', description: 'Camiseta Wearit. Aqua', price: 'R$ 84,99', category: ['FEMININO', 'ROUPAS', 'VERÃO'] },
  { imageUrl: '/images/roupa7.png', description: 'Camiseta Wearit. Olive', price: 'R$ 84,99', category: ['POPULARES', 'ROUPAS', 'NEW', 'MASCULINO', 'VERÃO'] },
  { imageUrl: '/images/roupa8.png', description: 'Camiseta Wearit. Red', price: 'R$ 99,90', category: ['NEW','POPULARES', 'ROUPAS', 'FEMININO', 'VERÃO'] },
  { imageUrl: '/images/roupa9.png', description: 'Bermuda Wearit. Preto', price: 'R$ 109,99', category: ['POPULARES', 'ROUPAS', 'MASCULINO', 'VERÃO'] },
  { imageUrl: '/images/roupa10.png', description: 'Bag Wearit. Preto', price: 'R$ 149,90', category: ['MASCULINO','FEMININO', 'ROUPAS'] },
  { imageUrl: '/images/roupa11.png', description: 'Bermuda Wearit. Caqui', price: 'R$ 109,99', category: ['VERÃO', 'MASCULINO', 'ROUPAS'] },
  { imageUrl: '/images/roupa12.png', description: 'Meias Wearit. Azul', price: 'R$ 59,90', category: ['INVERNO', 'FEMININO', 'ROUPAS', 'MASCULINO'] },
  { imageUrl: '/images/roupa13.png', description: 'Camiseta Wearit. Preta', price: 'R$ 89,90', category: ['INVERNO', 'FEMININO', 'ROUPAS'] },
  { imageUrl: '/images/roupa14.png', description: 'Calça Wearit. Preta', price: 'R$ 199,00', category: ['INVERNO', 'MASCULINO', 'ROUPAS'] },
  { imageUrl: '/images/roupa15.png', description: 'Meias Wearit. Branca', price: 'R$ 59,90', category: ['INVERNO', 'MASCULINO', 'ROUPAS', 'FEMININO'] },
  { imageUrl: '/images/roupa16.png', description: 'Moletom com Gorro Wearit. Rosa', price: 'R$ 199,00', category: ['NEW','INVERNO', 'FEMININO', 'ROUPAS'] },
  { imageUrl: '/images/roupa17.png', description: 'Moletom com Gorro. Verde', price: 'R$ 199,00', category: ['INVERNO', 'FEMININO','MASCULINO', 'ROUPAS'] },
];


function ProductList({ selectedCategory }) {
    const navigate = useNavigate();
  
    // Filtrar os produtos com base na categoria selecionada
    const filteredProducts = selectedCategory
        ? products.filter(product => product.category.includes(selectedCategory))
        : products;
  
    const handleProductClick = (product) => {
      navigate('/produtos', { state: product });
    };
  
    return (
      <div className="product-list">
        {filteredProducts.map((product, index) => (
          <div 
            key={index} 
            className="product-item" 
            onClick={() => handleProductClick(product)}
          >
            <img src={product.imageUrl} alt={product.description} />
            <p>{product.description}</p>
            <p>{product.price}</p>
          </div>
        ))}
      </div>
    );
  }

export default ProductList;
