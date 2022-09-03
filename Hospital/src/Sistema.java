import java.io.*;
import java.util.*;

public class Sistema 
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		// ArrayList que contiene las piezas
		ArrayList<Pieza> rooms = new ArrayList<Pieza>(10);
		initializeArray(rooms);
		
		// Opción ingresada por el usuario
		int opcion;
		
		// Clase menu para utilizar sus metodos.
		Menu menu = new Menu();
		
		// While que se termina con la opción 0.
		while (true)
		{
			menu.showMenu();
			opcion = Integer.parseInt(reader.readLine());
			
			switch (opcion)
			{
				case 1:
				{
					Paciente patient = new Paciente();
					patient.setPatientData();
					patient.setRut();
					
					System.out.println("Ingrese la pieza en donde se quedará el paciente (1-10)");
					int roomNumber = menu.verifyNumber(1, 10);
					
					// Se disminuye para trabajar correctamente con los indices
					roomNumber = roomNumber - 1;
					
					Pieza tmpRoom;
					tmpRoom = rooms.get(roomNumber);
					      
			        // Se revisa que la pieza no este llena.
					if (tmpRoom.getTotalPatients() == 5)
					{	
						System.out.println("La pieza esta llena, por favor seleccione otra.");
						break;
					}
					else
					{
						tmpRoom.addPatient(patient, patient.getRut());
					}
					break;
				}
				
				case 2:
				{
					System.out.println("Ingrese el rut del paciente a eliminar:");
					String rut = reader.readLine();
					Pieza tmpRoom;
					for (int i = 0 ; i < 10 ; i++)
					{
						tmpRoom = rooms.get(i);
						if (tmpRoom.search(rut) == true)
						{
							tmpRoom.deletePatient(rut);
						}
					}
					break;
				}
				
				case 3:
				{
					Pieza tmpRoom;
					// Se recorren todas las piezas.
					for (int i = 0 ; i < 10 ; i ++)
					{
						tmpRoom = rooms.get(i);
						tmpRoom.showPatients();
					}
					break;
				}
				
				
				case 4:
				{
					seekPatient(rooms);
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
	
	// Se instancia cada pieza del arrayList
	public static void initializeArray(ArrayList<Pieza> rooms) throws IOException
	{
		CSV file = new CSV("patients");
		String line = file.firstLine();
		// Se inicializan las piezas.
		for (int i = 0 ; i < 10 ; i++)
		{
			Paciente tmpPacient = new Paciente();
			Pieza tmpRoom = new Pieza(i+1);
			rooms.add(i, tmpRoom);
			tmpPacient.readPatientData(line, file);
			tmpRoom.addPatient(tmpPacient, tmpPacient.getRut());
			line = file.nextLine();
		}
	}
	
	
	public static void seekPatient(ArrayList<Pieza> rooms) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		 
		System.out.println("Ingrese el rut del paciente");
		String rut = reader.readLine();
		Pieza tmp;
		
		// Se recorren las piezas
		for(int i = 0 ; i < 10 ; i++)
		{
			// Se obtiene la pieza en la posición i-ésima.
			tmp = rooms.get(i);
			
			// Se busca el paciente en la pieza y si existe se termina el ciclo.
			if (tmp.search(rut) == true) 
			{
				return;
			}		
		}
		
		System.out.println("El paciente no fue encontrado");
	}
	
}
