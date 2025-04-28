package prog2.model;
import prog2.vista.CentralUBException;
import java.util.ArrayList;

public class SistemaRefrigeracio implements InComponent {
    ArrayList<BombaRefrigerant> llistaBombes = new ArrayList();

    public void afegirBomba(BombaRefrigerant b) throws CentralUBException { llistaBombes.add(b); }

    @Override
    public void activa() throws CentralUBException {

    }

    @Override
    public void desactiva() {

    }

    @Override
    public boolean getActivat() {
        return false;
    }

    @Override
    public void revisa(PaginaIncidencies p) {

    }

    @Override
    public float getCostOperatiu() {
        return 0;
    }

    @Override
    public float calculaOutput(float input) {
        return 0;
    }
}
