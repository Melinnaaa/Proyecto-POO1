package util;
import java.io.BufferedReader;
import java.io.IOException;

import exceptions.RutException;
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
	public Paciente setPatientData(int room) throws IOException, RutException
	{
	    // Se obtienen los datos del paciente
	    System.out.println("Ingrese el nombre del paciente:");
	    String name = bf.readLine();
	    
	    
	    System.out.println("Ingrese el rut del paciente, sin digito verificador:");
	    String rut = bf.readLine();
	    
	    // Comprobamos que el rut no contenga caracteres.
	    boolean isNumeric = rut.chars().allMatch( Character::isDigit );
	    int rutNoDigit;
	    
	    // De no contenerlos de transforma a int
	    if(isNumeric == true)
	    {
	    	rutNoDigit = Integer.parseInt(rut);
	    }
	    
	    // Por otro lado se lanza el error
	    else 
	   	{
	    	throw new  RutException();
	    }
	    
	    System.out.println("Ingrese la edad del paciente:");
	    int age = Integer.parseInt(bf.readLine());
	    
	    System.out.println("Ingrese la gravedad del paciente:");
        int gravedad = Integer.parseInt(bf.readLine());
        
        System.out.println("Ingrese la patologia del paciente:");
        String pathology = bf.readLine();
        
        // Se guardan los datos del ingresados instanciando un objeto paciente.
        Paciente tmpPatient = new Paciente(name, rutNoDigit, age, gravedad, pathology, room);  
        return tmpPatient;
	}
	
	// Sobrecarga
	// Se guardan los datos del paciente leidos por consola
	public void setPatientData(Paciente tmp) throws IOException
	{
	    // Se obtienen los datos del paciente
	    System.out.println("Ingrese el nombre del paciente:");
	    tmp.setName(bf.readLine());
	    
	    // Se lee el rut sin digitos correctamente
	    tmp.setRut(readRutNoDigit());
	    
	    // Se lee la edad
	    System.out.println("Ingrese la edad del paciente:");
	    tmp.setAge(Integer.parseInt(bf.readLine()));
	    
	    // Se lee la gravedad
	    System.out.println("Ingrese la gravedad del paciente:");
        tmp.setGravedad(Integer.parseInt(bf.readLine()));
        
        // Se lee la patologia
        System.out.println("Ingrese la patologia del paciente:");
        tmp.setPathology(bf.readLine());
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
	    String rut;
	    boolean isNumeric;
	    //Se lee hasta que el rut no contenga caracteres.
	    do
	    {
	    	System.out.println("Ingrese el rut del paciente sin digito verificador y sin puntos.");
			rut = bf.readLine();
			
			// Comprobamos que el rut no contenga caracteres.
		    isNumeric = rut.chars().allMatch( Character::isDigit );
	    }while(isNumeric == false);
	    
	    int rutNoDigit = Integer.parseInt(rut);
		return rutNoDigit;
	}
	
	// Se lee la gravedad ingresada
	public int readGravity() throws IOException
	{
		System.out.println("Ingrese la gravedad del paciente (1-3)");
		int gravity = verifyNumber(1,3);
		return gravity;
	}
	
	// Se lee
	public int readRoomNumber() throws IOException
	{
		System.out.println("Ingrese la pieza en donde se quedará el paciente (1-10)");
		int roomNumber = verifyNumber(1, 10) - 1;
		return roomNumber;
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
}
