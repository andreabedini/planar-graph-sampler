package ThreeConnected;

import dataWithEvaluations.ReaderOfEvaluations;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import maps.ThreeConnectedNetwork;

/**
 *
 * @author abedini
 */
public class FixedSize {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int size = Integer.parseInt(args[1]);
        Random r = new Random(System.currentTimeMillis());
        PrintWriter out = new PrintWriter(System.out, true);
        try {
            ReaderOfEvaluations.loadNetworkGeneratingFunctionsValues();
            while (n > 0) {
                ThreeConnectedNetwork threeConnectedNetwork = ThreeConnectedNetwork.draw_dxxK(r);
                if (threeConnectedNetwork.vertexList.size() == size) {
                    threeConnectedNetwork.printForBedini(out);
                    n--;
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(-1);
        }
    }
}
