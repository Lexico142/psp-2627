package actividad3;


public class Aforo {
    private int entradas = 0;

    public void entrar() {
        int actual = entradas;
        entradas = actual + 1;
    }

    public int getEntradas() {
        return entradas;
    }
}
