package prog2.model;
import prog2.vista.CentralUBException;

import java.util.List;

/**
 *
 * @author Daniel Ortiz
 */
public class Dades implements InDades{
    public final static long  VAR_UNIF_SEED = 123;
    public final static float GUANYS_INICIALS = 0;
    public final static float PREU_UNITAT_POTENCIA = 1;
    public final static float PENALITZACIO_EXCES_POTENCIA = 250;
    public final static float COST_OPERATIU_BARRES_CONTROL =5;

    // Afegir atributs:

    private VariableUniforme variableUniforme;
    private int insercioBarres;
    private Reactor reactor;
    private SistemaRefrigeracio sistemaRefrigeracio;
    private GeneradorVapor generadorVapor;
    private Turbina turbina;
    private Bitacola bitacola;
    private int dia;
    private float guanysAcumulats;

    public Dades(){
        // Inicialitza Atributs
        this.variableUniforme = new VariableUniforme(VAR_UNIF_SEED);
        this.insercioBarres = 100;
        this.reactor = new Reactor();
        this.reactor.desactiva();
        this.sistemaRefrigeracio = new SistemaRefrigeracio();
        this.generadorVapor = new GeneradorVapor();
        this.generadorVapor.activa();
        this.turbina = new Turbina();
        this.turbina.activa();
        this.bitacola = new Bitacola();
        this.dia = 1;
        this.guanysAcumulats = GUANYS_INICIALS;
        
        // Afegeix bombes refrigerants
        BombaRefrigerant b0 = new BombaRefrigerant(variableUniforme, 0);
        BombaRefrigerant b1 = new BombaRefrigerant(variableUniforme, 1);
        BombaRefrigerant b2 = new BombaRefrigerant(variableUniforme, 2);
        BombaRefrigerant b3 = new BombaRefrigerant(variableUniforme, 3);
        
        this.sistemaRefrigeracio.afegirBomba(b0);
        this.sistemaRefrigeracio.afegirBomba(b1);
        this.sistemaRefrigeracio.afegirBomba(b2);
        this.sistemaRefrigeracio.afegirBomba(b3);

        this.sistemaRefrigeracio.desactiva();
    }
    
    /**
     * Actualitza l'economia de la central. Genera una pàgina econòmica a 
     * partir de la demanda de potencia actual. Aquesta pàgina econòmica inclou 
     * beneficis, penalització per excès de potència, costos operatius y 
     * guanys acumulats.
     * @param demandaPotencia Demanda de potència actual.
     */
    private PaginaEconomica actualitzaEconomia(float demandaPotencia){
        float potenciaGenerada=calculaPotencia();

        float percentatgePotenciaStisfeta= potenciaGenerada/demandaPotencia;

        float beneficis;
        float penalitzacio=0;
        if (potenciaGenerada>demandaPotencia){
            beneficis=demandaPotencia*PREU_UNITAT_POTENCIA;
            penalitzacio=PENALITZACIO_EXCES_POTENCIA;
        }
        else {
            beneficis=potenciaGenerada*PREU_UNITAT_POTENCIA;
        }

        float costOperatiu=(COST_OPERATIU_BARRES_CONTROL+ reactor.getCostOperatiu()+
                sistemaRefrigeracio.getCostOperatiu()+ generadorVapor.getCostOperatiu()+
                turbina.getCostOperatiu())*PREU_UNITAT_POTENCIA;

        guanysAcumulats=beneficis-(costOperatiu+penalitzacio);

        PaginaEconomica novaPagina = new PaginaEconomica(dia,demandaPotencia,potenciaGenerada,percentatgePotenciaStisfeta,
                beneficis,penalitzacio,costOperatiu,guanysAcumulats);
        return novaPagina;
    }

    /**
     * Aquest mètode ha de establir la nova temperatura del reactor.
     */
    private void refrigeraReactor() {
          // Completar
    }

    /**
     * Aquest mètode ha de revisar els components de la central. Si
     * es troben incidències, s'han de registrar en la pàgina d'incidències
     * que es proporciona com a paràmetre d'entrada.
     * @param paginaIncidencies Pàgina d'incidències.
     */
    private void revisaComponents(PaginaIncidencies paginaIncidencies) {
          // Completar
    }

    @Override
    public float getInsercioBarres() {
        return insercioBarres;
    }

    @Override
    public void setInsercioBarres(float insercioBarres) throws CentralUBException {

    }

    @Override
    public void activaReactor() throws CentralUBException {
        reactor.activa();
    }

    @Override
    public void desactivaReactor() {
        reactor.desactiva();
    }

    @Override
    public Reactor mostraReactor() {
        return reactor;
    }

    @Override
    public void activaBomba(int id) throws CentralUBException {

    }

    @Override
    public void desactivaBomba(int id) {

    }

    @Override
    public SistemaRefrigeracio mostraSistemaRefrigeracio() {
        return sistemaRefrigeracio;
    }

    @Override
    public float calculaPotencia() {
       return mostraEstat().getOutputTurbina();
    }

    @Override
    public float getGuanysAcumulats() {
        return guanysAcumulats;
    }

    @Override
    public PaginaEstat mostraEstat() {
        float outputReactor= reactor.calculaOutput(insercioBarres);
        float outputSistemaRefrigeracio= sistemaRefrigeracio.calculaOutput(outputReactor);
        float outputGeneradorVapor= generadorVapor.calculaOutput(outputSistemaRefrigeracio);
        float outputTurbina= turbina.calculaOutput(outputGeneradorVapor);

        PaginaEstat paginaEstat=new PaginaEstat(dia,insercioBarres,outputReactor,outputSistemaRefrigeracio,
                outputGeneradorVapor,outputTurbina);

        return paginaEstat;
    }

    @Override
    public Bitacola mostraBitacola() {
        return bitacola;
    }

    @Override
    public List<PaginaIncidencies> mostraIncidencies() {
        return List.of();
    }

    public Bitacola finalitzaDia(float demandaPotencia) {
        // Actualitza economia
        PaginaEconomica paginaEconomica = actualitzaEconomia(demandaPotencia);
        
        // Genera pàgina d'estat amb la configuració escollida (la nova pàgina
        // d'estat inclou la nova configuració escollida pel operador abans de
        // refrigerar el reactor)
        PaginaEstat paginaEstat = mostraEstat();

        // Actualitza estat de la central...

        // Refrigera el reactor
        refrigeraReactor();

        // Revisa els components de la central i registra incidències
        PaginaIncidencies paginaIncidencies = new PaginaIncidencies(dia);
        revisaComponents(paginaIncidencies);
        
        // Incrementa dia
        dia += 1;
        
        // Guarda pàgines de bitacola
        bitacola.afegeixPagina(paginaEconomica);
        bitacola.afegeixPagina(paginaEstat);
        bitacola.afegeixPagina(paginaIncidencies);
        
        // Retorna pàgines
        Bitacola bitacolaDia = new Bitacola();
        bitacolaDia.afegeixPagina(paginaEconomica);
        bitacolaDia.afegeixPagina(paginaEstat);
        bitacolaDia.afegeixPagina(paginaIncidencies);
        return bitacolaDia;
    }
}
