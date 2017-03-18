import java.util.Scanner;

/**
 * Created by Alex on 2/12/17.
 * Problem: Burning Midnight Oil
 * Description: http://codeforces.com/problemset/problem/165/B
 */
public class W3_165B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numLines = in.nextInt();
        int decayFactor = in.nextInt();
        int low = 0;
        int high = numLines;
        while (low + 1 < high) {
            int mid = (low + high) / 2;
            if (p(numLines, decayFactor, mid)) {
                low = mid;
            } else {
                high = mid;
            }
        }
        System.out.print(high);
    }

    private static boolean p(int numLinesNeeded, int decayFactor, int initial) {
        int numLinesWritten = 0;
        int numTea = 0;
        int codeWritten = (int) (initial / Math.pow(decayFactor, numTea));
        while (codeWritten > 0) {
            numLinesWritten += codeWritten;
            numTea++;
            codeWritten = (int) (initial / Math.pow(decayFactor, numTea));
        }
        return numLinesNeeded > numLinesWritten;
    }
}
