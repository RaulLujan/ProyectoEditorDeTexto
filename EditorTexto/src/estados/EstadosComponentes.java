package estados;

import java.awt.Font;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.text.AttributeSet;
import javax.swing.text.StyleConstants;
import vista.Vista;

// Esta clase es un hilo, que durante toda la ejecución del Editor de Texto, va comprobando
// los diferentes estilos o atributos del texto,cambiando el estado de los componentes
// del Editor para que este sea compresible y que tenga coherencia.
/**
 * Un EstadosComponentes es un proceso que comprueba los estilos del texto
 * cambiando el estado de los compoentes del Editor de texto.
 */
public class EstadosComponentes implements Runnable {

	// Componentes de EstadosComponentes.
	private AttributeSet atributos;
	private AttributeSet atributosParrafos;
	private Vista vista;

	// Fuentes de cambio de estado.
	public final Font FUENTE_MARCADO;
	public final Font FUENTE_NO_MARCADO;

	/**
	 * Constructor que inicializa el EstadosComponentes se construye tomando
	 * Vista, siendo vista el JFrame principal.
	 * 
	 * @param vista
	 *            representa al JFrame.
	 */
	public EstadosComponentes(Vista vista) {
		this.vista = vista;
		FUENTE_MARCADO = new Font(this.vista.getMenu().getFont().getFontName(), Font.BOLD,
				this.vista.getMenu().getFont().getSize() + 1);
		FUENTE_NO_MARCADO = new Font(this.vista.getMenu().getFont().getFontName(), Font.PLAIN,
				this.vista.getMenu().getFont().getSize());
	}

	// Método que pone en ejecución al Hilo.
	/**
	 * Método que pone a funcionar a EstadosComponentes. En el cual se generan
	 * los cambios de estado de los componentes del Editor de Texto.
	 */
	@Override
	public void run() {
		while (true) {
			if (this.vista.getPanelTexto().getText() != "") {
				obtenerAtributos();
			}
			try {
				Thread.sleep(100);
			} catch (Exception e) {
			}
		}
	}

	// Método que obtiene la posicion donde empieza el texto selecionado o del
	// cursor.
	/**
	 * Método que obtiene la posicion donde empieza el texto selecionado o del
	 * cursor.
	 */
	public int obtenerPosicion() {
		if (this.vista.getPanelTexto().getSelectedText() != null) {
			return this.vista.getPanelTexto().getSelectionStart();
		} else {
			return this.vista.getPanelTexto().getCaretPosition();
		}
	}

	// Método que obtiene los atributo de donde empieza el texto selecionado o
	// del
	// cursor.
	/**
	 * Método que obtiene los atributo de donde empieza el texto selecionado o
	 * del cursor.
	 */
	public void obtenerAtributos() {

		// Atributos de caracter.
		atributos = this.vista.getPanelTexto().getStyledDocument().getCharacterElement(obtenerPosicion())
				.getAttributes();

		// Atributos de Párrafo.
		atributosParrafos = this.vista.getPanelTexto().getStyledDocument().getParagraphElement(obtenerPosicion())
				.getAttributes();

		// Negrita.
		if (StyleConstants.isBold(atributos)) {
			ponerNegrita(true);
		} else {
			ponerNegrita(false);
		}

		// Cursiva.
		if (StyleConstants.isItalic(atributos)) {
			ponerCursiva(true);
		} else {
			ponerCursiva(false);
		}

		// Subrayado.
		if (StyleConstants.isUnderline(atributos)) {
			ponerSubrayado(true);
		} else {
			ponerSubrayado(false);
		}

		// Alineación.
		if (atributosParrafos.containsAttribute(StyleConstants.Alignment, StyleConstants.ALIGN_LEFT)) {
			ponerAlineacionIzq(true);
		} else {
			ponerAlineacionIzq(false);
		}

		if (atributosParrafos.containsAttribute(StyleConstants.Alignment, StyleConstants.ALIGN_CENTER)) {
			ponerAlineacionCent(true);
		} else {
			ponerAlineacionCent(false);
		}

		if (atributosParrafos.containsAttribute(StyleConstants.Alignment, StyleConstants.ALIGN_RIGHT)) {
			ponerAlineacionDer(true);
		} else {
			ponerAlineacionDer(false);
		}

		if (atributosParrafos.containsAttribute(StyleConstants.Alignment, StyleConstants.ALIGN_JUSTIFIED)) {
			ponerAlineacionJust(true);
		} else {
			ponerAlineacionJust(false);
		}

		// Idioma.
		if (this.vista.getIdioma().getIdioma().equals("es")) {
			ponerEspanol(true);
		} else {
			ponerEspanol(false);
		}

		if (this.vista.getIdioma().getIdioma().equals("en")) {
			ponerIngles(true);
		} else {
			ponerIngles(false);
		}

		if (this.vista.getIdioma().getIdioma().equals("fr")) {
			ponerFrances(true);
		} else {
			ponerFrances(false);
		}

		if (this.vista.getIdioma().getIdioma().equals("de")) {
			ponerAleman(true);
		} else {
			ponerAleman(false);
		}

		if (this.vista.getIdioma().getIdioma().equals("it")) {
			ponerItaliano(true);
		} else {
			ponerItaliano(false);
		}

	}

	// Método que cambia el estado de los componentes de Negrita.
	/**
	 * Método que cambia el estado de los componentes de Negrita.
	 * 
	 * @param marcado
	 *            que represnta si esta marcado o no.
	 */
	public void ponerNegrita(boolean marcado) {
		if (marcado) {
			this.vista.getMenu().getNegrita().setFont(FUENTE_MARCADO);
			this.vista.getPanelTexto().getMenuBotonDer().getNegrita().setFont(FUENTE_MARCADO);
		} else {
			this.vista.getMenu().getNegrita().setFont(FUENTE_NO_MARCADO);
			this.vista.getPanelTexto().getMenuBotonDer().getNegrita().setFont(FUENTE_NO_MARCADO);
		}
		this.vista.getHerramientas().getNegrita().setSelected(marcado);
	}

	// Método que cambia el estado de los componentes de Cursiva.
	/**
	 * Método que cambia el estado de los componentes de Cursiva.
	 * 
	 * @param marcado
	 *            que represnta si esta marcado o no.
	 */
	public void ponerCursiva(boolean marcado) {
		if (marcado) {
			this.vista.getMenu().getCursiva().setFont(FUENTE_MARCADO);
			this.vista.getPanelTexto().getMenuBotonDer().getCursiva().setFont(FUENTE_MARCADO);
		} else {
			this.vista.getMenu().getCursiva().setFont(FUENTE_NO_MARCADO);
			this.vista.getPanelTexto().getMenuBotonDer().getCursiva().setFont(FUENTE_NO_MARCADO);
		}
		this.vista.getHerramientas().getCursiva().setSelected(marcado);
	}

	// Método que cambia el estado de los componentes de Cursiva.
	/**
	 * Método que cambia el estado de los componentes de Cursiva.
	 * 
	 * @param marcado
	 *            que represnta si esta marcado o no.
	 */
	public void ponerSubrayado(boolean marcado) {
		if (marcado) {
			this.vista.getMenu().getSubrayado().setFont(FUENTE_MARCADO);
			this.vista.getPanelTexto().getMenuBotonDer().getSubrayar().setFont(FUENTE_MARCADO);
		} else {
			this.vista.getMenu().getSubrayado().setFont(FUENTE_NO_MARCADO);
			this.vista.getPanelTexto().getMenuBotonDer().getSubrayar().setFont(FUENTE_NO_MARCADO);
		}
		this.vista.getHerramientas().getSubrayado().setSelected(marcado);
	}

	// Método que cambia el estado de los componentes de Alineación Izquierda.
	/**
	 * Método que cambia el estado de los componentes de Alineación Izquierda.
	 * 
	 * @param marcado
	 *            que represnta si esta marcado o no.
	 */
	public void ponerAlineacionIzq(boolean marcado) {
		if (marcado) {
			this.vista.getMenu().getJusIzq().setFont(FUENTE_MARCADO);
			this.vista.getPanelTexto().getMenuBotonDer().getJusIzq().setFont(FUENTE_MARCADO);
		} else {
			this.vista.getMenu().getJusIzq().setFont(FUENTE_NO_MARCADO);
			this.vista.getPanelTexto().getMenuBotonDer().getJusIzq().setFont(FUENTE_NO_MARCADO);
		}
		this.vista.getHerramientas().getJusIzq().setSelected(marcado);
	}

	// Método que cambia el estado de los componentes de Alineación Centro.
	/**
	 * Método que cambia el estado de los componentes de Alineación Centro.
	 * 
	 * @param marcado
	 *            que represnta si esta marcado o no.
	 */
	public void ponerAlineacionCent(boolean marcado) {
		if (marcado) {
			this.vista.getMenu().getJusCent().setFont(FUENTE_MARCADO);
			this.vista.getPanelTexto().getMenuBotonDer().getJusCent().setFont(FUENTE_MARCADO);
		} else {
			this.vista.getMenu().getJusCent().setFont(FUENTE_NO_MARCADO);
			this.vista.getPanelTexto().getMenuBotonDer().getJusCent().setFont(FUENTE_NO_MARCADO);
		}
		this.vista.getHerramientas().getJusCent().setSelected(marcado);
	}

	// Método que cambia el estado de los componentes de Alineación Derecha.
	/**
	 * Método que cambia el estado de los componentes de Alineación Derecha.
	 * 
	 * @param marcado
	 *            que represnta si esta marcado o no.
	 */
	public void ponerAlineacionDer(boolean marcado) {
		if (marcado) {
			this.vista.getMenu().getJusDer().setFont(FUENTE_MARCADO);
			this.vista.getPanelTexto().getMenuBotonDer().getJusDer().setFont(FUENTE_MARCADO);
		} else {
			this.vista.getMenu().getJusDer().setFont(FUENTE_NO_MARCADO);
			this.vista.getPanelTexto().getMenuBotonDer().getJusDer().setFont(FUENTE_NO_MARCADO);
		}
		this.vista.getHerramientas().getJusDer().setSelected(marcado);
	}

	// Método que cambia el estado de los componentes de Alineación Justificado.
	/**
	 * Método que cambia el estado de los componentes de Alineación Justificado.
	 * 
	 * @param marcado
	 *            que represnta si esta marcado o no.
	 */
	public void ponerAlineacionJust(boolean marcado) {
		if (marcado) {
			this.vista.getMenu().getJustificado().setFont(FUENTE_MARCADO);
			this.vista.getPanelTexto().getMenuBotonDer().getJustificado().setFont(FUENTE_MARCADO);
		} else {
			this.vista.getMenu().getJustificado().setFont(FUENTE_NO_MARCADO);
			this.vista.getPanelTexto().getMenuBotonDer().getJustificado().setFont(FUENTE_NO_MARCADO);
		}
		this.vista.getHerramientas().getJustificado().setSelected(marcado);
	}

	// Método que cambia el estado de los componentes de Idioma Español.
	/**
	 * Método que cambia el estado de los componentes de Idioma Español.
	 * 
	 * @param marcado
	 *            que represnta si esta marcado o no.
	 */
	public void ponerEspanol(boolean marcado) {
		if (marcado) {
			this.vista.getMenu().getEspanol().setFont(FUENTE_MARCADO);
			this.vista.getHerramientas().getIdiomas().getEspanol().setFont(FUENTE_MARCADO);
			this.vista.getHerramientas().getIdioma().setIcon(getIcon("./resources/imagenes/spain.png"));
		} else {
			this.vista.getMenu().getEspanol().setFont(FUENTE_NO_MARCADO);
			this.vista.getHerramientas().getIdiomas().getEspanol().setFont(FUENTE_NO_MARCADO);
		}
	}

	// Método que cambia el estado de los componentes de Idioma Ingles.
	/**
	 * Método que cambia el estado de los componentes de Idioma Ingles.
	 * 
	 * @param marcado
	 *            que represnta si esta marcado o no.
	 */
	public void ponerIngles(boolean marcado) {
		if (marcado) {
			this.vista.getMenu().getIngles().setFont(FUENTE_MARCADO);
			this.vista.getHerramientas().getIdiomas().getIngles().setFont(FUENTE_MARCADO);
			this.vista.getHerramientas().getIdioma().setIcon(getIcon("./resources/imagenes/united-kingdom.png"));
		} else {
			this.vista.getMenu().getIngles().setFont(FUENTE_NO_MARCADO);
			this.vista.getHerramientas().getIdiomas().getIngles().setFont(FUENTE_NO_MARCADO);
		}
	}

	// Método que cambia el estado de los componentes de Idioma Frances.
	/**
	 * Método que cambia el estado de los componentes de Idioma Frances.
	 * 
	 * @param marcado
	 *            que represnta si esta marcado o no.
	 */
	public void ponerFrances(boolean marcado) {
		if (marcado) {
			this.vista.getMenu().getFrances().setFont(FUENTE_MARCADO);
			this.vista.getHerramientas().getIdiomas().getFrances().setFont(FUENTE_MARCADO);
			this.vista.getHerramientas().getIdioma().setIcon(getIcon("./resources/imagenes/france.png"));
		} else {
			this.vista.getMenu().getFrances().setFont(FUENTE_NO_MARCADO);
			this.vista.getHerramientas().getIdiomas().getFrances().setFont(FUENTE_NO_MARCADO);
		}
	}

	// Método que cambia el estado de los componentes de Idioma Aleman.
	/**
	 * Método que cambia el estado de los componentes de Idioma Aleman.
	 * 
	 * @param marcado
	 *            que represnta si esta marcado o no.
	 */
	public void ponerAleman(boolean marcado) {
		if (marcado) {
			this.vista.getMenu().getAleman().setFont(FUENTE_MARCADO);
			this.vista.getHerramientas().getIdiomas().getAleman().setFont(FUENTE_MARCADO);
			this.vista.getHerramientas().getIdioma().setIcon(getIcon("./resources/imagenes/germany.png"));
		} else {
			this.vista.getMenu().getAleman().setFont(FUENTE_NO_MARCADO);
			this.vista.getHerramientas().getIdiomas().getAleman().setFont(FUENTE_NO_MARCADO);
		}
	}

	// Método que cambia el estado de los componentes de Idioma Italiano.
	/**
	 * Método que cambia el estado de los componentes de Idioma Italiano.
	 * 
	 * @param marcado
	 *            que represnta si esta marcado o no.
	 */
	public void ponerItaliano(boolean marcado) {
		if (marcado) {
			this.vista.getMenu().getItaliano().setFont(FUENTE_MARCADO);
			this.vista.getHerramientas().getIdiomas().getItaliano().setFont(FUENTE_MARCADO);
			this.vista.getHerramientas().getIdioma().setIcon(getIcon("./resources/imagenes/italy.png"));
		} else {
			this.vista.getMenu().getItaliano().setFont(FUENTE_NO_MARCADO);
			this.vista.getHerramientas().getIdiomas().getItaliano().setFont(FUENTE_NO_MARCADO);
		}
	}

	// Método de la para ajustar los Iconos.
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
	public AttributeSet getAtributos() {
		return atributos;
	}

	public void setAtributos(AttributeSet atributos) {
		this.atributos = atributos;
	}

	public AttributeSet getAtributosParrafos() {
		return atributosParrafos;
	}

	public void setAtributosParrafos(AttributeSet atributosParrafos) {
		this.atributosParrafos = atributosParrafos;
	}

	public Vista getVista() {
		return vista;
	}

	public void setVista(Vista vista) {
		this.vista = vista;
	}

}
