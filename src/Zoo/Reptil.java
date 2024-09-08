package Zoo;

public class Reptil extends Animal {
    public Reptil(String codigo, String nombre, int edad, double peso) {
        super(codigo, nombre, edad, peso);
    }

    @Override
    public String getTipo() {
        return "Reptiles";
    }
}

