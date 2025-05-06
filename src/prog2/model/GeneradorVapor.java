package prog2.model;
import prog2.vista.CentralUBException;

public class GeneradorVapor implements InComponent{
    private boolean activat;

    public void setActivat(boolean activat) {
        this.activat = activat;
    }

    @Override
    public void activa() throws CentralUBException {
        setActivat(true);
    }

    @Override
    public void desactiva() {
        setActivat(false);
    }

    @Override
    public boolean getActivat() {
        return activat;
    }

    @Override
    public void revisa(PaginaIncidencies p) {
        // Aquesta clase no llença incidencies.
    }

    @Override
    public float getCostOperatiu() {
        if (getActivat()) {return 25;} else {return 0;}
    }

    @Override
    public float calculaOutput(float input) {
        if (getActivat()){
            return input * 0.9f;
        } else {
            return 25;
        }
    }
}
