package controlador;

import hospital.Seccion;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import util.Lector;
import vista.VistaEliminar;

public class ControladorEliminar 
{
    public void eliminar(VistaEliminar ventana, String rut) throws IOException
    {
        Seccion sec = new Seccion();
        sec.deletePatient(rut);
        sec.exportPatients();
        ventana.dispose();
    }
}
