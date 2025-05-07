package prog2.model;
public class PaginaEstat extends PaginaBitacola {
    private int grauInsercioBarres;
    private String outputReactor;
    private String outputSistemaRefrigeracio;
    private String outputGeneradorVapor;
    private String outputTurbina;

    public PaginaEstat(int dia, int grauInsercioBarres, String outputReactor,
                       String outputSistemaRefrigeracio, String outputGeneradorVapor, String outputTurbina) {
        super(dia);
        this.grauInsercioBarres = grauInsercioBarres;
        this.outputReactor = outputReactor;
        this.outputSistemaRefrigeracio = outputSistemaRefrigeracio;
        this.outputGeneradorVapor = outputGeneradorVapor;
        this.outputTurbina = outputTurbina;
    }

    public int getGrauInsercioBarres() { return grauInsercioBarres; }
    public String getOutputReactor() { return outputReactor; }
    public String getOutputSistemaRefrigeracio() { return outputSistemaRefrigeracio; }
    public String getOutputGeneradorVapor() { return outputGeneradorVapor; }
    public String getOutputTurbina() { return outputTurbina; }

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