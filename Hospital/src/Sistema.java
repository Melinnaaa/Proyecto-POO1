import java.io.*;
import java.util.*;

public class Sistema {

	public static void main(String[] args) throws IOException
	{
		
		// ArrayList que contiene las piezas
		HashMap <String, Pieza> rooms = new HashMap <String, Pieza>(10);
		
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
					menu.showPatients();
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
