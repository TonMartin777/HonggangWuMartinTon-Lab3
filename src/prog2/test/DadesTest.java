package prog2.test;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import prog2.model.Bitacola;
import prog2.model.Dades;
import prog2.vista.CentralUBException;

import static org.junit.jupiter.api.Assertions.*;

public class DadesTest {

    private Dades dades;

    @BeforeEach
    void setUp() {
        dades = new Dades();
    }

    @Test
    void testGetInsercioBarresInicial() {
        assertEquals(100f, dades.getInsercioBarres());
    }

    @Test
    void testSetInsercioBarresValid() throws CentralUBException {
        dades.setInsercioBarres(50f);
        assertEquals(50f, dades.getInsercioBarres());
    }

    @Test
    void testSetInsercioBarresInvalidBaix() {
        assertThrows(CentralUBException.class, () -> dades.setInsercioBarres(-10));
    }

    @Test
    void testSetInsercioBarresInvalidAlt() {
        assertThrows(CentralUBException.class, () -> dades.setInsercioBarres(110));
    }

    @Test
    void testActivaReactorValid() throws CentralUBException {
        dades.mostraReactor().setTemperatura(500);
        dades.activaReactor();
        assertTrue(dades.mostraReactor().getActivat());
    }

    @Test
    void testActivaReactorExcepcio() {
        dades.mostraReactor().setTemperatura(1200);
        assertThrows(CentralUBException.class, () -> dades.activaReactor());
    }

    @Test
    void testDesactivaReactor() {
        dades.mostraReactor().setActivat(true);
        dades.desactivaReactor();
        assertFalse(dades.mostraReactor().getActivat());
    }

    @Test
    void testActivaDesactivaBomba() throws CentralUBException {
        dades.activaBomba(1);
        assertTrue(dades.mostraSistemaRefrigeracio().getLlistaBombes().get(1).getActivat());

        dades.desactivaBomba(1);
        assertFalse(dades.mostraSistemaRefrigeracio().getLlistaBombes().get(1).getActivat());
    }

    @Test
    void testActivaBombaForaDeServei() {
        dades.mostraSistemaRefrigeracio().getLlistaBombes().get(2).setForaDeServei(true);
        assertThrows(CentralUBException.class, () -> dades.activaBomba(2));
    }

    @Test
    void testCalculaPotencia() {
        float potencia = dades.calculaPotencia();
        assertTrue(potencia >= 0);
    }

    @Test
    void testGetGuanysAcumulats() {
        assertEquals(0f, dades.getGuanysAcumulats());
    }

    @Test
    void testMostraEstat() {
        assertNotNull(dades.mostraEstat());
    }

    @Test
    void testMostraBitacola() {
        assertNotNull(dades.mostraBitacola());
    }

    @Test
    void testMostraIncidencies() {
        assertNotNull(dades.mostraIncidencies());
        assertTrue(dades.mostraIncidencies().isEmpty());
    }

    @Test
    void testFinalitzaDia() {
        Bitacola resultat = dades.finalitzaDia(150);
        assertNotNull(resultat);
    }
}
