package componentes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import vista.Vista;

//Clase que muestra un menu desplegable con los diferentes idiomas.
/**
 * Un PanelIdiomas es un componenete de nuestra interfaz que se coloca en un
 * componenete de nuestra Barra de Herramientas y muestra un menu con los
 * diferentes idiomas para cambiarlo a nuestra elección.
 */
public class PanelIdiomas extends JPopupMenu implements ActionListener {

	// Componentes de PanelIdiomas.
	private static final long serialVersionUID = 1L;
	private Vista vista;

	// JMenuItem de PanelIdiomas.
	private JMenuItem espanol, ingles, aleman, frances, italiano;

	/**
	 * Constructor que inicializar el PanelIdiomas tomando el JFrame principal
	 * que representa la vista del editor de Texto. Ademas este contructor se
	 * encargar de inicializar y construir los diferentes compoennetes de
	 * nuestro Editor de Texto del PanelIdiomas.
	 * 
	 * @param vista
	 *            representa al JFrame.
	 */
	public PanelIdiomas(Vista vista) {
		this.vista = vista;

		// Contruyo los JMenuItem de este menu.
		espanol = new JMenuItem();
		ingles = new JMenuItem();
		aleman = new JMenuItem();
		frances = new JMenuItem();
		italiano = new JMenuItem();

		// Añado los JMenuItem de este menu.
		add(espanol);
		add(ingles);
		add(aleman);
		add(frances);
		add(italiano);

		// Diferentes Listener para los compoennetes.
		espanol.addActionListener(this);
		ingles.addActionListener(this);
		aleman.addActionListener(this);
		frances.addActionListener(this);
		italiano.addActionListener(this);
	}

	// Método ActionListener que recoge los eventos del PanelIdiomas y llama a
	// la clase que contiene la funcionalidad del menu para su tratamiento.
	/**
	 * Método que selecciona la orden correspondiente que se debe ejecutar
	 * dependiendo de la opcion selecionada en el Menu.
	 * 
	 * @param ae
	 *            correspondiente al ActionEvent que llamo al método.
	 */
	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == espanol) {
			vista.getIdioma().cambioDeIdioma("es");
		} else if (ae.getSource() == ingles) {
			vista.getIdioma().cambioDeIdioma("en");
		} else if (ae.getSource() == frances) {
			vista.getIdioma().cambioDeIdioma("fr");
		} else if (ae.getSource() == aleman) {
			vista.getIdioma().cambioDeIdioma("de");
		} else if (ae.getSource() == italiano) {
			vista.getIdioma().cambioDeIdioma("it");
		}
		this.setVisible(false);
		setFocusable(false);
	}

	// Getters y Setters.
	public JMenuItem getEspanol() {
		return espanol;
	}

	public void setEspanol(JMenuItem espanol) {
		this.espanol = espanol;
	}

	public JMenuItem getIngles() {
		return ingles;
	}

	public void setIngles(JMenuItem ingles) {
		this.ingles = ingles;
	}

	public JMenuItem getAleman() {
		return aleman;
	}

	public void setAleman(JMenuItem aleman) {
		this.aleman = aleman;
	}

	public JMenuItem getFrances() {
		return frances;
	}

	public void setFrances(JMenuItem frances) {
		this.frances = frances;
	}

	public JMenuItem getItaliano() {
		return italiano;
	}

	public void setItaliano(JMenuItem italiano) {
		this.italiano = italiano;
	}

	public Vista getVista() {
		return vista;
	}

	public void setVista(Vista vista) {
		this.vista = vista;
	}

}
