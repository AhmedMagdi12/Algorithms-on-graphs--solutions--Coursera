import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Acyclicity {

    private static int acyclic(ArrayList<Integer>[] adj) {
        // boolean[] hasVisited = new boolean[adj.length];
        // int[] stack = new int[adj.length];
        for (int i = 0; i < adj.length; i++) {
            boolean[] hasVisited = new boolean[adj.length];

            if (DFS(adj, i, hasVisited) != 1) {
                return 1;
            }
            // System.out.println("***********************");
        }
        return 0;

    }

    static int DFS(ArrayList<Integer>[] adj, int current, boolean visited[]) {
        visited[current] = true;
        // System.out.println(current);
        for (int i = 0; i < adj[current].size(); i++) {
            int temp = adj[current].get(i);
            if (!visited[temp]) {
                DFS(adj, temp, visited);
            } else
                return 1;
        }
        return 0;
    }/*
      * private static int acyclic(ArrayList<Integer>[] adj) { boolean[] hasVisited =
      * new boolean[adj.length]; int[] stack = new int[adj.length]; for (int i = 0; i
      * < adj.length; i++) { if(hasVisited[i] == false){ if (DFS(adj,i,hasVisited ,
      * stack) == 1) return 1; } } return 0;
      * 
      * } static int DFS(ArrayList<Integer>[] adj ,int v, boolean visited[] , int[]
      * stack) { visited[v] = true; stack[v] = 1; for(int i = 0; i <
      * adj[v].size();i++){ int temp = adj[v].get(i); if((visited[temp] == false &&
      * DFS(adj, adj[v].get(i), visited, stack) == 1) || stack[adj[v].get(i)] == 1)
      * return 1; } stack[v]=0; return 0; }
      */

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
        System.out.println(acyclic(adj));
    }
}
