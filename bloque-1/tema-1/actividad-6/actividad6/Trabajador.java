package actividad6;

import java.io.IOException;

public class Trabajador {

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("[trabajador] espero órdenes en " + Canal.archivo);

        while (true) {
            Mensaje mensaje = Canal.recibir();

            if (mensaje != null && mensaje.esFin()) {
                System.out.println("[trabajador] leo: fin. cierro.");
                return;
            }

            if (mensaje != null && mensaje.esEjecuta()) {
                int numero = mensaje.tarea;

                System.out.println("[trabajador] leo: ejecuta encargo " + numero);
                System.out.println("[trabajador] estoy trabajando");

                Canal.enviar(Mensaje.trabajando(numero));
                long resultado = ejecutar(numero);
                Canal.enviar(Mensaje.completa(numero, resultado));

                System.out.println("[trabajador] digo: encargo " + numero + " completo, resultado=" + resultado);
            }
            Thread.sleep(Canal.msPausa);
        }
    }

    private static long ejecutar(int numero) throws InterruptedException {
        Thread.sleep(Canal.msAntesContestar);
        return (long) numero * 3;
    }
}
