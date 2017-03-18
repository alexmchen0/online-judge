import java.util.*;

/**
 * Created by Alex on 2/26/17.
 * Problem: Fox and Names
 * Description: http://codeforces.com/problemset/problem/510/C
 */
public class W5_510C {
    private static boolean hasCycle(LinkedList<Integer>[] graph) {
        for (int i = 0; i < 26; i++) {
            LinkedList<Integer> toVisit = new LinkedList<>();
            HashSet<Integer> visited = new HashSet<>();

            toVisit.push(i);
            while (!toVisit.isEmpty()) {
                int curNode = toVisit.pop();
                visited.add(curNode);
                for (int node : graph[curNode]) {
                    if (node == i) {
                        return true;
                    }
                    if (!visited.contains(node)) {
                        toVisit.push(node);
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numNames = Integer.parseInt(in.nextLine());

        LinkedList<Integer>[] graph = new LinkedList[26];
        for (int i = 0; i < 26; i++) {
            graph[i] = new LinkedList<>();
        }
        int[] inDegrees = new int[26];

        String prev = in.nextLine();
        String next;

        forLoop:
        for (int n = 0; n < numNames - 1; n++) {
            next = in.nextLine();
            int idx = 0;
            while (idx < prev.length() && idx < next.length()) {
                char prevChar = prev.charAt(idx);
                char nextChar = next.charAt(idx);
                if (prevChar != nextChar) {
                    graph[prevChar - 'a'].add(nextChar - 'a');
                    inDegrees[nextChar - 'a']++;
                    prev = next;
                    continue forLoop;
                }
                idx++;
            }
            if (prev.length() > next.length()) {
                System.out.println("Impossible");
                return;
            }
            prev = next;
        }

        if (hasCycle(graph)) {
            System.out.println("Impossible");
        } else {
            StringBuilder order = new StringBuilder();
            LinkedList<Integer> toVisit = new LinkedList<>();
            for (int i = 0; i < 26; i++) {
                if (inDegrees[i] == 0) {
                    toVisit.add(i);
                }
            }

            while (!toVisit.isEmpty()) {
                int i = toVisit.pop();
                order.append((char) (i + 'a'));
                for (int node : graph[i]) {
                    inDegrees[node]--;
                    if (inDegrees[node] == 0) {
                        toVisit.push(node);
                    }
                }
            }
            System.out.println(order.toString());
        }
    }
}
