import { Link } from 'react-router-dom';
import './Options.css';

function Options({ onSelectCategory }) {
    return (
        <section className="navigation-section">
            <nav className="nav-menu" id="navMenu">
                <ul>
                    <li onClick={() => onSelectCategory('ROUPAS')}>
                        <Link to="/roupas">ROUPAS</Link>
                    </li>
                    <li onClick={() => onSelectCategory('MASCULINO')}>
                        <Link to="/masculino">MASCULINO</Link>
                    </li>
                    <li onClick={() => onSelectCategory('FEMININO')}>
                        <Link to="/feminino">FEMININO</Link>
                    </li>
                    <li onClick={() => onSelectCategory('CONTATO')}>
                        <Link to="/contatos">CONTATO</Link>
                    </li>
                </ul>
            </nav>
        </section>
    );
}

export default Options;
