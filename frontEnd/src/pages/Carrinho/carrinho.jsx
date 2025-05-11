import { useCart } from '../../context/CartContext'; // Importe o hook useCart
import Footer from "../../layout/Footer";
import Header from '../../layout/Header';
import BottomMenu from '../../layout/BottomMenu';
import FooterF from "../../layout/RodaPe";
import './carrinho.css';
import { Link } from 'react-router-dom';

function Carrinho() {
    const { cart, clearCart, removeItem } = useCart(); // Agora temos o removeItem para remover itens individuais

    // Verifique se o nome de usuário está armazenado no localStorage para determinar o estado de login
    const nomeUsuario = localStorage.getItem('nomeUsuario'); // Verifica se o nome de usuário está no Local Storage
    const isAuthenticated = nomeUsuario !== null; // Verifica se o nome de usuário está presente

    // Função para calcular o total do carrinho
    const calculateTotal = () => {
        return cart.reduce((total, item) => {
            // Remove o "R$" e a vírgula dos preços para converter em número
            const price = parseFloat(item.price.replace('R$', '').replace(',', '.'));
            return total + price;
        }, 0).toFixed(2); // Mantém duas casas decimais
    };

    // Função para gerar a mensagem para o WhatsApp com as informações do carrinho
    const generateMessage = () => {
        let message = "Olá, gostaria de finalizar minha compra! Aqui estão os detalhes do meu carrinho:\n\n";

        cart.forEach(item => {
            message += `Produto: ${item.description}\nTamanho: ${item.size}\nPreço: ${item.price}\n\n`;
        });

        message += `Total: R$ ${calculateTotal()}\n\nObrigado!`;

        // Codifica a mensagem para ser usada no link do WhatsApp
        return encodeURIComponent(message);
    };

    return (
        <div id='carCont'>
            <div>
                <Footer nome="FRETE GRÁTIS EM COMPRAS A PARTIR DE R$ 199,00" />
                <Header />
            </div>
            <div className='principal'>
                <div className='car-container'>
                    <h1 className='car-title'>CARRINHO</h1>

                    {cart.length > 0 && (
                        <div className='buttons'>
                            <div className='subbuttons'>
                                <button onClick={clearCart}>LIMPAR CARRINHO</button>
                                <Link to="../"><button>CONTINUAR COMPRANDO</button></Link>
                                {isAuthenticated ? (
                                    // Exibe o botão "FINALIZAR COMPRA" se o usuário estiver logado
                                    <Link to="/finalizar"><button>FINALIZAR COMPRA</button>
                                    </Link>
                                ) : (
                                    // Exibe o botão "CADASTRE-SE" caso o usuário não esteja logado
                                    <Link to="/registrar">
                                        <button>CADASTRE-SE</button>
                                    </Link>
                                )}
                            </div>
                            <div className='total'>
                                <p>TOTAL: R$ {calculateTotal()}</p>
                            </div>
                        </div>
                    )}
                    <div className='containerProducts'>
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
                </div>
            </div>

            <FooterF className='footer' />
            <BottomMenu />
        </div>
    );
}

export default Carrinho;
