package Vaja35;

/*
Avtor: Jure Purgar
Ime datoteke: Datoteka.java
Opis: Implementacija razreda Datoteka
*/

public class Datoteka {
    
    // Deklariramo lastnosti
    private String vsebina;
    private String ime;
    private boolean jeOdprta;

    // Konstruktor s katerim ustvarimo nov objekt razreda Datoteka
    public Datoteka(String imeDatoteke) {
        // inicjaliziramo lastnosti
        this.ime = imeDatoteke;
        this.jeOdprta = false;
        vsebina = "";
    }

    // metoda ki vrne ali je datoteka odprta
    public boolean getJeOdprta() {
        return jeOdprta;
    }

    // metoda ki vrne velikost datoteke
    public int getVelikost() {
        return vsebina.length();
    }

    // metoda ki vrne ime datoteke
    public String getIme() {
        return ime;
    }

    // metoda ki prebere vsebino datoteke
    public String preberiVsebino() {
        if (jeOdprta) {
            return vsebina;
        }
        return null;
    }

    // metoda ki vpiše vsebino
    public void vpisiVsebino(String besedilo) {
        if (jeOdprta) {
            this.vsebina = besedilo;
        }
    }

    // metoda ki doda besedilo obstoječi vsebini
    public void dodajVsebino(String besedilo) {
        if (jeOdprta) {
            this.vsebina += besedilo;
        }
    }

    // metoda ki izbriše vsebino
    public void izbrisiVsebino() {
        this.vsebina = "";
    }

    // metoda ki odpre datoteko
    public void odpri() {
        jeOdprta = true;        
    }

    // metoda ki zapre datoteko
    public void zapri() {
        jeOdprta = false;        
    }

    // metoda ki preimenuje datoteko
    public void preimenuj(String novoIme) {
        if (!jeOdprta) {
            ime = novoIme;
        }
    }
}