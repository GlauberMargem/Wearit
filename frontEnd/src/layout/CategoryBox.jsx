import './CategoryBox.css'

function CategoryBox({ categorybox, onSelectCategory }) {
    return (
        <section className="navigation-box">
            <nav className="box-menu" id="boxMenu">
                <ul>
                    {categorybox.map((box, index) => (
                        <li key={index} onClick={() => onSelectCategory(box)}>
                            <a href="#">{box}</a>
                        </li>
                    ))}
                </ul>
            </nav>
        </section>
    );
}

export default CategoryBox