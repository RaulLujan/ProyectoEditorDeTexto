package componentes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import apoyo.Fuente;
import eventos.MenuListener;
import vista.Vista;

// Clase que obtiene las propiedades de un JMenuBar y que proporciona a la Interfaz una barra de menu con opciones de 
// Archivo, Edición, Inserción, Formato, Ajustes y Ayuda.
/**
 * Un Menu es un componenete de nuestra interfaz que se coloca en la parte
 * superior de la ventna y nos proporciona por medio de menus desplagables todo
 * tipo de funcionalidad que nuestro editor es capaz de hacer.
 */
public class Menu extends JMenuBar implements ActionListener {

	// Componentes de Menu.
	private static final long serialVersionUID = 1L;
	private Vista vista;
	private MenuListener eventos;

	// Diferentes JMenus de nuestro Menu.
	private JMenu menuArchivo, menuEditar, menuInsertar, menuFormato, menuAjustes, menuAyuda, idioma, menuTexto,
			alinear, menuEstilos;

	// Diferentes JMenuItems, que serán las opciones de nuestros JMenus.
	private JMenuItem abrir, salir, copiar, cortar, pegar, guardar, fuente, imagen, negrita, cursiva, subrayado, jusIzq,
			jusDer, jusCent, justificado, seleccion, acercaDe, color, nuevoDoc, exportarPDF;
	// Idiomas.
	private JMenuItem espanol, ingles, aleman, frances, italiano;

	/**
	 * Constructor que inicializar el Menu se construye tomando el JFrame
	 * principal que representa la vista del editor de Texto. Ademas este
	 * contructor se encargar de inicializar y construir los diferentes
	 * compoennetes de nuestro Editor de Texto del Menu.
	 * 
	 * @param vista
	 *            representa al JFrame.
	 */
	public Menu(Vista vista) {

		this.vista = vista;
		this.eventos = new MenuListener(this);

		// JMenus.
		menuArchivo = new JMenu();
		menuEditar = new JMenu();
		menuInsertar = new JMenu();
		menuFormato = new JMenu();
		menuAjustes = new JMenu();
		menuAyuda = new JMenu();
		add(menuArchivo);
		add(menuEditar);
		add(menuInsertar);
		add(menuFormato);
		add(menuAjustes);
		add(menuAyuda);

		// JMenuItems.
		abrir = new JMenuItem();
		guardar = new JMenuItem();
		salir = new JMenuItem();
		copiar = new JMenuItem();
		cortar = new JMenuItem();
		pegar = new JMenuItem();
		fuente = new JMenuItem();
		imagen = new JMenuItem();

		idioma = new JMenu();
		espanol = new JMenuItem();
		ingles = new JMenuItem();
		aleman = new JMenuItem();
		frances = new JMenuItem();
		italiano = new JMenuItem();

		menuTexto = new JMenu();
		negrita = new JMenuItem();
		cursiva = new JMenuItem();
		subrayado = new JMenuItem();

		alinear = new JMenu();
		jusIzq = new JMenuItem();
		jusDer = new JMenuItem();
		jusCent = new JMenuItem();
		justificado = new JMenuItem();

		seleccion = new JMenuItem();
		acercaDe = new JMenuItem();

		color = new JMenuItem();
		nuevoDoc = new JMenuItem();
		exportarPDF = new JMenuItem();

		menuEstilos = new JMenu();

		// Bucle para inicializar con los diferentes estilos del Sistema al Menu
		// de Estilos.
		for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
			JMenuItem estilo = new JMenuItem(info.getName());
			String clase = info.getClassName();
			menuEstilos.add(estilo);
			estilo.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						javax.swing.UIManager.setLookAndFeel(clase);
						javax.swing.SwingUtilities.updateComponentTreeUI(vista);
						Menu.this.vista.repaint();
					} catch (Exception ex) {
					}
				}
			});

		}

		// Los diferentes atajos de teclas para los Componentes del Menu.
		abrir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));
		guardar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.CTRL_DOWN_MASK));
		salir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_DOWN_MASK));
		copiar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK));
		cortar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_DOWN_MASK));
		pegar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_DOWN_MASK));
		fuente.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.CTRL_DOWN_MASK));
		negrita.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
		cursiva.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.CTRL_DOWN_MASK));
		subrayado.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
		jusIzq.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_DOWN_MASK));
		jusDer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_DOWN_MASK));
		jusCent.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, InputEvent.CTRL_DOWN_MASK));
		justificado.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_J, InputEvent.CTRL_DOWN_MASK));
		seleccion.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK));
		color.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, InputEvent.CTRL_DOWN_MASK));
		exportarPDF.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_DOWN_MASK));
		nuevoDoc.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, InputEvent.CTRL_DOWN_MASK));

		idioma.add(espanol);
		idioma.add(ingles);
		idioma.add(aleman);
		idioma.add(frances);
		idioma.add(italiano);

		menuTexto.add(negrita);
		menuTexto.add(cursiva);
		menuTexto.add(subrayado);

		alinear.add(jusIzq);
		alinear.add(jusCent);
		alinear.add(jusDer);
		alinear.add(justificado);

		menuArchivo.add(nuevoDoc);
		menuArchivo.addSeparator();
		menuArchivo.add(abrir);
		menuArchivo.add(guardar);
		menuArchivo.addSeparator();
		menuArchivo.add(exportarPDF);
		menuArchivo.addSeparator();
		menuArchivo.add(salir);
		menuEditar.add(copiar);
		menuEditar.add(cortar);
		menuEditar.add(pegar);
		menuEditar.addSeparator();
		menuEditar.add(fuente);
		menuEditar.addSeparator();
		menuEditar.add(seleccion);
		menuFormato.add(menuTexto);
		menuFormato.add(alinear);
		menuFormato.add(color);
		menuInsertar.add(imagen);
		menuAjustes.add(idioma);
		menuAjustes.add(menuEstilos);
		menuAyuda.add(acercaDe);

		// Diferentes Listener para los compoennetes.
		abrir.addActionListener(this);
		guardar.addActionListener(this);
		salir.addActionListener(this);
		copiar.addActionListener(this);
		cortar.addActionListener(this);
		pegar.addActionListener(this);
		fuente.addActionListener(this);
		imagen.addActionListener(this);
		espanol.addActionListener(this);
		ingles.addActionListener(this);
		aleman.addActionListener(this);
		frances.addActionListener(this);
		italiano.addActionListener(this);
		acercaDe.addActionListener(this);
		color.addActionListener(this);
		nuevoDoc.addActionListener(this);
		exportarPDF.addActionListener(this);

		seleccion.addActionListener(this);
		negrita.addActionListener(eventos.estiloLetra(negrita));
		cursiva.addActionListener(eventos.estiloLetra(cursiva));
		subrayado.addActionListener(eventos.estiloLetra(subrayado));

		jusIzq.addActionListener(eventos.justificarTexto(jusIzq));
		jusCent.addActionListener(eventos.justificarTexto(jusCent));
		jusDer.addActionListener(eventos.justificarTexto(jusDer));
		justificado.addActionListener(eventos.justificarTexto(justificado));

		setFocusable(false);

	}

	// Método ActionListener que recoge los eventos del Menu y llama a la clase
	// que contiene la funcionalidad del menu para su tratamiento.
	/**
	 * Método que selecciona la orden correspondiente que se debe ejecutar
	 * dependiendo de la opcion selecionada en el Menu.
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
		} else if (ae.getSource() == salir) {
			this.vista.cerrarVentana();
		} else if (ae.getSource() == abrir) {
			eventos.metodoAbrir();
		} else if (ae.getSource() == guardar) {
			eventos.metodoGuardar();
		} else if (ae.getSource() == fuente) {
			new Fuente(this.vista);
		} else if (ae.getSource() == imagen) {
			eventos.metodoImagen();
		} else if (ae.getSource() == espanol) {
			vista.getIdioma().cambioDeIdioma("es");
		} else if (ae.getSource() == ingles) {
			vista.getIdioma().cambioDeIdioma("en");
		} else if (ae.getSource() == frances) {
			vista.getIdioma().cambioDeIdioma("fr");
		} else if (ae.getSource() == aleman) {
			vista.getIdioma().cambioDeIdioma("de");
		} else if (ae.getSource() == italiano) {
			vista.getIdioma().cambioDeIdioma("it");
		} else if (ae.getSource() == seleccion) {
			vista.getPanelTexto().select(0, vista.getPanelTexto().getText().length());
		} else if (ae.getSource() == acercaDe) {
			eventos.metodoAcercaDe();
		} else if (ae.getSource() == color) {
			eventos.colores(ae);
		} else if (ae.getSource() == nuevoDoc) {
			eventos.metodoNuevoDoc();
		} else if (ae.getSource() == exportarPDF) {
			eventos.metodoExportarPDF();
		}
	}

	// Getters y Setters.

	public JMenu getMenuArchivo() {
		return menuArchivo;
	}

	public void setMenuArchivo(JMenu menuArchivo) {
		this.menuArchivo = menuArchivo;
	}

	public JMenu getMenuEditar() {
		return menuEditar;
	}

	public void setMenuEditar(JMenu menuEditar) {
		this.menuEditar = menuEditar;
	}

	public JMenu getMenuInsertar() {
		return menuInsertar;
	}

	public void setMenuInsertar(JMenu menuInsertar) {
		this.menuInsertar = menuInsertar;
	}

	public JMenu getMenuFormato() {
		return menuFormato;
	}

	public void setMenuFormato(JMenu menuFormato) {
		this.menuFormato = menuFormato;
	}

	public JMenu getMenuAjustes() {
		return menuAjustes;
	}

	public void setMenuAjustes(JMenu menuAjustes) {
		this.menuAjustes = menuAjustes;
	}

	public JMenu getMenuAyuda() {
		return menuAyuda;
	}

	public void setMenuAyuda(JMenu menuAyuda) {
		this.menuAyuda = menuAyuda;
	}

	public JMenu getIdioma() {
		return idioma;
	}

	public void setIdioma(JMenu idioma) {
		this.idioma = idioma;
	}

	public JMenu getMenuTexto() {
		return menuTexto;
	}

	public void setMenuTexto(JMenu texto) {
		this.menuTexto = texto;
	}

	public JMenu getAlinear() {
		return alinear;
	}

	public void setAlinear(JMenu alinear) {
		this.alinear = alinear;
	}

	public JMenuItem getAbrir() {
		return abrir;
	}

	public void setAbrir(JMenuItem abrir) {
		this.abrir = abrir;
	}

	public JMenuItem getSalir() {
		return salir;
	}

	public void setSalir(JMenuItem salir) {
		this.salir = salir;
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

	public JMenuItem getGuardar() {
		return guardar;
	}

	public void setGuardar(JMenuItem guardar) {
		this.guardar = guardar;
	}

	public JMenuItem getFuente() {
		return fuente;
	}

	public void setFuente(JMenuItem fuente) {
		this.fuente = fuente;
	}

	public JMenuItem getImagen() {
		return imagen;
	}

	public void setImagen(JMenuItem imagen) {
		this.imagen = imagen;
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
		return subrayado;
	}

	public void setSubrayar(JMenuItem subrayar) {
		this.subrayado = subrayar;
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

	public JMenuItem getSeleccion() {
		return seleccion;
	}

	public void setSeleccion(JMenuItem seleccion) {
		this.seleccion = seleccion;
	}

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

	public Vista getVista() {
		return vista;
	}

	public void setVista(Vista vista) {
		this.vista = vista;
	}

	public JMenu getMenuEstilos() {
		return menuEstilos;
	}

	public void setMenuEstilos(JMenu menuEstilos) {
		this.menuEstilos = menuEstilos;
	}

	public JMenuItem getSubrayado() {
		return subrayado;
	}

	public void setSubrayado(JMenuItem subrayado) {
		this.subrayado = subrayado;
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

	public MenuListener getEventos() {
		return eventos;
	}

	public void setEventos(MenuListener eventos) {
		this.eventos = eventos;
	}

	public JMenuItem getAcercaDe() {
		return acercaDe;
	}

	public void setAcercaDe(JMenuItem acercaDe) {
		this.acercaDe = acercaDe;
	}

	public JMenuItem getColor() {
		return color;
	}

	public void setColor(JMenuItem color) {
		this.color = color;
	}

	public JMenuItem getNuevoDoc() {
		return nuevoDoc;
	}

	public void setNuevoDoc(JMenuItem nuevoDoc) {
		this.nuevoDoc = nuevoDoc;
	}

	public JMenuItem getExportarPDF() {
		return exportarPDF;
	}

	public void setExportarPDF(JMenuItem exportarPDF) {
		this.exportarPDF = exportarPDF;
	}

}
