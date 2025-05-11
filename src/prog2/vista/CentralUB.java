/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog2.vista;

import prog2.adaptador.Adaptador;
import java.util.Scanner;

/**
 *
 * @author Daniel Ortiz
 */
import java.util.Scanner;

public class CentralUB {
    public final static float DEMANDA_MAX = 1800;
    public final static float DEMANDA_MIN = 250;
    public final static float VAR_NORM_MEAN = 1000;
    public final static float VAR_NORM_STD = 800;
    public final static long VAR_NORM_SEED = 123;

    /** Generador aleatori de la demanda de potència **/
    private VariableNormal variableNormal;

    /** Demanda de potència del dia actual **/
    private float demandaPotencia;
    private Adaptador adaptador;

    /* Constructor */
    public CentralUB() {
        variableNormal = new VariableNormal(VAR_NORM_MEAN, VAR_NORM_STD, VAR_NORM_SEED);
        demandaPotencia = generaDemandaPotencia();
        adaptador = new Adaptador();
    }

    public enum OpcioMenu {
        MOSTRAR_ESTADO_CENTRAL("Mostrar estat de la central"),
        MOSTRAR_BITACOLA("Mostrar bitàcola"),
        MOSTRAR_INCIDENCIAS("Mostrar incidències"),
        MOSTRAR_GRAU_INSERCIO("mostar grau d'inserció"),
        CAMBIAR_GRAU_INSERCIO("cambiar el grau d'insercio"),
        MOSTRAR_SISTEMA_REFRIGERACION("Mostrar sistema refrigeració"),
        ACTIVAR_REACTOR("Activar reactor"),
        DESACTIVAR_REACTOR("Desactivar reactor"),
        MOSTRAR_REACTOR("Mostrar reactor"),
        ACTIVAR_REFRIGERACION("Activar refrigeració"),
        DESACTIVAR_REFRIGERACION("Desactivar refrigeració"),
        ACTIVAR_BOMBA("Activar bomba"),
        DESACTIVAR_BOMBA("Desactivar bomba"),
        MOSTRAR_PORCENTAJE_POTENCIA("Mostrar percentatge potència"),
        GUARDAR_DATOS("Guardar dades"),
        CARGAR_DATOS("Carregar dades"),
        FINALIZAR_DIA("Finalitzar dia"),
        SALIR("Sortir");

        private final String descripcion;

        OpcioMenu(String descripcion) {
            this.descripcion = descripcion;
        }

        public String getDescripcion() {
            return descripcion;
        }
    }

    public void gestioCentralUB() {

        System.out.println("Benvingut a la planta PWR de la UB");
        System.out.println("La demanda de potència elèctrica avui es de " + demandaPotencia + " unitats");

        Scanner sc = new Scanner(System.in);


        Menu<OpcioMenu> menu = new Menu<>("Gestió Central UB", OpcioMenu.values());

        int opcio;
        do {
            menu.mostrarMenu();
            System.out.print("Entra una opcio >> ");
            opcio = sc.nextInt();
            sc.nextLine();

            try {
                OpcioMenu opcionSeleccionada = OpcioMenu.values()[opcio - 1];

                switch (opcionSeleccionada) {
                    case MOSTRAR_ESTADO_CENTRAL:
                        adaptador.mostraEstat();
                        break;
                    case MOSTRAR_BITACOLA:
                        adaptador.mostraBitacola();
                        break;
                    case MOSTRAR_INCIDENCIAS:
                        adaptador.mostraIncidencies();
                        break;
                    case MOSTRAR_GRAU_INSERCIO:
                        adaptador.getInsercio();
                        break;
                    case CAMBIAR_GRAU_INSERCIO:
                        System.out.println("Entra el nou grau d'inserció: ");
                        float grauInsercio= sc.nextFloat();
                        adaptador.setInsercio(grauInsercio);
                        break;
                    case MOSTRAR_SISTEMA_REFRIGERACION:
                        adaptador.mostraRefrigeracio();
                        break;
                    case ACTIVAR_REACTOR:
                        adaptador.activaReactor();
                        break;
                    case DESACTIVAR_REACTOR:
                        adaptador.desactivaReactor();
                        break;
                    case MOSTRAR_REACTOR:
                        adaptador.mostraReactor();
                        break;
                    case ACTIVAR_REFRIGERACION:
                        adaptador.activaRefrigeracio();
                        break;
                    case DESACTIVAR_REFRIGERACION:
                        adaptador.desactivaRefrigeracio();
                        break;
                    case ACTIVAR_BOMBA:
                        System.out.print("Entra ID de la bomba a activar >> ");
                        int idActiva = sc.nextInt();
                        sc.nextLine();
                        adaptador.activaBomba(idActiva);
                        break;
                    case DESACTIVAR_BOMBA:
                        System.out.print("Entra ID de la bomba a desactivar >> ");
                        int idDesactiva = sc.nextInt();
                        sc.nextLine();
                        adaptador.desactivaBomba(idDesactiva);
                        break;
                    case MOSTRAR_PORCENTAJE_POTENCIA:
                        adaptador.mostrarPercentatge(demandaPotencia);
                        break;
                    case GUARDAR_DATOS:
                        System.out.print("Guardant dades >> ");
                        adaptador.guardaDades("dades.txt");
                        break;
                    case CARGAR_DATOS:
                        System.out.print("Carregant dades >> ");
                        adaptador.carregaDades("dades.txt");
                        break;
                    case FINALIZAR_DIA:
                        finalitzaDia();
                        break;
                    case SALIR:
                        System.out.println("Sortint del sistema...");
                        break;
                    default:
                        System.out.println("Opció invàlida.");
                }
            } catch (CentralUBException e) {
                System.err.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.err.println("Error inesperat: " + e.getMessage());
            }

        } while (opcio != OpcioMenu.SALIR.ordinal() + 1);
    }


    private float generaDemandaPotencia() {
        float valor = Math.round(variableNormal.seguentValor());
        if (valor > DEMANDA_MAX)
            return DEMANDA_MAX;
        else if (valor < DEMANDA_MIN)
            return DEMANDA_MIN;
        else
            return valor;
    }

    private void finalitzaDia() {
        String info = adaptador.finalitzaDia(demandaPotencia);
        System.out.println(info);
        System.out.println("Dia finalitzat\n");

        // Generar i mostrar nova demanda de potencia
        demandaPotencia = generaDemandaPotencia();
        System.out.println("La demanda de potència elèctrica avui es de " + demandaPotencia + " unitats");
    }
}

