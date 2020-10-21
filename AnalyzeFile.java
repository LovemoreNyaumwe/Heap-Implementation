import java.util.ArrayList;

public class AnalyzeFile<V extends Comparable<V>> {
    public static void main(String[] args) {
        ReadFile textFile = new ReadFile("TextFile1.txt");
        MyHeap<Word> fileMinHeap = new MyHeap<>(true);
        MyHeap<Word> fileMaxHeap = new MyHeap<>(false);
        fileMaxHeap.build(textFile.process());
        fileMinHeap.build(textFile.process());

        int n = 5;
        int[] a;
        a = new int[]{4, 0, 1, -2, 3};
        mutateTheArray(n, a);

        System.out.println("10 most common words ");
        for (int i = 0; i < 10; i++) {
            System.out.println(fileMaxHeap.remove());
        }
        System.out.println("10 least common words ");
        for (int i = 0; i < 10; i++) {
            System.out.println(fileMinHeap.remove());
        }
        int[] num = new int[11];
        num[0] = 12;
        num[1] = 44;
        num[2] = 13;
        num[3] = 88;
        num[4] = 23;
        num[5] = 94;
        num[6] = 11;
        num[7] = 39;
        num[8] = 20;
        num[9] = 16;
        num[10] = 5;


        int[] keys = new int[num.length];
        //h(key) = (2*key +5) mod 11
        //12,44,13,88,23,94,11,39,20,16, and 5,
        for (int i = 0; i < num.length; i++) {
            keys[i] = (2 * num[i] + 5) % 11;
            //System.out.println(keys[i]+ " "+ num[i]);
        }
    }

    public static int[] mutateTheArray(int n, int[] a) {
        int[] b = new int[n];
        for (int i = 0; i < b.length; i++) {
            if (i - 1 == -1) {
                b[0] = 0 + a[i] + a[i + 1];
            }
            if (i + 1 == b.length) {
                b[i] = a[i - 1] + a[i] + 0;
            } else {
                b[i] = a[i - 1] + a[i] + a[i + 1];
            }
        }
        System.out.println(b);
        return b;
    }

    boolean alternatingSort(int[] a) {
        boolean isSorted = false;
        int [] b = new int[a.length];
        b[0] = a[0];
        for (int i = 0; i<b.length; i++){
            if(i%2 == 0){
                b[i+1] = a[a.length-i];
            }
            else{
                b[i+1] = a[i];
            }
        }
        return isSorted;
    }
    int[][] meanGroups(int[][] a) {
        int[][] b = new int[a.length][1];
        for(int i = 0; i<a.length; i++){
            b[i][1] = 0;
            for(int j = 0; j < a[i].length; j++){
                b[i][1] += a[i][j];
            }
            b[i][1] /= a[i].length;

        }
        return b;
    }
}
