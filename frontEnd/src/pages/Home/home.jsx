import './home.css';
import Footer from "../../layout/Footer";
import Header from '../../layout/Header';
import Options from '../../layout/Options';
import Banner from '../../layout/Banner';
import CategoryBox from '../../layout/CategoryBox';
import ProductList from '../../layout/ProductList';
import { useState } from 'react';
import BottomMenu from '../../layout/BottomMenu';
import FooterF from "../../layout/RodaPe";

const categorybox = ["NEW", "POPULARES", "INVERNO", "VERÃO"];

function Home() {
  const [selectedCategory, setSelectedCategory] = useState('NEW'); // Inicia com a categoria NEW

  const handleCategorySelect = (category) => {
    setSelectedCategory(category);
  };

  return (
    <div>
      <Footer nome="FRETE GRÁTIS EM COMPRAS A PARTIR DE R$ 199,00" />
      <Header />
      <div>
        <Options onSelectCategory={handleCategorySelect} />
      </div>
      <Banner />
      <Footer nome2="15% DE DESCONTO NA PRIMEIRA COMPRA COM O CÓDIGO: PRIMEIRA15" />
      <div>
        <CategoryBox categorybox={categorybox} onSelectCategory={handleCategorySelect} />
      </div>
      <ProductList selectedCategory={selectedCategory} />
      <FooterF />
      <BottomMenu />
    </div>
  );
}

export default Home;
