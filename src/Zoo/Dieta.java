package Zoo;

public class Dieta {
    private String codigo;
    private String tipo; // Ej: "carnívoro", "herbívoro", "omnívoro"

    public Dieta(String codigo, String tipo) {
        this.codigo = codigo;
        this.tipo = tipo;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getTipo() {
        return tipo;
    }
}
