package Interfaz;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JMenuBar;

public class aaa extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					aaa frame = new aaa();
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
	public aaa() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 665, 436);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblTitulo = new JLabel("Hospital PUCV");
		lblTitulo.setBackground(new Color(0, 0, 0));
		lblTitulo.setBounds(251, 0, 223, 55);
		lblTitulo.setForeground(Color.BLACK);
		lblTitulo.setFont(new Font("Times New Roman", Font.BOLD, 24));
		contentPane.add(lblTitulo);
		
		JLabel Agregar = new JLabel("1.Agregar paciente:");
		Agregar.setFont(new Font("Times New Roman", Font.BOLD, 18));
		Agregar.setBounds(251, 66, 206, 32);
		contentPane.add(Agregar);
		
		JLabel Eliminar = new JLabel("2.Eliminar paciente:");
		Eliminar.setFont(new Font("Times New Roman", Font.BOLD, 18));
		Eliminar.setBounds(251, 109, 206, 32);
		contentPane.add(Eliminar);
		
		JLabel Mostrar = new JLabel("3.Mostrar pacientes:");
		Mostrar.setFont(new Font("Times New Roman", Font.BOLD, 18));
		Mostrar.setBounds(251, 154, 206, 32);
		contentPane.add(Mostrar);
		
		JLabel Buscar = new JLabel("4.Buscar paciente:");
		Buscar.setFont(new Font("Times New Roman", Font.BOLD, 18));
		Buscar.setBounds(251, 197, 206, 32);
		contentPane.add(Buscar);
		
		JButton opcion = new JButton("Seleccione la opción");
		opcion.setBounds(251, 241, 161, 23);
		contentPane.add(opcion);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(490, 211, 101, 22);
		contentPane.add(menuBar);
		
		JLabel lblFondo = new JLabel("New label");
		lblFondo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblFondo.setBackground(new Color(0, 0, 0));
		lblFondo.setBounds(0, 0, 649, 397);
		lblFondo.setIcon(new ImageIcon("F:\\Descargas\\white.jpg"));
		contentPane.add(lblFondo);
	}
}
