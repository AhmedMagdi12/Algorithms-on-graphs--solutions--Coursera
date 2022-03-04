import java.util.*;

public class Dijkstra {

    static class Node implements Comparable<Node> {

        int index;
        long distance;

        public Node(int index, long distance) {

            this.index = index;
            this.distance = distance;

        }

        @Override
        public int compareTo(Node node) {
            if (this.distance > node.distance)
                return 1;
            else if (this.distance < node.distance)
                return -1;
            else
                return 0;
        }

    }

    private static long distance(ArrayList<Integer>[] adj, ArrayList<Integer>[] cost, int s, int t) {

        int dist[] = new int[adj.length];
        boolean sptSet[] = new boolean[adj.length];
        for (int i = 0; i < adj.length; i++) {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }
        dist[s] = 0;
        PriorityQueue<Node> q = new PriorityQueue<Node>();
        q.add(new Node(s, dist[s]));

        while (!q.isEmpty()) {
            Node uu = q.remove();
            int u = uu.index;
            sptSet[u] = true;
            for (int v : adj[u]) {

                int v_index = adj[u].indexOf(v);

                if (dist[u] + cost[u].get(v_index) < dist[v]) {

                    dist[v] = dist[u] + cost[u].get(v_index);
                    q.add(new Node(v, dist[v]));

                }

            }
        }
        if (dist[t] == Integer.MAX_VALUE)
            return -1;

        // print the constructed distance array

        return dist[t];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[]) new ArrayList[n];
        ArrayList<Integer>[] cost = (ArrayList<Integer>[]) new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
            cost[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y, w;
            x = scanner.nextInt();
            y = scanner.nextInt();
            w = scanner.nextInt();
            adj[x - 1].add(y - 1);
            cost[x - 1].add(w);
        }
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        System.out.println(distance(adj, cost, x, y));
    }
}