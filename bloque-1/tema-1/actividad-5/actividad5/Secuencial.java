package actividad5;

public class Secuencial {

    public static void main(String[] args) throws InterruptedException {
        long[] resultados = new long[Pedido.total];

        System.out.println("Secuencial. Hilo: " + Thread.currentThread().getName());
        System.out.println(Pedido.total + " pedidos × " + Pedido.duracionMs + " ms");
        System.out.println("Esperado: unos " + (Pedido.total * Pedido.duracionMs / 1000) + " s");
        System.out.println("---");

        long inicio = System.nanoTime();

        for (int numero = 1; numero <= Pedido.total; numero++) {
            resultados[numero - 1] = Pedido.preparar(numero);
            if (numero % 100 == 0) {
                System.out.println("[main] guardado el pedido " + numero + " / " + Pedido.total);
            }
        }
        long ms = (System.nanoTime() - inicio) / 1_000_000;

        informar(resultados, ms);
    }

    static void informar(long[] resultados, long ms) {
        long suma = Pedido.suma(resultados);
        System.out.println("---");
        System.out.println("[main] guardé " + resultados.length + " resultados");
        System.out.println("[main] resultado final = " + suma + " (esperado " + Pedido.sumaEsperada() + ")");
        System.out.println("[main] tiempo = " + ms + " ms");
    }
}
