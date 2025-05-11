package prog2.model;
import prog2.vista.CentralUBException;
import java.util.ArrayList;

public class SistemaRefrigeracio implements InComponent {
    private boolean activat;
    ArrayList<BombaRefrigerant> llistaBombes = new ArrayList();

    public SistemaRefrigeracio() {
        this.activat = true;
        this.llistaBombes = new ArrayList<>();
    }
    public void afegirBomba(BombaRefrigerant bomba) throws CentralUBException { llistaBombes.add(bomba); }

    @Override
    public void activa() throws CentralUBException {
        for (BombaRefrigerant b : llistaBombes) {
            if (!b.getForaDeServei()){
                b.setActivat(true);
            }
        }
    }

    public ArrayList<BombaRefrigerant> getLlistaBombes() { return llistaBombes; }

    @Override
    public void desactiva() {
        for (BombaRefrigerant b : llistaBombes) {
            b.setActivat(false);
        }
    }

    @Override
    public boolean getActivat() { return activat; }

    @Override
    public void revisa(PaginaIncidencies p) {
        for (BombaRefrigerant b : llistaBombes) {
            b.revisa(p);
        }
    }

    @Override
    public float getCostOperatiu() {
        int n = 0;
        for (BombaRefrigerant b : llistaBombes) {
            if (b.getActivat()){
                n++;
            }
        }
        return 130 * n;
    }

    @Override
    public float calculaOutput(float input) {
        int n = 0;
        for (BombaRefrigerant b : llistaBombes) {
            if (b.getActivat()){
                n++;
            }
        }
        return Math.min(input, 250 * n);
    }
}