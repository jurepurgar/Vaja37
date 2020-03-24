package Vaja32;

import java.io.*;
import java.util.ArrayList;

/*
Avtor: Jure Purgar
Ime datoteke: Test.java
Opis: Program za testiranje razreda Datoteka
*/

public class Test {

    // deklariramo reader
    private static BufferedReader in;

    public static void main(String[] args)  {
        // inicjaliziramo bralnik
        in = new BufferedReader(new InputStreamReader(System.in));

        // ustvarimo nov seznam datotek
        ArrayList<Datoteka> datoteke = new ArrayList<Datoteka>();

        try {
            // for zanko ponovimo trikrat
            for (int i=1; i<=3; i++) {
                // uporabnika vprašamo po željeni vsebini datoteke in preberemo rezultat
                System.out.println("Vnesite željeno vsebino datoteke " + i + ":");
                String vsebina = in.readLine();

                // ustvarimo nov objekt razreda Datoteka
                Datoteka d = new Datoteka("datoteka" + i + ".txt");

                // vpišemo vsebino v datoteko
                d.odpri();
                d.vpisiVsebino(vsebina);
                d.zapri();

                // dodamo nov objekt tipa datoteka v seznam

                datoteke.add(d);
            
            
            }

        } catch (Exception e) {
            System.out.println("Napaka: " + e);
        }

        for (Datoteka d : datoteke) {

            // inicjaliziramo spremenljivko
            String vsebina = "Neznana vsebina!";

            // poizkušamo prebrati vsebino preberemo vsebino datoteke
            try {
                d.odpri();
                vsebina = d.preberiVsebino();
                d.zapri();
            } catch (Exception e) {
                // če pride do napake pri branju dvignemo izjemo
                System.out.println("napaka pri branju: " + e);
            }

            // izpišemo vsebino datoteke
            System.out.println("Vsebina datoteke '" + d.getIme() + "' je: " + vsebina);
        }

    }
}
