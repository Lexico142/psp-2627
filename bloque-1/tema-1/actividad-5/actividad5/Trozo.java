package actividad5;

public class Trozo implements Runnable {

    final int id;
    final int desde;
    final int hasta;
    final long[] parcial;

    public Trozo(int id, int desde, int hasta) {
        this.id = id;
        this.desde = desde;
        this.hasta = hasta;
        this.parcial = new long[hasta - desde + 1];
    }

    @Override
    public void run() {
        try {
            System.out.println("[hilo-" + id + "] empiezo pedidos " + desde + ".." + hasta);
            for (int numero = desde; numero <= hasta; numero++) {
                parcial[numero - desde] = Pedido.preparar(numero);
            }
            System.out.println("[hilo-" + id + "] tramo listo");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("[hilo-" + id + "] me interrumpieron");
        }
    }
}
