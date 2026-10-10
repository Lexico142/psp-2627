package actividad1;



import java.util.ArrayList;

public class PasoReceta {
    java.util.Random randomizador = new java.util.Random();
    private String descripcion;
    private Recipiente recipiente;
    private ArrayList<Ingrediente> ingredientes = new ArrayList<>();
    private int duracionMs;


    public PasoReceta(String descripcion, Recipiente recipiente) {
        this.descripcion = descripcion;
        this.recipiente = recipiente;
        this.duracionMs = randomizarTiempo();
        this.ingredientes = new ArrayList<>();
    }

    public int randomizarTiempo(){
        int min = 200;
        int max = 800;
        return randomizador.nextInt((max - min) + 1) + min;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Recipiente getRecipiente() {
        return recipiente;
    }


    public ArrayList<Ingrediente> getIngredientes() {
        return ingredientes;
    }


    public int getDuracionMs() {
        return duracionMs;
    }
    public void anadirIngrediente(Ingrediente ingrediente) {
        this.ingredientes.add(ingrediente);
    }
}

