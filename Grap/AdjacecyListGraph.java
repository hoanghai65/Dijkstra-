package Grap;
import java.util.LinkedList;
import java.util.List;

public class AdjacecyListGraph implements Graph {
    private int n;
    private List<Integer>[] a;

    public AdjacecyListGraph(int n){
        this.n = n;
        a = new LinkedList[n];
        for(int i = 0; i < n ;i++){
            a[i] = new LinkedList<>();
        }
    }
    @Override
    public int size() {
        // TODO Auto-generated method stub
        int s = 0;
        for(int i = 0 ; i < n ; i++)
            s += a[i].size();
        return s/2;
    }

    @Override
    public int order() {
        // TODO Auto-generated method stub
        return n;
    }

    @Override
    public int dergree(int u) {
        
        return a[u].size();
    }

    @Override
    public Iterable<Integer> adjacency(int u) {
        // TODO Auto-generated method stub
        List<Integer> adj = new LinkedList<>();
        adj = a[u];
        return adj;
    }

    @Override
    public void addEdge(int u, int v) {
        // TODO Auto-generated method stub
        if(!a[u].contains(v)){
            a[u].add(v);
            a[v].add(u);
        }
        
    }

    public static void main(String[] args) {
        AdjacecyListGraph adj = new AdjacecyListGraph(5);
        // 0 H ,1 K, 2 D, 3 T , 4 B
        adj.addEdge(0, 1);
        adj.addEdge(0, 2);
        adj.addEdge(0, 3);
        adj.addEdge(0, 4);;

        adj.addEdge(3, 4);
        adj.addEdge(2, 3);
        adj.addEdge(1, 3);

        System.out.println("Size = "+ adj.size());
        System.out.println("Dergree = "+ adj.dergree(4) );
        System.out.println("Adjacency 4 = "+  adj.adjacency(4));
        System.out.println("Adjacency 0 = "+  adj.adjacency(0));
    }
    
}
