/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ThreeConnected;

import dataWithEvaluations.ReaderOfEvaluations;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Random;
import maps.ThreeConnectedNetwork;

/**
 *
 * @author andrea
 */
public class Main {

    public static void main(String[] args) {
        testBoltzmann3connectedNetworks();
    }

    public static void testBoltzmann3connectedNetworks() {
        Random r = new Random(System.currentTimeMillis());
        ReaderOfEvaluations.loadNetworkGeneratingFunctionsValues("1000");
        ThreeConnectedNetwork threeConnectedNetwork = ThreeConnectedNetwork.draw_dxxK(r);
        threeConnectedNetwork.toScreenParameters();
        try {
            PrintWriter out = new PrintWriter(System.out, true);
            threeConnectedNetwork.printForBedini(out);
        } catch (IOException e) {
            System.out.println("IOException");
            System.exit(-1);
        }
    }
}
