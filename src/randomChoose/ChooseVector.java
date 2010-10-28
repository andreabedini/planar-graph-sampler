package randomChoose;

import java.util.Random;

public class ChooseVector {
    double[] values;
    int nr_values = 0;

    /** Creates a new instance of ChooseVector */
    public ChooseVector(int n) {
        values = new double[n];
        this.nr_values = n;
    }

    public void setDoubleAt(int i, double x) {
        if (i >= this.nr_values) {
            System.out.println(x);
        }
        this.values[i] = x;
    }

    // if the array values is [p0,p1,...,pk], the procedure choose returns a random index i in [0,i-1]
    // such that Pr(i)=pi
    public int choose(Random random) {
        int i = 0;
        double u = random.nextDouble();
        while (values[i] < u)
            i++;
        return i;
    }

    public void toScreen() {
        for (int i = 0; i < nr_values; i++) {
            System.err.println("value at index " + i + ": " + values[i]);
        }
        System.err.println("");
    }
}
