import Footer from "../../layout/footer"
import Header from '../../layout/Header';
import Options from '../../layout/Options';
import BottomMenu from '../../layout/BottomMenu';
import FooterF from "../../layout/RodaPe";
import './registrar.css'

function Registrar() {
    return (
        <div>
          <Footer nome="SIGA-NOS NO INSTAGRAM @WEARIT." />
          <Header />
          <div>
            <Options />
          </div>
            <div className="inscrever-container">
        <h1>Inscreva-se</h1>
        <form>
            <label htmlFor="usuario">Usuário</label>
            <input type="text" id="usuario" name="usuario" placeholder="Digite seu usuário" />

            <label htmlFor="endereço">Endereço</label>
            <input type="text" id="Endereço" name="Endereço" placeholder="Digite seu Endereço" />

            <label htmlFor="numero">Numero</label>
            <input type="numero" id="numero" name="numero" placeholder="Digite o Numero da residencia" />

            <label htmlFor="cep">Cep</label>
            <input type="cep" id="cep" name="cep" placeholder="Digite o cep" />

            <label htmlFor="senha">Senha</label>
            <input type="password" id="senha" name="senha" placeholder="Digite sua senha" />

            <div className="button-group">
            <button type="submit" className="cadastrar-button">Cadastrar</button>
            <button type="button" className="login-button">Login</button>
            </div>
        </form>
        </div>
          <FooterF />
          <BottomMenu/> 
        </div>
      );
    }

export default Registrar