package Zoo;
import java.util.*;

public class ClasificacionAnimal {
    private List<Animal> mamiferos;
    private List<Animal> aves;
    private List<Animal> reptiles;

    public ClasificacionAnimal() {
        mamiferos = new ArrayList<>();
        aves = new ArrayList<>();
        reptiles = new ArrayList<>();
    }

    public void agregarAnimal(Animal animal) {
        switch (animal.getTipo().toLowerCase()) {
            case "mamifero":
                mamiferos.add(animal);
                break;
            case "ave":
                aves.add(animal);
                break;
            case "reptil":
                reptiles.add(animal);
                break;
            default:
                throw new IllegalArgumentException("Tipo de animal no reconocido: " + animal.getTipo());
        }
    }

    public List<Animal> getMamiferos() {
        return mamiferos;
    }

    public List<Animal> getAves() {
        return aves;
    }

    public List<Animal> getReptiles() {
        return reptiles;
    }

    public int contarMamiferos() {
        return mamiferos.size();
    }

    public int contarAves() {
        return aves.size();
    }

    public int contarReptiles() {
        return reptiles.size();
    }
}
