package actividad2;

import java.util.Random;

public class Randomizador {
    public static int getRandom(){
        Random rand = new Random();
        int min = 50;
        int max = 100;
        return rand.nextInt((max - min) + 1) + min;
    }

}
