import java.io.IOException;
import java.util.*;

/**
 * Created by Alex on 2/6/17.
 * Problem: Dijkstra?
 * Description: http://codeforces.com/problemset/problem/20/C
 */
public class W2_20C {
    public static class Node implements Comparable<Node> {
        int id;
        List<Edge> neighbors;
        long cost;
        boolean visited;
        int prevID;

        private Node(int id) {
            this.id = id;
            this.neighbors = new ArrayList<>();
            this.cost = Long.MAX_VALUE;
            this.visited = false;
            this.prevID = -1;
        }

        public int compareTo(Node other) {
            return Long.compare(this.cost, other.cost);
        }
    }

    private static class Edge {
        Node dest;
        int weight;

        Edge(Node dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    private static void dijkstra(Node source) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        source.cost = 0;
        source.visited = true;
        pq.add(source);

        while (!pq.isEmpty()) {
            Node current = pq.remove();

            for (Edge edge : current.neighbors) {
                Node nextNode = edge.dest;
                long newCost = current.cost + edge.weight;

                if (!nextNode.visited || newCost < nextNode.cost) {
                    nextNode.cost = newCost;
                    nextNode.visited = true;
                    nextNode.prevID = current.id;
                    pq.add(nextNode);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        final Scanner scan = new Scanner(System.in);
        // Read in input
        final int numVertices = scan.nextInt();
        final int numEdges = scan.nextInt();

        final List<Node> graph = new ArrayList<>(numVertices);
        for (int i = 0; i < numVertices; i++) {
            graph.add(new Node(i + 1));
        }

        for (int j = 0; j < numEdges; j++) {
            Node startNode = graph.get(scan.nextInt() - 1);
            Node endNode = graph.get(scan.nextInt() - 1);
            int weight = scan.nextInt();
            startNode.neighbors.add(new Edge(endNode, weight));
            endNode.neighbors.add(new Edge(startNode, weight));
        }

        // All of the costs will be saved in the node objects
        dijkstra(graph.get(0));

        long ans = graph.get(numVertices - 1).cost;
        if (ans == Long.MAX_VALUE) {
            System.out.println(-1);
        } else {
            Stack<Integer> path = new Stack<>();
            path.push(numVertices);
            int prevID;
            do {
                prevID = graph.get(path.peek() - 1).prevID;
                path.push(prevID);
            } while (prevID != -1);
            path.pop();

            StringBuilder pathString = new StringBuilder();
            while (!path.isEmpty()) {
                pathString.append(path.pop()).append(" ");
            }
            System.out.println(pathString);
        }
    }
}
