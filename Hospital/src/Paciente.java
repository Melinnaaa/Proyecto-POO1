import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Paciente implements VerifyRut
{
	private String name;
	private String rut;
	private int rutNoDigit;
	private int age;
	private int gravedad;
	
	// Constructor que inicializa todas las variables con datos de entrada
	public Paciente(String nombre, int rut, int edad, int gravedad) 
	{
		this.name = nombre;
		this.rutNoDigit = rut;
		this.age = edad;
		this.gravedad = gravedad;
	}
	
	// Constructor default
	public Paciente()
	{
		
	}

	public String getRut() 
	{
		return rut;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
	
	public String getName()
	{
		return name;
	}

	public int getAge() 
	{
		return age;
	}

	public void setAge(int age) 
	{
		this.age = age;
	}

	//rut sin guion
	public void setRut(int rut) 
	{
		this.rutNoDigit = rut;
	}
	
	// Rut con guion
	public void setRut() 
	{
		// Se pasa el rut sin digito a String
		this.rut = String.valueOf(rutNoDigit);
		// Se concatena el guión
		this.rut = this.rut.concat("-");
		// Se concatena el digito verificador
		this.rut = this.rut.concat(getDigit());
	}

	public void setGravedad(int gravedad)
	{
		this.gravedad = gravedad;
	}

	public int getGravedad() 
	{
		return gravedad;
	}
	

	// Se obtienen los datos del paciente por consola y se guardan
	public void setPatientData() throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		// Se obtienen los datos del paciente
        System.out.println("Ingrese el nombre del paciente:");
        name = reader.readLine();
        
        System.out.println("Ingrese el rut del paciente, sin digito verificador:");
        rutNoDigit = Integer.parseInt(reader.readLine());
        
        System.out.println("Ingrese la edad del paciente:");
        age = Integer.parseInt(reader.readLine());
        
        System.out.println("Ingrese la gravedad del paciente:");
        gravedad = Integer.parseInt(reader.readLine());
	}
	
	// Se obtienen los datos del paciente a traves de un archivo csv
	public void readPatientData(String line, CSV file)
	{
		name = file.get_csvField(0,line);
		rutNoDigit = Integer.parseInt(file.get_csvField(1, line));
		age = Integer.parseInt(file.get_csvField(2, line));
		gravedad = Integer.parseInt(file.get_csvField(3, line));
		//Se obtiene el rut con digito verificador.
		setRut();
	}
	
	// Muestra los datos de los pacientes.
	public void showPatientData() throws IOException
	{
		System.out.println("\nNombre: " + name);
		System.out.println("Edad: " + age);
		System.out.println("Rut: " + rut);
		System.out.println("Gravdedad: " + gravedad + "\n");
	}	

	// Se obtiene el digito verificador a partir del rut
	public String getDigit ()
	{
		int rut = rutNoDigit;
	    String digit = "";
	    int accum = 0;
	    int cont = 2;
	    //
	    while (rut != 0)
	    {
	        int mult = (rut % 10) * cont;
	        //
	        accum = accum + mult;
	        rut = Math.round(rut / 10);
	        cont++;
	        // Se reinicia el contador
	        if (cont == 8)
	        {
	        	cont = 2;
	        }
	    }
	    int res = 11 - (accum % 11);
	    
	    // Casos posibles al obtener el digito
	    if (res < 10) digit = String.valueOf(res);
	    if (res == 10) digit = "k";
	    if (res == 11) digit = "0";
	    
	    return digit;
    }
}
