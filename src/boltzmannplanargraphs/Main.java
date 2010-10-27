package boltzmannplanargraphs;
import java.util.Random;
import dataWithEvaluations.ReaderOfEvaluations;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import maps.BinaryTree;
import maps.ConnectedMap;
import maps.Network;
import maps.PlanarMap;
import maps.ThreeConnectedNetwork;
import maps.TwoConnectedMap;
import maps.closure.Dart;


public class Main {

    /** Creates a new instance of Main */
    public Main() {
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //testIO();
        //testRandomBinaryTree();
        //generateChosenThreeConnectedAndTestCopy();
        //testRandomClosure();
        //testBoltzmann3connectedNetworks();
        //testBoltzmannNetworks();
        //testBoltzmann2connected();
        //testBoltzmannConnected();
        //try{collectStatisticInfo();} catch(IOException e){};
        //double toleranceRatio=getToleranceRatio();
        try {
            testBoltzmannConnected();
        } catch(IOException e) {
        };
    }

    public static void testIO() {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        ReaderOfEvaluations.loadAllGeneratingFunctionsValues(in);
        ReaderOfEvaluations.printVectors();
    }

    public static void testRandomBinaryTree(){
        Random r = new Random(System.currentTimeMillis());
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        ReaderOfEvaluations.loadNetworkGeneratingFunctionsValues(in);
        BinaryTree tree = BinaryTree.draw_dyb(r);
        //BinaryTree.toScreen(tree);
        BinaryTree.printParameters(tree);
    }

    // public static void testRandomClosure(){
    //     while(true){
    //         Random r=new Random(System.currentTimeMillis());
    //         ReaderOfEvaluations.loadNetworkGeneratingFunctionsValues("10000");
    //         BinaryTree binaryTree=BinaryTree.draw_dyb(r);
    //         //BinaryTree.toScreen(tree);
    //         BinaryTree.printParameters(binaryTree);
    //         Dart dart=Dart.closure(binaryTree);
    //         if (dart!=null){
    //             ThreeConnectedNetwork threeConnecNetwork=new ThreeConnectedNetwork(dart);
    //             threeConnecNetwork.toScreenParameters();
    //             return;

    //         }
    //         else {
    //             System.out.println("rejet:path of length 3 passing by an internal vertex between the root vertex and the opposed vertex in the hexagon");
    //         }
    //     }
    // }

    public static void testBoltzmann3connectedNetworks(){
        Random r = new Random(System.currentTimeMillis());
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        ReaderOfEvaluations.loadNetworkGeneratingFunctionsValues(in);
        ThreeConnectedNetwork threeConnectedNetwork = ThreeConnectedNetwork.draw_dxxK(r);
        threeConnectedNetwork.toScreenParameters();
        //threeConnectedNetwork.printHalfEdges();
    }

    public static void testBoltzmannNetworks(){
        Random r = new Random(System.currentTimeMillis());
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        ReaderOfEvaluations.loadNetworkGeneratingFunctionsValues(in);
        Network network = Network.draw_dD(r);
        network.toScreenParameters();
        network.printHalfEdges();
    }

    public static void testBoltzmann2connected(){
        Random r=new Random(System.currentTimeMillis());
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        ReaderOfEvaluations.loadAllGeneratingFunctionsValues(in);
        TwoConnectedMap twoConnected = TwoConnectedMap.draw_dddB(r);
        twoConnected.toScreenParameters();
        twoConnected.printHalfEdges();
        twoConnected.printDegreeVertices();
    }

    public static void testBoltzmannConnected() throws IOException {
        PlanarMap.initStaticParameters();
        Random r = new Random(System.currentTimeMillis());
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        ReaderOfEvaluations.loadAllGeneratingFunctionsValues(in);
        ConnectedMap connected = ConnectedMap.draw_dddC(r);
        // stats
        connected.toScreenParameters();
        // graph
        try {
            PrintWriter out = new PrintWriter(System.out, true);
            connected.printForBedini(out);
        } catch (IOException e) {
            System.out.println("IOException");
            System.exit(-1);
        }
    }

    public static void collectStatisticInfo () throws IOException{
        int N=100;// N is the number of tries
        float mu=(float)2.2132652385;
        int[] nr_vertices=new int[N];
        int[] nr_edges=new int[N];
        float[] ratio_edges_vertices=new float[N];
        float[] gaussian=new float[N];
        float[][] proportion_vertices_of_degree=new float[15][N];
        Random r = new Random(System.currentTimeMillis());
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        ReaderOfEvaluations.loadAllGeneratingFunctionsValues(in);
        int currentIndex=-1;
        for (int i=0;i<N;++i){
            System.out.println(i);
            PlanarMap.initStaticParameters();
            ConnectedMap connected=ConnectedMap.draw_dddC(r);
            if (connected.nr_edges>10000){
                currentIndex++;
                nr_vertices[currentIndex]=connected.vertexList.size();
                nr_edges[currentIndex]=connected.nr_edges;
                ratio_edges_vertices[currentIndex]=(float)nr_edges[currentIndex]/(float)nr_vertices[currentIndex];
                gaussian[currentIndex]=((float)nr_edges[currentIndex]-(float)mu*(float)nr_vertices[currentIndex])/(float)Math.sqrt((double)nr_vertices[currentIndex]);
                int[] degrees=connected.degreeVertices();
                for (int j=1;j<15;++j){
                    if(j<=degrees[0]) proportion_vertices_of_degree[j][currentIndex]=(float)degrees[j]/(float)nr_vertices[currentIndex];
                }
            }
        }
        FileWriter statistics=new FileWriter("/home/fusy/statistics");
        statistics.write("number of successful tries: "+(currentIndex+1)+"\n");
        statistics.write("vertices\n");
        for (int i=0;i<=currentIndex;++i) statistics.write(nr_vertices[i]+" ");
        statistics.write("\n");
        statistics.write("edges\n");
        for (int i=0;i<=currentIndex;++i) statistics.write(nr_edges[i]+" ");
        statistics.write("\n");
        statistics.write("\n");
        statistics.write("ratio\n");
        for (int i=0;i<=currentIndex;++i) statistics.write("],["+i+","+ratio_edges_vertices[i]);
        statistics.write("\n");
        statistics.write("gaussian\n");
        for (int i=0;i<=currentIndex;++i) statistics.write(gaussian[i]+"\n");
        statistics.write("\n");
        statistics.write("degrees\n");
        for (int i=0;i<=currentIndex;++i){
            for (int j=1;j<15;++j)
                statistics.write("],["+j+","+proportion_vertices_of_degree[j][i]);
            statistics.write("\n");
        }
        statistics.close();

    }
}