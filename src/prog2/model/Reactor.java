package prog2.model;
import prog2.vista.CentralUBException;

public class Reactor implements InComponent{
    private boolean activat;
    private float temperatura;

    public float getTemperatura() { return temperatura; }
    public void setTemperatura(float temperatura) { this.temperatura = temperatura; }
    public void setActivat(boolean activat) {
        this.activat = activat;
    }

    @Override
    public void activa() throws CentralUBException {
        if (getTemperatura() > 1000 ) {
            throw new CentralUBException("Temperatura superior a 1000 graus");
        } else {
            setActivat(true);
        }
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

    }

    @Override
    public float getCostOperatiu() {
        if (getActivat()){ return 35; } else { return 0; }
    }

    @Override
    public float calculaOutput(float input) {
        if (getActivat()) {
            return temperatura + (100 - input) * 10;
        } else {
            return temperatura;
        }
    }
}
