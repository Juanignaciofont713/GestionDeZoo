package Zoo;
import java.util.ArrayList;
import java.util.List;

public class Habitat {
    private String codigo;
    private String nombre;
    private String tipo; // Ej: "sabana", "selva tropical", "ártico"
    private int capacidad;
    private List<Animal> animales;

    public Habitat(String codigo, String nombre, String tipo, int capacidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.tipo = tipo;
        this.capacidad = capacidad;
        this.animales = new ArrayList<>();
    }

    public boolean agregarAnimal(Animal animal) {
        if (animales.size() < capacidad) {
            animales.add(animal);
            return true;
        } else {
            return false;
        }
    }

    public List<Animal> getAnimales() {
        return animales;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public int getCapacidad() {
        return capacidad;
    }
}
