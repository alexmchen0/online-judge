import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by Alex on 2/1/17.
 * Problem: Serial Time!
 * Description: http://codeforces.com/problemset/problem/60/B
 */
public class W2_60B {
    private static int[] dl = {1, 0, 0, -1, 0, 0};
    private static int[] dr = {0, 1, 0, 0, -1, 0};
    private static int[] dc = {0, 0, 1, 0, 0, -1};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numLayers = in.nextInt();
        int numRows = in.nextInt();
        int numCols = in.nextInt();
        char plate[][][] = new char[numLayers][numRows][numCols];

        in.nextLine();
        in.nextLine();

        for (int l = 0; l < numLayers; l++) { // layer
            for (int r = 0; r < numRows; r++) { // row
                plate[l][r] = in.nextLine().toCharArray();
            }
            in.nextLine();
        }

        int startR = in.nextInt() - 1;
        int startC = in.nextInt() - 1;

        LinkedList<Point> toFlow = new LinkedList<>();

        toFlow.add(new Point(0, startR, startC));
        plate[0][startR][startC] = '#';
        int time = 0;

        while (!toFlow.isEmpty()) {
            Point point = toFlow.pop();
            time++;
            for (int d = 0; d < 6; d++) {
                int newL = point.l + dl[d];
                int newR = point.r + dr[d];
                int newC = point.c + dc[d];

                if (newR < 0 || newR >= numRows || newC < 0 || newC >= numCols ||
                        newL < 0 || newL >= numLayers || plate[newL][newR][newC] == '#') {
                    continue;
                }
                plate[newL][newR][newC] = '#';
                toFlow.add(new Point(newL, newR, newC));
            }
        }
        System.out.print(time);
    }

    public static class Point {
        int l, r, c;

        Point(int layer, int row, int col) {
            l = layer;
            r = row;
            c = col;
        }
    }
}