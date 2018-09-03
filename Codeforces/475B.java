import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Problem: Strongly Connected City
 * http://codeforces.com/problemset/problem/475/B
 */
public class W5_475B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numRows = in.nextInt();
        int numCols = in.nextInt();
        in.nextLine();
        LinkedList<Integer>[] graph = new LinkedList[numRows * numCols];
        char[] rows = in.nextLine().toCharArray();
        char[] cols = in.nextLine().toCharArray();

        for (int r = 0; r < numRows; r++) {
            for (int c = 0; c < numCols; c++) {
                int nodeID = r * numCols + c;
                graph[nodeID] = new LinkedList<>();

                char rDir = rows[r];
                if (rDir == '<' && c != 0) {
                    graph[nodeID].add(nodeID - 1);
                } else if (rDir == '>' && c != numCols - 1) {
                    graph[nodeID].add(nodeID + 1);
                }

                char cDir = cols[c];
                if (cDir == '^' && r != 0) {
                    graph[nodeID].add(nodeID - numCols);
                } else if (cDir == 'v' && r != numRows - 1) {
                    graph[nodeID].add(nodeID + numCols);
                }
            }
        }

        HashSet<Integer> visited = new HashSet<>();
        LinkedList<Integer> toVisit = new LinkedList<>();

        int nodeID = 0;
        toVisit.add(nodeID);
        while (!toVisit.isEmpty()) {
            int curNode = toVisit.remove();
            for (int node : graph[curNode]) {
                if (!visited.contains(node)) {
                    visited.add(node);
                    toVisit.add(node);
                }
            }
        }

        if (visited.size() != numRows * numCols) {
            System.out.println("NO");
            return;
        }

        System.out.println("YES");
    }
}
