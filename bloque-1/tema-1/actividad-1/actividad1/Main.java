package actividad1;


public class Main {

    static void main(String[] args) throws InterruptedException {
        java.util.ArrayList<Double> tiempos = new java.util.ArrayList<>();

        for (int i = 1; i <= 3; i++) {
            System.out.println("### Receta " + i + " ###");
            double t = prepararReceta();
            tiempos.add(t);
        }

        System.out.println("=== Resumen de recetas ===");
        for (int i = 0; i < tiempos.size(); i++) {
            System.out.println("Receta " + (i + 1) + ": " + tiempos.get(i) + " segundos");
        }
    }

    static double prepararReceta() throws InterruptedException {
        Cocinero cocinero = new Cocinero("Juan");

        Recipiente olla = new Recipiente("Olla");
        Recipiente sarten = new Recipiente("Sartén");
        Recipiente escurridor = new Recipiente("Escurridor");
        Recipiente plato = new Recipiente("Plato");

        Receta receta = new Receta("Espaguetis a la Boloñesa");

        Ingrediente agua = new Ingrediente("Agua", 1500, "ml");
        Ingrediente sal = new Ingrediente("Sal", 10, "g");
        Ingrediente espaguetis = new Ingrediente("Espaguetis", 250, "g");
        Ingrediente aceite = new Ingrediente("Aceite de oliva", 30, "ml");
        Ingrediente cebolla = new Ingrediente("Cebolla picada", 100, "g");
        Ingrediente ajo = new Ingrediente("Ajo picado", 2, "dientes");
        Ingrediente carne = new Ingrediente("Carne picada", 300, "g");
        Ingrediente tomate = new Ingrediente("Tomate frito", 200, "g");

        PasoReceta paso1 = new PasoReceta("Poner agua a hervir en la olla", olla);
        paso1.anadirIngrediente(agua);
        paso1.anadirIngrediente(sal);

        PasoReceta paso2 = new PasoReceta("Cocer los espaguetis en la olla", olla);
        paso2.anadirIngrediente(espaguetis);

        PasoReceta paso3 = new PasoReceta("Sofreír la cebolla y el ajo en la sartén con aceite", sarten);
        paso3.anadirIngrediente(aceite);
        paso3.anadirIngrediente(cebolla);
        paso3.anadirIngrediente(ajo);

        PasoReceta paso4 = new PasoReceta("Añadir la carne picada y dorarla", sarten);
        paso4.anadirIngrediente(carne);

        PasoReceta paso5 = new PasoReceta("Añadir el tomate y dejar reducir la salsa", sarten);
        paso5.anadirIngrediente(tomate);

        PasoReceta paso6 = new PasoReceta("Escurrir la pasta", escurridor);
        paso6.anadirIngrediente(espaguetis);

        PasoReceta paso7 = new PasoReceta("Mezclar la pasta con la salsa boloñesa", sarten);
        paso7.anadirIngrediente(espaguetis);

        PasoReceta paso8 = new PasoReceta("Emplatar los espaguetis a la boloñesa", plato);

        receta.anadirPaso(paso1);
        receta.anadirPaso(paso2);
        receta.anadirPaso(paso3);
        receta.anadirPaso(paso4);
        receta.anadirPaso(paso5);
        receta.anadirPaso(paso6);
        receta.anadirPaso(paso7);
        receta.anadirPaso(paso8);

        receta.preparar(cocinero);

        return receta.getTiempos().get(receta.getTiempos().size() - 1);
    }
}
