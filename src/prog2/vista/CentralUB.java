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

    public void gestioCentralUB() {
        // Mostrar missatge inicial
        System.out.println("Benvingut a la planta PWR de la UB");
        System.out.println("La demanda de potència elèctrica avui es de " + demandaPotencia + " unitats");

        Scanner sc = new Scanner(System.in);

        String[] opcions = {
                "Mostrar estat de la central",
                "Mostrar bitàcola",
                "Mostrar incidències",
                "Mostrar sistema refrigeració",
                "Activar reactor",
                "Desactivar reactor",
                "Activar refrigeració",
                "Desactivar refrigeració",
                "Activar bomba",
                "Desactivar bomba",
                "Mostrar percentatge potència",
                "Guardar dades",
                "Carregar dades",
                "Finalitzar dia",
                "Sortir"
        };

        Menu<String> menu = new Menu<>("Gestió Central UB", opcions);

        int opcio;
        do {
            menu.mostrarMenu();
            System.out.print("Entra una opcio >> ");
            opcio = sc.nextInt();
            sc.nextLine(); // neteja línia

            try {
                switch (opcio) {
                    case 1:
                        adaptador.mostraEstat();
                        break;
                    case 2:
                        adaptador.mostraBitacola();
                        break;
                    case 3:
                        adaptador.mostraIncidencies();
                        break;
                    case 4:
                        adaptador.mostraRefrigeracio();
                        break;
                    case 5:
                        adaptador.activaReactor();
                        break;
                    case 6:
                        adaptador.desactivaReactor();
                        break;
                    case 7:
                        adaptador.activaRefrigeracio();
                        break;
                    case 8:
                        adaptador.desactivaRefrigeracio();
                        break;
                    case 9:
                        System.out.print("Entra ID de la bomba a activar >> ");
                        int idActiva = sc.nextInt();
                        sc.nextLine();
                        adaptador.activaBomba(idActiva);
                        break;
                    case 10:
                        System.out.print("Entra ID de la bomba a desactivar >> ");
                        int idDesactiva = sc.nextInt();
                        sc.nextLine();
                        adaptador.desactivaBomba(idDesactiva);
                        break;
                    case 11:
                        adaptador.mostrarPercentatge(demandaPotencia);
                        break;
                    case 12:
                        System.out.print("Entra camí per guardar dades >> ");
                        String camiGuardar = sc.nextLine();
                        adaptador.guardaDades(camiGuardar);
                        break;
                    case 13:
                        System.out.print("Entra camí per carregar dades >> ");
                        String camiCarregar = sc.nextLine();
                        adaptador.carregaDades(camiCarregar);
                        break;
                    case 14:
                        finalitzaDia();
                        break;
                    case 15:
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

        } while (opcio != 15);
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

