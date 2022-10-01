package exceptions;
@SuppressWarnings("serial")
public class InsertDataException extends Exception
{
	public InsertDataException()
	{
		super("El dato ingresado es invalido");
	}
}
