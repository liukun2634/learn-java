package algorithm.chapter2;

public class Insertion extends Example {
    public static void sort(Comparable a[]) {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            //merge j>0 and less in one condition
            for (int j = i ; j > 0 && less(a[j], a[j-1]); j--) {
                    exch(a, j, j-1);
                }
            }
        }
    }
}
