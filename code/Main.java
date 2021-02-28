
    import java.awt.EventQueue;

    /**
     * 
     * Berechnet die Tage von Geburt bis zum heutigen Datum. Heutiges Datum wird per
     * Button automatisch ausgegeben. Geburtstag wird eingegeben und auf Richtigkeit
     * verifiziert. Errechnete Tage werden ausgegeben
     * 
     * @author tom beyer
     * @version 3.0
     */
    public class Main {
    
        public static void main(String[] args) {
    
            EventQueue.invokeLater(new Runnable() {
                public void run() {
                    try {
                        GuiFrontend frame = new GuiFrontend();
                        frame.setVisible(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
    
        }
    }
      

