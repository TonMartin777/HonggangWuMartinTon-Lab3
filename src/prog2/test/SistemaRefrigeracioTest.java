package prog2.test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import prog2.model.BombaRefrigerant;
import prog2.model.SistemaRefrigeracio;
import prog2.model.VariableUniforme;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SistemaRefrigeracioTest {
    private SistemaRefrigeracio sistemaRefrigeracio;

    @BeforeEach
    void setUp() { sistemaRefrigeracio = new SistemaRefrigeracio(); }

    @Test
    void afegirBomba() {
        BombaRefrigerant bomba = new BombaRefrigerant();
        sistemaRefrigeracio.afegirBomba(bomba);
        assertEquals(1, sistemaRefrigeracio.getLlistaBombes().size());
        assertTrue(sistemaRefrigeracio.getLlistaBombes().contains(bomba));
    }

    @Test
    void activa() {
        sistemaRefrigeracio.activa();
        assertTrue(sistemaRefrigeracio.getActivat());
    }

    @Test
    void getLlistaBombes() {
        sistemaRefrigeracio.afegirBomba(new BombaRefrigerant());
        List<BombaRefrigerant> llistaEsperada = sistemaRefrigeracio.getLlistaBombes();
        assertEquals(llistaEsperada, sistemaRefrigeracio.getLlistaBombes());
    }
}