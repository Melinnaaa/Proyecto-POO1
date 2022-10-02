package controlador;

import hospital.Seccion;
import import_export.CSV;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.table.DefaultTableModel;
import pacientes.Paciente;
import util.Lector;
import import_export.ImportExport;
import vista.VistaAgregar;
import vista.VistaMostrar;

public class ControladorMostrar 
{
    public void mostrar(VistaMostrar ventana) throws IOException
    {
        CSV file = new CSV("patients");
	String line = file.firstLine();
        DefaultTableModel model = (DefaultTableModel) ventana.getPacientes().getModel();
        model.setNumRows(0);
        while (file.get_csvField(0,line) != null)
        {
            String [] row = new String[6];
            row[0] = file.get_csvField(0,line);
            row[1] = file.get_csvField(1, line);
            row[2] = file.get_csvField(2, line);
            row[3] = file.get_csvField(3, line);
            row[4] = file.get_csvField(4, line);
            row[5] = file.get_csvField(5, line);
            model.addRow(row);
            line = file.nextLine();
        }
        file.close();
    }
    
    public void mostrar(VistaMostrar ventana, int gravedad) throws IOException
    {
        CSV file = new CSV("patients");
	String line = file.firstLine();
        DefaultTableModel model = (DefaultTableModel) ventana.getPacientes().getModel();
        model.setNumRows(0);
        while (file.get_csvField(0,line) != null)
        {
            String [] row = new String[6];
            row[0] = file.get_csvField(0,line);
            row[1] = file.get_csvField(1, line);
            row[2] = file.get_csvField(2, line);
            row[3] = file.get_csvField(3, line);
            row[4] = file.get_csvField(4, line);
            row[5] = file.get_csvField(5, line);
            if (Integer.parseInt(row[3]) == gravedad)
            {
                model.addRow(row);
            }
            line = file.nextLine();
        }
        file.close();
    }
    
    public void mostrar(VistaMostrar ventana, String patologia) throws IOException
    {
        CSV file = new CSV("patients");
	String line = file.firstLine();
        DefaultTableModel model = (DefaultTableModel) ventana.getPacientes().getModel();
        model.setNumRows(0);
        while (file.get_csvField(0,line) != null)
        {
            String [] row = new String[6];
            row[0] = file.get_csvField(0,line);
            row[1] = file.get_csvField(1, line);
            row[2] = file.get_csvField(2, line);
            row[3] = file.get_csvField(3, line);
            row[4] = file.get_csvField(4, line);
            row[5] = file.get_csvField(5, line);
            if (patologia.equals(row[4]) == true)
            {
                model.addRow(row);
            }
            line = file.nextLine();
        }
        file.close();
    }
}
