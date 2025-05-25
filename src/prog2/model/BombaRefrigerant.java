package prog2.model;
import prog2.vista.CentralUBException;

public class BombaRefrigerant implements InBombaRefrigerant{
    private int id;
    private boolean activat;
    private boolean foraDeServei=false;
    private VariableUniforme variableUniforme;
    private float capacitat=250;
    private float costOperatiu = 130;

    public BombaRefrigerant (VariableUniforme variableUniforme,int id) {
        this.id = id;
        this.variableUniforme = variableUniforme;
    }
    public BombaRefrigerant() {}

    @Override
    public int getId() { return id; }

    @Override
    public boolean getActivat() { return activat; }

    public void setActivat(boolean activat) { this.activat = activat; }

    @Override
    public boolean getForaDeServei() { return foraDeServei; }

    public void setForaDeServei(boolean foraDeServei) { this.foraDeServei = foraDeServei; }

    @Override
    public float getCapacitat() {
        if (getActivat()) {
            return capacitat;
        } else { return 0;}
    }

    @Override
    public float getCostOperatiu() {
        if (getActivat()) {
            return costOperatiu;
        } else { return 0;}
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
    public void revisa(PaginaIncidencies p) {
        if (getForaDeServei()) {
            return; // Si ja està fora de servei, no cal fer res
        }
        int numAleatori = variableUniforme.seguentValor();
        if (numAleatori > 75) {
            setForaDeServei(true);
            setActivat(false);
            p.afegeixIncidencia("La bomba "+ getId()+ " esta fora de servei");
        }
    }

    public String toString(){
        return "Id = " + getId() + ", Activat = " + getActivat() +
                ", ForaDeServei = " + getForaDeServei();
    }
}
