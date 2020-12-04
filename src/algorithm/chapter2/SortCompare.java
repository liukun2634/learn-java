package algorithm.chapter2;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class SortCompare {
    public static double time(SortAlgorithm sortAlgorithm, Double[] a) {
        Stopwatch timer = new Stopwatch();
        sortAlgorithm.sort(a);
        return timer.elapsedTime();
    }

    public static double timeRandomInput(SortAlgorithm sortAlgorithm, int N, int T) {
        double total = 0.0;
        Double[] a = new Double[N];
        for (int t = 0; t < T; t++) {
            for (int i = 0; i < N; i++) {
                a[i] = StdRandom.uniform();
            }
            total += time(sortAlgorithm, a);
        }
        return total;
    }

    public static void main (String[] args) {
        //N is array length, T is random times
        int N = 100000;
        int T = 100;
        StdOut.printf("For %d random Doubles\n", N);
        StdOut.printf("Selection time is: %f \n", timeRandomInput(new Selection(), N, T));
        StdOut.printf("Insertion time is: %f \n", timeRandomInput(new Insertion(), N, T));
        StdOut.printf("Shell time is: %f \n", timeRandomInput(new Shell(), N, T));
    }

}
