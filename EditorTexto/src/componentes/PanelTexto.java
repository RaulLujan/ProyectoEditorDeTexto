package componentes;

import java.awt.BorderLayout;
import javax.swing.JTextPane;
import vista.Vista;

// Clase  que obtiene las propiedades de un JTextPane y que proporciona a la Interfaz 
// un panel editable donde poder escribir nuestros documentos.
/**
 * Un PanelTexto es un componenete de nuestra interfaz en el cual podemos
 * ecribir la informacionqeu querarmos, ademas es la parte donde se aplicara
 * todo la funcionalidad del editor de texto.
 */
public class PanelTexto extends JTextPane {

	// Componentes de PanelTexto.
	private static final long serialVersionUID = 1L;

	// Tambien MenuBotonDer ya que es donde se aplica este menu.
	private MenuBotonDer menuBotonDer;

	/**
	 * Constructor que inicializar el PanelTexto tomando el JFrame principal que
	 * representa la vista del editor de Texto.
	 * 
	 * @param vista
	 *            representa al JFrame.
	 */
	public PanelTexto(Vista vista) {

		setLayout(new BorderLayout());
		menuBotonDer = new MenuBotonDer(vista);

		// Añadimos el Menu emergente con el Click Derecho.
		setComponentPopupMenu(menuBotonDer);

	}

	// Getters y Setters.
	public MenuBotonDer getMenuBotonDer() {
		return menuBotonDer;
	}

	public void setMenuBotonDer(MenuBotonDer menuBotonDer) {
		this.menuBotonDer = menuBotonDer;
	}

}
