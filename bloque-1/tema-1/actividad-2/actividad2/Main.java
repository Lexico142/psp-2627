package actividad2;

public class Main {
    public static void main(String[] args) {
        Backup backup = new Backup("Backup");
        Correo correo = new Correo("Correo");
        Impresora impresora = new Impresora("Impresora");

        backup.start();
        correo.start();
        impresora.start();

        try {
            impresora.join();
            correo.join();
            backup.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("oficina cerrada");
    }
}
