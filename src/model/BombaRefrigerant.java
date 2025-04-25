package model;

public class BombaRefrigerant implements InBombaRefrigerant{
    int Id;
    boolean Activat;
    boolean ForaDeServei;



    @Override
    public int getId() {
        return 0;
    }

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
    public boolean getForaDeServei() {
        return false;
    }

    @Override
    public float getCapacitat() {
        return 0;
    }

    @Override
    public float getCostOperatiu() {
        return 0;
    }
}
