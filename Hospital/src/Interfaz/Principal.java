package Interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 785, 512);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel tituloBienvenida = new JLabel("¡Bienvenido al Hospital PUCV!");
		tituloBienvenida.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tituloBienvenida.setBounds(225, 21, 278, 44);
		contentPane.add(tituloBienvenida);
		
		JButton agregarPaciente = new JButton("Agregar Paciente");
		agregarPaciente.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent eventoIrAgregarPaciente) 
			{
				AgregarPaciente frame2 = new AgregarPaciente();
				frame2.setVisible(true);
				dispose();
			}
		});
		agregarPaciente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		agregarPaciente.setBounds(272, 75, 166, 32);
		contentPane.add(agregarPaciente);
	}
}
