package prog2.model;
import prog2.vista.CentralUBException;

public class BombaRefrigerant implements InBombaRefrigerant{
    private int id;
    private boolean activat;
    private boolean foraDeServei;


    public BombaRefrigerant (int id, boolean activat, boolean foraDeServei) {
        this.id = id;
        this.activat = activat;
        this.foraDeServei = foraDeServei;
    }

    @Override
    public int getId() { return id; }

    @Override
    public boolean getActivat() { return activat; }

    public void setActivat(boolean activat) { this.activat = activat; }

    @Override
    public boolean getForaDeServei() { return foraDeServei; }

    @Override
    public float getCapacitat() {
        return 0;
    }

    @Override
    public float getCostOperatiu() {
        return 0;
    }

    @Override
    public void activa() throws CentralUBException {

    }

    @Override
    public void desactiva() {

    }

    @Override
    public void revisa(PaginaIncidencies p) {

    }
}
