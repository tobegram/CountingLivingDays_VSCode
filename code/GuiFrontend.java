package code;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GuiFrontend extends JFrame {

    /*
     * Initialisieren der Variablen
     */
    private static final long serialVersionUID = 2820930589816760577L;
    protected JPanel contentPane;
    protected JTextField txfHeute, txfGeburt, txfAusgabe;
    protected JButton btnheute, btnVerifizieren, btnTageZaehlen, btnEnde, btnok, btnNochmal, btnSpeichern, btnHistorie;
    protected JLabel lblInfoTageZaehlen, lblInfoAllgemein, lblnfoDatumHeute, lblInfoDatumGeburt, lblAusgabeTage,
            lblInfoDatumVerifizieren, lblInfoVerifizierungOkay;
    protected int tagGeburt, monatGeburt, jahrGeburt;
    protected boolean korrekt1;
    

    /**
     * Erzeugen aller Objekte
     */
    Verifikation vn = new Verifikation();
    LocalDate heute = LocalDate.now();
    Backend bd = new Backend();
    Historie hist = new Historie();
    
    /**
     * Create the frame.
     */
    public GuiFrontend() {
        setTitle("Der Geburt-Tage-Rechner");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 523, 660);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(102, 205, 170));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        initComponents();

        getContentPane().add(btnEnde);
        getContentPane().add(btnheute);
        getContentPane().add(txfGeburt);
        getContentPane().add(txfHeute);
        getContentPane().add(btnVerifizieren);
        getContentPane().add(btnTageZaehlen);
        getContentPane().add(lblnfoDatumHeute);
        getContentPane().add(lblInfoDatumGeburt);
        getContentPane().add(lblInfoDatumVerifizieren);
        getContentPane().add(lblAusgabeTage);
        getContentPane().add(lblInfoTageZaehlen);
        getContentPane().add(lblInfoAllgemein);
        getContentPane().add(btnok);
        getContentPane().add(txfAusgabe);
        getContentPane().add(lblInfoVerifizierungOkay);
        getContentPane().add(btnNochmal);
        getContentPane().add(btnSpeichern);
        getContentPane().add(btnHistorie);
        
        
    }

    private void initComponents() {

        /*
         * Labels > alle zusammengefasst
         */
        // Visible(true)
        lblInfoAllgemein = new JLabel();
        lblInfoAllgemein.setText(
                "<html>Hallo!\r<br/> \r\n\r<br/>\r\nIch bin ein kleines Programm, welches die Tage seit Deiner Geburt bis heute errechnet. \r<br/>\r\n\r<br/>\r\nProbier mich doch einfach aus!<html>");
        lblInfoAllgemein.setToolTipText("");
        lblInfoAllgemein.setVerticalAlignment(SwingConstants.TOP);
        lblInfoAllgemein.setBounds(10, 11, 286, 84);
        // Visible(false)
        lblnfoDatumHeute = new JLabel("Bitte drück den Button \"heutiges Datum\"!");
        lblnfoDatumHeute.setBounds(10, 106, 359, 23);
        lblnfoDatumHeute.setVisible(false);
        // Visible(false)
        lblInfoDatumGeburt = new JLabel("Bitte gib im nächsten Feld Deinen Geburtstag ein!");
        lblInfoDatumGeburt.setBounds(10, 167, 359, 23);
        lblInfoDatumGeburt.setVisible(false);
        // Visible(false)
        lblInfoDatumVerifizieren = new JLabel(
                "<html> Mit dem Button \"Datum verifizieren\" wird \u00FCberpr\u00FCft, ob Dein eingegebener\r<br/>Geburtstag im Kalender zu finden ist.<html>");
        lblInfoDatumVerifizieren.setVerticalAlignment(SwingConstants.TOP);
        lblInfoDatumVerifizieren.setBounds(10, 227, 445, 47);
        lblInfoDatumVerifizieren.setVisible(false);
        // Visible(false)
        lblAusgabeTage = new JLabel("Tage bist Du auf dieser Erde!");
        lblAusgabeTage.setBounds(76, 435, 166, 23);
        lblAusgabeTage.setVisible(false);
        // Visible(false)
        lblInfoTageZaehlen = new JLabel(
                "Bitte dr\u00FCck nun den Button \"Tage z\u00E4hlen\" und die Tage werden errechnet.");
        lblInfoTageZaehlen.setBounds(10, 338, 445, 23);
        lblInfoTageZaehlen.setVisible(false);
        // Visible(false)
        lblInfoVerifizierungOkay = new JLabel("Die Verifizierung ist abgeschlossen! ");
        lblInfoVerifizierungOkay.setBounds(10, 304, 408, 23);
        lblInfoVerifizierungOkay.setVisible(false);

        /*
         * Button okay > Lässt den nächsten Schritt erscheinen (visible)
         */
        btnok = new JButton("Okay");
        btnok.setBounds(305, 76, 90, 23);
        btnok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lblnfoDatumHeute.setVisible(true);
                lblInfoDatumGeburt.setVisible(true);
                lblInfoDatumVerifizieren.setVisible(true);
                txfGeburt.setVisible(true);
                txfHeute.setVisible(true);
                btnheute.setVisible(true);
                btnVerifizieren.setVisible(true);
            }
        });

        /*
         * Button heute
         * Beim Klicken des Button btnheute wird das aktuelle Datum im Textfeld txfheute ausgegeben
         */
        btnheute = new JButton("heutiges Datum");
        btnheute.setBounds(92, 140, 150, 23);
        btnheute.setVisible(false);
        btnheute.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                datumHeuteAusgeben();
            }
        });

        /*
         * Button Ende
         *  Beim Klicken des Button btnEnde wird das Hauptfenster geschlossen und das Programm beendet.
         */
        btnEnde = new JButton("Exit");
        btnEnde.setForeground(new Color(0, 0, 0));
        btnEnde.setBackground(new Color(0, 128, 0));
        btnEnde.setBounds(394, 587, 103, 23);
        btnEnde.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        /*
         * Button Nochmal
         * Beim Klicken des Button btnNochmal wird eine temporäre Textdatei erstellt und die Parameter
         * DatemHeute, DatumGeburtstag, Errechnete Tage gespeichert.
         * Alle Parameter werden im Fenster genullt und es kann eine neue Eingabe vorgenommen werden.
         */
        btnNochmal = new JButton("Nochmal!");
        btnNochmal.setBounds(252, 435, 89, 23);
        btnNochmal.setVisible(false);
        btnNochmal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lblInfoDatumVerifizieren.setVisible(true);
                lblInfoVerifizierungOkay.setVisible(false);
                lblInfoTageZaehlen.setVisible(false);
                btnVerifizieren.setVisible(true);
                btnTageZaehlen.setVisible(false);
                lblAusgabeTage.setVisible(false);
                txfAusgabe.setVisible(false);
                btnHistorie.setVisible(true);
                btnNochmal.setVisible(false);
                txfGeburt.requestFocus();
                txfGeburt.selectAll();
                
                
                try {
                    
                    bd.zwischenSpeichern(txfGeburt.getText(), txfHeute.getText(), txfAusgabe.getText());
                } catch (Exception e2) {
                    e2.getStackTrace();
                }
                
                
            }
        });
        
        /*
         * Button Speichern
         */
        btnSpeichern = new JButton("Speichern");
        btnSpeichern.setBounds(394, 475, 103, 23);
        btnSpeichern.setVisible(false);
        btnSpeichern.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Backend bd = new Backend();
                bd.speichern();
            }
        });
        
        /*
         * Button Historie
         * Beim Klicken des Button btnHistorie erscheint ein neues Fenster mit einer Liste 
         * der eingegeben Parameter Datumheute, DatumGeburtstag, Errechnete Tage.
         */
        btnHistorie = new JButton ("Historie");
        btnHistorie.setBounds(252, 475, 89, 23);
        btnHistorie.setVisible(false);
        btnHistorie.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                hist.setGeburtstag(txfGeburt.getText());
                hist.setHeute(txfHeute.getText());
                hist.settagegezählt(txfAusgabe.getText());
                try {
                    
                   hist.setVisible(true);
                } catch (Exception e2) {
                e2.printStackTrace();
                  }
            }
        });
        
        /*
         * Textfeld heute
         */
        txfHeute = new JTextField();
        txfHeute.setHorizontalAlignment(SwingConstants.CENTER);
        txfHeute.setBounds(308, 140, 90, 23);
        txfHeute.setColumns(10);
        txfHeute.setVisible(false);

        /*
         * Textfeld Geburtstag
         */
        txfGeburt = new JTextField();
        txfGeburt.setHorizontalAlignment(SwingConstants.CENTER);
        txfGeburt.setFont(new Font("Tahoma", Font.ITALIC, 11));
        txfGeburt.setText("tt.mm.jjjj");
        txfGeburt.setBounds(308, 193, 90, 23);
        txfGeburt.setColumns(10);
        txfGeburt.setVisible(false);
        txfGeburt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    datumverifizieren();
                }
            }
        });
        txfGeburt.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                txfGeburt.selectAll();
            }
        });
        /*
         * Button Verifizieren
         */
        btnVerifizieren = new JButton("Datum verifizieren");
        btnVerifizieren.setBounds(92, 270, 150, 23);
        btnVerifizieren.setVisible(false);
        btnVerifizieren.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent enter) {
                datumverifizieren();
                
            }
       });

        /*
         * Button Tage berechnen
         */
        btnTageZaehlen = new JButton("Tage z\u00E4hlen");
        btnTageZaehlen.setBounds(92, 383, 150, 23);
        btnTageZaehlen.setVisible(false);
        btnTageZaehlen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
             tageZaehlen();
            }
        });
        

        /*
         * Textfeld Ausgabe
         */
        txfAusgabe = new JTextField();
        txfAusgabe.setHorizontalAlignment(SwingConstants.CENTER);
        txfAusgabe.setFont(new Font("Tahoma", Font.BOLD, 11));
        txfAusgabe.setBounds(10, 436, 56, 20);
        txfAusgabe.setColumns(10);
        txfAusgabe.setVisible(false);

    }

    /**
     * Methode Datum Verifizieren Hauptmethode für die Verifikation des eingegebenen
     * Geburtstages. Die Methode wird in dieser Klasse nur aufgerufen. Es gibt eine
     * eigene Verifikationsklasse, um dass Datum zu prüfen.
     */
     private void datumverifizieren() {
        if (vn.datumVerifizieren(txfGeburt.getText()) == true) {
            btnVerifizieren.setVisible(false);
            btnTageZaehlen.setVisible(true);
            lblInfoVerifizierungOkay.setVisible(true);
            lblInfoTageZaehlen.setVisible(true);
            btnTageZaehlen.requestFocus();
            btnTageZaehlen.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                        tageZaehlen();
                    }
                }
                
            });
        } else {
            txfGeburt.requestFocus();
            txfGeburt.selectAll();
        }
    }

    /**
     * Methode, um das heutige Datum auszugeben
     */
     private void datumHeuteAusgeben() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String datumHeute = dtf.format(heute);
        txfHeute.setText(datumHeute);
        txfGeburt.requestFocus();
        txfGeburt.selectAll();
    }

    /**
     * Methode für die Berechnung der Tage zwischen Geburt und Heute
     */
    private void tageZaehlen() {
        LocalDate geburt = LocalDate.of(vn.jahrGeburt, vn.monatGeburt, vn.tagGeburt);
        long dauer = ChronoUnit.DAYS.between(geburt, heute);
        txfAusgabe.setVisible(true);
        txfAusgabe.setText("" + dauer);
        lblAusgabeTage.setVisible(true);
        btnNochmal.setVisible(true);
        txfGeburt.requestFocus();
        txfGeburt.selectAll();
        btnVerifizieren.setVisible(true);
        btnTageZaehlen.setVisible(false);
        btnSpeichern.setVisible(true);

    }
}
