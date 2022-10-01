package import_export;
import pacientes.Doctor;
import pacientes.Paciente;

public class ImportExport
{
	// Lee el archivo csv de pacientes.
	public Paciente readData(String line, CSV file)
    {
		String name = file.get_csvField(0,line);
        int rut = Integer.parseInt(file.get_csvField(1, line));
        int age = Integer.parseInt(file.get_csvField(2, line));
        int gravedad = Integer.parseInt(file.get_csvField(3, line));
        String pathology = file.get_csvField(4, line);
        int room = Integer.parseInt(file.get_csvField(5, line));
        Paciente tmpPatient = new Paciente(name, rut, age, gravedad, pathology, room);
        return tmpPatient;
    }
	
	// Sobrecarga
	// Lee el archivo csv de doctores.
	public Doctor readData(CSV file, String line)
	{
		String name = file.get_csvField(0,line);
        int rut = Integer.parseInt(file.get_csvField(1, line));
        int age = Integer.parseInt(file.get_csvField(2, line));
        String specialty = file.get_csvField(3, line);
        int workRoom = Integer.parseInt(file.get_csvField(4, line));
        Doctor tmp = new Doctor(name, rut, age, specialty, workRoom);
		return tmp;
	}
}
