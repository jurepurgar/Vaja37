package Vaja35;

/*
Avtor: Jure Purgar
Ime datoteke: Program.java
Opis: Upravljanje z seznamom datotek
*/

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.*;

// Deklariramo javni razred Miza ki imlementira vmesnik ActionListener
public class Program implements ActionListener {

    // Definiramo lastnosti razreda
    private JFrame frame;
    private JPanel rootPanel;
    private JPanel editorPanel;

    private JLabel nameLabel;
    private JTextField nameText;
    private JLabel contentLabel;
    private JTextField contentText;
    private JButton addFileBtn;
    
    private JTable table;
    private FilesTableModel tableModel;

    // Staticna metoda, ki se zazene ob zacetku
    public static void main(String[] args) { 
        Program p = new Program();
    }

    public Program() {

        // inicjaliziramo okno
        frame = new JFrame("Datoteke");

        // ustvarimo root površino
        rootPanel = new JPanel();

        // ustvarimo površino namenjeno urejanju in ji določimo layout
        editorPanel = new JPanel();
        editorPanel.setLayout(new BoxLayout(editorPanel, BoxLayout.PAGE_AXIS));
            
        // kreiramo oznake in vnosna polja
        nameLabel = new JLabel("Ime datoteke: ");
        contentLabel = new JLabel("Vsebina datoteke: ");
        nameText = new JTextField(20);
        contentText = new JTextField(20);

        // ustvarimo gumb in mu določimo poslušalca
        addFileBtn = new JButton("Dodaj datoteko");
        addFileBtn.addActionListener(this);       

        // dodamo komponente za urejanje na površino
        editorPanel.add(nameLabel);
        editorPanel.add(nameText);
        editorPanel.add(contentLabel);
        editorPanel.add(contentText);
        editorPanel.add(addFileBtn);
    
        // ustvarimo model tabele, ki je definiran v razredu FilesTableModel,
        tableModel = new FilesTableModel();
        // ustvarimo tabelo
        table = new JTable(tableModel);

        // dodamo površino za urejanje in tabelo na root površino
        rootPanel.add(editorPanel, BorderLayout.LINE_START);
        rootPanel.add(new JScrollPane(table), BorderLayout.LINE_END);

        // dodamo toot površino v okno
        frame.add(rootPanel);

        // metoda ki okno prikaže
        frame.setVisible(true);

        // nastavimo velikost okna
        frame.setSize(800, 600);

        // nastavimo delovanje, tako da se ob zapiranju okna ustavi izvajanje aplikacije
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    // implementira metodo ki jo predpisuje vmesnik
    @Override
    public void actionPerformed(ActionEvent e) {
        // kreiramo objekt razreda datoteka z imenom ki je v tekstovnem polju za ime datoteke
        Datoteka file = new Datoteka(nameText.getText());      

        // odpremo datoteko, zapišemo vsebino iz vnosnega polja za vsebino in zapremo datoteko
        file.odpri();
        file.vpisiVsebino(contentText.getText());        
        file.zapri();

        // dodamo datoteko v tabelo
        tableModel.AddFile(file);

        // izbrišemo vsebino vnosnih polj
        nameText.setText("");
        contentText.setText("");
    }


}

