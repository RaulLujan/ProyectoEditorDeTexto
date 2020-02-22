package componentes;

import javax.swing.JScrollPane;

// Clase que obtiene las propiedades de un JScrollPane y que proporciona a la Interfaz 
// una funcinalidad añadida a un componente. Para poder hacer mas Responsive este componente.
/**
 * Un Scroll es un componenete de nuestra interfaz con el cual podemos hacer un
 * desplazamiento de los contenidos 2D que se muestran en el componente al que
 * se le pone.
 */
public class Scroll extends JScrollPane {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor que inicializa el Scroll se construye tomando el PanelTexto
	 * ya es donde se va aplicar la funcionalidad del Scroll
	 * 
	 * @param panelTexto
	 *            representa al PanelTexto.
	 */
	public Scroll(PanelTexto panelTexto) {
		super(panelTexto);
		setFocusable(false);
	}

	// Esta clase no tienes Atributos por lo que no tiene Getters y Setters.

}
