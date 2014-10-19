import dataWithEvaluations.ReaderOfEvaluations;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import maps.ThreeConnectedNetwork;

/**
 *
 * @author andrea
 */
public class ThreeConnectedFixedSize {
    public static void main(String[] args) {
	int n = Integer.parseInt(args[0]);
	int m = Integer.parseInt(args[1]);
	Random r = new Random(System.currentTimeMillis());
	PrintWriter out = new PrintWriter(System.out, true);
	try {
	    ReaderOfEvaluations.loadNetworkGeneratingFunctionsValues();
	    while (n > 0) {
		ThreeConnectedNetwork threeConnectedNetwork = ThreeConnectedNetwork.draw_dxxK(r);
		threeConnectedNetwork.toTwoConnectedMap();
		if (threeConnectedNetwork.vertexList.size() == m) {
		    threeConnectedNetwork.printForBedini(out);
		    n--;
		}
	    }
	} catch (IOException ex) {
	    Logger.getLogger(ThreeConnectedFixedSize.class.getName()).log(Level.SEVERE, null, ex);
	    System.exit(-1);
	}
    }
}
