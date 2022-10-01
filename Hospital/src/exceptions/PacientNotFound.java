package exceptions;
@SuppressWarnings("serial")

public class PacientNotFound extends Exception
{
	public PacientNotFound ()
	{
		super("El paciente ingresado no se encuentra en el hospital");
	}
}
