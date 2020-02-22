package eventos;

import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledEditorKit;
import componentes.MenuBotonDer;

// Clase encargada de proporcionar la funcionalidad a los diferentes componentes de MenuBotonDer.
// Apoyando a esta con eventos y metodos.
/**
 * MenuBotonDerListener es una estructura que proporciona las funcionalidades
 * necesarias para MenuBotonDer.
 */
public class MenuBotonDerListener {

	// Componentes de MenuBotonDerListener.
	private MenuBotonDer menu;

	/**
	 * Constructor que inicializar el MenuBotonDerListener se construye tomando
	 * el MenuBotonDer al cual va a proporcinar las funcinaliades de sus
	 * componentes.
	 * 
	 * @param menu
	 *            representa al MenuBotonDer.
	 */
	public MenuBotonDerListener(MenuBotonDer menu) {
		this.menu = menu;
	}

	// Evento de los componentes encargados de los estilos de Negrita, Cursiva y
	// Subrayado.
	// El cual da funcionalidad a esos componentes.
	/**
	 * Evento de los componentes encargados de los estilos de Negrita, Cursiva y
	 * Subrayado.
	 * 
	 * @param e
	 *            representa al Componente JMenuItem que lo llamo.
	 * @return ActionListener evento resultante.
	 */
	public ActionListener estiloLetra(JMenuItem e) {
		if (e.equals(menu.getNegrita())) {
			return new StyledEditorKit.BoldAction();
		} else if (e.equals(menu.getCursiva())) {
			return new StyledEditorKit.ItalicAction();
		} else if (e.equals(menu.getSubrayar())) {
			return new StyledEditorKit.UnderlineAction();
		}
		return null;
	}

	// Evento de los componentes encargados de los estilos Alineacíon.
	// El cual da funcionalidad a esos componentes.
	/**
	 * Evento de los componentes encargados de los estilos de Alineacíon.
	 * 
	 * @param e
	 *            representa al Componente JMenuItem que lo llamo.
	 * @return ActionListener evento resultante.
	 */
	public ActionListener justificarTexto(JMenuItem e) {
		if (e.equals(menu.getJusIzq())) {
			return new StyledEditorKit.AlignmentAction(null, StyleConstants.ALIGN_LEFT);
		} else if (e.equals(menu.getJusCent())) {
			return new StyledEditorKit.AlignmentAction(null, StyleConstants.ALIGN_CENTER);
		} else if (e.equals(menu.getJusDer())) {
			return new StyledEditorKit.AlignmentAction(null, StyleConstants.ALIGN_RIGHT);
		} else if (e.equals(menu.getJustificado())) {
			return new StyledEditorKit.AlignmentAction(null, StyleConstants.ALIGN_JUSTIFIED);
		}
		return new StyledEditorKit.AlignmentAction(null, StyleConstants.ALIGN_LEFT);
	}

	// Esta clase no necesita Getters y Setters.

}
