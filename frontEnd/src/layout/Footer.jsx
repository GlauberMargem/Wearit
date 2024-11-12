import './Footer.css';

function Footer({ nome, nome2 }) {
  return (
    <footer>
      <h1>{nome}</h1> 
      {nome2 && <h2>{nome2}</h2>}  {/* só exibe o nome2 se for passado */}
    </footer>
  );
}

export default Footer;
