package controlador;

import hospital.Seccion;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.table.DefaultTableModel;
import pacientes.Paciente;
import util.Lector;
import vista.VistaBuscar;
import vista.VistaEliminar;

public class ControladorBuscar 
{
    public void buscar(VistaBuscar ventana, String rut) throws IOException
    {
        Seccion sec = new Seccion();
        Paciente patient = sec.seekPatient(rut);
        DefaultTableModel model = (DefaultTableModel) ventana.getPacientes().getModel();
        model.setNumRows(0);
        if (patient != null)
        {
            String [] row = new String[6];
            row[0] = patient.getName();
            row[1] = patient.getRut();
            row[2] = Integer.toString(patient.getAge());
            row[3] = Integer.toString(patient.getGravedad());
            row[4] = patient.getPathology();
            row[5] = Integer.toString(patient.getRoom());
            model.addRow(row);
        }
    }
}
