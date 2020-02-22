package apoyo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import vista.Vista;

// Clase que abre una ventana que muestra las diferentes opciones de fuente o 
// estilos de letra para personalizar nuestro texto seleccionado.
/**
 * Una Fuente es una ventana que perimite personalizar el texto seleccionado. Se
 * prodra elegir entre el tipo de fuente, el tamaño, el color, en Negrita, en
 * Cursiva y en subrayado.
 */
public class Fuente extends JDialog implements ActionListener {

	// Componentes de la Fuente.
	private static final long serialVersionUID = 1L;
	private Vista vista;
	private JToggleButton negrita, cursiva, subrayado;
	private JButton aceptar, cancelar;
	private JComboBox<Integer> tamano;
	private JComboBox<String> familia;
	private SimpleAttributeSet attrs;
	private String fuentes[];
	private JColorChooser colores;
	private JPanel panelOpciones, panelBotones;

	/**
	 * Constructor que inicializa la fuente tomando el JFrame principal que
	 * representa la vista del editor de Texto.
	 * 
	 * @param vista
	 *            representa al JFrame.
	 */
	public Fuente(Vista vista) {
		this.setTitle("Fuente");
		this.vista = vista;
		this.setSize(700, 500);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(new BorderLayout());

		// Inicializamos los componentes.
		panelOpciones = new JPanel(new FlowLayout());
		setTitle(vista.getIdioma().getFuente());
		negrita = new JToggleButton();
		cursiva = new JToggleButton();
		subrayado = new JToggleButton();
		negrita.setIcon(getIcon("./resources/imagenes/negrita.png"));
		cursiva.setIcon(getIcon("./resources/imagenes/cursiva.png"));
		subrayado.setIcon(getIcon("./resources/imagenes/subrayado.png"));

		// Añadimos los componentes a la Fuente.
		panelOpciones.add(negrita);
		panelOpciones.add(cursiva);
		panelOpciones.add(subrayado);

		tamano = new JComboBox<Integer>();
		familia = new JComboBox<String>();
		for (int i = 10; i <= 48; i++)
			tamano.addItem(new Integer(i));
		panelOpciones.add(tamano);

		// Cargo las funetes disponibles del sistema.
		GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
		fuentes = environment.getAvailableFontFamilyNames();
		familia = new JComboBox<String>(fuentes);
		panelOpciones.add(familia);
		colores = new JColorChooser(Color.BLACK);

		// Añadimos los componentes a la Fuente.
		panelOpciones.add(colores);
		this.add(panelOpciones, BorderLayout.CENTER);
		panelBotones = new JPanel(new FlowLayout());
		aceptar = new JButton(vista.getIdioma().getAceptar());
		cancelar = new JButton(vista.getIdioma().getCancelar());
		panelBotones.add(aceptar);
		panelBotones.add(cancelar);
		this.add(panelBotones, BorderLayout.SOUTH);

		attrs = new SimpleAttributeSet();
		aceptar.addActionListener(this);
		cancelar.addActionListener(this);
		this.setVisible(true);
	}

	// Metodo de la interface ActionListener.
	/**
	 * Método que escucha los eventos sobre la Fuente y los captura para
	 * realizar la funcionalidad de estos..
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == aceptar) {
			if (negrita.isSelected())
				StyleConstants.setBold(attrs, true);
			if (cursiva.isSelected())
				StyleConstants.setItalic(attrs, true);
			if (subrayado.isSelected())
				StyleConstants.setUnderline(attrs, true);
			StyleConstants.setForeground(attrs, colores.getColor());
			StyleConstants.setFontFamily(attrs, familia.getSelectedItem().toString());
			StyleConstants.setFontSize(attrs, Integer.parseInt(tamano.getSelectedItem().toString()));
			if (vista.getPanelTexto().getSelectedText() != null)
				vista.getPanelTexto().getStyledDocument().setCharacterAttributes(
						vista.getPanelTexto().getSelectionStart(), vista.getPanelTexto().getSelectedText().length(),
						attrs, true);
			this.dispose();
		} else if (e.getSource() == cancelar) {
			this.dispose();
		}
	}

	// Metodo de la para ajustar los Iconos.
	/**
	 * Método que ajusta una iamgen a tamaño icono.
	 * 
	 * @param ruta
	 *            La drireccion donde se encuentra almacenada la imagen.
	 * @return El icono de la imagen recibida.
	 */
	public Icon getIcon(String ruta) {
		Icon icono = new ImageIcon(new ImageIcon(ruta).getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
		return icono;
	}

	// Getters y Setters.
	public Vista getVista() {
		return vista;
	}

	public void setVista(Vista vista) {
		this.vista = vista;
	}

	public JToggleButton getNegrita() {
		return negrita;
	}

	public void setNegrita(JToggleButton negrita) {
		this.negrita = negrita;
	}

	public JToggleButton getCursiva() {
		return cursiva;
	}

	public void setCursiva(JToggleButton cursiva) {
		this.cursiva = cursiva;
	}

	public JToggleButton getSubrayado() {
		return subrayado;
	}

	public void setSubrayado(JToggleButton subrayado) {
		this.subrayado = subrayado;
	}

	public JButton getAceptar() {
		return aceptar;
	}

	public void setAceptar(JButton aceptar) {
		this.aceptar = aceptar;
	}

	public JButton getCancelar() {
		return cancelar;
	}

	public void setCancelar(JButton cancelar) {
		this.cancelar = cancelar;
	}

	public JComboBox<Integer> getTamano() {
		return tamano;
	}

	public void setTamano(JComboBox<Integer> tamano) {
		this.tamano = tamano;
	}

	public JComboBox<String> getFamilia() {
		return familia;
	}

	public void setFamilia(JComboBox<String> familia) {
		this.familia = familia;
	}

	public SimpleAttributeSet getAttrs() {
		return attrs;
	}

	public void setAttrs(SimpleAttributeSet attrs) {
		this.attrs = attrs;
	}

	public String[] getFuentes() {
		return fuentes;
	}

	public void setFuentes(String[] fuentes) {
		this.fuentes = fuentes;
	}

	public JColorChooser getColores() {
		return colores;
	}

	public void setColores(JColorChooser colores) {
		this.colores = colores;
	}

	public JPanel getPanelOpciones() {
		return panelOpciones;
	}

	public void setPanelOpciones(JPanel panelOpciones) {
		this.panelOpciones = panelOpciones;
	}

	public JPanel getPanelBotones() {
		return panelBotones;
	}

	public void setPanelBotones(JPanel panelBotones) {
		this.panelBotones = panelBotones;
	}

}