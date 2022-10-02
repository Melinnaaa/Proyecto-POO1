package util;

import java.io.IOException;

import exceptions.AgeException;
import exceptions.GravityException;
import exceptions.RutException;
import pacientes.Paciente;

public class Menu 
{		
	// Menu de edicion de datos del paciente.
	public Paciente editPatientMenu(Paciente tmp, int op, Lector l) throws IOException, RutException
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
				tmp.setRut();
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
				try
				{
					tmp = l.setPatientData(tmp.getRoom());
				}
				catch (RutException e)
				{
					System.out.println("Error: " + e.getMessage() + "\n");
					l.setPatientData(tmp);
				}
				catch (AgeException e)
				{
					System.out.println("Error: " + e.getMessage() + "\n");
					l.setPatientData(tmp);
					
				}
				catch(GravityException e)
				{
					System.out.println("Error: " + e.getMessage() + "\n");
					l.setPatientData(tmp);
				}
				tmp.setRut();
				break;
			}
		}
		return tmp;
	}
}
