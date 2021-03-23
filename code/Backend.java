package code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.colorchooser.*;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JList;
import javax.swing.JPanel;

public class Backend extends JFrame {
    
    protected JPanel contentPane;
    private String dateiname = "." + File.separator + "\\temp.txt";     
   
    
    public Backend () {
        setTitle("Historie");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(600, 100, 300, 200);
        setVisible(true);
        setResizable(false);
        
        contentPane = new JPanel();
        contentPane.setBackground(new Color(102, 205, 170));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        
        
        //JList list = new JList();
       
    }
    
    
    public void zwischenSpeichern (String geburt, String heute, String tage) {
        try {
            
            
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    

    }
    
    
    public void speichern () {
        
        File datei = new File(dateiname);
        BufferedReader in = null;
            if(!datei.exists())
        {
            try {
                datei.createNewFile();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    
            
            
            
     }  
    
}
