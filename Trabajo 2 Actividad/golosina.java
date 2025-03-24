public class Golosina {
    private String nombre;
    private double peso;

    // Constructor
    public Golosina(String nombre, double peso) {
        this.nombre = nombre;
        this.peso = peso;
    }

    // Getter y Setter para nombre
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter y Setter para peso
    public double getPeso() {
        return this.peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
}

