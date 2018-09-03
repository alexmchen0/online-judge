import java.util.*;

/**
 * http://codeforces.com/problemset/problem/514/B
 */
public class WA_514B_2 {
    private static int ox, oy;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        ox = in.nextInt();
        oy = in.nextInt();

        PriorityQueue<Point> points = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            points.add(new Point(in.nextInt(), in.nextInt()));
        }

        int count = 0;
        while (!points.isEmpty()) {
            count++;
            int x1 = points.peek().x - ox;
            int y1 = points.poll().y - oy;
            while (!points.isEmpty()) {
                int x2 = points.peek().x - ox;
                int y2 = points.peek().y - oy;
                if (y1 * x2 == y2 * x1) {
                    points.poll();
                } else {
                    break;
                }
            }
        }
        System.out.println(count);
    }

    private static class Point implements Comparable<Point> {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            int x1 = x - ox;
            int y1 = y - oy;
            int x2 = o.x - ox;
            int y2 = o.y - oy;
            int sign = (x1 < 0 ^ x2 < 0) ? -1 : 1;
            return sign * (y1 * x2 - y2 * x1);
        }
    }
}
