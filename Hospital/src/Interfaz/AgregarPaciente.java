package Interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AgregarPaciente extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgregarPaciente frame = new AgregarPaciente();
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
	public AgregarPaciente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 785, 512);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton volverAPrincipal = new JButton("volver");
		volverAPrincipal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		volverAPrincipal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent volverAPrincipal) {
				Principal frame1 = new Principal();
				frame1.setVisible(true);
				dispose();
			}
		});
		volverAPrincipal.setBounds(282, 354, 166, 32);
		contentPane.add(volverAPrincipal);
		
		JTextArea nombrePaciente = new JTextArea();
		nombrePaciente.setBounds(282, 45, 166, 22);
		contentPane.add(nombrePaciente);
		
		JLabel ingreseNombre = new JLabel("Ingrese nombre del paciente:");
		ingreseNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		ingreseNombre.setBounds(282, 10, 170, 32);
		contentPane.add(ingreseNombre);
		
		JLabel ingreseRut = new JLabel("Ingrese RUT del paciente:");
		ingreseRut.setFont(new Font("Tahoma", Font.PLAIN, 12));
		ingreseRut.setBounds(282, 77, 170, 32);
		contentPane.add(ingreseRut);
		
		JTextArea rutPaciente = new JTextArea();
		rutPaciente.setBounds(282, 102, 166, 22);
		contentPane.add(rutPaciente);
		
		JLabel ingreseEdad = new JLabel("Ingrese edad del paciente:");
		ingreseEdad.setFont(new Font("Tahoma", Font.PLAIN, 12));
		ingreseEdad.setBounds(282, 134, 166, 32);
		contentPane.add(ingreseEdad);
		
		JTextArea edadPaciente = new JTextArea();
		edadPaciente.setBounds(282, 162, 166, 22);
		contentPane.add(edadPaciente);
		
		JLabel ingreseGravedad = new JLabel("Ingrese gravedad del paciente:");
		ingreseGravedad.setFont(new Font("Tahoma", Font.PLAIN, 12));
		ingreseGravedad.setBounds(282, 194, 204, 32);
		contentPane.add(ingreseGravedad);
		
		JTextArea gravedadPaciente = new JTextArea();
		gravedadPaciente.setBounds(282, 223, 166, 22);
		contentPane.add(gravedadPaciente);
		
		JLabel ingresePatologia = new JLabel("Ingrese patología del paciente:");
		ingresePatologia.setFont(new Font("Tahoma", Font.PLAIN, 12));
		ingresePatologia.setBounds(282, 258, 166, 32);
		contentPane.add(ingresePatologia);
		
		JTextArea patologiaPaciente = new JTextArea();
		patologiaPaciente.setBounds(282, 287, 166, 22);
		contentPane.add(patologiaPaciente);
	}
}
