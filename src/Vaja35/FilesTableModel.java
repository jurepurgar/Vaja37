package Vaja35;

/*
Avtor: Jure Purgar
Ime datoteke: FilesTableModel.java
Opis: Implementacija abstraktnega razreda AbstractTableModel, ki se uporablja kot model tabele za objekte razreda Datoteka
*/

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

// deklariramo razred, ki razširi abstraktni razred AbstractModelTable
public class FilesTableModel extends AbstractTableModel {

    // ustvarimo seznam v katerega se shranjujejo objekti
    private ArrayList<Datoteka> files = new ArrayList<Datoteka>();

    // metoda ki vrne število vrstic v tabeli, ki je enaka velikosti seznama objektov
    @Override
    public int getRowCount() {
        return files.size();
    }

    // metoda ki vrne število stolpcev v tabeli, ki je vedno enako 3
    @Override
    public int getColumnCount() {
        return 3;
    }

    // metoda ki vrne vsebino za določeno celico
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Datoteka f = files.get(rowIndex);

        if (columnIndex == 0) {
            // če gre za prvi stolpec vrnemo ime datoteke
            return f.getIme();
        } else if (columnIndex == 1) {
            // če gre za drugi stolpec vrnemo velikost datoteke
            return f.getVelikost();
        } else if (columnIndex == 2) {
            // če gre za tretji stolpec, odpremo datoteko, preberemo vsebino v lokalno spremenljivko, zapremo datoteko in vrnemo vsebino
            f.odpri();
            String vsebina = f.preberiVsebino();
            f.zapri();
            return vsebina;
        } 
        // to se nebi smelo zgoditi, vrnemo null
        return null;
    }

    // metoda ki vrne ime posameznega stolpca
    @Override
    public String getColumnName(int columnIndex) {
        if (columnIndex == 0) {
            return "Ime";
        } else if (columnIndex == 1) {
            return "Velikost";
        } else if (columnIndex == 2) {
            return "Vsebina";
        } 
        // to se nebi smelo zgoditi, vrnemo null
        return null;
    }

    // metoda ki doda novo datoteko na seznam
    public void AddFile(Datoteka file)
    {
        // objekt dodamo v seznam
        files.add(file);
        // obvestino tabelo da je bila dodana vrstica, tako se sprememba izriše na zaslon.
        super.fireTableRowsInserted(files.size(), files.size());
    }

}