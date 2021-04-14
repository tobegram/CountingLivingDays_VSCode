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
    
    private JFrame frameHistorie;
    protected JPanel contentPane; 
    protected JButton btnEnde; 
    private DefaultListModel<String> historieModel;
    
    
    public Historie (String geburtstag, String heute, String tageGezählt) {
        setTitle("Historie");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
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
                System.exit(0);
            }
        });
        btnEnde.setBounds(230, 230, 89, 23);
        contentPane.add(btnEnde);
        
        JLabel lblHistorie = new JLabel("Historie");
        lblHistorie.setHorizontalAlignment(SwingConstants.CENTER);
        lblHistorie.setBounds(75, 45, 168, 23);
        contentPane.add(lblHistorie);
        
        JList listHistorie = new JList();
        listHistorie.setForeground(Color.WHITE);
        listHistorie.setBackground(Color.WHITE);
        listHistorie.setBounds(327, 90, -297, 68);
        contentPane.add(listHistorie);
        listHistorie.setVisible(true);
        
        historieModel = new DefaultListModel<String>();
        historieModel.addElement(geburtstag + "      " + 
                                 heute + "      "  +
                                    tageGezählt);
        
        
    }
}
