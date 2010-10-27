/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TwoConnected;

import dataWithEvaluations.ReaderOfEvaluations;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Random;
import maps.TwoConnectedMap;

/**
 *
 * @author andrea
 */
public class Main {

    public static void main(String[] args) {
        testBoltzmann2connected();
    }

    public static void testBoltzmann2connected() {
        Random r = new Random(System.currentTimeMillis());
        ReaderOfEvaluations.loadTwoConnectedValues("1000");
        TwoConnectedMap twoConnected = TwoConnectedMap.draw_dddB(r);
        twoConnected.toScreenParameters();
        try {
            PrintWriter out = new PrintWriter(System.out, true);
            twoConnected.printForBedini(out);
        } catch (IOException e) {
            System.out.println("IOException");
            System.exit(-1);
        }
    }
}
