package controlador;

import hospital.Seccion;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import pacientes.Paciente;
import util.Lector;
import vista.VistaEliminar;

public class ControladorEliminar 
{
    public void eliminar(VistaEliminar ventana, String rut) throws IOException
    {
        Seccion sec = new Seccion();
        if (sec.deletePatient(rut) == true)
        {
            sec.exportPatients();
            sec.generateReport();
            ventana.dispose();
        }
    }
}
