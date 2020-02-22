package componentes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.KeyStroke;
import apoyo.Fuente;
import eventos.MenuBotonDerListener;
import vista.Vista;

// Clase  que obtiene las propiedades de un JPopupMenu y que proporciona a la Interfaz para el evento 
// del Click Derecho del raton con las funcionalidades basicas de un editor de texto como copiar, pegar, 
// cortar, estilo de fuente, alineacion y selección.
/**
 * Un MenuBotonDer es un componenete de nuestra interfaz que como su nombre
 * indica, da la funcionalidad de un Menu pero con el evento del Click Derecho
 * del raton.
 */
public class MenuBotonDer extends JPopupMenu implements ActionListener {

	// Componentes de MenuBotonDer.
	private static final long serialVersionUID = 1L;
	private Vista vista;
	private MenuBotonDerListener eventos;

	// Diferentes JMenus de nuestro MenuBotonDer.
	private JMenu texto, alinear;

	// Diferentes JMenuItems, que serán las opciones de nuestros JMenus o
	// directamente opciones
	// de nuestro MenuBotonDer ya que este es un Menu básico.
	private JMenuItem copiar, cortar, pegar, fuente, jusIzq, jusDer, jusCent, justificado, negrita, cursiva, subrayar,
			seleccion;

	/**
	 * Constructor que inicializar el MenuBotonDer tomando el JFrame principal
	 * que representa la vista del editor de Texto. Ademas este contructor se
	 * encargar de inicializar y construir los diferentes compoennetes de
	 * nuestro Editor de Texto del MenuBotonDer.
	 * 
	 * @param vista
	 *            representa al JFrame.
	 */
	public MenuBotonDer(Vista vista) {

		this.vista = vista;
		this.eventos = new MenuBotonDerListener(this);

		// JMenus y JMenuItems.
		copiar = new JMenuItem();
		cortar = new JMenuItem();
		pegar = new JMenuItem();
		fuente = new JMenuItem();

		seleccion = new JMenuItem();

		texto = new JMenu();
		negrita = new JMenuItem();
		cursiva = new JMenuItem();
		subrayar = new JMenuItem();

		alinear = new JMenu();
		jusIzq = new JMenuItem();
		jusDer = new JMenuItem();
		jusCent = new JMenuItem();
		justificado = new JMenuItem();

		texto.add(negrita);
		texto.add(cursiva);
		texto.add(subrayar);
		alinear.add(jusIzq);
		alinear.add(jusCent);
		alinear.add(jusDer);
		alinear.add(justificado);

		// Los diferentes atajos de teclas para los Componentes del
		// MenuBotonDer.
		copiar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK));
		cortar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_DOWN_MASK));
		pegar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_DOWN_MASK));
		fuente.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.CTRL_DOWN_MASK));
		negrita.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
		cursiva.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.CTRL_DOWN_MASK));
		subrayar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
		jusIzq.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_DOWN_MASK));
		jusDer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_DOWN_MASK));
		jusCent.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, InputEvent.CTRL_DOWN_MASK));
		justificado.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_J, InputEvent.CTRL_DOWN_MASK));
		seleccion.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK));

		add(copiar);
		add(cortar);
		add(pegar);
		addSeparator();
		add(fuente);
		add(texto);
		add(alinear);
		addSeparator();
		add(seleccion);

		// Diferentes Listener para los compoennetes.
		copiar.addActionListener(this);
		cortar.addActionListener(this);
		pegar.addActionListener(this);
		fuente.addActionListener(this);
		seleccion.addActionListener(this);
		negrita.addActionListener(eventos.estiloLetra(negrita));
		cursiva.addActionListener(eventos.estiloLetra(cursiva));
		subrayar.addActionListener(eventos.estiloLetra(subrayar));

		jusIzq.addActionListener(eventos.justificarTexto(jusIzq));
		jusCent.addActionListener(eventos.justificarTexto(jusCent));
		jusDer.addActionListener(eventos.justificarTexto(jusDer));
		justificado.addActionListener(eventos.justificarTexto(justificado));

		setFocusable(false);
	}

	// Método ActionListener que recoge los eventos del MenuBotonDer y llama a
	// la clase
	// que contiene la funcionalidad del menu para su tratamiento.
	/**
	 * Método que selecciona la orden correspondiente que se debe ejecutar
	 * dependiendo de la opcion selecionada en el MenuBotonDer.
	 * 
	 * @param ae
	 *            correspondiente al ActionEvent que llamo al método.
	 */
	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == copiar) {
			this.vista.getPanelTexto().copy();
		} else if (ae.getSource() == pegar) {
			this.vista.getPanelTexto().paste();
		} else if (ae.getSource() == cortar) {
			this.vista.getPanelTexto().cut();
		} else if (ae.getSource() == fuente) {
			new Fuente(this.vista);
		} else if (ae.getSource() == seleccion) {
			vista.getPanelTexto().select(0, vista.getPanelTexto().getText().length());
		}
	}

	// Getters y Setters.
	public JMenu getTexto() {
		return texto;
	}

	public Vista getVista() {
		return vista;
	}

	public void setVista(Vista vista) {
		this.vista = vista;
	}

	public void setTexto(JMenu texto) {
		this.texto = texto;
	}

	public JMenu getAlinear() {
		return alinear;
	}

	public void setAlinear(JMenu alinear) {
		this.alinear = alinear;
	}

	public JMenuItem getCopiar() {
		return copiar;
	}

	public void setCopiar(JMenuItem copiar) {
		this.copiar = copiar;
	}

	public JMenuItem getCortar() {
		return cortar;
	}

	public void setCortar(JMenuItem cortar) {
		this.cortar = cortar;
	}

	public JMenuItem getPegar() {
		return pegar;
	}

	public void setPegar(JMenuItem pegar) {
		this.pegar = pegar;
	}

	public JMenuItem getFuente() {
		return fuente;
	}

	public void setFuente(JMenuItem fuente) {
		this.fuente = fuente;
	}

	public JMenuItem getJusIzq() {
		return jusIzq;
	}

	public void setJusIzq(JMenuItem jusIzq) {
		this.jusIzq = jusIzq;
	}

	public JMenuItem getJusDer() {
		return jusDer;
	}

	public void setJusDer(JMenuItem jusDer) {
		this.jusDer = jusDer;
	}

	public JMenuItem getJusCent() {
		return jusCent;
	}

	public void setJusCent(JMenuItem jusCent) {
		this.jusCent = jusCent;
	}

	public JMenuItem getJustificado() {
		return justificado;
	}

	public void setJustificado(JMenuItem justificado) {
		this.justificado = justificado;
	}

	public JMenuItem getNegrita() {
		return negrita;
	}

	public void setNegrita(JMenuItem negrita) {
		this.negrita = negrita;
	}

	public JMenuItem getCursiva() {
		return cursiva;
	}

	public void setCursiva(JMenuItem cursiva) {
		this.cursiva = cursiva;
	}

	public JMenuItem getSubrayar() {
		return subrayar;
	}

	public void setSubrayar(JMenuItem subrayar) {
		this.subrayar = subrayar;
	}

	public JMenuItem getSeleccion() {
		return seleccion;
	}

	public void setSeleccion(JMenuItem seleccion) {
		this.seleccion = seleccion;
	}

}
