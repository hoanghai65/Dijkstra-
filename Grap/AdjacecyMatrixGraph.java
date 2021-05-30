package Grap;
import java.util.LinkedList;
import java.util.List;

public class AdjacecyMatrixGraph implements Graph{

    private int n;
    private boolean[][] a;

    public AdjacecyMatrixGraph(int n){
        this.n = n;
        a = new boolean[n][n];
    }
    @Override
    public int size() {
        // TODO Auto-generated method stub
        return n;
    }

    @Override
    public int order() {
        // TODO Auto-generated method stub
        int m = 0;
        for(int u = 0; u < n; u++)
            for(int v = 0; v < n ; v++)
                if(a[u][v])
                    m++;
        return m/2;
    }

    @Override
    public int dergree(int u) {
        // TODO Auto-generated method stub
        int d = 0;
        for(int v = 0; v < n ; v++){
            if(a[u][v])
                d++;
        }
        return d;
    }

    @Override
    public Iterable<Integer> adjacency(int u) {
        // TODO Auto-generated method stub
        List<Integer> adj = new LinkedList<>();
        for(int v = 0; v < n ; v++)
            if(a[u][v])
                adj.add(v);
        
        return adj;
    }

    @Override
    public void addEdge(int u, int v) {
        // TODO Auto-generated method stub
        a[u][v] = true;
        a[v][u] = true;       
    }


    public static void main(String[] args) {
        AdjacecyMatrixGraph adj = new AdjacecyMatrixGraph(7);
        // 0 H ,1 K, 2 D, 3 T , 4 B
        adj.addEdge(0, 1);
        adj.addEdge(0, 2);
        adj.addEdge(0, 3);
        adj.addEdge(0, 4);

        adj.addEdge(3, 4);
        adj.addEdge(2, 3);
        adj.addEdge(1, 3);

        System.out.println("Size = "+ adj.size());
        System.out.println("Dergree = "+ adj.dergree(4) );
        System.out.println("Adjacency 4 = "+  adj.adjacency(4));
     }
}