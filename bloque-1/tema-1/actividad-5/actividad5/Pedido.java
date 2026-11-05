package actividad5;

public final class Pedido {

    public static final int total = 800;
    public static final int hilos = 8;
    public static final int porHilo = total / hilos;
    public static final long duracionMs = 25;

    private Pedido() {
    }

    public static long preparar(int numero) throws InterruptedException {
        Thread.sleep(duracionMs);
        return 1;
    }

    public static long suma(long[] resultados) {
        long total = 0;
        for (long resultado : resultados) {
            total += resultado;
        }
        return total;
    }

    public static long sumaEsperada() {
        return total;
    }
}
