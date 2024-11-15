import { useCart } from '../../context/CartContext'; // Importe o hook useCart
import Footer from "../../layout/Footer";
import Header from '../../layout/Header';
import BottomMenu from '../../layout/BottomMenu';
import FooterF from "../../layout/RodaPe";
import './carrinho.css';
import { Link } from 'react-router-dom';

function Carrinho() {
    const { cart, clearCart, removeItem } = useCart(); // Agora temos o removeItem para remover itens individuais

    // Função para calcular o total do carrinho
    const calculateTotal = () => {
        return cart.reduce((total, item) => {
            // Remove o "R$" e a vírgula dos preços para converter em número
            const price = parseFloat(item.price.replace('R$', '').replace(',', '.'));
            return total + price;
        }, 0).toFixed(2); // Mantém duas casas decimais
    };

    return (
        <div>
            <Footer nome="FRETE GRÁTIS EM COMPRAS A PARTIR DE R$ 199,00" />
            <Header />
            <div className='principal'>
                <div className='car-container'>
                    <h1 className='car-title'>🛒 SEU CARRINHO</h1>
                    {cart.length === 0 ? (
                        <p className='error-mensage'>O CARRINHO ESTÁ VAZIO.</p>
                    ) : (
                        cart.map((item, index) => (
                            <div key={index} className="produto-carrinho">
                                <img className='prod-image' src={item.imageUrl} alt={item.description} />
                                <div className='prod-info'>
                                    <p className='description'>{item.description}</p>
                                    <p className='price'>{item.price}</p>
                                    <p className='tamanho'>Tamanho: {item.size}</p>
                                </div>
                                {/* Botão para remover o item individual */}
                                <button onClick={() => removeItem(index)} className="remove-item-button">🗑️</button>
                            </div>
                        ))
                    )}
                </div>
                {cart.length > 0 && (
                <div className='buttons'>
                    <button onClick={clearCart}>LIMPAR CARRINHO</button>
                    <Link to="../"> <button >CONTINUAR COMPRANDO</button></Link>
                    <button onClick={clearCart}>FINALIZAR COMPRA</button>
                    <p>TOTAL: R$ {calculateTotal()}</p>
                </div>
                )}
            </div>
            <FooterF className='footer'/>
            <BottomMenu />
        </div>
    );
}

export default Carrinho;
