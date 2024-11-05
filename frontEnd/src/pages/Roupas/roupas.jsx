import Footer from "../../layout/footer"
import Header from '../../layout/Header';
import Options from '../../layout/Options';
import BottomMenu from '../../layout/BottomMenu';
import FooterF from "../../layout/RodaPe";
import ProductList from '../../layout/ProductList'; // Importa o componente de lista de produtos

function Roupas() {
    const selectedCategory = "ROUPAS"; // Categoria predefinida para esta página

    return (
        <div>
                <Footer nome="FRETE GRÁTIS ACIMA DE R$ 199" />           
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

export default Roupas