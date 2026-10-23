package actividad3;

public class AforoSincronizado extends Aforo {

    @Override
    public synchronized void entrar() {
        super.entrar();
    }

    @Override
    public synchronized int getEntradas() {
        return super.getEntradas();
    }
}
