package actividad2;

import java.util.Random;

public class Impresora extends Thread {
    public Impresora (String nombre) {
        super(nombre);
    }

    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println("[" + getName() + "] tecla " + i);
            try {
                Thread.sleep(Randomizador.getRandom());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            ;
        }
        System.out.println("[" + getName() + "] fin");
    }

}
