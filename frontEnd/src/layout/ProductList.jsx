import { useNavigate } from 'react-router-dom';
import './ProductList.css';

const products = [
  { imageUrl: '/images/roupa3.jpg', description: 'Camiseta Wearit. Preta', price: 'R$ 150,00', category: ['NEW', 'MASCULINO', 'ROUPAS'] },
  { imageUrl: '/images/roupa4.jpg', description: 'Camiseta Wearit. Branca', price: 'R$ 150,00', category: ['NEW', 'FEMININO', 'ROUPAS'] },
  { imageUrl: '/images/roupa5.jpg', description: 'Camiseta Wearit. Preta', price: 'R$ 150,00', category: ['NEW', 'FEMININO', 'ROUPAS'] },
  { imageUrl: '/images/roupa6.jpg', description: 'Camiseta Wearit. Branca', price: 'R$ 150,00', category: ['NEW', 'FEMININO', 'ROUPAS'] },
  { imageUrl: '/images/roupa1.jpg', description: 'Camiseta Wearit. Preta', price: 'R$ 150,00', category: ['POPULARES', 'MASCULINO', 'ROUPAS'] },
  { imageUrl: '/images/roupa2.jpg', description: 'Camiseta Wearit. Branca', price: 'R$ 150,00', category: ['POPULARES', 'FEMININO', 'ROUPAS'] },
  { imageUrl: '/images/roupa9.jpg', description: 'Camiseta Wearit. Branca', price: 'R$ 150,00', category: ['POPULARES', 'ROUPAS'] },
  { imageUrl: '/images/foto2.png', description: 'Moletom Wearit. Preto', price: 'R$ 250,00', category: ['POPULARES'] },
  { imageUrl: '/images/roupa17.png', description: 'Moletom Wearit. branco', price: 'R$ 250,00', category: ['POPULARES', 'ROUPAS'] },
  { imageUrl: '/images/foto2.png', description: 'Moletom Wearit. Preto', price: 'R$ 250,00', category: ['INVERNO', 'MASCULINO', 'ROUPAS'] },
  { imageUrl: '/images/roupa7.png', description: 'Moletom Wearit. branco', price: 'R$ 250,00', category: ['INVERNO', 'MASCULINO', 'ROUPAS'] },
  { imageUrl: '/images/roupa13.png', description: 'Moletom Wearit. Preto', price: 'R$ 250,00', category: ['INVERNO', 'FEMININO', 'ROUPAS'] },
  { imageUrl: '/images/roupa12.png', description: 'Moletom Wearit. branco', price: 'R$250,00', category: ['INVERNO', 'FEMININO', 'ROUPAS'] },
  { imageUrl: '/images/roupa9.png', description: 'Calça Wearit. Preta', price: 'R$ 200,00', category: ['INVERNO', 'MASCULINO', 'ROUPAS'] },
  { imageUrl: '/images/roupa10.png', description: 'Calça Wearit. Branca', price: 'R$ 200,00', category: ['INVERNO', 'MASCULINO', 'ROUPAS'] },
  { imageUrl: '/images/roupa15.png', description: 'Calça Wearit. Preta', price: 'R$ 200,00', category: ['INVERNO', 'FEMININO', 'ROUPAS'] },
  { imageUrl: '/images/roupa14.png', description: 'Calça Wearit. Branca', price: 'R$ 200,00', category: ['INVERNO', 'FEMININO', 'ROUPAS'] },
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
