package Vaja30;

/*
Avtor: Jure Purgar
Ime datoteke: Datoteka.java
Opis: Implementacija razreda Datoteka
*/

public class Datoteka {
    
    // Deklariramo lastnosti
    private String vsebina;
    private String ime;
    protected boolean jeOdprta;

    // Konstruktor s katerim ustvarimo nov objekt razreda Datoteka
    public Datoteka(String imeDatoteke) {
        // inicjaliziramo lastnosti
        this.ime = imeDatoteke;
        this.jeOdprta = false;
        vsebina = "";
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
    public String preberiVsebino() throws Exception {
        if (jeOdprta) {
            return vsebina;
        } else {
            throw new Exception("Branje ni mogoče ker datoteka ni odprta!");
        }
    }

    // metoda ki vpiše vsebino
    public void vpisiVsebino(String besedilo) throws Exception {
        if (jeOdprta) {
            this.vsebina = besedilo;
        } else {
            // dvignemo izjemo če datoteka ni odprta
            throw new Exception("Pisanje ni mogoče ker datoteka ni odprta!");
        }
    }

    // metoda ki doda besedilo obstoječi vsebini
    public void dodajVsebino(String besedilo) throws Exception {
        if (jeOdprta) {
            this.vsebina += besedilo;
        }else {
            // dvignemo izjemo če datoteka ni odprta
            throw new Exception("Dodajanje ni mogoče ker datoteka ni odprta!");
        }
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
    public void preimenuj(String novoIme) throws Exception {
        if (!jeOdprta) {
            ime = novoIme;
        } else {
            // dvignemo izjemo če je datoteka odprta
            throw new Exception("Preimenovanje ni mogoče ker je datoteka odprta!");            
        }
    }
}