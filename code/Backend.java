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
    
    
    private String dateiname = "." + File.separator + "\\temp.txt";     
   
    
    public Backend () {
        
        
        
        
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
