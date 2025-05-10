package prog2.model;
import java.util.ArrayList;
import java.util.List;

public class Bitacola implements InBitacola {
    private ArrayList<PaginaBitacola> llistaBitacola;

    public Bitacola() {
        llistaBitacola = new ArrayList<>();
    }

    @Override
    public void afegeixPagina(PaginaBitacola p) {
        llistaBitacola.add(p);
    }

    @Override
    public List<PaginaIncidencies> getIncidencies() {
        List<PaginaIncidencies> result = new ArrayList<>();
        for (PaginaBitacola p : llistaBitacola) {
            if (p instanceof PaginaIncidencies) {
                result.add((PaginaIncidencies) p);
            }
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (PaginaBitacola p : llistaBitacola) {
            s.append(p.toString()).append("\n");
        }
        return s.toString();
    }
}

