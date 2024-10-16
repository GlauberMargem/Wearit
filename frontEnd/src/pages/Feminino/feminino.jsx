import Footer from "../../layout/footer"
import Header from '../../layout/Header';
import Options from '../../layout/Options';
import BottomMenu from '../../layout/BottomMenu';
import FooterF from "../../layout/RodaPe";
import ProductList from '../../layout/ProductList'; // Importa o componente de lista de produtos

function Feminino() {
    const selectedCategory = "FEMININO"; // Categoria predefinida para esta página

    return (
        <div>
            <Footer nome="SIGA-NOS NO INSTAGRAM @WEARIT." />
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

export default Feminino