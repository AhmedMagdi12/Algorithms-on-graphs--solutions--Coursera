import java.util.ArrayList;
import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class ConnectingPoints {
    private static class Nodes {
        int x;
        int y;
        int root;
        int rank;
        public Nodes (int x , int y , int root) {

        this.x = x;
        this.y = y;
        this.root=root;
        this.rank=0;
        }
    }
    private static class Edge {
        int x;
        int y;
        double weight;
        public Edge (int u , int v , double weight) {
        this.x = u;
        this.y = v;
        this.weight=weight;
        }


    }

    static double compute_distance(int x1 , int y1 , int x2 , int y2) {
    return Math.sqrt(Math.pow( x1-x2 , 2)+Math.pow( y1-y2 , 2));
    }

    static int find (int v , Nodes[] N){

        if(v != N[v].root){

            N[v].root = find(N[v].root, N);

        }
        return N[v].root;
    }

    static void Union(int u , int v ,Nodes[] nodes){

        int root1 = find(u, nodes);
        int root2 = find(v, nodes);



        if(root1 != root2){
            if(nodes[root1].rank > nodes[root2].rank)
                nodes[root2].root = root1;
            else{
                nodes[root1].root = root2;
                if(nodes[root1].rank ==  nodes[root2].rank)
                    nodes[root2].rank++;
            }
        }

    }

    private static double minimumDistance(int[] x, int[] y) {
        double result = 0.;
        //write your code here

        Nodes[] arr = new Nodes[x.length];
        Queue<Edge> q = new PriorityQueue<Edge>(new Comparator<Edge>(){
            @Override
            public int compare(Edge e1, Edge e2) {
                return e1.weight > e2.weight ? 1 : -1;
            }
        });

        for(int i = 0; i < x.length; i++){

            arr[i] = new Nodes(x[i] , y[i] , i);
        }


        for(int i = 0; i < x.length; i++) {

            for(int j = i + 1 ; j < x.length; j++) {


                q.add(new Edge(i , j , compute_distance(x[i], y[i], x[j], y[j])));
            }
        }

        while(!q.isEmpty()) {
            Edge e = q.poll();
            if(find(e.x, arr) != find(e.y, arr)){
                result+=e.weight;
                //  union u and v
                Union(e.x , e.y , arr);
            }

        }
        return result;

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = scanner.nextInt();
            y[i] = scanner.nextInt();
        }
        DecimalFormat form = new DecimalFormat("0.0000000");
        System.out.println(form.format(minimumDistance(x, y)));
    }
}
