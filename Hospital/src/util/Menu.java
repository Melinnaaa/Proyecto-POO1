package util;

import java.io.IOException;

import pacientes.Paciente;

public class Menu 
{	
	// Muestra las opciones del menu
	public void showMenu()
	{
		System.out.println("Bienvenido al Hospital PUCV:");
		System.out.println("---");
		System.out.println("1. Agregar Paciente.");
        System.out.println("2. Eliminar Paciente.");
        System.out.println("3. Mostrar Pacientes.");
        System.out.println("4. Buscar paciente.");
        System.out.println("5. Mostrar paciente por gravedad.");
        System.out.println("6. Modificar datos paciente.");
        System.out.println("7. Mostrar por patologia.");
        System.out.println("0. Salir.");
        System.out.println("---");
	}
	
	// Menu de edicion de datos del paciente.
	public Paciente editPatientMenu(Paciente tmp, int op, Lector l) throws IOException
	{
		switch (op)
		{
			case 1:
			{
				tmp.setName(l.readName());
				break;
			}
			case 2:
			{
				tmp.setRut(l.readRutNoDigit());
				break;
			}
			case 3:
			{
				tmp.setAge(l.readAge());
				break;
			}
			case 4:
			{
				tmp.setGravedad(l.readGravity());
				break;
			}
			case 5:
			{
				tmp.setPathology(l.readPathology());
				break;
			}
			case 6:
			{
				tmp = l.setPatientData(tmp.getRoom());
				break;
			}
		}
		tmp.setRut();
		return tmp;
	}
}
