package prog2.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import prog2.model.GeneradorVapor;
import prog2.model.PaginaIncidencies;
import prog2.vista.CentralUBException;

class GeneradorVaporTest {

    private GeneradorVapor generador;

    @BeforeEach
    void setUp() {
        generador = new GeneradorVapor();
    }

    @Test
    void setActivat() {
        generador.setActivat(true);
        assertTrue(generador.getActivat());

        generador.setActivat(false);
        assertFalse(generador.getActivat());
    }

    @Test
    void activa() throws CentralUBException {
        generador.activa();
        assertTrue(generador.getActivat());
    }

    @Test
    void desactiva() {
        generador.setActivat(true);
        generador.desactiva();
        assertFalse(generador.getActivat());
    }

    @Test
    void getActivat() {
        assertFalse(generador.getActivat());
        generador.setActivat(true);
        assertTrue(generador.getActivat());
    }

    @Test
    void revisa() {
        PaginaIncidencies p = new PaginaIncidencies(1);
        generador.revisa(p);
        assertEquals(0, p.getIncidencies().size());
    }

    @Test
    void getCostOperatiuDesactivat() {
        generador.setActivat(false);
        assertEquals(0f, generador.getCostOperatiu());
    }

    @Test
    void getCostOperatiuActivat() {
        generador.setActivat(true);
        assertEquals(25f, generador.getCostOperatiu());
    }

    @Test
    void calculaOutputDesactivat() {
        generador.setActivat(false);
        assertEquals(25f, generador.calculaOutput(100));
    }

    @Test
    void calculaOutputActivat() {
        generador.setActivat(true);
        assertEquals(90f, generador.calculaOutput(100f));
        assertEquals(45f, generador.calculaOutput(50f));
    }
}
