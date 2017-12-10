import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

public class Inicial extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicial frame = new Inicial();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Inicial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(280,20, 651, 504);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(Color.orange);
		contentPane.setLayout(null);
		this.setTitle("Sudoku");
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		panel.setBounds(24, 11, 586, 250);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JTextPane txtpnElSudokuEs = new JTextPane();
		txtpnElSudokuEs.setForeground(Color.BLACK);
		txtpnElSudokuEs.setEditable(false);
		txtpnElSudokuEs.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtpnElSudokuEs.setText("\tEl Sudoku es un pasatiempo que se populariz\u00F3 en Jap\u00F3n en 1986, y se dio a conocer en el ambito internacional en 2005. El objetivo del sudoku es rellenar una cuadr\u00EDcula de 9 \u00D7 9 celdas (81 casillas) dividida en subcuadr\u00EDulas de 3\u00D73 (tambi\u00E9n llamadas \u201Ccajas\u201D o \u201Cregiones\u201D) con las cifras del 1 al 9 partiendo de algunos n\u00FAmeros ya dispuestos en algunas de las celdas. La  \u00FAnica restricci\u00F3n es que no debe repetirse ninguna cifra en una misma fila, columna o subcuadr\u00EDcula. \r\n\tEn este caso, se cuenta con tres configuraciones predefinidas de tres niveles y con la opci\u00F3n de comenzar con un tablero vacio e ir cargarle la configuraci\u00F3n que deseemos.");
		txtpnElSudokuEs.setBounds(10, 11, 566, 233);
		txtpnElSudokuEs.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5,Color.BLACK));
		panel.add(txtpnElSudokuEs);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setMargin(new Insets(0, 0, 0, 0));
		btnNewButton.setHideActionText(true);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setDefaultCapable(false);
		btnNewButton.setBackground(Color.ORANGE);
		btnNewButton.setIcon(new ImageIcon(Inicial.class.getResource("/Imagenes/btn_jugar2.png")));
		btnNewButton.setBounds(217, 391, 190, 65);
		btnNewButton.setPressedIcon(new ImageIcon(Inicial.class.getResource("/Imagenes/btn_jugarpush.png")));
		contentPane.add(btnNewButton);
		btnNewButton.setOpaque(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorderPainted(false);
		
		JTextPane txtpnImportanteLuegoDe = new JTextPane();
		txtpnImportanteLuegoDe.setBorder(new MatteBorder(5, 5, 5, 5, (Color) Color.RED));
		txtpnImportanteLuegoDe.setEditable(false);
		txtpnImportanteLuegoDe.setFont(new Font("SansSerif", Font.ITALIC, 15));
		txtpnImportanteLuegoDe.setForeground(Color.BLACK);
		txtpnImportanteLuegoDe.setText("IMPORTANTE: Luego de insertar un valor en una casilla, se deber\u00E1 presionar la tecla ENTER para efectuar la jugada y verificar que el n\u00FAmero ingresado sea v\u00E1lido. Caso contrario, el movimiento no ser\u00E1 registrado y el sistema presentar\u00E1 fallas. Si el n\u00FAmero es de color azul, fue ingresado correctamente.\r\n\r\n");
		txtpnImportanteLuegoDe.setBounds(30, 286, 569, 94);
		contentPane.add(txtpnImportanteLuegoDe);
		
		btnNewButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new Otra().setVisible(true);
				setVisible(false);
			}
			
		});
		
	}
}
