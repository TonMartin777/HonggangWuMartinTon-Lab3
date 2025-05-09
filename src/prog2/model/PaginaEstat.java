package prog2.model;
public class PaginaEstat extends PaginaBitacola {
    private float grauInsercioBarres;
    private float outputReactor;
    private float outputSistemaRefrigeracio;
    private float outputGeneradorVapor;
    private float outputTurbina;

    public PaginaEstat(int dia, float grauInsercioBarres, float outputReactor,
                       float outputSistemaRefrigeracio, float outputGeneradorVapor, float outputTurbina) {
        super(dia);
        this.grauInsercioBarres = grauInsercioBarres;
        this.outputReactor = outputReactor;
        this.outputSistemaRefrigeracio = outputSistemaRefrigeracio;
        this.outputGeneradorVapor = outputGeneradorVapor;
        this.outputTurbina = outputTurbina;
    }

    public float getGrauInsercioBarres() { return grauInsercioBarres; }
    public float getOutputReactor() { return outputReactor; }
    public float getOutputSistemaRefrigeracio() { return outputSistemaRefrigeracio; }
    public float getOutputGeneradorVapor() { return outputGeneradorVapor; }
    public float getOutputTurbina() { return outputTurbina; }

    @Override
    public String toString() {
        return "- Dia: " + getDia() + "\n"
                + "- Grau Insercio: " + getGrauInsercioBarres() + "\n"
                + "- Output Reactor: " + getOutputReactor() + "\n"
                + "- Output Sistema Refrigeració: " + getOutputSistemaRefrigeracio() + "\n"
                + "- Output Generador de Vapor: " + getOutputGeneradorVapor() + "\n"
                + "- Output Turbina: " + getOutputTurbina() + "\n";
    }
}