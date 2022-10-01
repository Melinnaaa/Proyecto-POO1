package hospital;
import java.io.*;
import java.util.*;
import util.CSV;
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
		importPatients();
	}
	
	// Se importan los pacientes desde un archivo csv.
	public void importPatients() throws IOException
	{
		CSV fileDoc = new CSV("doctores");
		String lineDoc = fileDoc.firstLine();
		
		// Se inicializan las piezas.
		for (int i = 0 ; i < 10 ; i++)
		{
			Doctor doc = readData(fileDoc, lineDoc); 
			// Se instancia cada casilla del arrayLista con una pieza
			Pieza room = new Pieza(i+1, doc);
			rooms.add(i, room);
			lineDoc = fileDoc.nextLine();
		}
		
		// Se abre el arhivo y se comienza en la primera linea.
		CSV file = new CSV("patients");
		String line = file.firstLine();
		Pieza tmpRoom; 
		
		// Mientras exista una linea con datos
		while (file.get_csvField(0,line) != null)
		{
			// Leemos los datos del paciente en dicha linea
			Paciente tmpPacient = readData(line, file);
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
	
	// Lee el archivo csv de pacientes.
	public Paciente readData(String line, CSV file)
    {
		String name = file.get_csvField(0,line);
        int rut = Integer.parseInt(file.get_csvField(1, line));
        int age = Integer.parseInt(file.get_csvField(2, line));
        int gravedad = Integer.parseInt(file.get_csvField(3, line));
        String pathology = file.get_csvField(4, line);
        int room = Integer.parseInt(file.get_csvField(5, line));
        Paciente tmpPatient = new Paciente(name, rut, age, gravedad, pathology, room);
        return tmpPatient;
    }
	
	// Sobrecarga
	// Lee el archivo csv de doctores.
	public Doctor readData(CSV file, String line)
	{
		String name = file.get_csvField(0,line);
        int rut = Integer.parseInt(file.get_csvField(1, line));
        int age = Integer.parseInt(file.get_csvField(2, line));
        String specialty = file.get_csvField(3, line);
        int workRoom = Integer.parseInt(file.get_csvField(4, line));
        Doctor tmp = new Doctor(name, rut, age, specialty, workRoom);
		return tmp;
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
		
	// Sobrecarga
	// Busca un paciente y lo edita.
	public boolean seekPatient(Impresora print, Menu m, Lector l) throws IOException
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
		
		// Se instancia un objeto paciente y se guardan los datos ingresados por el usuario.
		Paciente patient = l.setPatientData(tmpRoom.getRoomNumber());
				
		// Se revisa que el paciente no se encuentre en el hospital.
		if (tmpRoom.search(patient.getRut()) == null)
		{
			tmpRoom.addPatient(patient, patient.getRut());
			return true;
		}
		return false;	
	}
	
	// Se elimina el paciente indicado
	public boolean deletePatient(String rut) throws IOException
	{
		Pieza tmpRoom;
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
}
