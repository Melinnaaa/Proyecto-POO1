import java.util.*;
public class Pieza 
{
	private int totalPatients;
	private int totalBeds;
	private ArrayList <Paciente> patients; 
	private Hashtable <String, Paciente> patientsName;
	private Hashtable <String, Paciente> patientsRut;
	
	public Pieza (ArrayList <Paciente>patients, Hashtable <String, Paciente>patientsName, Hashtable <String, Paciente>patientsRut)
	{
		totalPatients = 0;
		totalBeds = 5;
		patients = this.patients;
		patientsName = this.patientsName;
		patientsRut = this.patientsRut;
	}

	public int getTotalPatients() 
	{
		return totalPatients;
	}

	public ArrayList<Paciente> getPatients() 
	{
		return patients;
	}

	public Hashtable<String, Paciente> getPatientsName() 
	{
		return patientsName;
	}

	public void setTotalPatients(int totalPatients) 
	{
		this.totalPatients = totalPatients;
	}
	
	public void setTotalBeds(int totalBeds)
	{
		this.totalBeds = totalBeds;
	}

	public Hashtable<String, Paciente> getPatientsRut() 
	{
		return patientsRut;
	}
}
