package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.*;
import javax.swing.text.StyledDocument;
import apoyo.Iconos;
import apoyo.Idioma;
import componentes.BarraInferior;
import componentes.Menu;
import componentes.MenuHerramientas;
import componentes.PanelTexto;
import componentes.Scroll;

// Clase que obtiene las propiedades de un JFrame y que proporciona a la Interfaz principal del Editor de Texto.
// Esta es la clase donde se colocaran todos los componentes del Editor de Texto.
/**
 * Una Vista es la parte principal del Editor de texto, la cual se encarga de
 * distribuir y coordinar los diferentes componentes del editor de texto.
 */
public class Vista extends JFrame {

	// Componentes de Vista.
	private static final long serialVersionUID = 1L;
	private Dimension dimension;
	private Idioma idioma;
	private Menu menu;
	private MenuHerramientas herramientas;
	private PanelTexto panelTexto;
	private Scroll scroll;
	private BarraInferior barraInferior;
	private final StyledDocument estilos;

	/**
	 * Constructor que inicializa la Vista y genera y coloca los diferentes
	 * componentes del Editor de Texto.
	 */
	public Vista() {
		this.dimension = Toolkit.getDefaultToolkit().getScreenSize();
		setLayout(new BorderLayout());
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

		// WindowListener.
		addWindowListener(new WindowListener() {
			@Override
			public void windowOpened(WindowEvent e) {
			}

			@Override
			public void windowIconified(WindowEvent e) {
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
			}

			@Override
			public void windowClosing(WindowEvent e) {
				cerrarVentana();
			}

			@Override
			public void windowClosed(WindowEvent e) {
			}

			@Override
			public void windowActivated(WindowEvent e) {
			}
		});

		// Dimensión cuando se hace pequeña.
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setPreferredSize(new Dimension(750, 500));
		pack();

		// Inserción de Componentes.
		panelTexto = new PanelTexto(this);
		estilos = panelTexto.getStyledDocument();

		menu = new Menu(this);
		setJMenuBar(menu);

		herramientas = new MenuHerramientas(this);
		add(herramientas, BorderLayout.NORTH);

		scroll = new Scroll(panelTexto);
		add(scroll, BorderLayout.CENTER);

		barraInferior = new BarraInferior(this);
		add(barraInferior, BorderLayout.SOUTH);

		idioma = new Idioma(this);
		setVisible(true);

		new Iconos(this);

		this.panelTexto.requestFocus();

	}

	// Método que cuando se va a cerrar la ventana crea un panel de diálogo para
	// confirma el cierre del editor de texto y si quiere guardarlo antes.
	/**
	 * Método que cuando se va a cerrar la ventana crea un panel de diálogo para
	 * confirma el cierre del editor de texto y si quiere guardarlo antes.
	 */
	public void cerrarVentana() {
		String[] botones = { this.idioma.getGuardar(), this.idioma.getSalir(), this.idioma.getCancelar() };
		int eleccion = JOptionPane.showOptionDialog(this, this.idioma.getPreguntaGuargar(),
				this.idioma.getPreguntaSalir(), 0, 0, null, botones, null);
		if (eleccion == 0) {
			this.menu.getEventos().metodoGuardar();
			System.exit(0);
		} else if (eleccion == 1) {
			System.exit(0);
		}
	}

	// Getters y Setters.
	public Scroll getScroll() {
		return scroll;
	}

	public void setScroll(Scroll scroll) {
		this.scroll = scroll;
	}

	public PanelTexto getPanelTexto() {
		return panelTexto;
	}

	public void setPanelTexto(PanelTexto panelTexto) {
		this.panelTexto = panelTexto;
	}

	public Dimension getDimension() {
		return dimension;
	}

	public void setDimension(Dimension dimension) {
		this.dimension = dimension;
	}

	public Idioma getIdioma() {
		return idioma;
	}

	public void setIdioma(Idioma idioma) {
		this.idioma = idioma;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public MenuHerramientas getHerramientas() {
		return herramientas;
	}

	public void setHerramientas(MenuHerramientas herramientas) {
		this.herramientas = herramientas;
	}

	public BarraInferior getBarraInferior() {
		return barraInferior;
	}

	public void setBarraInferior(BarraInferior barraInferior) {
		this.barraInferior = barraInferior;
	}

	public StyledDocument getEstilos() {
		return estilos;
	}

}
