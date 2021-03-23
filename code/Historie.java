package code;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class Historie  {
    
    private JFrame frame;
    protected JPanel contentPane; 
    protected JButton btnEnde; 
    private JTextArea taListe;
    private JScrollPane sclListe;
    
    public Historie () {
        JFrame frame = new JFrame();
        frame.setTitle("Historie");
        frame.setBounds(600, 100, 300, 200);
        frame.setVisible(true);
        frame.setResizable(false);
        
        
        contentPane = new JPanel();
        contentPane.setBackground(new Color(102, 205, 170));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        frame.setContentPane(contentPane);
        contentPane.setLayout(null);
        
        btnEnde = new JButton("Ende");
        btnEnde.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setDefaultCloseOperation(0);
            }
        });
        btnEnde.setBounds(185, 127, 89, 23);
        contentPane.add(btnEnde);
        
        taListe = new JTextArea();
        taListe.setBounds(10, 25, 235, 91);
        contentPane.add(taListe);
        taListe.setVisible(true);
        taListe.setLineWrap(true);
        sclListe = new JScrollPane(taListe);
        sclListe.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
        
    }
}
