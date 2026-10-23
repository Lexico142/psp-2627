package actividad4;

public class Alumno implements Runnable {

    private final Recreo recreo;
    private final String nombre;

    public Alumno(Recreo recreo, String nombre) {
        this.recreo = recreo;
        this.nombre = nombre;
    }

    @Override
    public void run() {
        try {
            recreo.esperarTimbre(nombre);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
