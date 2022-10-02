package exceptions;
@SuppressWarnings("serial")
public class GravityException extends Exception
{
	public GravityException ()
	{
		super("La gravedad contiene caracteres no numericos.");
	}
}
