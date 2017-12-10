import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import org.jpl7.JPL;
import org.jpl7.Query;
import org.jpl7.Term;

import com.sun.prism.paint.Color;

import javafx.scene.shape.Line;
import javax.swing.JButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JRadioButton;
import javax.swing.border.MatteBorder;

public class Otra extends JFrame {

	private JPanel contentPane;
	private static JTextField[][] cuadros=new JTextField[10][10];
	private Integer[][] config1,config2,config3;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Otra frame = new Otra();
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
	public Otra() {		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(280,20, 850, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(java.awt.Color.ORANGE);
		this.setTitle("Sudoku");
		
		new Query("consult('Sudoku.pl')").hasSolution();//Cargo programa de prolog.
		
		config1=new Integer[10][10];
		config2=new Integer[10][10];
		config3=new Integer[10][10];
		
		cargarConfiguraciones();
		
		
		JButton btnTerminar = new JButton("Terminar");
		btnTerminar.setBounds(668, 120, 124, 41);
		contentPane.add(btnTerminar);
		
		JButton btnComprobar=new JButton("Comprobar");
		btnComprobar.setBounds(668, 190, 124, 43);
		contentPane.add(btnComprobar);
		
		btnTerminar.setEnabled(false);	
		btnComprobar.setEnabled(false);
		
		JButton btnTerminarCarga = new JButton("Terminar carga");
		btnTerminarCarga.setBounds(668, 450, 124, 23);
		contentPane.add(btnTerminarCarga);
		btnTerminarCarga.setVisible(false);
		
		JLabel l= new JLabel(new ImageIcon(this.getClass().getResource("/Imagenes/linea.png")));
		l.setSize(8,567);
		l.setLocation(247, 64);
		contentPane.add(l);
		
		JLabel l2= new JLabel(new ImageIcon(this.getClass().getResource("/Imagenes/linea.png")));
		l2.setSize(8,567);
		l2.setLocation(439,64);
		contentPane.add(l2);
		
		JLabel l3= new JLabel(new ImageIcon(this.getClass().getResource("/Imagenes/lineaHor.png")));
		l3.setSize(567,8);
		l3.setLocation(64,247);
		contentPane.add(l3);
		
		JLabel l4= new JLabel(new ImageIcon(this.getClass().getResource("/Imagenes/lineaHor.png")));
		l4.setSize(567,8);
		l4.setLocation(64,439);
		contentPane.add(l4);
		
		JRadioButton rdbtnFcil = new JRadioButton("F\u00E1cil");
		rdbtnFcil.setForeground(java.awt.Color.BLACK);
		rdbtnFcil.setBackground(java.awt.Color.ORANGE);
		rdbtnFcil.setBounds(668, 289, 109, 23);
		contentPane.add(rdbtnFcil);
		
		JPanel panel = new JPanel();
		
		rdbtnFcil.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				reiniciar();
				panel.setVisible(false);
				btnTerminar.setEnabled(true);	
				btnComprobar.setEnabled(true);
				btnTerminarCarga.setVisible(false);
				for(int i=1;i<10;i++)
					for(int j=1;j<10;j++)
						if (config1[i][j]!=null){
							cuadros[i][j].setText(config1[i][j].toString());
							cuadros[i][j].setEditable(false);
							new Query("asserta(punto("+i+","+j+","+config1[i][j]+")).").hasSolution();
						}
				btnTerminar.setVisible(true);
				btnComprobar.setVisible(true);
			}
			
		});
		
		
		
		JRadioButton rdbtnMedio = new JRadioButton("Medio");
		rdbtnMedio.setForeground(java.awt.Color.BLACK);
		rdbtnMedio.setBackground(java.awt.Color.ORANGE);
		rdbtnMedio.setBounds(668, 327, 109, 23);
		contentPane.add(rdbtnMedio);
		
		rdbtnMedio.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				reiniciar();
				panel.setVisible(false);
				btnTerminar.setEnabled(true);	
				btnComprobar.setEnabled(true);
				btnTerminarCarga.setVisible(false);
				for(int i=1;i<10;i++)
					for(int j=1;j<10;j++)
						if (config2[i][j]!=null){
							cuadros[i][j].setText(config2[i][j].toString());
							cuadros[i][j].setEditable(false);
							new Query("asserta(punto("+i+","+j+","+config2[i][j]+")).").hasSolution();
						}
				btnTerminar.setVisible(true);	
				btnComprobar.setVisible(true);
			}
			
		});
		
		JRadioButton rdbtnDifcil = new JRadioButton("Dif\u00EDcil");
		rdbtnDifcil.setForeground(java.awt.Color.BLACK);
		rdbtnDifcil.setBackground(java.awt.Color.ORANGE);
		rdbtnDifcil.setBounds(668, 366, 109, 23);
		contentPane.add(rdbtnDifcil);
		
		rdbtnDifcil.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				reiniciar();
				panel.setVisible(false);
				btnTerminar.setEnabled(true);	
				btnComprobar.setEnabled(true);
				btnTerminarCarga.setVisible(false);
				for(int i=1;i<10;i++)
					for(int j=1;j<10;j++)
						if (config3[i][j]!=null){
							cuadros[i][j].setText(config3[i][j].toString());
							cuadros[i][j].setEditable(false);
							new Query("asserta(punto("+i+","+j+","+config3[i][j]+")).").hasSolution();
						}
				btnTerminar.setVisible(true);
				btnComprobar.setVisible(true);
			}
			
		});
		
		JRadioButton rbPropia = new JRadioButton("Configuraci\u00F3n propia");
		rbPropia.setBackground(java.awt.Color.ORANGE);
		rbPropia.setForeground(java.awt.Color.BLACK);
		rbPropia.setBounds(668, 407, 139, 23);
		contentPane.add(rbPropia);
		
		rbPropia.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				reiniciar();
				panel.setVisible(false);
				btnTerminarCarga.setVisible(true);
				for(int i=1;i<10;i++)
					for(int j=1;j<10;j++){
							cuadros[i][j].setText("");
							cuadros[i][j].setEditable(true);
						}
				btnTerminar.setEnabled(false);
				btnComprobar.setEnabled(false);
			}
			
		});
		
		ButtonGroup bg=new ButtonGroup();
		bg.add(rdbtnFcil);
		bg.add(rdbtnMedio);
		bg.add(rdbtnDifcil);
		bg.add(rbPropia);
		
		
		panel.setBorder(new MatteBorder(2, 2, 2, 2, (java.awt.Color) java.awt.Color.RED));
		panel.setBackground(java.awt.Color.ORANGE);
		panel.setBounds(661, 274, 163, 165);
		contentPane.add(panel);
		
		
		
		btnTerminarCarga.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				btnTerminar.setEnabled(true);	
				btnComprobar.setEnabled(true);
				btnTerminarCarga.setVisible(false);
				for (int i=1;i<10;i++)
					for (int j=1;j<10;j++)
						if (!cuadros[i][j].getText().equals("")){
							cuadros[i][j].setEditable(false);
							cuadros[i][j].setForeground(java.awt.Color.GRAY);
							cuadros[i][j].setBackground(java.awt.Color.WHITE);
						}
			}
			
		});
		
		
		
		for(int i=1;i<10;i++)
			for(int j=1;j<10;j++){
					cuadros[i][j]=new JTextField();
					cuadros[i][j].setSize(54,54);
					cuadros[i][j].setLocation(i*64, j*64);
					cuadros[i][j].setHorizontalAlignment(SwingConstants.CENTER);
					cuadros[i][j].setFont(cuadros[i][j].getFont().deriveFont(26f));
					cuadros[i][j].setFont(cuadros[i][j].getFont().deriveFont(Font.BOLD));
					contentPane.add(cuadros[i][j]);
					cuadros[i][j].addActionListener(new OyenteText(i,j));
					cuadros[i][j].setEditable(false);
					
				}
			
		
		
		btnTerminar.addActionListener(new ActionListener(){

			
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Query pto=null;	
				
				boolean sol = new Query("time(solucion())").hasSolution();		
				if (!sol){
					JOptionPane.showMessageDialog(null,"El sudoku es insoluble","Es soluble?",JOptionPane.ERROR_MESSAGE);
					btnTerminar.setEnabled(false);
					btnComprobar.setEnabled(false);
				}
				else{
					for(int i=1;i<10;i++)
						for(int j=1;j<10;j++)
						if (cuadros[i][j].getText().equals("")){
							pto=new Query("punto("+i+","+j+",N)");
							Term t=pto.oneSolution().get("N");
							cuadros[i][j].setText(t.toString());
							cuadros[i][j].setForeground(java.awt.Color.WHITE);
							cuadros[i][j].setBackground(java.awt.Color.BLACK);
							cuadros[i][j].setEditable(false);
							
						}
					btnComprobar.setEnabled(false);
					btnTerminar.setEnabled(false);
					new Query("consult('Sudoku.pl')").hasSolution();
				}
			}
			
		});
		
		btnComprobar.addActionListener(new ActionListener(){

			
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Query pto=null;	
				boolean sol = new Query("time(solucion())").hasSolution();				
				if (sol)
					JOptionPane.showMessageDialog(null,"El sudoku tiene solucion","Es soluble?",JOptionPane.INFORMATION_MESSAGE);
				else
					JOptionPane.showMessageDialog(null,"El sudoku es insoluble","Es soluble?",JOptionPane.ERROR_MESSAGE);
				
				for(int i=1;i<10;i++)
					for(int j=1;j<10;j++)
					if (cuadros[i][j].getText().equals("")){
						pto=new Query("retract(punto("+i+","+j+",N))");
						pto.hasSolution();
					}
				new Query("consult('Sudoku.pl')").hasSolution();
			}
			
		});
		
		
	}

	private void cargarConfiguraciones() {
		config1[3][1]=4;
		config1[4][1]=3;
		config1[9][1]=6;
		config1[1][2]=6;
		config1[4][2]=1;
		config1[6][2]=9;
		config1[1][3]=7;
		config1[8][3]=4;
		config1[9][3]=9;
		config1[3][4]=1;
		config1[5][4]=8;
		config1[6][4]=5;
		config1[7][4]=4;
		config1[8][4]=6;
		config1[3][5]=6;
		config1[4][5]=2;
		config1[5][5]=9;
		config1[6][5]=3;
		config1[7][5]=7;
		config1[2][6]=7;
		config1[3][6]=5;
		config1[4][6]=4;
		config1[5][6]=1;
		config1[7][6]=9;
		config1[1][7]=4;
		config1[2][7]=6;
		config1[9][7]=7;
		config1[4][8]=9;
		config1[6][8]=4;
		config1[9][8]=1;
		config1[1][9]=2;
		config1[7][9]=8;
		config1[6][9]=7;
		
		//Configuracion 2
		config2[2][1]=4;
		config2[4][1]=8;
		config2[8][1]=3;
		config2[2][2]=5;
		config2[3][2]=7;
		config2[6][2]=3;
		config2[6][3]=4;
		config2[8][3]=2;
		config2[9][3]=9;
		config2[2][4]=2;
		config2[6][4]=7;
		config2[7][4]=5;
		config2[1][5]=7;
		config2[4][5]=4;
		config2[5][5]=6;
		config2[1][6]=4;
		config2[6][6]=5;
		config2[7][6]=9;
		config2[8][6]=7;
		config2[9][6]=2;
		config2[2][7]=7;
		config2[6][7]=8;
		config2[7][7]=6;
		config2[9][7]=3;
		config2[4][8]=6;
		config2[5][8]=4;
		config2[9][8]=7;
		config2[4][9]=7;
		config2[6][9]=9;
		config2[8][9]=8;
		config2[9][9]=4;
		
		//Configuracion 3
		config3[1][1]=8;
		config3[3][2]=3;
		config3[4][2]=6;
		config3[2][3]=7;
		config3[5][3]=9;
		config3[7][3]=2;
		config3[2][4]=5;
		config3[6][4]=7;
		config3[5][5]=4;
		config3[6][5]=5;
		config3[7][5]=7;
		config3[4][6]=1;
		config3[8][6]=3;
		config3[3][7]=1;
		config3[8][7]=6;
		config3[9][7]=8;
		config3[3][8]=8;
		config3[4][8]=5;
		config3[8][8]=1;
		config3[2][9]=9;
		config3[7][9]=4;
	}
	
	
	/*
	 * Clase oyente de los JTextField que componen el tablero.
	 */
	class OyenteText implements ActionListener{

		private int x,y;
		
		/*
		 * Constructor de la clase OyenteText.
		 * @param recibe como parametro los indices del textfield correspondiente.
		 */
		public OyenteText(int i,int j){
			x=i;
			y=j;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Integer N=null;
				if (cuadros[x][y].getText().equals("")){
					new Query("retract(punto("+x+","+y+",_))").hasSolution();
					cuadros[x][y].setFocusable(false);
					cuadros[x][y].setFocusable(true);
					cuadros[x][y].setBackground(java.awt.Color.WHITE);	
					cuadros[x][y].setForeground(java.awt.Color.gray);	
					contentPane.requestFocus();
				}
				else{
					try{
						N=Integer.valueOf(Otra.cuadros[x][y].getText());
						Query elim=new Query("retractall(punto("+x+","+y+",_))");
						elim.hasSolution();
						Query ins=new Query("movimiento_valido("+x+","+y+","+N+").");
						if (!ins.hasSolution()){
							JOptionPane.showMessageDialog(null, "El numero ingresado no respeta las reglas del juego","Error",JOptionPane.ERROR_MESSAGE);
							Otra.cuadros[x][y].setText(null);
						}
						else{
							cuadros[x][y].setFocusable(false);
							cuadros[x][y].setFocusable(true);	
							contentPane.requestFocus();
							Otra.cuadros[x][y].setForeground(java.awt.Color.BLUE);
							Otra.cuadros[x][y].setBackground(java.awt.Color.getHSBColor(35, 35, 35));
						}
					}
					catch(NumberFormatException t){
						JOptionPane.showMessageDialog(null, "Ingrese un digito dentro de la casilla","Error",JOptionPane.ERROR_MESSAGE);
						
					}
					
				}
		}
		
		
		
	}
	
	public void reiniciar(){
		for(int i=1;i<10;i++)
			for(int j=1;j<10;j++){
					cuadros[i][j].setText("");
					cuadros[i][j].setEditable(true);
					cuadros[i][j].setForeground(java.awt.Color.GRAY);
					cuadros[i][j].setBackground(java.awt.Color.WHITE);
				}
		Query pto=new Query("retractall(punto(_,_,_))");
		pto.hasSolution();
	}
}
