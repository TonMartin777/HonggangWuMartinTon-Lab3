package prog2.model;
import prog2.vista.CentralUBException;

public class GeneradorVapor implements InComponent{
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
    public float getCostOperatiu() { return 25; }

    @Override
    public float calculaOutput(float input) {
        if (getActivat()){
            return input * 0.9f;
        } else {
            return 25;
        }
    }
}
