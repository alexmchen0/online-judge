import java.util.*;

/**
 * Created by Alex on 2/17/17.
 * Problem: Ping-Pong (Easy Version)
 * Description: http://codeforces.com/problemset/problem/320/B
 */
public class W4_320B {
    private static class Interval {
        int low, high;

        Interval(int low, int high) {
            this.low = low;
            this.high = high;
        }

        private boolean canMoveTo(Interval next) {
            return low > next.low && low < next.high ||
                    high > next.low && high < next.high;
        }
    }

    private static boolean hasPath(ArrayList<LinkedList<Integer>> graph, int start, int dest) {
        LinkedList<Integer> toVisit = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        toVisit.add(start);
        while (!toVisit.isEmpty()) {
            int curNode = toVisit.remove();
            visited.add(curNode);
            for (int node : graph.get(curNode)) {
                if (node == dest) {
                    return true;
                }
                if (!visited.contains(node)) {
                    toVisit.add(node);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numQueries = Integer.parseInt(in.nextLine());
        ArrayList<LinkedList<Integer>> graph = new ArrayList<>();
        ArrayList<Interval> intervals = new ArrayList<>();
        for (int q = 0; q < numQueries; q++) {
            int type = in.nextInt();
            if (type == 1) {
                Interval newNode = new Interval(in.nextInt(), in.nextInt());
                int newNodeIndex = intervals.size();
                intervals.add(newNode);
                graph.add(new LinkedList<>());

                for (int i = 0; i < intervals.size(); i++) {
                    if (intervals.get(i).canMoveTo(newNode)) {
                        graph.get(i).add(newNodeIndex);
                    }
                    if (newNode.canMoveTo(intervals.get(i))) {
                        graph.get(newNodeIndex).add(i);
                    }
                }
            } else {
                if (hasPath(graph, in.nextInt() - 1, in.nextInt() - 1)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }
}
