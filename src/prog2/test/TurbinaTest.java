package prog2.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import prog2.model.PaginaIncidencies;
import prog2.model.Turbina;
import prog2.vista.CentralUBException;

class TurbinaTest {

    private Turbina turbina;

    @BeforeEach
    void setUp() {
        turbina = new Turbina();
    }

    @Test
    void setActivat() {
        turbina.setActivat(true);
        assertTrue(turbina.getActivat());

        turbina.setActivat(false);
        assertFalse(turbina.getActivat());
    }

    @Test
    void activa() throws CentralUBException {
        turbina.activa();
        assertTrue(turbina.getActivat());
    }

    @Test
    void desactiva() {
        turbina.setActivat(true);
        turbina.desactiva();
        assertFalse(turbina.getActivat());
    }

    @Test
    void getActivat() {
        assertFalse(turbina.getActivat());

        turbina.setActivat(true);
        assertTrue(turbina.getActivat());
    }

    @Test
    void revisa() {
        // Com que no fa res, només comprovem que no llença excepcions
        assertDoesNotThrow(() -> turbina.revisa(new PaginaIncidencies(1)));
    }

    @Test
    void getCostOperatiu() {
        turbina.setActivat(false);
        assertEquals(0f, turbina.getCostOperatiu());

        turbina.setActivat(true);
        assertEquals(20f, turbina.getCostOperatiu());
    }

    @Test
    void calculaOutput() {
        turbina.setActivat(false);
        assertEquals(0f, turbina.calculaOutput(150));
        assertEquals(0f, turbina.calculaOutput(50));

        turbina.setActivat(true);
        assertEquals(0f, turbina.calculaOutput(99));

        assertEquals(200f, turbina.calculaOutput(100));
        assertEquals(300f, turbina.calculaOutput(150));
    }
}
