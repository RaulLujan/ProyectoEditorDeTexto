package apoyo;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import vista.Vista;

// Clase que se encarga de cargar todos los iconos, ajustarlos y aplicarlos a los componentes
// de nuestro programa.
/**
 * Iconos es un proceso por el cual se le aplican los diferentes iconos a los
 * componentes de nuestro editor de texto.
 */
public class Iconos {

	// Componentes de Iconos.
	private Vista vista;

	// Cuando se contruye inicializa y carga los iconos.
	/**
	 * Constructor que inicializa Iconos tomando el JFrame principal que
	 * representa la vista del editor de Texto.
	 * 
	 * @param vista
	 *            representa al JFrame.
	 */
	public Iconos(Vista vista) {

		this.vista = vista;

		// Icono de ventana.
		ImageIcon icono = new ImageIcon("./resources/imagenes/file.png");
		this.vista.setIconImage(icono.getImage());

		// Iconos de Alineación.
		this.vista.getHerramientas().getJusIzq().setIcon(getIcon("./resources/imagenes/left-align.png"));
		this.vista.getHerramientas().getJusCent().setIcon(getIcon("./resources/imagenes/center-align.png"));
		this.vista.getHerramientas().getJusDer().setIcon(getIcon("./resources/imagenes/right-align.png"));
		this.vista.getHerramientas().getJustificado().setIcon(getIcon("./resources/imagenes/justify.png"));
		this.vista.getMenu().getJusIzq().setIcon(getIcon("./resources/imagenes/left-align.png"));
		this.vista.getMenu().getJusCent().setIcon(getIcon("./resources/imagenes/center-align.png"));
		this.vista.getMenu().getJusDer().setIcon(getIcon("./resources/imagenes/right-align.png"));
		this.vista.getMenu().getJustificado().setIcon(getIcon("./resources/imagenes/justify.png"));
		this.vista.getPanelTexto().getMenuBotonDer().getJusIzq()
				.setIcon(getIcon("./resources/imagenes/left-align.png"));
		this.vista.getPanelTexto().getMenuBotonDer().getJusCent()
				.setIcon(getIcon("./resources/imagenes/center-align.png"));
		this.vista.getPanelTexto().getMenuBotonDer().getJusDer()
				.setIcon(getIcon("./resources/imagenes/right-align.png"));
		this.vista.getPanelTexto().getMenuBotonDer().getJustificado()
				.setIcon(getIcon("./resources/imagenes/justify.png"));

		// Iconos de Abrir y Guardar.
		this.vista.getHerramientas().getAbrir().setIcon(getIcon("./resources/imagenes/folder.png"));
		this.vista.getHerramientas().getGuardar().setIcon(getIcon("./resources/imagenes/save.png"));
		this.vista.getMenu().getAbrir().setIcon(getIcon("./resources/imagenes/folder.png"));
		this.vista.getMenu().getGuardar().setIcon(getIcon("./resources/imagenes/save.png"));

		// Iconos de Negrita, Cursiva y Subrayado.
		this.vista.getHerramientas().getNegrita().setIcon(getIcon("./resources/imagenes/negrita.png"));
		this.vista.getHerramientas().getCursiva().setIcon(getIcon("./resources/imagenes/cursiva.png"));
		this.vista.getHerramientas().getSubrayado().setIcon(getIcon("./resources/imagenes/subrayado.png"));
		this.vista.getMenu().getNegrita().setIcon(getIcon("./resources/imagenes/negrita.png"));
		this.vista.getMenu().getCursiva().setIcon(getIcon("./resources/imagenes/cursiva.png"));
		this.vista.getMenu().getSubrayado().setIcon(getIcon("./resources/imagenes/subrayado.png"));
		this.vista.getPanelTexto().getMenuBotonDer().getNegrita().setIcon(getIcon("./resources/imagenes/negrita.png"));
		this.vista.getPanelTexto().getMenuBotonDer().getCursiva().setIcon(getIcon("./resources/imagenes/cursiva.png"));
		this.vista.getPanelTexto().getMenuBotonDer().getSubrayar()
				.setIcon(getIcon("./resources/imagenes/subrayado.png"));

		// Iconos de color.
		this.vista.getHerramientas().getColor().setIcon(getIcon("./resources/imagenes/colorFuente.png"));
		this.vista.getMenu().getColor().setIcon(getIcon("./resources/imagenes/colorFuente.png"));

		// Icono de Lupa para la Busqueda.
		this.vista.getHerramientas().getBuscar().setIcon(getIcon("./resources/imagenes/search.png"));

		// Iconos de banderas para los idiomas.
		this.vista.getHerramientas().getIdiomas().getEspanol().setIcon(getIcon("./resources/imagenes/spain.png"));
		this.vista.getHerramientas().getIdiomas().getIngles()
				.setIcon(getIcon("./resources/imagenes/united-kingdom.png"));
		this.vista.getHerramientas().getIdiomas().getAleman().setIcon(getIcon("./resources/imagenes/germany.png"));
		this.vista.getHerramientas().getIdiomas().getFrances().setIcon(getIcon("./resources/imagenes/france.png"));
		this.vista.getHerramientas().getIdiomas().getItaliano().setIcon(getIcon("./resources/imagenes/italy.png"));
		this.vista.getMenu().getEspanol().setIcon(getIcon("./resources/imagenes/spain.png"));
		this.vista.getMenu().getIngles().setIcon(getIcon("./resources/imagenes/united-kingdom.png"));
		this.vista.getMenu().getAleman().setIcon(getIcon("./resources/imagenes/germany.png"));
		this.vista.getMenu().getFrances().setIcon(getIcon("./resources/imagenes/france.png"));
		this.vista.getMenu().getItaliano().setIcon(getIcon("./resources/imagenes/italy.png"));

		// Iconos de Pegar, Copiar y Cortar.
		this.vista.getMenu().getCopiar().setIcon(getIcon("./resources/imagenes/copy.png"));
		this.vista.getMenu().getCortar().setIcon(getIcon("./resources/imagenes/cortar.png"));
		this.vista.getMenu().getPegar().setIcon(getIcon("./resources/imagenes/paste.png"));
		this.vista.getPanelTexto().getMenuBotonDer().getCopiar().setIcon(getIcon("./resources/imagenes/copy.png"));
		this.vista.getPanelTexto().getMenuBotonDer().getCortar().setIcon(getIcon("./resources/imagenes/cortar.png"));
		this.vista.getPanelTexto().getMenuBotonDer().getPegar().setIcon(getIcon("./resources/imagenes/paste.png"));

		// Iconos de Seleccionar Todo y de Fuente.
		this.vista.getPanelTexto().getMenuBotonDer().getSeleccion()
				.setIcon(getIcon("./resources/imagenes/seleccionarTodo.png"));
		this.vista.getPanelTexto().getMenuBotonDer().getFuente().setIcon(getIcon("./resources/imagenes/font.png"));
		this.vista.getMenu().getSeleccion().setIcon(getIcon("./resources/imagenes/seleccionarTodo.png"));
		this.vista.getMenu().getFuente().setIcon(getIcon("./resources/imagenes/font.png"));

		// Iconos de Imagen y de Cerrar.
		this.vista.getMenu().getSalir().setIcon(getIcon("./resources/imagenes/close.png"));
		this.vista.getMenu().getImagen().setIcon(getIcon("./resources/imagenes/imagen.png"));

		// Iconos de Nuevo Documento y de Exportar a PDF
		this.vista.getMenu().getNuevoDoc().setIcon(getIcon("./resources/imagenes/nuevo.png"));
		this.vista.getMenu().getExportarPDF().setIcon(getIcon("./resources/imagenes/export.png"));
		this.vista.getHerramientas().getNuevoDoc().setIcon(getIcon("./resources/imagenes/nuevo.png"));
		this.vista.getHerramientas().getExportarPDF().setIcon(getIcon("./resources/imagenes/export.png"));
	}

	// Método de la para ajustar los Iconos.
	/**
	 * Método que ajusta una iamgen a tamaño icono.
	 * 
	 * @param ruta
	 *            La drireccion donde se encuentra almacenada la imagen.
	 * @return El icono de la imagen recibida.
	 */
	public static Icon getIcon(String ruta) {
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

}
