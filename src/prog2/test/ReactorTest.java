package prog2.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import prog2.model.PaginaIncidencies;
import prog2.model.Reactor;
import prog2.vista.CentralUBException;

class ReactorTest {

    private Reactor reactor;

    @BeforeEach
    void setUp() {
        reactor = new Reactor();
    }

    @Test
    void getTemperatura() {
        reactor.setTemperatura(750);
        assertEquals(750f, reactor.getTemperatura());
    }

    @Test
    void setTemperatura() {
        reactor.setTemperatura(500);
        assertEquals(500f, reactor.getTemperatura());

        reactor.setTemperatura(1200);
        assertEquals(1200f, reactor.getTemperatura());
    }

    @Test
    void setActivat() {
        reactor.setActivat(true);
        assertTrue(reactor.getActivat());

        reactor.setActivat(false);
        assertFalse(reactor.getActivat());
    }

    @Test
    void activaCorrectament() throws CentralUBException {
        reactor.setTemperatura(900);
        reactor.activa();
        assertTrue(reactor.getActivat());

        reactor.setTemperatura(1200);
        CentralUBException e = assertThrows(CentralUBException.class, () -> reactor.activa());
        assertEquals("Temperatura superior a 1000 graus", e.getMessage());
        assertFalse(reactor.getActivat());
    }

    @Test
    void desactiva() {
        reactor.setActivat(true);
        reactor.desactiva();
        assertFalse(reactor.getActivat());
    }

    @Test
    void getActivat() {
        assertFalse(reactor.getActivat());
        reactor.setActivat(true);
        assertTrue(reactor.getActivat());
    }

    @Test
    void revisa() {
        reactor.setTemperatura(800);
        PaginaIncidencies p = new PaginaIncidencies(1);
        reactor.revisa(p);
        assertEquals(0, p.getIncidencies().size());
    }

    @Test
    void getCostOperatiu() {
        reactor.setActivat(false);
        assertEquals(0f, reactor.getCostOperatiu());

        reactor.setActivat(true);
        assertEquals(35f, reactor.getCostOperatiu());
    }

    @Test
    void calculaOutput() {
        reactor.setTemperatura(500);
        reactor.setActivat(false);
        assertEquals(500f, reactor.calculaOutput(80));

        reactor.setTemperatura(600);
        reactor.setActivat(true);
        float resultat = reactor.calculaOutput(90);  // (100 - 90) * 10 = 100
        assertEquals(700f, resultat);
    }
}
