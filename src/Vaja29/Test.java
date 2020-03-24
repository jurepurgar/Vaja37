package Vaja29;

import java.io.*;

/*
Avtor: Jure Purgar
Ime datoteke: Test.java
Opis: Program za testiranje razreda Datoteka
*/

public class Test {

    // deklariramo reader
    private static BufferedReader in;

    public static void main(String[] args)  {
        
        // Deklariramo in inicjaliziramo nov objekt tipa Datoteka
        Datoteka d = new Datoteka("test.txt");

        // inicjaliziramo bralnik
        in = new BufferedReader(new InputStreamReader(System.in));

        try {
            // uporabnika vprašamo po željeni vsebini datoteke
            System.out.println("Vnesite željeno vsebino datoteke:");
            String vsebina = in.readLine();

            // odpremo datoteko in vpišemo vsebino 
            d.odpri();
            d.vpisiVsebino(vsebina);

            // izpišemo velikost in vsebino datoteke
            System.out.println("Vsebina datoteke je '" + d.preberiVsebino() + "'");
            System.out.println("Velikost datoteke je '" + d.getVelikost() + "'");
        } catch (Exception e) {
            System.out.println("Napaka: " + e);
        }

    }
}
