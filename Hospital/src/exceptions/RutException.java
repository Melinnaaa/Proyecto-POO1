package exceptions;
@SuppressWarnings("serial")
public class RutException extends Exception
{
	public RutException()
	{
		super("El rut ingresado contiene caracteres no validos.");
	}
}
