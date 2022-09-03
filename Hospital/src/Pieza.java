import java.io.*;
import java.util.*;
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
	
	// Se encarga de buscar el paciente a partir de la gravedad.
	public void search (int gravity) throws IOException
	{
		// Se recorren los pacientes.
		for (Paciente m : patientsRut.values())
		{
			// Se comprueba que la gravedad sea igual.
			if (m.getGravedad() == gravity ) 
			{
				// Muestra los datos del paciente.
				m.showPatientData();
			}
		}
	}
	
	// Sobrecarga
	// Se encarga de buscar el paciente y imprimir los datos de este si fue encontrado.
	public boolean search (String rut) throws IOException
	{
		Paciente tmp =  patientsRut.get(rut);
		
		// Se comprueba que el paciente exista
		if (tmp == null) 
		{
			return false;
		}
		System.out.println("El paciente se encuentra en la pieza " + roomNumber + "\n");
		tmp.showPatientData();
		return true;
	}
	
	// Recorre los pacientes en la pieza.
	public void showPatients() throws IOException
	{
		// For each para recorrer los values del mapa.
		for (Paciente m : patientsRut.values())
		{
			// muestra los datos del paciente.
			System.out.println("Pieza " + roomNumber);
			m.showPatientData();
		}
	}
}
