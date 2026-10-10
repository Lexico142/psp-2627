package actividad1;
import java.time.LocalTime;

public class Cocinero {
    private String nombre;

    public Cocinero(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void ejecutarPaso(PasoReceta paso) throws InterruptedException {
        System.out.println("====================");
        System.out.println("Cocinero: " + getNombre());
        System.out.println("Hora de inicio: " + LocalTime.now());
        System.out.println("Ejecutando paso: " + paso.getDescripcion());
        System.out.println("Recipiente: " + paso.getRecipiente().getNombre());
        System.out.println("Ingredientes: ");
        for (Ingrediente ingrediente : paso.getIngredientes()) {
            System.out.println(ingrediente);
        }
        System.out.println("Duración: " + (paso.getDuracionMs()/1000.0) + " segundos");

        Thread.sleep((long) paso.getDuracionMs());

        paso.getRecipiente().setEstado("en uso");
        paso.getRecipiente().agregarIngredientes(paso.getIngredientes());

        paso.getRecipiente().setEstado("terminado");

        System.out.println("Hora de fin: " + LocalTime.now());
        System.out.println("====================");
    }

}
