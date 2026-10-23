package actividad4;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== 1) Tres alumnos + portero con notify() ===");
        demoNotify();

        Thread.sleep(300);
        System.out.println();
        System.out.println("=== 2) Tres alumnos + portero con notifyAll() ===");
        demoNotifyAll();
    }

    private static void demoNotify() throws InterruptedException {
        Recreo recreo = new Recreo();

        Thread a1 = new Thread(new Alumno(recreo, "alumno 1"), "alumno 1");
        Thread a2 = new Thread(new Alumno(recreo, "alumno 2"), "alumno 2");
        Thread a3 = new Thread(new Alumno(recreo, "alumno 3"), "alumno 3");
        Thread portero = new Thread(new Portero(recreo, false), "portero");

        a1.start();
        a2.start();
        a3.start();
        portero.start();

        Thread.sleep(400);
        System.out.println("Han salido " + recreo.getDespertados() + " alumno(s) tras el notify");

        recreo.liberarRestantes();
        a1.join();
        a2.join();
        a3.join();
        portero.join();
        System.out.println("Tras la limpieza final han salido " + recreo.getDespertados() + " alumnos en total");
    }

    private static void demoNotifyAll() throws InterruptedException {
        Recreo recreo = new Recreo();

        Thread a1 = new Thread(new Alumno(recreo, "alumno 1"), "alumno 1");
        Thread a2 = new Thread(new Alumno(recreo, "alumno 2"), "alumno 2");
        Thread a3 = new Thread(new Alumno(recreo, "alumno 3"), "alumno 3");
        Thread portero = new Thread(new Portero(recreo, true), "portero");

        a1.start();
        a2.start();
        a3.start();
        portero.start();

        a1.join();
        a2.join();
        a3.join();
        portero.join();
        System.out.println("Han salido " + recreo.getDespertados() + " alumnos tras el notifyAll");
    }
}
