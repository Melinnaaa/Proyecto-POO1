package exceptions;
@SuppressWarnings("serial")

public class AgeException extends Exception
{
	public AgeException ()
	{
		super("El paciente ingresado no se encuentra en el hospital");
	}
}
