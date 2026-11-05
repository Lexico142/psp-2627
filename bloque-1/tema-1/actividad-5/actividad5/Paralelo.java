package actividad5;

public class Paralelo {

    public static void main(String[] args) throws InterruptedException {

        long[] resultados = new long[Pedido.total];
        Trozo[] trozos = new Trozo[Pedido.hilos];
        Thread[] hilos = new Thread[Pedido.hilos];

        System.out.println("Paralelo. Hilo: " + Thread.currentThread().getName());
        System.out.println(Pedido.hilos + " hilos × " + Pedido.porHilo + " pedidos × " + Pedido.duracionMs + " ms");
        System.out.println("Esperado: unos " + (Pedido.porHilo * Pedido.duracionMs / 1000) + " s, si van a la vez");
        System.out.println("---");


        long inicio = System.nanoTime();
        for (int h = 0; h < Pedido.hilos; h++) {
            int desde = h * Pedido.porHilo + 1;
            int hasta = desde + Pedido.porHilo - 1;
            trozos[h] = new Trozo(h + 1, desde, hasta);
            hilos[h] = new Thread(trozos[h], "hilo-" + (h + 1));
            hilos[h].start();
        }
        for (Thread hilo : hilos) {
            hilo.join();
        }

        for (Trozo trozo : trozos) {
            guardar(resultados, trozo);
        }
        long ms = (System.nanoTime() - inicio) / 1_000_000;

        Secuencial.informar(resultados, ms);
    }

    private static void guardar(long[] resultados, Trozo trozo) {
        for (int i = 0; i < trozo.parcial.length; i++) {
            resultados[trozo.desde - 1 + i] = trozo.parcial[i];
        }
        System.out.println("[main] guardo el tramo " + trozo.desde + ".." + trozo.hasta);
    }
}
