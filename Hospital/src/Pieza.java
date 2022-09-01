import java.io.*;
import java.util.*;
public class Pieza 
{
	private int totalPatients;
	private int totalBeds;
	private HashMap <String, Paciente> patientsRut;
	
	public Pieza ()
	{
		totalPatients = 0;
		totalBeds = 5;
		patientsRut = new HashMap<String, Paciente>();
	}

	// Se obtiene la cantidad de pacientes de la pieza.
	public int getTotalPatients() 
	{
		return patientsRut.size();
	}
	
	// Retorna el mapa de pacientes
	public HashMap<String, Paciente> getPatientsRut() 
	{
		return patientsRut;
	}
	
	// Inserta un paciente en el mapa de pacientes.
	public void setPatients(Paciente tmp, String rut)
	{
		patientsRut.put(rut, tmp);
	}
	
	// Se encarga de buscar el paciente, retorna true de existir, false de no existir.
	public boolean search (String rut) throws IOException
	{
		Paciente tmp =  patientsRut.get(rut);
		// Se comprueba que el paciente exista
		if (tmp == null) 
		{
			return false;
		}
		return true;
	}
	
	// Se encarga de buscar el paciente y imprimir los datos de este si fue encontrado.
	public boolean search (String rut, int i) throws IOException
	{
		Paciente tmp =  patientsRut.get(rut);
		
		// Se comprueba que el paciente exista
		if (tmp == null) 
		{
			return false;
		}
		System.out.println("El paciente se encuentra en la pieza " + (i+1) + "\n");
		tmp.showPatients();
		return true;
	}
	
	// Recorre los pacientes en la pieza.
	public void showPatients() throws IOException
	{
		// For each para recorrer los values del mapa.
		for (Paciente m : patientsRut.values())
		{
			// muestra los datos del paciente.
			m.showPatients();
		}
	}
	
	public void deletePatient(String rut) throws IOException
	{
		patientsRut.remove(rut);
	}
}
