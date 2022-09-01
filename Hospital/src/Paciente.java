import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Paciente 
{
	private String name;
	private String rut;
	private int age;
	private int gravedad;
	
	// Constructor que inicializa todas las variables con datos de entrada
	public Paciente(String nombre, String rut, int edad, int gravedad) 
	{
		this.name = nombre;
		this.rut = rut;
		this.age = edad;
		this.gravedad = gravedad;
	}
	
	// COnstructor default
	public Paciente()
	{
		
	}

	public String getNombre() 
	{
		return name;
	}


	public String getRut() 
	{
		return rut;
	}


	public int getEdad() 
	{
		return age;
	}


	public int getGravedad() 
	{
		return gravedad;
	}

	// Se obtienen los datos del paciente por consola y se guardan
	public void getPatientData() throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		// Se obtienen los datos del paciente
        System.out.println("Ingrese el nombre del paciente:");
        name = reader.readLine();
        
        System.out.println("Ingrese el rut del paciente:");
        rut = reader.readLine();
        
        System.out.println("Ingrese la edad del paciente:");
        age = Integer.parseInt(reader.readLine());
        
        System.out.println("Ingrese la gravedad del paciente:");
        gravedad = Integer.parseInt(reader.readLine());
	}
	
	// Muestra los datos de los pacientes.
	public void showPatients() throws IOException
	{
		System.out.println("Nombre: " + name);
		System.out.println("Edad: " + age);
		System.out.println("Rut: " + rut);
		System.out.println("Gravdedad: " + gravedad);
	}
	
}
