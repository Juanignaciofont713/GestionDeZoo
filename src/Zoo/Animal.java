package Zoo;
import java.util.List;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public abstract class Animal {
    private String codigo;
    private String nombre;
    private int edad;
    private double peso;
    private Dieta dieta;
    

    public Animal(String codigo, String nombre, int edad, double peso) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
    }

    public void asignarDieta(Dieta dieta) {
        this.dieta = dieta;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public double getPeso() {
        return peso;
    }

    public Dieta getDieta() {
        return dieta;
    }

    public abstract String getTipo();
}
