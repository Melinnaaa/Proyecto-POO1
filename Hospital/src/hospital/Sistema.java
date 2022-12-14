package hospital;
import java.io.*;
import exceptions.RutException;
import util.Impresora;
import util.Lector;
import util.Menu;
import vista.VistaPrincipal;

public class Sistema 
{
    public static void main(String[] args) throws IOException, RutException
    {           
        // Se instancia un objeto lector, el cual se encarga de leer datos por consolo.
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Lector l = new Lector(reader);
        
        // Se instancia un objeto impresora, utilizada para mostrar los datos de pacientes
        Impresora print = new Impresora();
        print.showOption();
        // Opción ingresada por el usuario
        int opcion = l.verifyNumber(1,2);
        // Si quiere usar interfaz gráfica.
        if (opcion == 1)
        {
            VistaPrincipal ventana = new VistaPrincipal();
            ventana.setVisible(true);
            return;
        }
            
        // Se instancia un objeto menu para utilizar sus metodos.
        Menu menu = new Menu();

        // Se instancia un objeto sección 
        Seccion rooms = new Seccion();

        // While que se termina con la opción 0.
        while (true)
        {
            print.showMenu();
            opcion = l.verifyNumber(0, 7);

            switch (opcion)
            {
                // Agregar paciente.
                case 1:
                {
                    int roomNumber = l.readRoomNumber();
                    print.showAdd(rooms.addPatientRoom(roomNumber, l));
                    break;
                }

                // Eliminar paciente.
                case 2:
                {
                    String rut = l.readRut();
                    print.showDelete(rooms.deletePatient(rut));
                    break;
                }

                // Mostrar pacientes.
                case 3:
                {
                    rooms.seekPatients(print);
                    break;
                }

                // Buscar paciente.
                case 4:
                {
                    String rut = l.readRut();
                    print.showFound(rooms.seekPatient(rut, print));
                    break;
                }

                // Mostrar por gravedad.
                case 5:
                {
                    int gravedad = l.readGravity();
                    rooms.seekPatients(gravedad, print);
                    break;
                }

                // Modificar datos del paciente.
                case 6:
                {
                    print.showFound(rooms.seekPatient(print, menu, l));
                    break;
                }

                // Mostrar por patologia
                case 7:
                {
                    String pathology = l.readPathology();
                    print.showFindPathology(rooms.seekPatients(pathology, print));
                    break;
                }

                // Salir
                case 0:
                {
                    rooms.exportPatients();
                    rooms.generateReport();
                    return;
                }
            }
        }
    }
}
