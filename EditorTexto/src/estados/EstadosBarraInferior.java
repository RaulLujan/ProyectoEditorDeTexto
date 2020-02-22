package estados;

import java.util.StringTokenizer;
import javax.swing.text.AttributeSet;
import componentes.BarraInferior;
import vista.Vista;

// Esta clase es un hilo, que durante toda la ejecución del Editor de Texto, va comprobando
// los diferentes estilos o atributos del texto, dando información de los diferentes estados  
// de los componentes del Editor para que este sea compresible y que tenga coherencia.
/**
 * Un EstadosBarraInferior es un proceso que comprueba los estilos del texto dando
 * información de los estados del Editor.
 */
public class EstadosBarraInferior implements Runnable {

	// Componentes de EstadosBarraInferior.
	private Vista vista;
	private AttributeSet atributos;
	private BarraInferior barra;

	// Atributos especiales para la información de la Barra Inferior.
	private String palabras;
	private String fuente;
	private String idioma;

	/**
	 * Constructor que inicializa el EstadosBarraInferior se construye tomando
	 * Vista y BarraInferior siendo vista el JFrame principal y BarraInferior
	 * donde se mostrara la información obtenida.
	 * 
	 * @param vista
	 *            representa al JFrame.
	 * @param barra
	 *            representa a BarraInferior.
	 */
	public EstadosBarraInferior(Vista vista, BarraInferior barra) {
		this.vista = vista;
		this.barra = barra;
		this.palabras = "";
		this.fuente = "";
		this.idioma = "";
	}

	// Método que pone en ejecución al Hilo.
	/**
	 * Método que pone a funcionar a EstadosBarraInferior. En el cual se generan
	 * las diferentes frases con la información obtenida.
	 */
	@Override
	public void run() {
		while (true) {
			try {
				// Contar Palabras y Caracteres, dependiendo de si el texto este
				// seleccionado o no.
				if (this.vista.getPanelTexto().getSelectedText() != null) {
					contarPalabras(this.vista.getPanelTexto().getSelectedText());
					this.palabras = String.format("%s: %s", vista.getIdioma().getSeleccion(), palabras);
				} else {
					this.palabras = "";
					contarPalabras(this.vista.getPanelTexto().getText());
				}

				// Obtengo los atributos del texto para saber la fuetne y el
				// tamaño de este.
				atributos = this.vista.getPanelTexto().getStyledDocument().getCharacterElement(obtenerPosicion() - 1)
						.getAttributes();
				this.fuente = String.format("%s: %s                    | %s: %s", vista.getIdioma().getFuente(),
						this.vista.getPanelTexto().getStyledDocument().getFont(atributos).getFamily(),
						vista.getIdioma().getTam(),
						this.vista.getPanelTexto().getStyledDocument().getFont(atributos).getSize());

				// Obtengo la información del Idioma.
				this.idioma = String.format("%s: %s", vista.getIdioma().getLenguaje(), vista.getIdioma().getElIdioma());

			} catch (Exception e) {
			}
			// Escribo la información obtenida en la BarraInferior.
			this.barra.setText(
					String.format("%s                    | %s                    | %s ", palabras, fuente, idioma));
		}
	}

	// Método que cuenta las palabras y los caracteres.
	/**
	 * Método que cuenta las palabras y los caracteres.
	 * 
	 * @param texto
	 *            representa al texto donde tiene que contar.
	 */
	private void contarPalabras(String texto) {
		StringTokenizer stringTokenizer = new StringTokenizer(texto);
		this.palabras = String.format("%s %s, %s %s", stringTokenizer.countTokens(), vista.getIdioma().getPalabra(),
				texto.length(), vista.getIdioma().getCaracter());

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

	// Getters y Setters.
	public Vista getVista() {
		return vista;
	}

	public void setVista(Vista vista) {
		this.vista = vista;
	}

	public AttributeSet getAtributos() {
		return atributos;
	}

	public void setAtributos(AttributeSet atributos) {
		this.atributos = atributos;
	}

	public BarraInferior getBarra() {
		return barra;
	}

	public void setBarra(BarraInferior barra) {
		this.barra = barra;
	}

	public String getPalabras() {
		return palabras;
	}

	public void setPalabras(String palabras) {
		this.palabras = palabras;
	}

	public String getFuente() {
		return fuente;
	}

	public void setFuente(String fuente) {
		this.fuente = fuente;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

}
