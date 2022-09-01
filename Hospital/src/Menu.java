import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

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
        System.out.println("0. Salir.");
        System.out.println("---");
	}
	
	// Verifica que el numero esté en el rango indicado
	public int verifyNumber(int low, int high) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n;
		
		// Se verifica que se indique una pieza que exista.
		do
		{
			n = Integer.parseInt(reader.readLine());
		}while(n < low || n > high);
		return n;
	}
}
