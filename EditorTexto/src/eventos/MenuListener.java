package eventos;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.text.StyledEditorKit;
import javax.swing.text.rtf.RTFEditorKit;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import componentes.Menu;

// Clase encargada de proporcionar la funcionalidad a los diferentes componentes de Menu.
// Apoyando a esta con eventos y metodos.
/**
 * MenuListener es una estructura que proporciona las funcionalidades necesarias
 * para Menu.
 */
public class MenuListener {

	// Componentes de MenuHerramientasListener.
	private Menu menu;

	/**
	 * Constructor que inicializar el MenuListener se construye tomando el Menu
	 * al cual va a proporcinar las funcinaliades de sus componentes.
	 * 
	 * @param menu
	 *            representa al Menu.
	 */
	public MenuListener(Menu menu) {
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

	// Evento encargado de mostrar una ventana emergente y abrir un documento en
	// nuestro editor.
	/**
	 * Evento encargado de mostrar una ventana emergente y abrir un documento en
	 * nuestro editor.
	 */
	public void metodoAbrir() {
		JFileChooser file = new JFileChooser();
		UIManager.put("FileChooser.acceptAllFileFilterText", menu.getVista().getIdioma().getTodosLosArchivos());
		if (file.showOpenDialog(this.menu) == JFileChooser.APPROVE_OPTION) {
			String fileName = file.getSelectedFile().getAbsolutePath();
			RTFEditorKit rtf = new RTFEditorKit();
			try {
				FileInputStream fi = new FileInputStream(fileName);
				rtf.read(fi, this.menu.getVista().getPanelTexto().getDocument(), 0);
				fi.close();
			} catch (Exception e) {
			}
		}
	}

	// Evento encargado de mostrar una ventana emergente y guardar un documento
	// en nuestro editor.
	/**
	 * Evento encargado de mostrar una ventana emergente y guardar un documento
	 * en nuestro editor.
	 */
	public void metodoGuardar() {
		JFileChooser file = new JFileChooser();
		UIManager.put("FileChooser.acceptAllFileFilterText", menu.getVista().getIdioma().getTodosLosArchivos());
		if (file.showSaveDialog(this.menu) == JFileChooser.APPROVE_OPTION) {
			String fileName = file.getSelectedFile().getAbsolutePath();
			StyledDocument doc = (StyledDocument) this.menu.getVista().getPanelTexto().getDocument();
			RTFEditorKit kit = new RTFEditorKit();
			BufferedOutputStream out;
			try {
				out = new BufferedOutputStream(new FileOutputStream(fileName));
				kit.write(out, doc, doc.getStartPosition().getOffset(), doc.getLength());
				out.flush();
				out.close();
			} catch (Exception e) {
			}
		}
	}

	// Evento encargado de mostrar una ventana emergente y cargar una imagen
	// en nuestro editor.
	/**
	 * Evento encargado de mostrar una ventana emergente y cargar una imagen en
	 * nuestro editor.
	 */
	public void metodoImagen() {
		JFileChooser fileChooser = new JFileChooser();
		UIManager.put("FileChooser.acceptAllFileFilterText", menu.getVista().getIdioma().getTodosLosArchivos());
		int resultado = fileChooser.showOpenDialog(this.menu.getVista());
		if (resultado == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			this.menu.getVista().getPanelTexto().insertIcon(new ImageIcon(file.getAbsolutePath()));
		}
	}

	// Evento encargado de mostrar una ventana emergente con la informacion
	// basica del Editor de Texto.
	/**
	 * Evento encargado de mostrar una ventana emergente con la informacion
	 * basica del Editor de Texto.
	 */
	public void metodoAcercaDe() {
		String[] botones = { menu.getVista().getIdioma().getAceptar() };
		JOptionPane.showOptionDialog(menu.getVista(), menu.getVista().getIdioma().getInfo(),
				menu.getVista().getIdioma().getAcercaDe(), 0, 0, getIcon("./resources/imagenes/info.png"), botones,
				null);
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
		Icon icono = new ImageIcon(new ImageIcon(ruta).getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));
		return icono;
	}

	// Evento de los componentes encargados de los estilos de color de letra.
	// El cual da funcionalidad a esos componentes.
	/**
	 * Evento de los componentes encargados de los estilos de color de letra.
	 * 
	 * @param e
	 *            representa al Componente que lo llamo.
	 */
	public void colores(ActionEvent e) {
		Color color = JColorChooser.showDialog(null, menu.getVista().getIdioma().getSelectColor(), Color.BLACK);
		new StyledEditorKit.ForegroundAction(null, color).actionPerformed(e);

	}

	// Evento encargado de limpiar el panel de texto para generar un nuevo
	// espacio de escritura para un nuevo documento.
	/**
	 * Evento que genera una nueva hoja para el editor de texto.
	 */
	public void metodoNuevoDoc() {
		String[] botones = { menu.getVista().getIdioma().getGuardar(), menu.getVista().getIdioma().getSalir(),
				menu.getVista().getIdioma().getCancelar() };
		int eleccion = JOptionPane.showOptionDialog(menu.getVista(), menu.getVista().getIdioma().getPreguntaGuargar(),
				menu.getVista().getIdioma().getPreguntaSalir(), 0, 0, null, botones, null);

		if (eleccion == 0) {
			metodoGuardar();
			metodoReseterar();
		} else if (eleccion == 1) {
			metodoReseterar();
		}
	}

	// Evento encargado reseterar todos los estilos del editor.
	/**
	 * Evento encargado reseterar todos los estilos del editor.
	 */
	public void metodoReseterar() {
		menu.getVista().getPanelTexto().setText("");

		SimpleAttributeSet atributos = new SimpleAttributeSet();
		StyleConstants.setAlignment(atributos, StyleConstants.ALIGN_LEFT);
		menu.getVista().getHerramientas().getFamilia().setSelectedIndex(5);
		menu.getVista().getHerramientas().getTamanyo().setSelectedIndex(5);
		StyleConstants.setBold(atributos, false);
		StyleConstants.setItalic(atributos, false);
		StyleConstants.setUnderline(atributos, false);
		new StyledEditorKit.ForegroundAction(null, Color.BLACK);

		StyledDocument doc = menu.getVista().getPanelTexto().getStyledDocument();
		doc.setCharacterAttributes(doc.getLength(), 1, atributos, false);
		doc.setParagraphAttributes(doc.getLength(), 1, atributos, false);

	}

	// Evento guardar el contenido del documento a formato PDF.
	/**
	 * Evento guardar el contenido del documento a formato PDF.
	 */
	public void metodoExportarPDF() {
		JFileChooser file = new JFileChooser();
		UIManager.put("FileChooser.acceptAllFileFilterText", "PDF");
		int op = file.showSaveDialog(menu.getVista());
		if (op == JFileChooser.APPROVE_OPTION) {
			try {
				OutputStream archivo = new FileOutputStream(file.getSelectedFile() + ".pdf");
				Document doc = new Document();
				PdfWriter.getInstance(doc, archivo);
				doc.open();
				doc.add(new Paragraph(menu.getVista().getPanelTexto().getText()));
				doc.close();
				archivo.close();
			} catch (Exception e) {
			}
		}
	}

	// Esta clase no necesita Getters y Setters.
}
