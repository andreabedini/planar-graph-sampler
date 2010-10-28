package TwoConnected;

import dataWithEvaluations.ReaderOfEvaluations;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import maps.TwoConnectedMap;

/**
 *
 * @author andrea
 */
public class Main {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        Random r = new Random(System.currentTimeMillis());
        PrintWriter out = new PrintWriter(System.out, true);
        try {
            ReaderOfEvaluations.loadTwoConnectedValues("1000");
            while (n-- > 0) {
                TwoConnectedMap twoConnected = TwoConnectedMap.draw_dddB(r);
                twoConnected.printForBedini(out);
            }
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(-1);
        }
    }
}
