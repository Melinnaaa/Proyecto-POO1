package pacientes;
import java.io.IOException;
import util.Impresora;

public class Persona implements VerifyRut
{
	private String name;
	private String rut;
	private int rutNoDigit;
	private int age;
	
	public Persona(String nombre, int rut, int edad)
	{
		this.name = nombre;
		this.rutNoDigit = rut;
		this.age = edad;
		setRut();
	}
	
	public Persona()
	{
		
	}
	
	public String getRut() 
	{
		return rut;
	}
	
	public int getRutNoDigit()
	{
		return rutNoDigit;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
	
	public String getName()
	{
		return name;
	}

	public int getAge() 
	{
		return age;
	}

	public void setAge(int age) 
	{
		this.age = age;
	}

	// Rut sin guion
	public void setRut(int rut) 
	{
		this.rutNoDigit = rut;
	}
	
	// Rut con guion
	public void setRut() 
	{
		// Se pasa el rut sin digito a String
		this.rut = String.valueOf(rutNoDigit);
		// Se concatena el guión
		this.rut = this.rut.concat("-");
		// Se concatena el digito verificador
		this.rut = this.rut.concat(getDigit());
	}
	
	// Muestra los datos de la persona.
    public void showData(Impresora print) throws IOException
    {
    	print.showPerson(this);
    }
    
	// Se obtiene el digito verificador a partir del rut
	public String getDigit ()
	{
		int rut = rutNoDigit;
	    String digit = "";
	    int accum = 0;
	    int cont = 2;
	    //
	    while (rut != 0)
	    {
	        int mult = (rut % 10) * cont;
	        //
	        accum = accum + mult;
	        rut = Math.round(rut / 10);
	        cont++;
	        // Se reinicia el contador
	        if (cont == 8)
	        {
	        	cont = 2;
	        }
	    }
	    int res = 11 - (accum % 11);
	    
	    // Casos posibles al obtener el digito
	    if (res < 10) digit = String.valueOf(res);
	    if (res == 10) digit = "k";
	    if (res == 11) digit = "0";
	    
	    return digit;
    }
}
