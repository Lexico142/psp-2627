package actividad2;

public class Backup extends Thread {

    public Backup(String nombre) {
        super(nombre);
    }

    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println("[" + getName() + "] copiando fichero " + i);
            pausa(Randomizador.getRandom());
        }
        System.out.println("[" + getName() + "] fin");
    }

    private static void pausa(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}