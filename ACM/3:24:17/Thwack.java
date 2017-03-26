import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by Alex on 3/24/17.
 */
public class Thwack {
    private static int[] dr = {1, 0, -1, 0};
    private static int[] dc = {0, 1, 0, -1};
    private static int rows, cols, height;
    private static Point start, end;
    private static int[][] graph;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numTests = Integer.parseInt(in.nextLine());
        for (int t = 0; t < numTests; t++) {
            rows = in.nextInt();
            cols = in.nextInt();
            in.nextLine();
            height = in.nextInt();

            graph = new int[rows][cols];
            for (int r = 0; r < rows; r++) {
                in.nextLine();
                for (int c = 0; c < cols; c++) {
                    String next = in.next();
                    if (next.equals("A")) {
                        graph[r][c] = 101;
                        start = new Point(r, c);
                    } else if (next.equals("W")) {
                        graph[r][c] = 102;
                        end = new Point(r, c);
                    } else {
                        graph[r][c] = Integer.parseInt(next);
                    }

                }
            }
            System.out.println(hasPath() ? "LUNCH!" : "THWACK!");
        }
    }

    private static boolean hasPath() {
        boolean[][] visited = new boolean[rows][cols];
        LinkedList<Point> next = new LinkedList<>();
        next.add(start);

        while (!next.isEmpty()) {
            Point point = next.remove();
            if (point.equals(end)) {
                return true;
            }

            if (visited[point.r][point.c]) {
                continue;
            }

            visited[point.r][point.c] = true;

            for (int d = 0; d < 4; d++) {
                int newR = point.r + dr[d];
                int newC = point.c + dc[d];
                if (newR < rows && newR >= 0 &&
                        newC < cols && newC >= 0 &&
                        (graph[newR][newC] > height ||
                                graph[newR][newC] == -1)) {
                    next.add(new Point(newR, newC));
                }
            }
        }
        return false;
    }

    private static class Point{
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public boolean equals(Object obj) {
            Point other = (Point) obj;
            return this.r == other.r &&
                    this.c == other.c;
        }
    }
}
