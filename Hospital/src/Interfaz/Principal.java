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
	public Principal() {
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
		agregarPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent eventoIrAgregarPaciente) {
				AgregarPaciente frame2 = new AgregarPaciente();
				frame2.setVisible(true);
				dispose();
			}
		});
		agregarPaciente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		agregarPaciente.setBounds(264, 75, 205, 38);
		contentPane.add(agregarPaciente);
		
		JButton eliminaPaciente = new JButton("Eliminar Paciente");
		eliminaPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent eventoIrEliminarPaciente) {
				EliminarPaciente frame3 = new EliminarPaciente();
				frame3.setVisible(true);
				dispose();
			}
		});
		eliminaPaciente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		eliminaPaciente.setBounds(264, 123, 205, 38);
		contentPane.add(eliminaPaciente);
		
		JButton muestraPacientes = new JButton("Mostrar pacientes del registro");
		muestraPacientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent eventoIrMostrarPacientes) {
				MostrarPacientes frame4 = new MostrarPacientes();
				frame4.setVisible(true);
				dispose();
			}
		});
		muestraPacientes.setFont(new Font("Tahoma", Font.PLAIN, 12));
		muestraPacientes.setBounds(264, 171, 205, 38);
		contentPane.add(muestraPacientes);
		
		JButton buscaPaciente = new JButton("Buscar Paciente");
		buscaPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent eventoIrBuscarPaciente) {
				BuscarPaciente frame5 = new BuscarPaciente();
				frame5.setVisible(true);
				dispose();
			}
		});
		buscaPaciente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		buscaPaciente.setBounds(264, 219, 205, 38);
		contentPane.add(buscaPaciente);
		
		JButton muestraPacientesGravedad = new JButton("Mostrar pacientes por gravedad");
		muestraPacientesGravedad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent eventoIrMostrarPorGravedad) {
				mostrarPorGravedad frame6 = new mostrarPorGravedad();
				frame6.setVisible(true);
				dispose();
			}
		});
		muestraPacientesGravedad.setFont(new Font("Tahoma", Font.PLAIN, 12));
		muestraPacientesGravedad.setBounds(264, 267, 205, 38);
		contentPane.add(muestraPacientesGravedad);
		
		JButton modificaDatosPaciente = new JButton("Modificar datos de un paciente");
		modificaDatosPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent eventoIrModificarDatosPaciente) {
				ModificarDatosPaciente frame7 = new ModificarDatosPaciente();
				frame7.setVisible(true);
				dispose();
			}
		});
		modificaDatosPaciente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		modificaDatosPaciente.setBounds(264, 315, 205, 38);
		contentPane.add(modificaDatosPaciente);
		
		JButton muestraPacientesPatologia = new JButton("Mostrar pacientes por patología");
		muestraPacientesPatologia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent eventoIrmostrarPorPatología) {
				mostrarPorPatología frame8 = new mostrarPorPatología();
				frame8.setVisible(true);
				dispose();
			}
		});
		muestraPacientesPatologia.setFont(new Font("Tahoma", Font.PLAIN, 12));
		muestraPacientesPatologia.setBounds(264, 363, 205, 38);
		contentPane.add(muestraPacientesPatologia);
		
		JButton salirPrograma = new JButton("Salir");
		salirPrograma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		salirPrograma.setFont(new Font("Tahoma", Font.PLAIN, 12));
		salirPrograma.setBounds(264, 411, 205, 38);
		contentPane.add(salirPrograma);
	}
}
