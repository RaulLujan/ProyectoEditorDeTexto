package componentes;

import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import eventos.MenuHerramientasListener;
import vista.Vista;

// Clase  que obtiene las propiedades de un JToolBar y que proporciona a la Interfaz una barra de Herramientas con opciones
// de absceso rapido como botones y menus desplegables.
/**
 * Un MenuHerramientas es un componenete de nuestra interfaz que se coloca en la
 * parte superior de la ventna y nos proporciona por medio de botones y menus
 * desplagables todo tipo de funcionalidad de uso rapido de nuestro Editor de
 * Texto.
 */
public class MenuHerramientas extends JToolBar {

	// Componentes de MenuHerramientas.
	private static final long serialVersionUID = 1L;
	private Vista vista;
	private MenuHerramientasListener eventos;

	// JButtons.
	private JButton nuevoDoc, exportarPDF, abrir, guardar, color, idioma, buscar;

	// Grupo de Botones para la alineación.
	private ButtonGroup grupo;

	// JToggleButton botones que permanecen pulsados.
	// Alieación.
	private JToggleButton jusIzq, jusDer, jusCent, justificado;
	// Estilos.
	private JToggleButton negrita, cursiva, subrayado;

	// JLabels y JComboBoxs para el tamaño y la fuente de letra.
	private JLabel fuente, tam;
	private JComboBox<Integer> tamanyo;
	private JComboBox<String> familia;

	// SimpleAttributeSet para cambio de atributos en el texto.
	private SimpleAttributeSet attrs;

	// Panel para el boton de Idiomas.
	private PanelIdiomas idiomas;

	// JTextField para la barra de Busqueda.
	private JTextField barraBusqueda;

	/**
	 * Constructor que inicializa el MenuHerramientas se construye tomando el
	 * JFrame principal que representa la vista del editor de Texto. Ademas este
	 * contructor se encargar de inicializar y construir los diferentes
	 * compoennetes de nuestro Editor de Texto del MenuHerramientas.
	 * 
	 * @param vista
	 *            representa al JFrame.
	 */
	public MenuHerramientas(Vista vista) {

		this.vista = vista;
		this.eventos = new MenuHerramientasListener(this);

		// Botones.
		nuevoDoc = new JButton();
		exportarPDF = new JButton();
		abrir = new JButton();
		abrir = new JButton();
		guardar = new JButton();
		tamanyo = new JComboBox<>();
		negrita = new JToggleButton();
		cursiva = new JToggleButton();
		subrayado = new JToggleButton();
		grupo = new ButtonGroup();
		jusIzq = new JToggleButton();
		jusCent = new JToggleButton();
		jusDer = new JToggleButton();
		justificado = new JToggleButton();
		color = new JButton();
		idioma = new JButton();

		// JLabels.
		fuente = new JLabel();
		tam = new JLabel();

		// Panel.
		idiomas = new PanelIdiomas(vista);

		// BUsqueda.
		barraBusqueda = new JTextField();
		barraBusqueda.setPreferredSize(new Dimension(150, 25));
		buscar = new JButton();

		add(nuevoDoc);
		addSeparator();
		add(abrir);
		add(guardar);
		addSeparator();
		add(exportarPDF);
		addSeparator();

		// Atributos.
		attrs = new SimpleAttributeSet();

		// Cargo las funetes disponibles del sistema.
		GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
		String fuentes[] = environment.getAvailableFontFamilyNames();
		familia = new JComboBox<String>(fuentes);
		familia.setSelectedIndex(5);

		add(fuente);
		add(familia);
		addSeparator();
		add(tam);
		add(tamanyo);

		addSeparator();

		for (int i = 10; i <= 48; i++)
			tamanyo.addItem(new Integer(i));
		tamanyo.setSelectedIndex(5);

		add(negrita);
		add(cursiva);
		add(subrayado);
		addSeparator();

		add(jusIzq);
		add(jusCent);
		add(jusDer);
		add(justificado);
		grupo.add(jusIzq);
		grupo.add(jusCent);
		grupo.add(jusDer);
		grupo.add(justificado);
		addSeparator();

		add(color);
		addSeparator();

		add(idioma);
		add(idiomas);
		addSeparator();

		add(barraBusqueda);
		add(buscar);
		addSeparator();

		jusIzq.setSelected(true);

		// Diferentes Listener para los compoennetes.
		abrir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				eventos.metodoAbrir();
			}
		});
		guardar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				eventos.metodoGuardar();
			}
		});
		familia.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				eventos.fuenLetra(e);
			}
		});
		tamanyo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				eventos.tamLetra(e);
			}
		});
		negrita.addActionListener(eventos.estiloLetra(negrita));
		cursiva.addActionListener(eventos.estiloLetra(cursiva));
		subrayado.addActionListener(eventos.estiloLetra(subrayado));

		color.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				eventos.colores(e);
			}
		});

		idioma.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				eventos.cambiarDeIdioma();
			}
		});

		buscar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				eventos.buscar();
			}
		});
		nuevoDoc.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				eventos.metodoNuevoDoc();
			}
		});
		exportarPDF.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				eventos.metodoExportarPDF();
			}
		});

		jusIzq.addActionListener(eventos.justificarTexto(jusIzq));
		jusCent.addActionListener(eventos.justificarTexto(jusCent));
		jusDer.addActionListener(eventos.justificarTexto(jusDer));
		justificado.addActionListener(eventos.justificarTexto(justificado));

		// Cambio de atributos con la fuente y el tamaño.
		StyleConstants.setFontFamily(attrs, familia.getSelectedItem().toString());
		StyleConstants.setFontSize(attrs, Integer.parseInt(tamanyo.getSelectedItem().toString()));
		vista.getPanelTexto().setCharacterAttributes(attrs, true);

		setSize(vista.getDimension().width, 30);
		setFloatable(false);
	}

	// Getters y Setters.
	public JButton getAbrir() {
		return abrir;
	}

	public void setAbrir(JButton abrir) {
		this.abrir = abrir;
	}

	public JButton getGuardar() {
		return guardar;
	}

	public void setGuardar(JButton guardar) {
		this.guardar = guardar;
	}

	public JButton getColor() {
		return color;
	}

	public void setColor(JButton color) {
		this.color = color;
	}

	public JComboBox<Integer> getTamanyo() {
		return tamanyo;
	}

	public void setTamanyo(JComboBox<Integer> tamanyo) {
		this.tamanyo = tamanyo;
	}

	public JComboBox<String> getFamilia() {
		return familia;
	}

	public void setFamilia(JComboBox<String> familia) {
		this.familia = familia;
	}

	public ButtonGroup getGrupo() {
		return grupo;
	}

	public void setGrupo(ButtonGroup grupo) {
		this.grupo = grupo;
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

	public SimpleAttributeSet getAttrs() {
		return attrs;
	}

	public void setAttrs(SimpleAttributeSet attrs) {
		this.attrs = attrs;
	}

	public JToggleButton getJusIzq() {
		return jusIzq;
	}

	public void setJusIzq(JToggleButton jusIzq) {
		this.jusIzq = jusIzq;
	}

	public JToggleButton getJusDer() {
		return jusDer;
	}

	public void setJusDer(JToggleButton jusDer) {
		this.jusDer = jusDer;
	}

	public JToggleButton getJusCent() {
		return jusCent;
	}

	public void setJusCent(JToggleButton jusCent) {
		this.jusCent = jusCent;
	}

	public JToggleButton getJustificado() {
		return justificado;
	}

	public void setJustificado(JToggleButton justificado) {
		this.justificado = justificado;
	}

	public Vista getVista() {
		return vista;
	}

	public void setVista(Vista vista) {
		this.vista = vista;
	}

	public JLabel getFuente() {
		return fuente;
	}

	public void setFuente(JLabel fuente) {
		this.fuente = fuente;
	}

	public JLabel getTam() {
		return tam;
	}

	public void setTam(JLabel tam) {
		this.tam = tam;
	}

	public JButton getIdioma() {
		return idioma;
	}

	public void setIdioma(JButton idioma) {
		this.idioma = idioma;
	}

	public PanelIdiomas getIdiomas() {
		return idiomas;
	}

	public void setIdiomas(PanelIdiomas idiomas) {
		this.idiomas = idiomas;
	}

	public JButton getBuscar() {
		return buscar;
	}

	public void setBuscar(JButton buscar) {
		this.buscar = buscar;
	}

	public JTextField getBarraBusqueda() {
		return barraBusqueda;
	}

	public void setBarraBusqueda(JTextField barraBusqueda) {
		this.barraBusqueda = barraBusqueda;
	}

	public JButton getNuevoDoc() {
		return nuevoDoc;
	}

	public void setNuevoDoc(JButton nuevoDoc) {
		this.nuevoDoc = nuevoDoc;
	}

	public JButton getExportarPDF() {
		return exportarPDF;
	}

	public void setExportarPDF(JButton exportarPDF) {
		this.exportarPDF = exportarPDF;
	}

}
