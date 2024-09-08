package Zoo;

public class Ave extends Animal {
    public Ave(String codigo, String nombre, int edad, double peso) {
        super(codigo, nombre, edad, peso);
    }

    @Override
    public String getTipo() {
        return "Aves";
    }
}
