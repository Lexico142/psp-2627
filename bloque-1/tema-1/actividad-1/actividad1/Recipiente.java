package actividad1;


import java.util.ArrayList;

public class Recipiente {
    private String nombre;
    private String estado = "vacío";
    private ArrayList<Ingrediente> ingredientes = new ArrayList<>();

    public Recipiente(String nombre) {
        this.nombre = nombre;
        this.ingredientes = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }


    public void setEstado(String estado) {
        this.estado = estado;
    }


    public void agregarIngredientes(ArrayList<Ingrediente> ingredientes) {

        this.ingredientes.addAll(ingredientes);
    }

    @Override
    public String toString() {
        return nombre + " " + estado;
    }
}
