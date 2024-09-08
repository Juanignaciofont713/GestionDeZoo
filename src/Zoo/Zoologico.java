package Zoo;
import java.util.*;
import java.io.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.io.BufferedWriter;

public class Zoologico {
    private List<Animal> animales;
    private List<Cuidador> cuidadores;
    private List<Habitat> habitats;
    private List<Dieta> dietas;
    private ClasificacionAnimal clasificacionAnimal;

    public Zoologico() {
        animales = new ArrayList<>();
        cuidadores = new ArrayList<>();
        habitats = new ArrayList<>();
        dietas = new ArrayList<>();
        clasificacionAnimal = new ClasificacionAnimal();
    }

    public void leerDatosDesdeCSV(String rutaArchivoAnimales, String rutaArchivoCuidadores, String rutaArchivoHabitats, String rutaArchivoDietas) {
        // Implementar la lectura de datos desde archivos CSV
    }

    public void escribirDatosHaciaCSV(String rutaArchivoAnimales, String rutaArchivoCuidadores, String rutaArchivoHabitats, String rutaArchivoDietas) {
        // Implementar la escritura de datos hacia archivos CSV
    }

    public void agregarAnimal(Animal animal) {
        animales.add(animal);
    }

    public void agregarCuidador(Cuidador cuidador) {
        cuidadores.add(cuidador);
    }

    public void agregarHabitat(Habitat habitat) {
        habitats.add(habitat);
    }

    public void agregarDieta(Dieta dieta) {
        dietas.add(dieta);
    }

    public List<Animal> buscarAnimalesPorEspecie(String tipo) {
        List<Animal> resultado = new ArrayList<>();
        for (Animal animal : animales) {
            if (animal.getTipo().equalsIgnoreCase(tipo)) {
                resultado.add(animal);
            }
        }
        return resultado;
    }

    public List<Animal> buscarAnimalesPorHabitat(String codigoHabitat) {
        for (Habitat habitat : habitats) {
            if (habitat.getCodigo().equalsIgnoreCase(codigoHabitat)) {
                return habitat.getAnimales();
            }
        }
        return new ArrayList<>();
    }

    public List<Animal> listarAnimalesPorCuidador(String codigoCuidador) {
        // Implementar la lógica para listar animales bajo el cuidado de un cuidador específico
        return new ArrayList<>();
    }

    public Map<String, Integer> contarAnimalesPorTipo() {
        Map<String, Integer> conteo = new HashMap<>();
        for (Animal animal : animales) {
            conteo.put(animal.getTipo(), conteo.getOrDefault(animal.getTipo(), 0) + 1);
        }
        return conteo;
    }

    public int contarMamiferos() {
        return clasificacionAnimal.contarMamiferos();
    }

    public int contarAves() {
        return clasificacionAnimal.contarAves();
    }

    public int contarReptiles() {
        return clasificacionAnimal.contarReptiles();
    }
    
    // Escribir la lista de animales en un archivo CSV
    public void escribirAnimalesCSV(String archivo) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            // Cabecera del CSV
            bw.write("Codigo,Nombre,Edad,Peso,Tipo\n");
            // Iterar sobre la lista de animales y escribir sus datos
            for (Animal animal : clasificacionAnimal.getMamiferos()) {
                bw.write(animal.getCodigo() + "," + animal.getNombre() + "," +
                         animal.getEdad() + "," + animal.getPeso() + "," +
                         animal.getTipo() + "\n");
            }
            for (Animal animal : clasificacionAnimal.getAves()) {
                bw.write(animal.getCodigo() + "," + animal.getNombre() + "," +
                         animal.getEdad() + "," + animal.getPeso() + "," +
                         animal.getTipo() + "\n");
            }
            for (Animal animal : clasificacionAnimal.getReptiles()) {
                bw.write(animal.getCodigo() + "," + animal.getNombre() + "," +
                         animal.getEdad() + "," + animal.getPeso() + "," +
                         animal.getTipo() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        Zoologico zoo = new Zoologico();
        
        // Crear algunos cuidadores
        Cuidador cuidador1 = new Cuidador("C001", "Font Juan Ignacio", "Mamiferos");
        Cuidador cuidador2 = new Cuidador("C002", "Font Miguel Geronimo", "Reptiles");
        Cuidador cuidador3 = new Cuidador("C003", "Font Ramon Miguel", "Aves");
        zoo.agregarCuidador(cuidador1);
        zoo.agregarCuidador(cuidador2);
        zoo.agregarCuidador(cuidador3);
        
        // Crear algunas dietas
        Dieta dietaCarnivoro = new Dieta("D001", "Carnivoro");
        Dieta dietaHerbivoro = new Dieta("D002", "Herbívoro");
        Dieta dietaOmnivoro = new Dieta("D003", "Omnívoro");
        zoo.agregarDieta(dietaCarnivoro);
        zoo.agregarDieta(dietaHerbivoro);
        zoo.agregarDieta(dietaOmnivoro);

        // Crear algunos hábitats
        Habitat sabana = new Habitat("H001", "Sabana Africana", "Sabana", 5);
        Habitat selva = new Habitat("H002", "Selva Amazónica", "Selva Tropical", 3);
        zoo.agregarHabitat(sabana);
        zoo.agregarHabitat(selva);

        // Crear algunos animales
        Animal leon = new Mamifero("A001", "Leon", 5, 190.5);
        Animal elefante = new Mamifero("A002", "Elefante", 10, 540.3);
        Animal loro = new Ave("A003", "Loro", 2, 1.2);
        Animal cocodrilo = new Reptil("A004", "Cocodrilo", 7, 300.0);

        zoo.agregarAnimal(leon);
        zoo.agregarAnimal(elefante);
        zoo.agregarAnimal(loro);
        zoo.agregarAnimal(cocodrilo);
        
        // Escribir los animales en un archivo CSV
        zoo.escribirAnimalesCSV("animales.csv");
        
        // Asignar animales a hábitats
        sabana.agregarAnimal(leon);
        sabana.agregarAnimal(elefante);
        selva.agregarAnimal(loro);
        selva.agregarAnimal(cocodrilo);

        // Ejemplos de operaciones
        System.out.println("Animales en la sabana:");
        for (Animal animal : zoo.buscarAnimalesPorHabitat("H001")) {
            System.out.println(animal.getNombre());
        }

        System.out.println("\nAnimales en la selva:");
        for (Animal animal : zoo.buscarAnimalesPorHabitat("H002")) {
            System.out.println(animal.getNombre());
        }

        System.out.println("\nConteo de animales por tipo:");
        Map<String, Integer> conteo = zoo.contarAnimalesPorTipo();
        for (Map.Entry<String, Integer> entry : conteo.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

