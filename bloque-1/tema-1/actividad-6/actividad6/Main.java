package actividad6;

import java.io.IOException;

public class Main {

    private static final int encargos = 8;

    public static void main(String[] args) throws IOException, InterruptedException {
        long[] resultados = new long[encargos];

        System.out.println("[main] canal: " + Canal.archivo);
        System.out.println("[main] el otro proceso es actividad6.Trabajador. Si no está arrancado, me quedo esperando.");
        System.out.println("---");

        for (int numero = 1; numero <= encargos; numero++) {
            Canal.enviar(Mensaje.ejecuta(numero));
            System.out.println("[main] digo: ejecuta encargo " + numero);

            Mensaje respuesta = esperarCompleta(numero);
            resultados[numero - 1] = respuesta.resultado;
            System.out.println("[main] guardo encargo " + numero + " -> " + respuesta.resultado);

            System.out.println("[main] espero antes de mandar el siguiente");
            Thread.sleep(Canal.msAntesContestar);
        }

        Canal.enviar(Mensaje.fin());
        System.out.println("---");
        System.out.println("[main] guardé " + resultados.length + " resultados:");
        for (int i = 0; i < resultados.length; i++) {
            System.out.println("  encargo " + (i + 1) + " -> " + resultados[i]);
        }
        System.out.println("[main] suma = " + sumar(resultados));
    }

    private static Mensaje esperarCompleta(int numero) throws IOException, InterruptedException {
        while (true) {
            Mensaje mensaje = Canal.recibir();
            if (mensaje != null && mensaje.esCompleta() && mensaje.tarea == numero) {
                return mensaje;
            }
            Thread.sleep(Canal.msPausa);
        }
    }

    private static long sumar(long[] resultados) {
        long total = 0;
        for (long resultado : resultados) {
            total += resultado;
        }
        return total;
    }
}
