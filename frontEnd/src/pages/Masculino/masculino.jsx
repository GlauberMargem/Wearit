import Footer from "../../layout/Footer"
import Header from '../../layout/Header';
import Options from '../../layout/Options';
import BottomMenu from '../../layout/BottomMenu';
import FooterF from "../../layout/RodaPe";
import ProductList from '../../layout/ProductList'; // Importa o componente de lista de produtos

function Masculino() {
    const selectedCategory = "MASCULINO"; // Categoria predefinida para esta página

    return (
        <div>
            <Footer nome="FRETE GRÁTIS EM COMPRAS A PARTIR DE R$ 199,00" />
            <Header />
            <div>
                <Options />
            </div>
            {/* Exibe a lista de produtos filtrados pela categoria "MASCULINO" */}
            <ProductList selectedCategory={selectedCategory} />
            <FooterF />
            <BottomMenu />
        </div>
    );
}

export default Masculino