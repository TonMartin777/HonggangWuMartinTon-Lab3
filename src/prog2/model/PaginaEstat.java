package prog2.model;

public class PaginaEstat extends PaginaBitacola {
    private float insercioBarres;
    private float outputReactor;
    private float outputSistemaRefrigeracio;
    private float outputGeneradorVapor;
    private float outputTurbina;

    public PaginaEstat(int dia,float insercioBarres, float outputReactor,float outputSistemaRefrigeracio,
                       float outputGeneradorVapor, float outputTurbina){
        super(dia);
        this.insercioBarres=insercioBarres;
        this.outputReactor=outputReactor;
        this.outputSistemaRefrigeracio=outputSistemaRefrigeracio;
        this.outputGeneradorVapor=outputGeneradorVapor;
        this.outputTurbina=outputTurbina;
    }

    public float getInsercioBarres() {return insercioBarres;}
    public float getOutputReactor() {return outputReactor;}
    public float getOutputSistemaRefrigeracio() {return outputSistemaRefrigeracio;}
    public float getOutputGeneradorVapor() {return outputGeneradorVapor;}
    public float getOutputTurbina() {return outputTurbina;}

    public String toString() {
        return "# Pàgina Econòmica\n"+
                "- Dia: " +getDia()+ "\n" +
                "- Inserció Barres: " + getInsercioBarres() + " %" + "\n" +
                "- Output Reactor: " + getOutputReactor() + " Graus" + "\n" +
                "- Output Sistema de Refrigeració: " + getOutputSistemaRefrigeracio() + " Graus" + "\n" +
                "- Output Generador de Vapor: " + getOutputGeneradorVapor() + " Graus" + "\n" +
                "- Output Turbina: " + getOutputTurbina() + " Unitats de Potència" + "\n";
    }
}