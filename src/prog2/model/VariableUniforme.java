package prog2.model;

import java.util.Random;

/**
 *
 * @author Daniel Ortiz
 */
public class VariableUniforme {
    private Random random;

    public VariableUniforme(long seed) {
        this.random = new Random(seed);
    }

    public int seguentValor() {
        return random.nextInt(100);
    }
}
