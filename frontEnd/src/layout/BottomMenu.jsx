import React from 'react';
import './BottomMenu.css';
import { Link } from 'react-router-dom';

const BottomMenu = () => {
    return (
        <div className="bottom-menu">
            <Link to="/" className="menu-option">
                <img src="/icons/home1.png" alt="Opção 1" className="menu-icon" />
            </Link>
            <div className="menu-option">
                <img src="/icons/desejo.png" alt="Opção 2" className="menu-icon" />
            </div>
            <div className="menu-option">
                <img src="/icons/sacola.png" alt="Opção 3" className="menu-icon" />
            </div>
            <Link  to="/login" className="menu-option">
                <img src="/icons/user.png" alt="Opção 4" className="menu-icon" />
            </Link>
        </div>
    );
};

export default BottomMenu;
