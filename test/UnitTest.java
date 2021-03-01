package test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import code.Verifikation;
import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;





public class UnitTest {
  
    Verifikation test = new Verifikation();

    /**
     * Unittest für WAHR-Aussagen
     */
    @Test
    public void DatumTestenTrue() {
        assertTrue(test.datumSyntaxVerifizieren("20.05.1980"));
        assertTrue(test.datumTageVerifizieren("20.12.1980"));
        assertTrue(test.datumTageVerifizieren("01.01.1980"));
        assertTrue(test.datumTageVerifizieren("31.12.1980"));

    }

    /**
     * Unittest für FALSCH-Aussagen
     */
    @Test
    public void DatumTestenFalse() {
        LocalDate localDate = LocalDate.now().plusDays(1);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        // Syntax
        assertFalse(test.datumSyntaxVerifizieren("123.05.1980"));
        assertFalse(test.datumSyntaxVerifizieren("12.005.1980"));
        assertFalse(test.datumSyntaxVerifizieren("12.05.11980"));
        assertFalse(test.datumSyntaxVerifizieren("ab.05.1980"));
        assertFalse(test.datumSyntaxVerifizieren("12.ab.1980"));
        assertFalse(test.datumSyntaxVerifizieren("12.05.abcd"));
        assertFalse(test.datumSyntaxVerifizieren("12!12.2012"));
        assertFalse(test.datumSyntaxVerifizieren("12.12!2012"));
        assertTrue(test.datumSyntaxVerifizieren(dtf.format(localDate)));

        // Tage
        // assertFalse(test.datumTageVerifizieren("32.05.1980"));
        assertFalse(test.datumTageVerifizieren("00.05.1980"));
        // Monate
        assertFalse(test.datumMonateVerifizieren("12.13.1980"));
        // assertFalse(test.datumMonateVerifizieren("12.12.2021"));
        assertFalse(test.datumMonateVerifizieren("12.00.1980"));
        // assertFalse(test.datumMonateVerifizieren("12.12.0000"));
        // Zukunft
        // String datumHeute = heute.format(heute);
        assertFalse(test.datumTagZukunft(dtf.format(localDate)));
    }

}
