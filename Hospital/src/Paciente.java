
public class Paciente 
{
	private String nombre;
	private String rut;
	private int edad;
	private int gravedad;
	
	// Constructor
	public Paciente(String nombre, String rut, int edad, int gravedad) 
	{
		this.nombre = nombre;
		this.rut = rut;
		this.edad = edad;
		this.gravedad = gravedad;
	}

	public String getNombre() {
		return nombre;
	}


	public String getRut() {
		return rut;
	}


	public int getEdad() {
		return edad;
	}


	public int getGravedad() {
		return gravedad;
	}

	
	

}
