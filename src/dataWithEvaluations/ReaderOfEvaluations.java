package dataWithEvaluations;

import randomChoose.ChooseVector;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import maps.*;

public class ReaderOfEvaluations {

    public static String FILE_NETWORKS = "../../src/dataWithEvaluations/values_networks";
    public static String FILE_PLANAR_GRAPHS = "../../src/dataWithEvaluations/values_planar";

    public static void loadNetworkGeneratingFunctionsValues() throws FileNotFoundException, IOException {
        BufferedReader reader = new BufferedReader(new FileReader(FILE_NETWORKS));
        readBigNumberBinaryTrees(reader);
        readBigNumber3connected(reader);
        readBigNumberNetworks(reader);
    }

    public static void loadTwoConnectedValues() throws FileNotFoundException, IOException {
        BufferedReader reader = new BufferedReader(new FileReader(FILE_NETWORKS));
        readBigNumberBinaryTrees(reader);
        readBigNumber3connected(reader);
        readBigNumberNetworks(reader);
        readBigNumber2Connected(reader);
    }

    public static void loadAllGeneratingFunctionsValues() throws FileNotFoundException, IOException {
        BufferedReader reader = new BufferedReader(new FileReader(FILE_PLANAR_GRAPHS));
        readBigNumberBinaryTrees(reader);
        readBigNumber3connected(reader);
        readBigNumberNetworks(reader);
        readBigNumber2Connected(reader);
        readBigNumberConnected(reader);
        readBigNumberPlanar(reader);
    }

    public static void readBigNumber3connected(BufferedReader reader) throws IOException {
        System.err.println("Loading 4 vectors for 3 connected");
        affectChooseVector(ThreeConnectedNetwork.ch_K_in_dyK, reader);
        System.err.println("ch_K_in_dyK loaded");
        affectChooseVector(ThreeConnectedNetwork.ch_dxK_in_dxyK, reader);
        System.err.println("ch_dxK_in_dxyK loaded");
        affectChooseVector(ThreeConnectedNetwork.ch_b_or_dxb, reader);
        System.err.println("ch_b_or_dxb loaded");
        affectChooseVector(ThreeConnectedNetwork.ch_3b_or_dyb, reader);
        System.err.println("ch_3b_or_dyb loaded");
    }

    public static void readBigNumber2Connected(BufferedReader reader) throws IOException {
        System.err.println("Loading 4 vectors for 2 connected");
        affectChooseVector(TwoConnectedMap.ch_xy_in_dB, reader);
        System.err.println("ch_xy_in_dBloaded");
        affectChooseVector(TwoConnectedMap.ch_y_in_ddB, reader);
        System.err.println("ch_y_in_ddB loaded");
        affectChooseVector(TwoConnectedMap.ch_nontrivialD_or_dD, reader);
        System.err.println("ch_nontrivialD_or_dD loaded");
        affectChooseVector(TwoConnectedMap.ch_dD_or_ddD, reader);
        System.err.println("ch_dD_or_ddD loaded");
    }

    public static void readBigNumberBinaryTrees(BufferedReader reader) throws IOException {
        System.err.println("Loading 9 vectors for binary trees");
        affectChooseVector(BinaryTree.ch_1_or_u, reader);
        System.err.println("ch_1_or_u loaded");
        affectChooseVector(BinaryTree.ch_1_or_v, reader);
        System.err.println("ch_1_or_v loaded");
        affectChooseVector(BinaryTree.ch_u_or_v, reader);
        System.err.println("ch_u_or_v loaded");
        affectChooseVector(BinaryTree.ch_dxu_or_dxv, reader);
        System.err.println("ch_dxu_or_dxv loaded");
        affectChooseVector(BinaryTree.choose_vector_dxu, reader);
        System.err.println("choose_vector_dxu loaded");
        affectChooseVector(BinaryTree.choose_vector_dxv, reader);
        System.err.println("choose_vector_dxv loaded");
        affectChooseVector(BinaryTree.ch_dyu_or_dyv, reader);
        System.err.println("ch_dyu_or_dyv loaded");
        affectChooseVector(BinaryTree.choose_vector_dyv, reader);
        System.err.println("choose_vector_dyv loaded");
        affectChooseVector(BinaryTree.choose_vector_dyu, reader);
        System.err.println("choose_vector_dyu loaded");
    }

    public static void readBigNumberConnected(BufferedReader reader) throws IOException {
        System.err.println("Loading 4 vectors for connected maps");
        affectChooseVector(ConnectedMap.poisson_dB, reader);
        System.err.println("poisson_dB loaded");
        affectChooseVector(ConnectedMap.ch_dC_or_ddC, reader);
        System.err.println("ch_dC_or_ddC loaded");
        affectChooseVector(ConnectedMap.ch_2ddC_or_dddC, reader);
        System.err.println("ch_2ddC_or_dddC loaded");
        affectChooseVector(ConnectedMap.choose_vector_dddC, reader);
        System.err.println("choose_vector_dddC loaded");
    }

    public static void readBigNumberNetworks(BufferedReader reader) throws IOException {
        System.err.println("Loading 21 vectors for networks");
        affectChooseVector(Network.choose_vector_non_trivial_D, reader);
        System.err.println("choose_vector_non_trivial_D loaded");
        affectChooseVector(Network.choose_vector_D, reader);
        System.err.println("choose_vector_D loaded");
        affectChooseVector(Network.choose_vector_P, reader);
        System.err.println("choose_vector_P loaded");
        affectChooseVector(Network.ch_y_or_P_or_H, reader);
        System.err.println("ch_y_or_P_or_H loaded");
        affectChooseVector(Network.ch_S_or_H, reader);
        System.err.println("ch_S_or_H loaded");
        affectChooseVector(Network.poisson_S_plus_H, reader);
        System.err.println("poisson_S_plus_H loaded");
        affectChooseVector(Network.poisson_at_least1_S_plus_H, reader);
        System.err.println("poisson_at_least1_S_plus_H loaded");
        affectChooseVector(Network.poisson_at_least2_S_plus_H, reader);
        System.err.println("poisson_at_least2_S_plus_H loaded");
        affectChooseVector(Network.choose_vector_dD, reader);
        System.err.println("choose_vector_dD loaded");
        affectChooseVector(Network.choose_vector_dS, reader);
        System.err.println("choose_vector_dS loaded");
        affectChooseVector(Network.choose_vector_dP, reader);
        System.err.println("choose_vector_dP loaded");
        affectChooseVector(Network.choose_vector_dH, reader);
        System.err.println("choose_vector_dH loaded");
        affectChooseVector(Network.ch_dP_or_dH, reader);
        System.err.println("ch_dP_or_dH loaded");
        affectChooseVector(Network.ch_dS_or_dH, reader);
        System.err.println("ch_dS_or_dH loaded");
        affectChooseVector(Network.choose_vector_ddD, reader);
        System.err.println("choose_vector_ddD loaded");
        affectChooseVector(Network.choose_vector_ddS, reader);
        System.err.println("choose_vector_ddS loaded");
        affectChooseVector(Network.choose_vector_ddP, reader);
        System.err.println("choose_vector_ddP loaded");
        affectChooseVector(Network.choose_vector_ddH, reader);
        System.err.println("choose_vector_ddH loaded");
        affectChooseVector(Network.ch_ddP_or_ddH, reader);
        System.err.println("ch_ddP_or_ddH loaded");
        affectChooseVector(Network.ch_ddS_or_ddH, reader);
        System.err.println("ch_ddS_or_ddH loaded");
    }

    public static void readBigNumberPlanar(BufferedReader reader) throws IOException {
        System.err.println("Loading 3 vectors for planar map");
        affectChooseVector(PlanarMap.poisson_C, reader);
        System.err.println("poisson_C loaded");
        affectChooseVector(PlanarMap.choose_vector_ddG, reader);
        System.err.println("choose_vector_ddG loaded");
        affectChooseVector(PlanarMap.choose_vector_dddG, reader);
        System.err.println("choose_vector_dddG loaded");
    }

    public static void affectChooseVector(ChooseVector vector, BufferedReader reader) throws IOException {
        int i = 0;
        String s = reader.readLine();
        System.err.println(s);
        StringTokenizer st = new StringTokenizer(s);
        while (st.hasMoreTokens()) {
            double x = 0;
            try {
                x = Double.parseDouble(st.nextToken());
            } catch (NumberFormatException e) {
                System.err.println("problem when loading choose_vector, not a number");
                System.err.println(x);
            }
            vector.setDoubleAt(i++, x);
        }
        vector.check();
    }

    public static void printVectors() {
        BinaryTree.ch_1_or_u.toScreen();
        BinaryTree.ch_1_or_v.toScreen();
        BinaryTree.ch_u_or_v.toScreen();
        BinaryTree.ch_dxu_or_dxv.toScreen();
        BinaryTree.choose_vector_dxu.toScreen();
        BinaryTree.choose_vector_dxv.toScreen();
        BinaryTree.ch_dyu_or_dyv.toScreen();
        BinaryTree.choose_vector_dyv.toScreen();
        BinaryTree.choose_vector_dyu.toScreen();
        ThreeConnectedNetwork.ch_K_in_dyK.toScreen();
        ThreeConnectedNetwork.ch_dxK_in_dxyK.toScreen();
        ThreeConnectedNetwork.ch_b_or_dxb.toScreen();
        ThreeConnectedNetwork.ch_3b_or_dyb.toScreen();
        Network.choose_vector_non_trivial_D.toScreen();
        Network.choose_vector_D.toScreen();
        Network.choose_vector_P.toScreen();
        Network.ch_y_or_P_or_H.toScreen();
        Network.ch_S_or_H.toScreen();
        Network.poisson_S_plus_H.toScreen();
        Network.poisson_at_least1_S_plus_H.toScreen();
        Network.poisson_at_least2_S_plus_H.toScreen();
        Network.choose_vector_dD.toScreen();
        Network.choose_vector_dS.toScreen();
        Network.choose_vector_dP.toScreen();
        Network.choose_vector_dH.toScreen();
        Network.ch_dP_or_dH.toScreen();
        Network.ch_dS_or_dH.toScreen();
        Network.choose_vector_ddD.toScreen();
        Network.choose_vector_ddS.toScreen();
        Network.choose_vector_ddP.toScreen();
        Network.choose_vector_ddH.toScreen();
        Network.ch_ddP_or_ddH.toScreen();
        Network.ch_ddS_or_ddH.toScreen();
        TwoConnectedMap.ch_xy_in_dB.toScreen();
        TwoConnectedMap.ch_y_in_ddB.toScreen();
        TwoConnectedMap.ch_nontrivialD_or_dD.toScreen();
        TwoConnectedMap.ch_dD_or_ddD.toScreen();
        ConnectedMap.poisson_dB.toScreen();
        ConnectedMap.ch_dC_or_ddC.toScreen();
        ConnectedMap.ch_2ddC_or_dddC.toScreen();
        ConnectedMap.choose_vector_dddC.toScreen();
        PlanarMap.poisson_C.toScreen();
        PlanarMap.choose_vector_ddG.toScreen();
        PlanarMap.choose_vector_dddG.toScreen();
    }
}
