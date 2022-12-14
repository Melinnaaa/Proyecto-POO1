package pacientes;
import java.io.IOException;

import util.Impresora;

public class Paciente extends Persona
{
	private String pathology;
	private int gravedad;
	private int room;

	// Constructor que inicializa todas las variables con datos de entrada
	public Paciente(String nombre, int rut, int edad, int gravedad, String pathology, int room) 
	{
		super(nombre, rut, edad);
		this.gravedad = gravedad;
		setPathology(pathology);
		this.room = room;
	}
	
	// Constructor default
	public Paciente()
	{
		super();
	}

	public void setGravedad(int gravedad)
	{
		this.gravedad = gravedad;
	}

	public int getGravedad() 
	{
		return gravedad;
	}
	
	public String getPathology() 
	{
		return pathology;
	}

	public void setPathology(String pathology) 
	{
		this.pathology = pathology;
	}	
	
	public int getRoom()
	{
		return room;
	}
	
	// Muestra los datos de los pacientes.
    @Override
    public void showData(Impresora print) throws IOException
    {
        super.showData(print);
        print.showPatient(this);
    }
}

