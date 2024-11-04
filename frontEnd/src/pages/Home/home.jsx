import Footer from "../../layout/footer";
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
            <Footer nome="FRETE GRÁTIS ACIMA DE R$ 199" />
      <Header />
      <div>
        <Options onSelectCategory={handleCategorySelect} />
      </div>
      <Banner />
      <Footer nome="15% de desconto para novos clientes use o código: wnew 15" />
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
