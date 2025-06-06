package prog2.adaptador;
import prog2.vista.CentralUBException;
import prog2.model.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Adaptador {
    private Dades dades;

    public Adaptador() { dades = new Dades();}

    // GETTERS I SETTERS
    public float getInsercio(){ return dades.getInsercioBarres(); }
    public void setInsercio(float insercio) throws CentralUBException { dades.setInsercioBarres(insercio); }

    public void activaReactor() throws CentralUBException{ dades.activaReactor(); }
    public void desactivaReactor(){ dades.desactivaReactor(); }
    public void mostraReactor(){ Reactor reactor = dades.mostraReactor();
    System.out.println("Activat: "+ reactor.getActivat()+" Cost operatiu: "+ reactor.getCostOperatiu()+
            " Temperatura "+ reactor.getTemperatura());}

    public void activaRefrigeracio() throws CentralUBException{
        SistemaRefrigeracio refrigeracio1 = dades.mostraSistemaRefrigeracio();
        refrigeracio1.activa();
    }
    public void desactivaRefrigeracio(){
        SistemaRefrigeracio refrigeracio1 = dades.mostraSistemaRefrigeracio();
        refrigeracio1.desactiva();
    }
    public void mostraRefrigeracio(){
        SistemaRefrigeracio refrigeracio1 = dades.mostraSistemaRefrigeracio();
        for (BombaRefrigerant bomba : refrigeracio1.getLlistaBombes()){
            System.out.println("ID: " + bomba.getId() + "Activat: " + bomba.getActivat() +
                    "Capacitat: " + bomba.getCapacitat() + "Cost operatiu: " + bomba.getCostOperatiu() +
                    "Fora de servei: " + bomba.getForaDeServei());
        }
    }

    public void activaBomba(int id) throws CentralUBException{ dades.activaBomba(id); }
    public void desactivaBomba(int id){ dades.desactivaBomba(id); }

    public void mostraEstat(){
        PaginaEstat estat = dades.mostraEstat();
        System.out.println(estat.toString());
    }
    public void mostraBitacola(){
        Bitacola bitacola = dades.mostraBitacola();
        System.out.println(bitacola.toString());
    }
    public void mostraIncidencies(){
        List<PaginaIncidencies> incidencies = dades.mostraIncidencies();
        StringBuffer resultat = new StringBuffer();
        for (PaginaIncidencies p : incidencies) {
            resultat.append(p.toString()).append("\n");
        } System.out.println(resultat);
    }
    public void mostrarPercentatge(float demanda){
        System.out.println("Demanda d'avui: " + demanda + "Potencia generada: " + dades.calculaPotencia() + "Percentatge de satisfacció: " + (int) ((dades.calculaPotencia()/demanda) * 100) + " %");
    }

    public void guardaDades(String camiDesti) throws CentralUBException{
        File file = new File(camiDesti);
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(this.dades);
        }
        catch (IOException e) {
            throw new CentralUBException(e.getMessage());
        }

        finally {
            try {
                if (fos!= null) { fos.close(); }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

            try {
                if (oos != null) { oos.close(); }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void carregaDades(String camiOrigen) throws CentralUBException{
        Dades dades1 = null;
        FileInputStream fin = null;
        ObjectInputStream ois = null;
        try {
            fin = new FileInputStream(camiOrigen);
            ois = new ObjectInputStream(fin);
            dades = (Dades) ois.readObject();
        }

        catch (IOException e) {
            System.out.println(e.getMessage());
        }

        catch (ClassNotFoundException e) {
            throw new CentralUBException("No s'ha trobat la classe dades al fitxer.");
        }

        finally {
            try {
                if (fin != null) { fin.close(); }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

            try {
                if (ois != null) { ois.close(); }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

     public float getGuanysAcumulats(){
        return dades.getGuanysAcumulats();
     }

    public boolean estaActiuReactor() {
        return dades.mostraReactor().getActivat();
    }

    public boolean getActivatBomba(int id) {
        return dades.getSistemaRefrigeracio().getLlistaBombes().get(id).getActivat();
    }

    public void setActivatBomba(int id, boolean activat) {
        try {
            if (activat) {
                dades.getSistemaRefrigeracio().getLlistaBombes().get(id).activa();
            } else {
                dades.getSistemaRefrigeracio().getLlistaBombes().get(id).desactiva();
            }
        } catch (CentralUBException e) {
            System.out.println("Error activant/desactivant bomba " + id + ": " + e.getMessage());
        }
    }

    public boolean estaForaDeServei(int idBomba) {
        return dades.getSistemaRefrigeracio().getLlistaBombes().get(idBomba).getForaDeServei();
    }

    public String getInfoReactor() {
        Reactor reactor = dades.mostraReactor();
        return "Activat: " + reactor.getActivat() +
                " | Cost operatiu: " + reactor.getCostOperatiu() +
                " | Temperatura: " + reactor.getTemperatura();
    }
    public String finalitzaDia(float demandaPotencia){
        Bitacola bitacola = dades.finalitzaDia(demandaPotencia);
        return bitacola.toString();
    }

    public List<BombaRefrigerant> getBombesForaServei() {
        List<BombaRefrigerant> foraServei = new ArrayList<>();
        for (BombaRefrigerant b : dades.getSistemaRefrigeracio().getLlistaBombes()) {
            if (b.getForaDeServei()) {
                foraServei.add(b);
            }
        }
        return foraServei;
    }

    public float getTemperatura(){
        return dades.getReactor().getTemperatura();
    }

}