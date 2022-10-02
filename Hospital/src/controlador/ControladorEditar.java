package controlador;

import hospital.Pieza;
import hospital.Seccion;
import java.io.IOException;
import pacientes.Paciente;
import vista.VistaEditar;

public class ControladorEditar 
{
    // Edita el nombre
    public void editarNombre(VistaEditar ventana) throws IOException
    {
        String name = ventana.getNombre().getText();
        Seccion sec = new Seccion();
        Paciente tmpPatient = new Paciente();
        Pieza room = sec.seekPatient(ventana.getRutStr().getText(), tmpPatient);
        // Si se emcontró el paciente a editar.
        if (room != null)
        {
            tmpPatient = room.search(ventana.getRutStr().getText());
            tmpPatient.setName(name);
            // Se elimina y se vuelve a añadir a la pieza, para modificarlo.
            room.deletePatient(ventana.getRutStr().getText());
            room.addPatient(tmpPatient, tmpPatient.getRut());
            // Se actualiza el csv
            sec.exportPatients();
            sec.generateReport();
            // Se cierra la ventana
            ventana.dispose();
        }
    }
    
    public void editarRut(VistaEditar ventana) throws IOException
    {
        Seccion sec = new Seccion();
        Paciente tmpPatient = null;
        Pieza room = sec.seekPatient(ventana.getRutStr().getText(), tmpPatient);
        // Si se emcontró el paciente a editar.
        if (room != null)
        {
            tmpPatient = room.search(ventana.getRutStr().getText());
            // Se setea el rut y se obtiene el nuevo digito verificador.
            tmpPatient.setRut(Integer.parseInt(ventana.getRut().getText()));
            tmpPatient.setRut();
            
            // Se elimina y se vuelve a añadir a la pieza, para modificarlo.
            room.deletePatient(ventana.getRutStr().getText());
            room.addPatient(tmpPatient, tmpPatient.getRut());
            // Se actualiza el csv
            sec.exportPatients();
            sec.generateReport();
            // Se cierra la ventana
            ventana.dispose();
        }
    }
    
    public void editarEdad(VistaEditar ventana) throws IOException
    {
        Seccion sec = new Seccion();
        Paciente tmpPatient = null;
        Pieza room = sec.seekPatient(ventana.getRutStr().getText(), tmpPatient);
        // Si se emcontró el paciente a editar.
        if (room != null)
        {
            tmpPatient = room.search(ventana.getRutStr().getText());
            // Se setea la edad y se obtiene el nuevo digito verificador.
            tmpPatient.setAge(Integer.parseInt(ventana.getEdad().getText()));
            // Se elimina y se vuelve a añadir a la pieza, para modificarlo.
            room.deletePatient(ventana.getRutStr().getText());
            room.addPatient(tmpPatient, tmpPatient.getRut());
            // Se actualiza el csv
            sec.exportPatients();
            sec.generateReport();
            // Se cierra la ventana
            ventana.dispose();
        }
    }
    
    public void editarGravedad(VistaEditar ventana) throws IOException
    {
        Seccion sec = new Seccion();
        Paciente tmpPatient = null;
        Pieza room = sec.seekPatient(ventana.getRutStr().getText(), tmpPatient);
        // Si se emcontró el paciente a editar.
        if (room != null)
        {
            tmpPatient = room.search(ventana.getRutStr().getText());
            // Se setea la gravedad y se obtiene el nuevo digito verificador.
            tmpPatient.setGravedad(Integer.parseInt(ventana.getGravedad().getText()));
            // Se elimina y se vuelve a añadir a la pieza, para modificarlo.
            room.deletePatient(tmpPatient.getRut());
            room.addPatient(tmpPatient, tmpPatient.getRut());
            // Se actualiza el csv
            sec.exportPatients();
            sec.generateReport();
            // Se cierra la ventana
            ventana.dispose();
        }
    }
    
    public void editarPatologia(VistaEditar ventana) throws IOException
    {
        Seccion sec = new Seccion();
        Paciente tmpPatient = null;
        Pieza room = sec.seekPatient(ventana.getRutStr().getText(), tmpPatient);
        // Si se emcontró el paciente a editar.
        if (room != null)
        {
            tmpPatient = room.search(ventana.getRutStr().getText());
            // Se setea la patologia y se obtiene el nuevo digito verificador.
            tmpPatient.setPathology(ventana.getPatologia().getText());
            // Se elimina y se vuelve a añadir a la pieza, para modificarlo.
            room.deletePatient(tmpPatient.getRut());
            room.addPatient(tmpPatient, tmpPatient.getRut());
            // Se actualiza el csv
            sec.exportPatients();
            sec.generateReport();
            // Se cierra la ventana
            ventana.dispose();
        }
    }
    
    public void editarTodo(VistaEditar ventana) throws IOException
    {
        String name = ventana.getNombre().getText();
        int rut = Integer.parseInt(ventana.getRut().getText());
        int edad = Integer.parseInt(ventana.getEdad().getText());
        int gravedad = Integer.parseInt(ventana.getGravedad().getText());
        String patologia = ventana.getPatologia().getText();
        Paciente tmpPatient = null;
        Seccion sec = new Seccion();
        Pieza room = sec.seekPatient(ventana.getRutStr().getText(), tmpPatient);
        // Si se emcontró el paciente a editar.
        if (room != null)
        {
            tmpPatient = new Paciente(name, rut, edad, gravedad, patologia, room.getRoomNumber());
            // Se setea la patologia y se obtiene el nuevo digito verificador.
            tmpPatient.setPathology(ventana.getPatologia().getText());
            // Se elimina y se vuelve a añadir a la pieza, para modificarlo.
            room.deletePatient(tmpPatient.getRut());
            room.addPatient(tmpPatient, tmpPatient.getRut());
            // Se actualiza el csv
            sec.exportPatients();
            sec.generateReport();
            // Se cierra la ventana
            ventana.dispose();
        }
    }  
}
