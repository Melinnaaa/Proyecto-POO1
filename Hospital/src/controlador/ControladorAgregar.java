package controlador;

import hospital.Seccion;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import util.Lector;
import vista.VistaAgregar;

public class ControladorAgregar 
{
    public void agregar(VistaAgregar ventana) throws IOException
    {
        int room = Integer.parseInt(ventana.getNumeroPieza().getText());
        String name = ventana.getNombre().getText();
        int rut = Integer.parseInt(ventana.getRut().getText());
        int edad = Integer.parseInt(ventana.getEdad().getText());
        int gravedad = Integer.parseInt(ventana.getGravedad().getText());
        String patologia = ventana.getPatologia().getText();
        Seccion sec = new Seccion();
        if (sec.addPatientRoom(room, name, rut, edad , gravedad, patologia) == true)
        {
            sec.generateReport();
            ventana.dispose();
        }
    }
}
