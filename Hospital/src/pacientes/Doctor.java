package pacientes;
import java.io.IOException;

import util.Impresora;

public class Doctor extends Persona
{
	private String specialty;
	private int workRoom;
	
	public Doctor (String nombre, int rut, int edad, String speciality, int workRoom)
	{
		super(nombre, rut, edad);
		this.specialty = speciality;
		this.workRoom = workRoom;
	}
	
	public String getSpecialty() 
	{
		return specialty;
	}
	
	public void setSpecialty(String specialty) 
	{
		this.specialty = specialty;
	}
	
	public int getWorkRoom() 
	{
		return workRoom;
	}
	
	public void setWorkRoom(int workRoom) 
	{
		this.workRoom = workRoom;
	}
	
	// Muestra los datos de los doctores.
    @Override
    public void showData(Impresora print) throws IOException
    {
        super.showData(print);
        print.showDoctor(this);
    }
	
}
