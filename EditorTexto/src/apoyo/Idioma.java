package apoyo;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;
import javax.swing.JOptionPane;
import vista.Vista;

//Clase que establece los texto y la informacion de los componentes dependiendo del idioma seleccioando.
/**
 * Un Idioma es un proceso en el que se establecen los texto y la informacion de
 * los compoenentes en el correspondiente idioma. Se prodra elegir entre
 * Español, Ingles, Frances, Aleman e Italiano.
 */
public class Idioma extends Properties {

	// Componentes de Idioma.
	private static final long serialVersionUID = 1L;
	private Vista vista;
	private Locale local;

	// Componentes especiales de ventanas emergentes.
	private String idioma;
	private String palabra, caracter, fuente, tam, lenguaje, elIdioma, seleccion;
	private String aceptar, guardar, salir, cancelar, preguntaGuargar, preguntaSalir;
	private String selectColor, todosLosArchivos;
	private String acercaDe, info;

	/**
	 * Constructor que inicializa Idioma tomando el JFrame principal que
	 * representa la vista del editor de Texto. Ademas este contructor se
	 * inicializa con el idima por defecto del ordenador.
	 * 
	 * @param vista
	 *            representa al JFrame.
	 */
	public Idioma(Vista vista) {
		this.vista = vista;

		// Cogemos el idioma por defecto del ordenador.
		this.idioma = System.getProperty("user.language");
		// LLamamos al método para cambiar el idioma.
		cambioDeIdioma(idioma);
	}

	// Método que carga la infoamcion del idioma de un fichero.
	/**
	 * Método que carga la informacion del fichero según el idioma.
	 * 
	 * @param idioma
	 *            representa al idioma.
	 */
	private void getProperties(String idioma) {
		try {
			load(new BufferedInputStream(new FileInputStream(new File(idioma))));
		} catch (IOException ex) {

		}
	}

	// Método que escoge el fichero correspindiente dependiendo del idioma.
	/**
	 * Método que dependiendo del idioma hace cargar las propiedades de un
	 * idioma o de otro.
	 * 
	 * @param idioma
	 *            representa al idioma.
	 */
	private void seleccionarIdioma(String idioma) {
		this.idioma = idioma;
		switch (idioma) {
		case "es":
			getProperties("./resources/idiomas/Language_es.properties");
			this.elIdioma = getProperty("espanol");
			break;
		case "en":
			getProperties("./resources/idiomas/Language_en.properties");
			this.elIdioma = getProperty("ingles");
			break;
		case "de":
			getProperties("./resources/idiomas/Language_de.properties");
			this.elIdioma = getProperty("aleman");
			break;
		case "fr":
			getProperties("./resources/idiomas/Language_fr.properties");
			this.elIdioma = getProperty("frances");
			break;
		case "it":
			getProperties("./resources/idiomas/Language_it.properties");
			this.elIdioma = getProperty("italiano");
			break;
		default:
			getProperties("./resources/idiomas/Language_es.properties");
		}
	}

	// Método pasa la infoacion del fichero a los componentes del editor para
	// aplicar el idioma.
	/**
	 * Método obtiene las propiedades del idioma seleccionado y las aplica a los
	 * diferente componente del Editor de Texto.
	 * 
	 * @param idioma
	 *            representa al idioma.
	 */
	public void cambioDeIdioma(String idioma) {
		seleccionarIdioma(idioma);
		this.local = new Locale(idioma);
		JOptionPane.setDefaultLocale(local);
		vista.setTitle(getProperty("titulo"));

		// Menus
		vista.getMenu().getMenuArchivo().setText(getProperty("menuArchivo"));
		vista.getMenu().getMenuEditar().setText(getProperty("menuEditar"));
		vista.getMenu().getMenuInsertar().setText(getProperty("menuInsertar"));
		vista.getMenu().getMenuFormato().setText(getProperty("menuFormato"));
		vista.getMenu().getMenuAjustes().setText(getProperty("menuAjustes"));
		vista.getMenu().getMenuAyuda().setText(getProperty("menuAyuda"));

		// Menu Archivo
		vista.getMenu().getNuevoDoc().setText(getProperty("nuevoDoc"));
		vista.getMenu().getExportarPDF().setText(getProperty("exporarPDF"));
		vista.getMenu().getAbrir().setText(getProperty("abrir"));
		vista.getMenu().getGuardar().setText(getProperty("guardar"));
		vista.getMenu().getSalir().setText(getProperty("salir"));

		// Menu Edicion
		vista.getMenu().getCopiar().setText(getProperty("copiar"));
		vista.getMenu().getCortar().setText(getProperty("cortar"));
		vista.getMenu().getPegar().setText(getProperty("pegar"));
		vista.getMenu().getFuente().setText(getProperty("fuente"));
		vista.getMenu().getSeleccion().setText(getProperty("seleccion"));

		// Menu Insertar
		vista.getMenu().getImagen().setText(getProperty("imagen"));

		// Menu Formato
		vista.getMenu().getMenuTexto().setText(getProperty("menuTexto"));
		vista.getMenu().getNegrita().setText(getProperty("negrita"));
		vista.getMenu().getCursiva().setText(getProperty("cursiva"));
		vista.getMenu().getSubrayar().setText(getProperty("subrayado"));
		vista.getMenu().getAlinear().setText(getProperty("menuAlinear"));
		vista.getMenu().getJusIzq().setText(getProperty("izq"));
		vista.getMenu().getJusCent().setText(getProperty("cent"));
		vista.getMenu().getJusDer().setText(getProperty("der"));
		vista.getMenu().getJustificado().setText(getProperty("just"));
		vista.getMenu().getColor().setText(getProperty("color"));

		// Menu Ajustes
		vista.getMenu().getMenuEstilos().setText(getProperty("estilo"));
		vista.getMenu().getIdioma().setText(getProperty("menuIdioma"));
		vista.getMenu().getEspanol().setText(getProperty("espanol"));
		vista.getMenu().getIngles().setText(getProperty("ingles"));
		vista.getMenu().getFrances().setText(getProperty("frances"));
		vista.getMenu().getAleman().setText(getProperty("aleman"));
		vista.getMenu().getItaliano().setText(getProperty("italiano"));

		// Menu Ayuda
		vista.getMenu().getAcercaDe().setText(getProperty("acercaDe"));

		// Menu Herramientas
		vista.getHerramientas().getNuevoDoc().setToolTipText(getProperty("nuevoDoc"));
		vista.getHerramientas().getExportarPDF().setToolTipText(getProperty("exporarPDF"));
		vista.getHerramientas().getAbrir().setToolTipText(getProperty("abrir"));
		vista.getHerramientas().getGuardar().setToolTipText(getProperty("guardar"));
		vista.getHerramientas().getFamilia().setToolTipText(getProperty("fuente"));
		vista.getHerramientas().getFuente().setText(getProperty("fuente"));
		vista.getHerramientas().getTamanyo().setToolTipText(getProperty("tamanyo"));
		vista.getHerramientas().getTam().setText(getProperty("tamanyo"));
		vista.getHerramientas().getNegrita().setToolTipText(getProperty("negrita"));
		vista.getHerramientas().getCursiva().setToolTipText(getProperty("cursiva"));
		vista.getHerramientas().getSubrayado().setToolTipText(getProperty("subrayado"));
		vista.getHerramientas().getGuardar().setToolTipText(getProperty("guardar"));
		vista.getHerramientas().getJusIzq().setToolTipText(getProperty("izq"));
		vista.getHerramientas().getJusCent().setToolTipText(getProperty("cent"));
		vista.getHerramientas().getJusDer().setToolTipText(getProperty("der"));
		vista.getHerramientas().getJustificado().setToolTipText(getProperty("just"));
		vista.getHerramientas().getColor().setToolTipText(getProperty("color"));
		vista.getHerramientas().getIdioma().setText(getProperty("menuIdioma"));
		vista.getHerramientas().getIdioma().setToolTipText(getProperty("menuIdioma"));
		vista.getHerramientas().getBuscar().setToolTipText(getProperty("buscar"));
		vista.getHerramientas().getBarraBusqueda().setToolTipText(getProperty("buscar"));
		vista.getHerramientas().getIdiomas().getEspanol().setText(getProperty("espanol"));
		vista.getHerramientas().getIdiomas().getIngles().setText(getProperty("ingles"));
		vista.getHerramientas().getIdiomas().getFrances().setText(getProperty("frances"));
		vista.getHerramientas().getIdiomas().getAleman().setText(getProperty("aleman"));
		vista.getHerramientas().getIdiomas().getItaliano().setText(getProperty("italiano"));

		// Menu Boton Derecho
		vista.getPanelTexto().getMenuBotonDer().getCopiar().setText(getProperty("copiar"));
		vista.getPanelTexto().getMenuBotonDer().getCortar().setText(getProperty("cortar"));
		vista.getPanelTexto().getMenuBotonDer().getPegar().setText(getProperty("pegar"));
		vista.getPanelTexto().getMenuBotonDer().getFuente().setText(getProperty("fuente"));
		vista.getPanelTexto().getMenuBotonDer().getSeleccion().setText(getProperty("seleccion"));
		vista.getPanelTexto().getMenuBotonDer().getTexto().setText(getProperty("menuTexto"));
		vista.getPanelTexto().getMenuBotonDer().getNegrita().setText(getProperty("negrita"));
		vista.getPanelTexto().getMenuBotonDer().getCursiva().setText(getProperty("cursiva"));
		vista.getPanelTexto().getMenuBotonDer().getSubrayar().setText(getProperty("subrayado"));
		vista.getPanelTexto().getMenuBotonDer().getAlinear().setText(getProperty("menuAlinear"));
		vista.getPanelTexto().getMenuBotonDer().getJusIzq().setText(getProperty("izq"));
		vista.getPanelTexto().getMenuBotonDer().getJusCent().setText(getProperty("cent"));
		vista.getPanelTexto().getMenuBotonDer().getJusDer().setText(getProperty("der"));
		vista.getPanelTexto().getMenuBotonDer().getJustificado().setText(getProperty("just"));

		// Barra de Estados
		vista.getBarraInferior().setToolTipText(getProperty("barraEstados"));

		// Parametros especiales de la barra de estaod.
		this.palabra = getProperty("palabras");
		this.caracter = getProperty("caracteres");
		this.fuente = getProperty("fuente");
		this.tam = getProperty("tamanyo");
		this.lenguaje = getProperty("menuIdioma");
		this.seleccion = getProperty("selec");

		// Ventanas emergentes.
		this.aceptar = getProperty("aceptar");
		this.guardar = getProperty("guardar");
		this.salir = getProperty("salir");
		this.cancelar = getProperty("cancelar");
		this.preguntaGuargar = getProperty("preguntaGuardar");
		this.preguntaSalir = getProperty("preguntaCerrar");
		this.selectColor = getProperty("seleccionarColor");
		this.acercaDe = getProperty("acercaDeEditor");
		this.info = getProperty("info");
		this.todosLosArchivos = getProperty("todosLosArchivos");

	}

	// Getters y Setters.

	public String getAceptar() {
		return aceptar;
	}

	public Vista getVista() {
		return vista;
	}

	public void setVista(Vista vista) {
		this.vista = vista;
	}

	public void setAceptar(String aceptar) {
		this.aceptar = aceptar;
	}

	public String getSeleccion() {
		return seleccion;
	}

	public void setSeleccion(String seleccion) {
		this.seleccion = seleccion;
	}

	public Locale getLocal() {
		return local;
	}

	public void setLocal(Locale local) {
		this.local = local;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public String getPalabra() {
		return palabra;
	}

	public void setPalabra(String palabra) {
		this.palabra = palabra;
	}

	public String getCaracter() {
		return caracter;
	}

	public void setCaracter(String caracter) {
		this.caracter = caracter;
	}

	public String getFuente() {
		return fuente;
	}

	public void setFuente(String fuente) {
		this.fuente = fuente;
	}

	public String getTam() {
		return tam;
	}

	public void setTam(String tam) {
		this.tam = tam;
	}

	public String getLenguaje() {
		return lenguaje;
	}

	public void setLenguaje(String lenguaje) {
		this.lenguaje = lenguaje;
	}

	public String getElIdioma() {
		return elIdioma;
	}

	public void setElIdioma(String elIdioma) {
		this.elIdioma = elIdioma;
	}

	public String getGuardar() {
		return guardar;
	}

	public void setGuardar(String guardar) {
		this.guardar = guardar;
	}

	public String getSalir() {
		return salir;
	}

	public void setSalir(String salir) {
		this.salir = salir;
	}

	public String getCancelar() {
		return cancelar;
	}

	public void setCancelar(String cancelar) {
		this.cancelar = cancelar;
	}

	public String getPreguntaGuargar() {
		return preguntaGuargar;
	}

	public void setPreguntaGuargar(String preguntaGuargar) {
		this.preguntaGuargar = preguntaGuargar;
	}

	public String getPreguntaSalir() {
		return preguntaSalir;
	}

	public void setPreguntaSalir(String preguntaSalir) {
		this.preguntaSalir = preguntaSalir;
	}

	public String getSelectColor() {
		return selectColor;
	}

	public void setSelectColor(String selectColor) {
		this.selectColor = selectColor;
	}

	public String getAcercaDe() {
		return acercaDe;
	}

	public void setAcercaDe(String acercaDe) {
		this.acercaDe = acercaDe;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getTodosLosArchivos() {
		return todosLosArchivos;
	}

	public void setTodosLosArchivos(String todosLosArchivos) {
		this.todosLosArchivos = todosLosArchivos;
	}

}