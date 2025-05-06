public class Tarea {
    private String titulo; //titulo de la tarea
    private int prioridad; //prioridad de la tarea 

    //constructor
    public Tarea(String titulo, int prioridad) {
        this.titulo = titulo;           
        this.prioridad = prioridad;     
    }
    //geters y setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    @Override
    public String toString() {
        return "Tarea{" + "titulo='" + titulo + '\'' + ", prioridad=" + prioridad + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tarea tarea = (Tarea) o;
        return prioridad == tarea.prioridad && titulo.equals(tarea.titulo);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(titulo, prioridad);
    }
}