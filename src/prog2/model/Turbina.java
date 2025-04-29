package prog2.model;
import prog2.vista.CentralUBException;

public class Turbina implements InComponent{
    private boolean activat;

    @Override
    public void activa() throws CentralUBException {

    }

    @Override
    public void desactiva() {

    }

    @Override
    public boolean getActivat() {
        return activat;
    }

    @Override
    public void revisa(PaginaIncidencies p) {

    }

    @Override
    public float getCostOperatiu() { return 20; }

    @Override
    public float calculaOutput(float input) {
        if (activat) {
            if (input < 100) {
                return 0;
            } else {
                return input * 2;
            }
        } else {
            return 0;
        }
    }
}
