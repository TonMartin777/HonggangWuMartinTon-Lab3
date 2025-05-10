package prog2.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import prog2.model.Bitacola;
import prog2.model.PaginaBitacola;
import prog2.model.PaginaIncidencies;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BitacolaTest {

    Bitacola bitacola;

    @BeforeEach
    void setUp() {
        bitacola = new Bitacola();
    }

    @Test
    void afegeixPagina() {
        PaginaBitacola pagina = new PaginaIncidencies(1);
        bitacola.afegeixPagina(pagina);

        String result = bitacola.toString();
        assertTrue(result.contains("1"));
    }

    @Test
    void getIncidencies() {
        PaginaBitacola p1 = new PaginaIncidencies(1);
        PaginaBitacola p2 = new PaginaIncidencies(2);

        bitacola.afegeixPagina(p1);
        bitacola.afegeixPagina(p2);

        List<PaginaIncidencies> incidencies = bitacola.getIncidencies();

        assertEquals(2, incidencies.size());
    }

    @Test
    void testToString() {
        bitacola.afegeixPagina(new PaginaIncidencies(1));
        bitacola.afegeixPagina(new PaginaIncidencies(2));

        String resultat = bitacola.toString();
        assertTrue(resultat.contains("1"));
        assertTrue(resultat.contains("2"));
    }
}