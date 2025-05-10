package prog2.test;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;
import prog2.model.BombaRefrigerant;
import prog2.model.PaginaIncidencies;
import prog2.model.VariableUniforme;
import prog2.vista.CentralUBException;

import static org.junit.jupiter.api.Assertions.*;

public class BombaRefrigerantTest {

    private BombaRefrigerant bomba;

    @BeforeEach
    void setUp() {
        VariableUniforme variable = new VariableUniforme(50);
        bomba = new BombaRefrigerant(variable, 1);
    }

    @Test
    void getId() {
        assertEquals(1, bomba.getId());
    }

    @Test
    void getActivat() {
        assertFalse(bomba.getActivat());
    }

    @Test
    void setActivat() {
        bomba.setActivat(true);
        assertTrue(bomba.getActivat());

        bomba.setActivat(false);
        assertFalse(bomba.getActivat());
    }

    @Test
    void getForaDeServei() {
        assertFalse(bomba.getForaDeServei());
    }

    @Test
    void setForaDeServei() {
        bomba.setForaDeServei(true);
        assertTrue(bomba.getForaDeServei());

        bomba.setForaDeServei(false);
        assertFalse(bomba.getForaDeServei());
    }

    @Test
    void getCapacitat() {
        bomba.setActivat(true);
        bomba.getCapacitat();
        assertEquals(50f, bomba.getCapacitat());

        bomba.setActivat(false);
        assertEquals(0f, bomba.getCapacitat());
    }

    @Test
    void getCostOperatiu() {
        bomba.setActivat(true);
        bomba.getCostOperatiu();
        assertEquals(130f, bomba.getCostOperatiu());

        bomba.setActivat(false);
        assertEquals(0f, bomba.getCostOperatiu());
    }

    @Test
    void activa() throws CentralUBException {
        bomba.activa();
        assertTrue(bomba.getActivat());
    }

    @Test
    void desactiva() {
        bomba.setActivat(true);
        bomba.desactiva();
        assertFalse(bomba.getActivat());
    }

    @Test
    void revisa() {
        bomba.setForaDeServei(false);
        bomba.revisa(new PaginaIncidencies(1)); // No hauria de fallar

        assertFalse(bomba.getForaDeServei());

        // Simulem una fallada revisant
        VariableUniforme variableAlta = new VariableUniforme(100); // Sempre > 75
        BombaRefrigerant bombaFalla = new BombaRefrigerant(variableAlta, 2);
        bombaFalla.revisa(new PaginaIncidencies(2));

        assertTrue(bombaFalla.getForaDeServei());
    }

    @Test
    void testToString() {
        bomba.setActivat(true);
        bomba.setForaDeServei(true);

        String resultat = bomba.toString();

        assertTrue(resultat.contains("Id = 1"));
        assertTrue(resultat.contains("Activat = true"));
        assertTrue(resultat.contains("ForaDeServei = true"));
    }
}
