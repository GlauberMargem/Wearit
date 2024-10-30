import Footer from "../../layout/footer"
import Header from '../../layout/Header';
import Options from '../../layout/Options';
import BottomMenu from '../../layout/BottomMenu';
import FooterF from "../../layout/RodaPe";


function Contatos() {
    return (
        <div>
            <Footer nome="FRETE GRÁTIS ACIMA DE R$ 199" />
          <Header />
          <div>
            <Options />
          </div>
          <FooterF />
          <BottomMenu/> 
        </div>
      );
    }

export default Contatos