package prog2.model;

public class PaginaEconomica extends PaginaBitacola{

    private float demandaPotencia;
    private float potenciaGenerada;
    private float percentatgePotenciaStisfeta;
    private float beneficis;
    private float penalitzacio;
    private float costOperatiu;
    private float guanysAcumulats;

    public PaginaEconomica(int dia, float demandaPotencia, float potenciaGenerada, float percentatgePotenciaStisfeta,
                           float beneficis, float penalitzacio, float costOperatiu, float guanysAcumulats){
        super(dia);
        this.demandaPotencia=demandaPotencia;
        this.potenciaGenerada=potenciaGenerada;
        this.percentatgePotenciaStisfeta=percentatgePotenciaStisfeta;
        this.beneficis=beneficis;
        this.penalitzacio=penalitzacio;
        this.costOperatiu=costOperatiu;
        this.guanysAcumulats=guanysAcumulats;

    }

    @Override
    public int getDia() {return super.getDia();}
    public float getDemandaPotencia() {return demandaPotencia;}
    public float getPotenciaGenerada() {return potenciaGenerada;}
    public float getPercentatgePotenciaStisfeta() {return percentatgePotenciaStisfeta;}
    public float getBeneficis() {return beneficis;}
    public float getPenalitzacio() {return penalitzacio;}
    public float getCostOperatiu() {return costOperatiu;}
    public float getGuanysAcumulats() {return guanysAcumulats;}

    @Override
    public String toString() {
        return "# Pàgina Econòmica\n"+
                "- Dia: " +getDia()+ "\n" +
                "- Demanda de Potència: " + getDemandaPotencia() + "\n" +
                "- Potència Generada: " + getPotenciaGenerada() + "\n" +
                "- Demanda de Potència Satisfeta: "+ getPercentatgePotenciaStisfeta() + " %" + "\n" +
                "- Beneficis: " + getBeneficis() + " Unitats Econòmiques" + "\n" +
                "- Penalització Excés Producció: " + getPenalitzacio() + " Unitats Econòmiques" + "\n" +
                "- Cost Operatiu: " + getCostOperatiu() +  " Unitats Econòmiques" + "\n" +
                "- Guanys acumulats: " + getGuanysAcumulats() + " Unitats Econòmiques" + "\n";
    }
}