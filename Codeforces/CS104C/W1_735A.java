import java.util.Scanner;

/**
 * Created by Alex on 1/30/17.
 * Problem: Ostap and Grasshopper
 * http://codeforces.com/problemset/problem/735/A
 */
public class W1_735A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numCells = in.nextInt();
        int jumpLength = in.nextInt();
        in.nextLine();

        String cellString = in.nextLine();
        int gPosition = 0, tPosition = 0;
        boolean obstacles[] = new boolean[numCells];
        for (int i = 0; i < cellString.length(); i++) {
            char cell = cellString.charAt(i);
            if (cell == '#') {
                obstacles[i] = true;
            } else if (cell == 'G') {
                gPosition = i;
            } else if (cell == 'T') {
                tPosition = i;
            }
        }

        if (Math.abs(tPosition - gPosition) % jumpLength == 0) {
            if (tPosition < gPosition) {
                jumpLength *= -1;
            }

            while (gPosition != tPosition) {
                gPosition += jumpLength;
                if (obstacles[gPosition]) {
                    System.out.print("NO");
                    return;
                }
            }

            System.out.print("YES");
            return;
        }

        System.out.print("NO");
    }
}
