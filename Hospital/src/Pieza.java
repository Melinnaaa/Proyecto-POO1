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
		patientsRut = new HashMap<String, Paciente>(10);
	}

	public int getTotalPatients() 
	{
		return totalPatients;
	}

	public void setTotalPatients(int totalPatients) 
	{
		this.totalPatients = totalPatients;
	}
	
	public HashMap<String, Paciente> getPatientsRut() 
	{
		return patientsRut;
	}
	
	public void getPatientsRut(HashMap<String, Paciente> patientsRut) 
	{
		patientsRut.;
	}
	
	// Crea un paciente y lo guarda en una tabla hash.
	public void createPatient(HashMap <String, Pieza> rooms) throws IOException 
	{
		// Se obtienen los datos del paciente
        System.out.println("Ingrese el nombre del paciente:");
        String name = getline();
        
        System.out.println("Ingrese el rut del paciente:");
        String rut = getline();
        
        System.out.println("Ingrese la edad del paciente:");
        int age = toInt();
        
        System.out.println("Ingrese la gravedad del paciente:");
        int gravity = toInt();
        
        // Variable temporal.
        Paciente tmp = new Paciente(name, rut, age, gravity);
        
        // Se pide la pieza a la cual se ingresará al paciente.
        System.out.println("Ingrese el numero de la pieza:");
        String room = getline();
        // Guardamos el paciente en la tabla a partir del nombre.-
        Pieza tmpRoom = 
        		tmpRoom.put(name, tmp);
        
        // Se guarda el paciente en la tabla a partir del rut.
        patientRut.put(rut, tmp);
    }
}
