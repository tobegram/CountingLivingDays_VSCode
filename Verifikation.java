 import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.*;
import javax.swing.JOptionPane;

public class Verifikation {

    /**
     * Methoden überprüfen die Richtigkeit des eingegebenen Datums.
     */

    private String regex1 = "^\\d{2}[\\.]\\d{2}[\\.]\\d{4}$";
    protected int tagGeburt, monatGeburt, jahrGeburt;
    private int[] normalJahr = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
    private int[] schaltJahr = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    public boolean datumVerifizieren(String eingabeGeburt) {
        if (datumSyntaxVerifizieren(eingabeGeburt) == true && datumMonateVerifizieren(eingabeGeburt) == true
                && datumTageVerifizieren(eingabeGeburt) == true && datumTagZukunft(eingabeGeburt) == true) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * Methode verifiziert die Syntax (tt.mm.yyyy)
     */
    public boolean datumSyntaxVerifizieren(String eingabeGeburt) {

        Pattern pt = Pattern.compile(regex1);
        Matcher mt = pt.matcher(eingabeGeburt);
        boolean result = mt.matches();

        if (result == true) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null,
                    "Verifikation fehlgeschlagen! \nDatumseingabe entspricht " + "nicht der Syntax dd.mm.yyyy",
                    "Fehler", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    /**
     * Methode verifiziert Richtigkeit der Monate.
     */
    public boolean datumMonateVerifizieren(String eingabeGeburt) {
        String[] split = eingabeGeburt.split("\\.");
        tagGeburt = Integer.parseInt(split[0]);
        monatGeburt = Integer.parseInt(split[1]);
        jahrGeburt = Integer.parseInt(split[2]);

        try {
            // Schaltjahr
            if ((jahrGeburt % 400) == 0 && monatGeburt > 0 && monatGeburt <= 12) {
                return true;
                // Normaljahr
            } else if ((jahrGeburt % 100) == 0 && monatGeburt > 0 && monatGeburt <= 12) {
                return true;
                // Schaltjahr
            } else if ((jahrGeburt % 4) == 0 && monatGeburt > 0 && monatGeburt <= 12) {
                return true;
                // Normaljahr
            } else if (monatGeburt > 0 && monatGeburt <= 12) {
                return true;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Verifikation fehlgeschlagen! " + "\nMonatseinghabe ist falsch!",
                    "Fehler", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return false;

    }

    /**
     * Methode verifiziert Richtigkeit der Tage. Tage müssen > 0 und <= max. Tag des
     * Monates sein.
     */
    public boolean datumTageVerifizieren(String eingabeGeburt) {
        String[] split = eingabeGeburt.split("\\.");
        tagGeburt = Integer.parseInt(split[0]);
        monatGeburt = Integer.parseInt(split[1]);
        jahrGeburt = Integer.parseInt(split[2]);

        try {
            // Schaltjahr
            if ((jahrGeburt % 400) == 0 && tagGeburt > 0 && tagGeburt <= (schaltJahr[monatGeburt - 1])) {
                return true;
                // Normaljahr
            } else if ((jahrGeburt % 100) == 0 && tagGeburt > 0 && tagGeburt <= (normalJahr[monatGeburt - 1])) {
                return true;
                // Schaltjahr
            } else if ((jahrGeburt % 4) == 0 && tagGeburt > 0 && tagGeburt <= (schaltJahr[monatGeburt - 1])) {
                return true;
                // Normaljahr
            } else if (tagGeburt > 0 && tagGeburt <= (normalJahr[monatGeburt - 1])) {
                return true;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Verifikation fehlgeschlagen! " + "\nTageseinghabe ist falsch!",
                    "Fehler", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return false;
    }

    /**
     * Methode verifiziert, dass das Datum nicht in der Zukunft liegt.
     */

    public boolean datumTagZukunft(String eingabeGeburt) {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate localDateHeute = LocalDate.now();
        LocalDate localDateGeburt = LocalDate.parse(eingabeGeburt, dtf);

        if (localDateGeburt.compareTo(localDateHeute) > 0) {
            JOptionPane.showMessageDialog(null, "Verifikation fehlgeschlagen! \nDatumseingabe liegt in der Zukunft",
                    "Fehler", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (localDateGeburt.compareTo(localDateHeute) == 0) {
            JOptionPane.showMessageDialog(null, "Verifikation fehlgeschlagen! \nDatumseingabe ist heute", "Fehler",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

}


