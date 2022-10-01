package util;
import hospital.Pieza;
import pacientes.Doctor;
import pacientes.Paciente;
import pacientes.Persona;

public class Impresora 
{
	// Se muestran los datos de la persona
	public void showPerson(Persona tmp)
	{
		System.out.println("\nNombre: " + tmp.getName());
		System.out.println("Edad: " + tmp.getAge());
		System.out.println("Rut: " + tmp.getRut());
	}
	
	// Se muestra los datos del paciente
	public void showPatient(Paciente tmp)
	{
		System.out.println("Gravdedad: " + tmp.getGravedad());
        System.out.println("Patologia: " + tmp.getPathology() + "\n");
	}
	
	public void showDoctor(Doctor tmp)
	{
		System.out.println("Gravdedad: " + tmp.getSpecialty());
        System.out.println("Patologia: " + tmp.getWorkRoom() + "\n");
	}
	
	// Se muestra el numero de la pieza
	public void showRoomNumber(Pieza tmp)
	{
		System.out.println("Pieza " + tmp.getRoomNumber());
	}
	
	// Se muestra el resultado eliminar un paciente
	public void showDelete(boolean result)
	{
		if (result == true)
		{
			System.out.println("El paciente fue eliminado del sistema.\n");
		}
		else
		{
			System.out.println("El paciente a eliminar no existe.\n");
		}
	}
	
	// Se muestra el resultado al añadir un paciente
	public void showAdd(boolean result)
	{
		if (result == true)
		{
			System.out.println("El paciente se ingreso correctamente.\n");
		}
		else
		{
			System.out.println("El paciente ya estaba ingresado / La pieza estaba llena.\n");
		}
	}
	
	// Se muestra el resultado al buscar un paciente
	public void showFound(boolean result)
	{
		if (result == false)
		{
			System.out.println("El paciente no fue encontrado.\n");
		}
	}
	
	// Se muestra el resultado al buscar un paciente por patologia
	public void showFindPathology(boolean result)
	{
		if (result == false)
		{
			System.out.println("No existe ningun paciente con esa patologia.\n");
		}
	}
	
	public void showEditMenu()
	{
		System.out.println("---");
		System.out.println("1. Editar Nombre.");
        System.out.println("2. Editar Rut.");
        System.out.println("3. Editar Edad.");
        System.out.println("4. Editar Gravedad.");
        System.out.println("5. Editar Patologia.");
        System.out.println("6. Editar todo.");
        System.out.println("7. Mostrar por patologia.");
        System.out.println("0. Salir.");
		
	}
}
