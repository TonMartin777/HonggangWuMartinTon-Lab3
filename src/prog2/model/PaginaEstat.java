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

    @Override
    public String toString() {
        return "- Dia: " + getDia() + "\n"
                + "- Grau Insercio: " + grauInsercioBarres + "\n"
                + "- Output Reactor: " + outputReactor + "\n"
                + "- Output Sistema Refrigeració: " + outputSistemaRefrigeracio + "\n"
                + "- Output Generador de Vapor: " + outputGeneradorVapor + "\n"
                + "- Output Turbina: " + outputTurbina + "\n";
    }
}