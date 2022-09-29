package hospital;
import java.io.*;
import java.util.*;
import pacientes.Paciente;
import util.Impresora;

public class Pieza 
{
	//private int totalPatients;
	private int totalBeds;
	private int roomNumber;
	private HashMap <String, Paciente> patientsRut;
	
	// Constructor de pieza.
	public Pieza (int i)
	{
		//totalPatients = 0;
		totalBeds = 5;
		roomNumber = i;
		patientsRut = new HashMap<String, Paciente>();
	}
	
	// Constructor default
	public Pieza()
	{
		
	}

	// Se obtiene la cantidad de pacientes de la pieza.
	public int getTotalPatients() 
	{
		return patientsRut.size();
	}
	
	public int getTotalBeds()
	{
		return totalBeds;
	}
	
	public int getRoomNumber()
	{
		return roomNumber;
	}
	
	// Inserta un paciente en el mapa de pacientes.
	public void addPatient(Paciente tmp, String rut)
	{
		patientsRut.put(rut, tmp);
	}
	
	// Elimina un paciente del mapa.
	public void deletePatient(String rut) throws IOException
	{
		patientsRut.remove(rut);
	}
	
	// Se encarga de buscar el paciente, si lo encuentre retorna un objeto paciente.
	public Paciente search (String rut) throws IOException
	{
		Paciente tmp =  patientsRut.get(rut);
		
		// Se comprueba que el paciente exista
		if (tmp == null) 
		{
			return null;
		}
		return tmp;
	}
	
	// Recorre los pacientes en la pieza.
	public void showPatients(Impresora print) throws IOException
	{
		// For each para recorrer los values del mapa.
		for (Paciente p : patientsRut.values())
		{
			print.showRoomNumber(this);
			p.showData(print);
		}
	}
	
	// Sobrecarga
	// Se encarga de mostrar los pacientes a partir de la gravedad indicada.
	public void showPatients (int gravity, Impresora print) throws IOException
	{
		// Se recorren los pacientes.
		for (Paciente p : patientsRut.values())
		{
			// Se comprueba que la gravedad sea igual.
			if (p.getGravedad() == gravity) 
			{
				// Muestra los datos del paciente.
				p.showData(print);
			}
		}
	}
	
	// Sobrecarga
	// Se encarga de mostrar los pacientes a partir de una patologya indicada.
	public boolean showPatients (String pathology, Impresora print) throws IOException
	{
		boolean find = false;
		// Se recorren los pacientes.
		for (Paciente p : patientsRut.values())
		{
			// Se comprueba que la gravedad sea igual.
			if (p.getPathology().equals(pathology)) 
			{
				// Muestra los datos del paciente.
				p.showData(print);
				find = true;
			}
		}
		return find;
	}
	
	// Exporta los pacientes de la pieza.
	public void exportPatients(FileWriter fw)
	{
		try
		{
			for (Paciente p : patientsRut.values())
			{
				fw.append(p.getName() + ",");
		    	fw.append(p.getRut() + ",");
		    	fw.append(p.getAge() + ",");
		    	fw.append(p.getGravedad() + ",");
		    	fw.append(p.getPathology());
		    	fw.append("\n");
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	/* Modifica los datos de los pacientes 
	public boolean editPatient (Paciente patient) throws IOException
	{
		tmp.editData();
		tmp.setRut();
		patientsRut.remove(rut);
		patientsRut.put(tmp.getRut(), tmp);
		return true;
	}*/
}
