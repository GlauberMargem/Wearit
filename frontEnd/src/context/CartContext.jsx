import React, { createContext, useState, useContext, useEffect } from 'react';

const CartContext = createContext();

export const CartProvider = ({ children }) => {
  // Estado inicializado com Local Storage
  const [cart, setCart] = useState(() => {
    const storedCart = localStorage.getItem('cart');
    return storedCart ? JSON.parse(storedCart) : [];
  });

  // Salva o carrinho no Local Storage quando atualizado
  useEffect(() => {
    localStorage.setItem('cart', JSON.stringify(cart));
  }, [cart]);

  // Adiciona um item ao carrinho
  const addToCart = (product) => {
    setCart((prevCart) => [...prevCart, product]);
  };

  // Limpa o carrinho
  const clearCart = () => {
    setCart([]);
    localStorage.removeItem('cart');
  };

  // Remove item individual do carrinho pelo índice
  const removeItem = (index) => {
    setCart((prevCart) => prevCart.filter((_, i) => i !== index));
  };

  return (
    <CartContext.Provider value={{ cart, addToCart, clearCart, removeItem }}>
      {children}
    </CartContext.Provider>
  );
};

// Hook para acessar o carrinho em qualquer lugar
export const useCart = () => {
  return useContext(CartContext);
};
