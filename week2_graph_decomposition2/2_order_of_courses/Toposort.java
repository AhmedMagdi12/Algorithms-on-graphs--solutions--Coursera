import com.sun.jndi.url.iiop.iiopURLContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Toposort {
    private static ArrayList<Integer> toposort(ArrayList<Integer>[] adj) {
        int visited[] = new int[adj.length];
        ArrayList<Integer> order = new ArrayList<Integer>();
        // write your code here
        for (int i = 0; i < adj.length; i++) {
            if (visited[i] == 0)
                dfss(i, adj, visited, order);

        }
        Collections.reverse(order);
        return order;
    }

    private static void dfss(int s, ArrayList<Integer>[] adj, int[] visited, ArrayList<Integer> order) {
        visited[s] = 1;

        for (int i = 0; i < adj[s].size(); i++) {

            if (visited[adj[s].get(i)] == 0) {
                dfss(adj[s].get(i), adj, visited, order);
            }
        }
        order.add(s);
    }

    private static void dfs(ArrayList<Integer>[] adj, int[] used, ArrayList<Integer> order, int s) {
        // write your code here
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[]) new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
        }
        ArrayList<Integer> order = toposort(adj);
        for (int x : order) {
            System.out.print((x + 1) + " ");
        }
    }
}
