package actividad1;



import java.util.ArrayList;

public class Receta {
    private String nombre;
    private ArrayList<PasoReceta> pasos;
    private ArrayList<Double> tiempos = new ArrayList<>();

    public Receta(String nombre) {
        this.nombre = nombre;
        this.pasos = new ArrayList<>();
    }


    public void preparar(Cocinero cocinero) throws InterruptedException {
        System.out.println("Preparando receta: " + cocinero.getNombre());
        long inicio = System.currentTimeMillis();
        for (PasoReceta paso : pasos) {
            cocinero.ejecutarPaso(paso);
        }
        long fin = System.currentTimeMillis();
        double total = (fin - inicio)/1000.0;
        total = Math.round(total * 1000.0) / 1000.0;
        tiempos.add(total);
        System.out.println("Tiempo total de preparación: " + total + " segundos");
    }

    public ArrayList<Double> getTiempos() {
        return tiempos;
    }

    public void anadirPaso(PasoReceta paso) {
        pasos.add(paso);
    }

}
