package prog2.model;
import java.util.ArrayList;
import java.util.List;

public class Bitacola implements InBitacola{
    private ArrayList<PaginaBitacola> llistaBitacola;

    @Override
    public void afegeixPagina(PaginaBitacola p) {
        llistaBitacola.add(p);
    }

    @Override
    public List<PaginaIncidencies> getIncidencies() {
        return List.of();
    }

    public String toString(){
        String s = "";
        for (PaginaBitacola p : llistaBitacola){
            s += p.toString();
            s += "\n";
        }
        return s;
    }
}
