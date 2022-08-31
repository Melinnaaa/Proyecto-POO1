import java.io.*;
import java.util.*;

public class Sistema {

	public static void main(String[] args) throws IOException
	{
		// Tabla hash que guarda un paciente a partir del nombre.
		Hashtable <String, Paciente> patientName = new Hashtable<String, Paciente>(10);
		
		// Tabla hash que guarda un paciente a partir del rut.
		Hashtable <String, Paciente> patientRut = new Hashtable<String, Paciente>(10);
		
		// ArrayList que guarda a todos los pacientes (Utilizado para mostrarlos a todos)
		ArrayList <Paciente> patients = new ArrayList<Paciente>(10);
		
		// ArrayList que contiene las piezas
		Hashtable <String, Pieza> rooms = new Hashtable <String, Pieza>(10);
		
		// Opción ingresada por el usuario
		int opcion;
		
		// Clase menu para utilizar sus metodos.
		Menu menu = new Menu();
		
		while (true)
		{
			menu.showMenu();
			opcion = menu.toInt();
			
			switch (opcion)
			{
				case 1:
				{
					menu.createPatient(patientName, patientRut);
					break;
				}
				
				case 2:
				{
					menu.deletePatient(patientName, patientRut);
					break;
				}
				
				case 3:
				{
					break;
				}
				
				case 4:
				{
					menu.search(patientName, patientRut);
					break;
				}
				
				case 0:
				{
					return;
				}
				
				default:
				{
					System.out.println("Ingrese una opcion valida");
					break;
				}
			}
		}
	}

}
