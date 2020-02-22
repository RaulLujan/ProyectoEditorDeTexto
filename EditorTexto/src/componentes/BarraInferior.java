package componentes;

import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;
import estados.EstadosBarraInferior;
import vista.Vista;

// Clase que obtiene las propiedades de un JLabel y muestra información sobre el editor de Texto.
/**
 * Una BarraInferior es una barra en la parte inferior del Editor de Texto que
 * muestra inforacion sobre la cantidad de palabras y caracteres, la fuente, el
 * tamaño y el idioma.
 * 
 */
public class BarraInferior extends JLabel {

	// Componentes de BarraInferior.
	private static final long serialVersionUID = 1L;
	private EstadosBarraInferior estado;

	/**
	 * Constructor que inicializa la Barra Inferior se construye tomando el
	 * JFrame principal que representa la vista del editor de Texto. Ademas este
	 * contructor lanza un servicio para obtener en todo momento la información
	 * que tiene que mostrar
	 * 
	 * @param vista
	 *            representa al JFrame.
	 */
	public BarraInferior(Vista vista) {

		// Caractericticas de la barra de estados.
		setSize(vista.getDimension().width, 30);
		setBorder(new EmptyBorder(2, 10, 3, 0));
		estado = new EstadosBarraInferior(vista, this);
		// LLamada al hilo que obtiene la información.
		new Thread(estado).start();
		setFocusable(false);
	}

	// Esta clase no tiene Getters y Setters ya que el único atributo que tiene
	// es el hilo estado que es propio de esta clase.

}
