package prog2.model;
import java.util.ArrayList;
public class PaginaIncidencies extends PaginaBitacola{
    ArrayList<String> incidencies = new ArrayList<String>();

    public PaginaIncidencies(int dia) {
        super(dia);
        this.incidencies = new ArrayList<>() ;
    }

    public void afegeixIncidencia(String descIncidencia){
        incidencies.add(descIncidencia);
    }

    public ArrayList<String> getIncidencies() {
        return incidencies;
    }

    @Override
    public String toString() {
        String s = "";
        for(String i : incidencies){
            s += "- Descripció Incidència: " + i + "\n";
        }
        return "# Pàgina Incidències\n"+
                "- Dia: " +getDia()+ "\n" + s;
    }
}
