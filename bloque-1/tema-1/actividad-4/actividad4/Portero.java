package actividad4;

public class Portero implements Runnable {

    private final Recreo recreo;
    private final boolean aTodos;

    public Portero(Recreo recreo, boolean aTodos) {
        this.recreo = recreo;
        this.aTodos = aTodos;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(300);
            if (aTodos) {
                recreo.tocarConNotifyAll();
            } else {
                recreo.tocarConNotify();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
