package controlador;

import hospital.Seccion;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import util.Lector;
import vista.VistaAgregar;
import vista.VistaBuscar;
import vista.VistaEditar;
import vista.VistaEliminar;
import vista.VistaMostrar;
import vista.VistaMostrarPrincipal;
import vista.VistaPrincipal;

public class ControladorPrincipal 
{
    //VistaPrincipal principal = new VistaPrincipal(); 
    public void agregar() throws IOException
    {
        VistaAgregar ventana = new VistaAgregar();
        ventana.setVisible(true);
    }
    public void eliminar()
    {
        VistaEliminar ventana = new VistaEliminar();
        ventana.setVisible(true);
    }
    public void mostrar() throws IOException
    {
        VistaMostrarPrincipal ventana = new VistaMostrarPrincipal();
        ventana.setVisible(true);
    }
    
    public void buscar() throws IOException
    {
        VistaBuscar ventana = new VistaBuscar();
        ventana.setVisible(true);
    }
    public void editar () throws IOException
    {
        VistaEditar ventana = new VistaEditar();
        ventana.setVisible(true);
    }
    
}
