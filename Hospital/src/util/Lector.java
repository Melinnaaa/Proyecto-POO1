package util;
import java.io.BufferedReader;
import java.io.IOException;

import pacientes.Paciente;

public class Lector 
{
	BufferedReader bf;
	
	// Se inicializa el reader utilizado en toda la clase.
	public Lector (BufferedReader bf)
	{
		this.bf = bf;
	}
	
	// Se guardan los datos del paciente leidos por consola
	public Paciente setPatientData() throws IOException
	{
	    // Se obtienen los datos del paciente
	    System.out.println("Ingrese el nombre del paciente:");
	    String name = bf.readLine();
	    
	    System.out.println("Ingrese el rut del paciente, sin digito verificador:");
	    int rut = Integer.parseInt(bf.readLine());
	    
	    System.out.println("Ingrese la edad del paciente:");
	    int age = Integer.parseInt(bf.readLine());
	    
	    System.out.println("Ingrese la gravedad del paciente:");
        int gravedad = Integer.parseInt(bf.readLine());
        
        System.out.println("Ingrese la patologia del paciente:");
        String pathology = bf.readLine();
        
        // Se guardan los datos del ingresados.
        Paciente tmpPatient = new Paciente(name, rut, age, gravedad, pathology);  
        return tmpPatient;
	}
	
	// Se lee el rut ingresado
	public String readRut() throws IOException
	{
		System.out.println("Ingrese el rut del paciente:");
		String rut = bf.readLine();
		return rut;
	}
	
	// Se lee la patologia ingresada
	public String readPathology () throws IOException
	{
		System.out.println("Ingrese la patologia del paciente.");
		String pathology = bf.readLine();
		return pathology;
	}
	
	// Se lee el nombre ingresado
	public String readName () throws IOException
	{
		System.out.println("Ingrese el nombre del paciente.");
		String name = bf.readLine();
		return name;
	}
	
	// Se lee la edad
	public int readAge() throws IOException
	{
		System.out.println("Ingrese la edad del paciente.");
		int age = Integer.parseInt(bf.readLine());
		return age;
	}
	
	// Lee el rut sin digito
	public int readRutNoDigit() throws IOException
	{
		System.out.println("Ingrese el rut del paciente sin digito verificador.");
		int rut = Integer.parseInt(bf.readLine());
		return rut;
	}
	
	// Se lee la gravedad ingresada
	public int readGravity() throws IOException
	{
		System.out.println("Ingrese la gravedad del paciente (1-3)");
		int gravity = verifyNumber(1,3);
		return gravity;
	}
	
	// Verifica que el numero esté en el rango indicado
	public int verifyNumber(int low, int high) throws IOException
	{
		int n;
		
		// Se verifica que se indique una pieza que exista.
		do
		{
			n = Integer.parseInt(bf.readLine());
		}while(n < low || n > high);
		
		return n;
	}
	
	public Paciente editPatient () throws IOException
	{
		// Se reingresan los datos del paciente
        System.out.println("Reingrese el nombre del paciente:");
        String name = bf.readLine();
        
        System.out.println("Reingrese el rut del paciente, sin digito verificador:");
        int rut = Integer.parseInt(bf.readLine());
        
        System.out.println("Reingrese la edad del paciente:");
        int age = Integer.parseInt(bf.readLine());
        
        System.out.println("Reingrese la gravedad del paciente:");
        int gravedad = Integer.parseInt(bf.readLine());
        
        System.out.println("Reingrese la patologia del paciente:");
        String pathology = bf.readLine();
    
        Paciente tmp = new Paciente(name, rut, age, gravedad, pathology);
        return tmp;
	}
}
