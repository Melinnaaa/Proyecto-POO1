package hospital;
import java.io.*;
import java.util.*;

import exceptions.AgeException;
import exceptions.GravityException;
import exceptions.RutException;
import import_export.CSV;
import import_export.ImportExport;
import util.Impresora;
import util.Lector;
import util.Menu;
import pacientes.Doctor;
import pacientes.Paciente;


public class Seccion 
{
	// ArrayList que contiene las piezas
	private ArrayList<Pieza> rooms = new ArrayList<Pieza>(10);
	
	public Seccion () throws IOException
	{
		importCsv();
	}
		
	// Recorre el arrayList de piezas y para encontrar al paciente a partir del rut
	public boolean seekPatient(String rut, Impresora print) throws IOException
	{
		Pieza tmpRoom;
		Paciente patient;
		// Se recorren las piezas
		for (int i = 0 ; i < 10 ; i++)
		{
			// Se obtiene la pieza en la posición i-ésima.
			tmpRoom = rooms.get(i);
			
			// Se asigna el paciente
			patient = tmpRoom.search(rut);
			
			// Se busca el paciente en la pieza y si existe se termina el ciclo.
			if (patient != null) 
			{
				print.showRoomNumber(tmpRoom);
				patient.showData(print);
				return true;
			}		
		}
		// De no ser encontrado en ninguna pieza se muestra mensaje.
		return false;
	}
        
        /* Sobrecarga
        *Recorre el arrayList de piezas y para encontrar al paciente a partir
        * del rut y lo retorna si lo encuentra, utilizado para la interfaz.
        */
	public Paciente seekPatient(String rut) throws IOException
	{
		Pieza tmpRoom;
		Paciente patient;
		// Se recorren las piezas
		for (int i = 0 ; i < 10 ; i++)
		{
			// Se obtiene la pieza en la posición i-ésima.
			tmpRoom = rooms.get(i);
			
			// Se asigna el paciente
			patient = tmpRoom.search(rut);
			
			// Se busca el paciente en la pieza y si existe se termina el ciclo.
			if (patient != null) 
			{
				return patient;
			}		
		}
		// De no ser encontrado en ninguna pieza se muestra mensaje.
		return null;
	}
		
	// Sobrecarga
	// Busca un paciente y lo edita.
	public boolean seekPatient(Impresora print, Menu m, Lector l) throws IOException, RutException
	{
		Pieza tmpRoom;
		Paciente tmpPatient;
		String rut = l.readRut();
		for (int i = 0; i < 10; i++)
		{
			// Se obtiene la pieza en la posición i-ésima.
			tmpRoom = rooms.get(i);
			
			// Se asigna el paciente
			tmpPatient = tmpRoom.search(rut);
			
			// Si el paciente se encontró.
			if (tmpPatient != null)
			{
				print.showEditMenu();
				int op = l.verifyNumber(0, 6);
				if (op == 0)
				{
					return true;
				}
				tmpPatient = m.editPatientMenu(tmpPatient, op, l);
				// Se elimina del mapa y se vuelve a agregar (por si cambian el rut, la clave cambia).
				tmpRoom.deletePatient(rut);
				tmpRoom.addPatient(tmpPatient, tmpPatient.getRut());
				return true;
			}
		}
		return false;
	}
	
	// Se buscan los pacientes de todas las piezas y se muestran
	public void seekPatients(Impresora print) throws IOException
	{
		Pieza tmpRoom;
		// Se recorren todas las piezas.
		for (int i = 0 ; i < 10 ; i ++)
		{
			tmpRoom = rooms.get(i);
			tmpRoom.showPatients(print);
		}
	}
	
	// Sobrecarga
	// Se buscan pacientes a partir de la gravedad
	public void seekPatients(int gravedad, Impresora print) throws IOException
	{
		Pieza tmpRoom;
		//Se recorren todas las piezas
		for (int i = 0; i < 10; i++)
		{
			tmpRoom = rooms.get(i);
			tmpRoom.showPatients(gravedad, print);
		}
	}
	
	// Sobrecarga
	// Se buscan pacientes a partir de la patologia
	public boolean seekPatients(String pathology, Impresora print) throws IOException
	{
		Pieza tmpRoom;
		boolean find = false;
		//Se recorren todas las piezas
		for (int i = 0; i < 10; i++)
		{
			tmpRoom = rooms.get(i);
			if (tmpRoom.showPatients(pathology, print) == true)
			{
				find = true;
			}
		}
		return find;
	}
	
	// Añade un paciente a la pieza indicada.
	public boolean addPatientRoom(int roomNumber, Lector l) throws IOException
	{	
		Pieza tmpRoom;
		tmpRoom = rooms.get(roomNumber);
		
		// Se revisa que la pieza no este llena.
		if (tmpRoom.getTotalPatients() == 5)
		{	
			return false;
		}
		Paciente patient = new Paciente();
		// Se instancia un objeto paciente y se guardan los datos ingresados por el usuario.
		try
		{
			patient = l.setPatientData(tmpRoom.getRoomNumber());
		}
		// Rut ingresado es invalido.
		catch (RutException e)
		{
			System.out.println("Error: " + e.getMessage());
			l.setPatientData(patient);
			return true;
		}
		// La edad ingresada es negativa.
		catch (AgeException e)
		{
			System.out.println("Error: " + e.getMessage());
			l.setPatientData(patient);
		}
		// La gravedad es numerica o supera el rango.
		catch (GravityException e)
		{
			System.out.println("Error: " + e.getMessage());
			l.setPatientData(patient);
		}
				
		// Se revisa que el paciente no se encuentre en el hospital.
		if (tmpRoom.search(patient.getRut()) == null)
		{
			tmpRoom.addPatient(patient, patient.getRut());
			return true;
		}
		return false;	
	}
        
        // Sobrecarga
        // Añade un paciente a la pieza indicada, utilizado para swing.
	public boolean addPatientRoom(int roomNumber, String name, int rut, int edad, int gravedad, String patologia) throws IOException
	{	
		Pieza tmpRoom;
		tmpRoom = rooms.get(roomNumber);
		
		// Se revisa que la pieza no este llena.
		if (tmpRoom.getTotalPatients() == 5)
		{	
			return false;
		}
                		// Se instancia un objeto paciente y se guardan los datos ingresados por el usuario.
		Paciente patient = new Paciente(name, rut ,edad ,gravedad, patologia, roomNumber);

		// Se revisa que el paciente no se encuentre en el hospital.
		if (tmpRoom.search(patient.getRut()) == null)
		{
			tmpRoom.addPatient(patient, patient.getRut());
                        exportPatients();
			return true;
		}
		return false;	
	}
	
	// Se elimina el paciente indicado
	public boolean deletePatient(String rut) throws IOException
	{
		Pieza tmpRoom;
		// Recorremos las piezas
		for (int i = 0 ; i < 10 ; i++)
		{
			tmpRoom = rooms.get(i);
			Paciente tmpPatient = tmpRoom.search(rut);
			if (tmpPatient != null)
			{
				tmpRoom.deletePatient(rut);
				return true;
			}
		}
		return false;
	}
	
	// Se importan los pacientes desde un archivo csv.
	public void importCsv() throws IOException
	{
		// Se abre el archivo de doctores
		ImportExport r = new ImportExport();
		CSV fileDoc = new CSV("doctores");
		String lineDoc = fileDoc.firstLine();
		
		// Se abre el arhivo csv de pacientes y se comienza en la primera linea.
		CSV file = new CSV("patients");
		String line = file.firstLine();
		Pieza tmpRoom; 
		
		// Se inicializan las piezas.
		for (int i = 0 ; i < 10 ; i++)
		{
			Doctor doc = r.readData(fileDoc, lineDoc); 
			// Se instancia cada casilla del arrayLista con una pieza
			Pieza room = new Pieza(i+1, doc);
			rooms.add(i, room);
			lineDoc = fileDoc.nextLine();
		}	
		
		// Mientras exista una linea con datos
		while (file.get_csvField(0,line) != null)
		{
			// Leemos los datos del paciente en dicha linea
			Paciente tmpPacient = r.readData(line, file);
			// Buscamos la pieza que le corresponde
			tmpRoom = rooms.get(tmpPacient.getRoom() - 1);
			// Lo añadimos a su pieza correspondiente
			tmpRoom.addPatient(tmpPacient, tmpPacient.getRut());
			line = file.nextLine();
		}
		file.close();
	}
	
	// Exporta los pacientes de todas las piezas.
	public void exportPatients() 
	{
		try 
		{
			FileWriter fw = new FileWriter("patients.csv");
	        for(int i = 0; i < rooms.size(); i++) 
	        {
	        	Pieza p = rooms.get(i);
	        	p.exportPatients(fw); 
	        }
	        
	       fw.flush(); 
	       fw.close();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	// Exporta los pacientes de todas las piezas.
	public void generateReport() 
	{
		try 
		{
			FileWriter fw = new FileWriter("report.txt");
			// Se recorren las piezas
	        for(int i = 0; i < rooms.size(); i++) 
	        {
	        	fw.write("Pacientes en la pieza " + (i+1) + ":\n\n");
	        	Pieza p = rooms.get(i);
	        	p.generateReport(fw); 
	        	fw.append("\n");
	        }
	        
	       fw.flush(); 
	       fw.close();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}
