package Zoo;
import java.io.*;
import java.util.*;

public class UtilCSV {
    public static List<String[]> leerCSV(String rutaArchivo) throws IOException {
        List<String[]> datos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                datos.add(linea.split(","));
            }
        }
        return datos;
    }

    public static void escribirCSV(String rutaArchivo, List<String[]> datos) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo))) {
            for (String[] fila : datos) {
                bw.write(String.join(",", fila));
                bw.newLine();
            }
        }
    }
}
