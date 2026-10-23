package actividad3;

public class Main {

    private static final int entradasPorVisitante = 1000;
    private static final int esperado = 4 * entradasPorVisitante;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== 1) Sin sincronización ===");
        Aforo aforo = new Aforo();
        Thread a = new Thread(new Visitante(aforo, entradasPorVisitante), "visitante-A");
        Thread b = new Thread(new Visitante(aforo, entradasPorVisitante), "visitante-B");
        Thread c = new Thread(new Visitante(aforo, entradasPorVisitante), "visitante-C");
        Thread d = new Thread(new Visitante(aforo, entradasPorVisitante), "visitante-D");
        a.start();
        b.start();
        c.start();
        d.start();
        a.join();
        b.join();
        c.join();
        d.join();
        System.out.println("Esperado: " + esperado + " | real: " + aforo.getEntradas());

        System.out.println();
        System.out.println("=== 2)  Con synchronized ===");
        AforoSincronizado aforoSync = new AforoSincronizado();
        Thread z = new Thread(new Visitante(aforoSync, entradasPorVisitante), "visitante-A");
        Thread x = new Thread(new Visitante(aforoSync, entradasPorVisitante), "visitante-B");
        Thread y = new Thread(new Visitante(aforoSync, entradasPorVisitante), "visitante-C");
        Thread w = new Thread(new Visitante(aforoSync, entradasPorVisitante), "visitante-D");
        z.start();
        x.start();
        y.start();
        w.start();
        z.join();
        x.join();
        y.join();
        w.join();
        System.out.println("Esperado: " + esperado + " | real: " + aforoSync.getEntradas());
    }
}
