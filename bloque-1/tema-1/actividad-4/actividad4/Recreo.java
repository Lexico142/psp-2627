package actividad4;

public class Recreo {

    private boolean sonando = false;
    private int despertados = 0;

    public synchronized void esperarTimbre(String alumno) throws InterruptedException {
        while (!sonando) {
            System.out.println(alumno + ": todavía no suena el timbre, espero...");
            wait();
        }
        despertados++;
        System.out.println(alumno + ": suena el timbre, salgo al recreo");
    }

    public synchronized void tocarConNotify() {
        sonando = true;
        System.out.println("portero: toco el timbre (notify)");
        notify();
    }

    public synchronized void tocarConNotifyAll() {
        sonando = true;
        System.out.println("portero: toco el timbre (notifyAll)");
        notifyAll();
    }

    public synchronized int getDespertados() {
        return despertados;
    }


    public synchronized void liberarRestantes() {
        sonando = true;
        System.out.println("portero: vuelvo a tocar el timbre para los que siguen esperando");
        notifyAll();
    }
}
