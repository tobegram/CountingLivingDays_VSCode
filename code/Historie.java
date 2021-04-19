package code;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JList;

public class Historie extends JFrame {
    
    /*
     * Initialisieren der Variablen
     */
    private JFrame frameHistorie;
    protected JPanel contentPane; 
    protected JButton btnEnde; 
    private DefaultListModel<String> historieModel;
    private String  geburtstag,  heute, tageGezählt;
    
    
    /*
     * Setters and Getters
     */
    public String getGeburtstag() {
        return geburtstag;
    }
    public void setGeburtstag(String geburtstag) {
        this.geburtstag = geburtstag;
    }
    public String getHeute() {
        return heute;
    }
    public void setHeute(String heute) {
        this.heute = heute;
    }
    public String gettageGezählt() {
        return tageGezählt;
    }
    public void settagegezählt (String tagegezählt) {
        this.tageGezählt = tagegezählt;
    }




    public Historie () {
        setTitle("Historie");
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setBounds(100, 100, 358, 317);
        getContentPane().setLayout(null);
        
        contentPane = new JPanel();
        contentPane.setBackground(new Color(102, 205, 170));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        
        btnEnde = new JButton("Ende");
        btnEnde.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                GuiFrontend gf = new GuiFrontend();
                gf.lblInfoDatumVerifizieren.setVisible(true);
                gf.lblInfoVerifizierungOkay.setVisible(false);
                gf.lblInfoTageZaehlen.setVisible(false);
                gf.btnVerifizieren.setVisible(true);
                gf.btnTageZaehlen.setVisible(false);
                gf.lblAusgabeTage.setVisible(false);
                gf.txfAusgabe.setVisible(false);
                gf.btnHistorie.setVisible(true);
                gf.btnNochmal.setVisible(false);
                
                gf.txfGeburt.requestFocus();
                gf.txfGeburt.selectAll();
            }
        });
        btnEnde.setBounds(230, 230, 89, 23);
        contentPane.add(btnEnde);
        
        JLabel lblHistorie = new JLabel("Historie");
        lblHistorie.setHorizontalAlignment(SwingConstants.CENTER);
        lblHistorie.setBounds(75, 45, 168, 23);
        contentPane.add(lblHistorie);
        
                
        JList listHistorie = new JList();
        listHistorie.setBounds(33, 79, 279, 106);
        contentPane.add(listHistorie);
        listHistorie.setVisible(true);
        historieModel = new DefaultListModel<String>();
        listHistorie.setModel(historieModel);
        historieModel.addElement(geburtstag + "      " + 
                                 heute + "      "  +
                                    tageGezählt + "   Tage");
        
        
    }
}
