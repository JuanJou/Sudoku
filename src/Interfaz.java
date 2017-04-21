import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.Canvas;
import javax.swing.JLabel;

public class Interfaz extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz frame = new Interfaz();
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
	public Interfaz() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000,800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnResolver = new JButton("Resolver");
		btnResolver.setBounds(708, 184, 171, 41);
		contentPane.add(btnResolver);
		
		JButton btnComprobar = new JButton("Comprobar");
		btnComprobar.setBounds(708, 271, 171, 41);
		contentPane.add(btnComprobar);
		
		JLabel cuadricula = new JLabel();
		cuadricula.setBounds(128, 136, 432, 432);
		contentPane.add(cuadricula);
		
		cuadricula.setIcon(new ImageIcon(this.getClass().getResource("/Sudoku.gif")));
		
		
	}
}
