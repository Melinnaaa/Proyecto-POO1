package exceptions;
@SuppressWarnings("serial")
public class AgeException extends Exception
{
	public AgeException ()
	{
		super("Edad no valida");
	}
}
