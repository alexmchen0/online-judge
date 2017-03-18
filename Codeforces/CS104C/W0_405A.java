import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Alex on 1/30/17.
 * Problem: Gravity Flip
 * Description: http://codeforces.com/problemset/problem/405/A
 */
public class W0_405A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numCols = Integer.parseInt(in.nextLine());
        int colValues[] = new int[numCols];

        for (int i = 0; i < numCols; i++) {
            colValues[i] = in.nextInt();
        }

        Arrays.sort(colValues);

        for (int colValue : colValues) {
            System.out.print(colValue + " ");
        }
    }
}
