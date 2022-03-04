import java.util.ArrayList;
import java.util.Scanner;

public class NegativeCycle {
    private static int negativeCycle(ArrayList<Integer>[] adj, ArrayList<Integer>[] cost) {
        int len = adj.length;
        float dist[] = new float[len];
        boolean sptSet[] = new boolean[len];
        for (int i = 0; i < len; i++) {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }
        dist[0] = 0;

        for (int j = 0; j < len; j++) {

            for (int u = 0; u < len; u++) {
                for (int v : adj[u]) {
                    int v_index = adj[u].indexOf(v);

                    if (dist[u] + cost[u].get(v_index) < dist[v]) {

                        dist[v] = dist[u] + cost[u].get(v_index);
                        if (j == len - 1)
                            return 1;
                    }

                }
            }

        }

        return 0;

        // print the constructed distance array

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
        System.out.println(negativeCycle(adj, cost));
    }
}
