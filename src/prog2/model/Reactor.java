package prog2.model;
import prog2.vista.CentralUBException;

public class Reactor implements InComponent{
    private boolean activat;
    private float temperatura;

    public float getTemperatura() { return temperatura; }
    public void setTemperatura(float temperatura) { this.temperatura = temperatura; }
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
    public float getCostOperatiu() { return 35; }

    @Override
    public float calculaOutput(float input) {
        if (getActivat()) {
            return temperatura + (100 - input) * 10;
        } else {
            return temperatura;
        }
    }
}
