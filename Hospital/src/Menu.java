import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Menu 
{
	static private BufferedReader reader;
	
	Menu()
	{
		reader = new BufferedReader(new InputStreamReader(System.in));
		
	}
	
	// Lee por consola
	public String getline() throws IOException
	{
		return reader.readLine();
	}
	
	// Lee por consola y lo pasa a int
	public int toInt() throws IOException
	{
		return  Integer.parseInt(getline());
	}
	
	// Muestra las opciones del menu
	public void showMenu()
	{
		System.out.println("Bienvenido al Hospital PUCV:");
		System.out.println("---");
		System.out.println("1. Agregar Paciente.");
        System.out.println("2. Eliminar Paciente.");
        System.out.println("3. Mostrar Pacientes.");
        System.out.println("4. Buscar paciente.");
        System.out.println("0. Salir.");
        System.out.println("---");
	}
		
	public void createPatient(Hashtable <String, Paciente> patientName, Hashtable <String, Paciente> patientRut) throws IOException 
	{
        System.out.println("Ingrese el nombre del paciente:");
        String name = getline();
        
        System.out.println("Ingrese el rut del paciente:");
        String rut = getline();
        
        System.out.println("Ingrese la edad del paciente:");
        int age = toInt();
        
        System.out.println("Ingrese la gravedad del paciente:");
        int gravity = toInt();
        
        Paciente tmp = new Paciente(name, rut, age, gravity);
        
        // Guardamos el paciente en la tabla a partir del nombre.-
        patientName.put(name, tmp);
        
        // Se guarda el paciente en la tabla a partir del rut.
        patientRut.put(rut, tmp);
    }
	
	public void searchByName(Hashtable <String, Paciente> patient) throws IOException
	{
		System.out.println("Ingrese el nombre del paciente a buscar:");
		String name = getline();
		Paciente tmp =  patient.get(name);
		
		// Se comprueba que el paciente exista
		if (tmp == null) 
		{
			System.out.println("No se encontró el paciente ingresado.");
			return;
		}
		else
		{
			System.out.println("Nombre: " + tmp.getNombre());
			System.out.println("Rut: " + tmp.getRut());
			System.out.println("Edad: " + tmp.getEdad());
			System.out.println("Gravedad: " + tmp.getGravedad());
		}
	}
	
	public void searchByRut(Hashtable <String, Paciente> patient) throws IOException
	{
		System.out.println("Ingrese el rut del paciente a buscar:");
		String rut = getline();
		Paciente tmp =  patient.get(rut);
		
		// Se comprueba que el paciente exista
		if (tmp == null) 
		{
			System.out.println("No se encontró el paciente ingresado.");
			return;
		}
		else
		{
			System.out.println("Nombre: " + tmp.getNombre());
			System.out.println("Rut: " + tmp.getRut());
			System.out.println("Edad: " + tmp.getEdad());
			System.out.println("Gravedad: " + tmp.getGravedad());
		}
	}
	
	public void searchPatient(Hashtable <String, Paciente> patientName, Hashtable <String, Paciente> patientRut) throws IOException
	{
		System.out.println("---");
		System.out.println("1. Por nombre.");
        System.out.println("2. Por rut.");
        System.out.println("0. Volver.");
        System.out.println("---");
        int in = toInt();
        Menu m = new Menu();
    
        switch (in)
        {
        	case 1:
        	{
        		m.searchByName(patientName);
        		break;
        	}
        	case 2:
        	{
        		m.searchByRut(patientRut);
        		break;
        	}
        	case 0:
        	{
        		return;
        	}
        	default:
        	{
        		System.out.println("Ingrese una opción valida");
        		break;
        	}
        	
        }
	}
}
