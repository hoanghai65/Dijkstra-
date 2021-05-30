package Grap;

import java.util.LinkedList;
import java.util.List;

public class GrapRoadMin implements Graph{
    private int[][] matrix;
    private int n;
    private int[] array;
    private int[] dist;
    public GrapRoadMin(int n){
        this.n = n;
        matrix = new int[n][n];
        array = new int[n];
    }
    public void addArray(int[] a){
        for(int i = 0; i < n; i++){
            array[i] = a[i];
        }
    }
    @Override
    public int size() {
        // TODO Auto-generated method stub
        int m = 0;
        for(int i = 0; i < n ; i++){
            for(int j = 0; j < n ; j++){
                if(matrix[i][j] != 0){
                    m++;
                }
            }
        }
        return m/2;
    }

    @Override
    public int order() {
        // TODO Auto-generated method stub
        return n;
    }

    @Override
    public int dergree(int u) {
        // TODO Auto-generated method stub
        int d = 0;
        for(int i = 0; i < n ;i++){
            if(matrix[u][i] != 0)
                d++;
        }
        return d;
    }

    @Override
    public Iterable<Integer> adjacency(int u) {
        // TODO Auto-generated method stub
        List<Integer> list = new LinkedList<>();
        for(int i = 0; i < n ;i++){
            if(matrix[u][i] != 0)
                list.add(array[i]);
        }
        
        return list;
    }

    @Override
    public void addEdge(int u, int v) {
        // TODO Auto-generated method stub
        
    }
    public void addEdge(int u, int v,int weithed) {
        if(matrix[u][v] == 0){
            matrix[u][v] = weithed;
            matrix[v][u] = weithed;
        }
    }
    public int distanceMin(int[] a, boolean[] check){
        int min = Integer.MAX_VALUE, indext = -1;
        for(int i = 0; i < n ;i++){
            if(!check[i] && a[i] < min){
                min =  a[i];
                indext = i;
            }
        }

        return indext;

    }

    public int[] djikstra(int[][] a, int x, int y)
    {
        dist = new int[n];
        boolean[] check = new boolean[n];
        for(int i = 0; i < n ; i++){
            dist[i] = Integer.MAX_VALUE;
            check[i] = false;
        }
        dist[x] = 0;
        for(int count = 0 ; count < n ; count++){
            int u = distanceMin(dist, check);
            check[u] = true;
            for(int i = 0; i < n ;i++){
                if(!check[i] && a[u][i] != 0 &&  dist[u] + a[u][i] < dist[i]){
                    dist[i] = dist[u] + a[u][i];
                }
            }
        }
        return dist;
    }

    public void listDjikstra(int[][] a, int x, int y , List<Integer>[] list){
        for(int i = 0; i < n ;i++){
            
        }
    }
    public void printMatrix(){
        for(int i = 0; i < n ; i++){
            for(int j = 0; j < n ; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        GrapRoadMin adj = new GrapRoadMin(6);
        // 0:1, 1:2, 2:3, 3:4, 4:5, 5:6 
        int[] a = {1,2,3,4,5,6};
        adj.addArray(a);
        adj.addEdge(0, 1, 2);
        adj.addEdge(0, 2, 4);

        adj.addEdge(1, 2, 1);
        adj.addEdge(1, 3, 4);
        adj.addEdge(1, 4, 2);

        adj.addEdge(2, 4, 3);

        adj.addEdge(3, 4, 3);
        adj.addEdge(3, 5, 2);

        adj.addEdge(4, 5, 2);

        System.out.println("Matrix");
        adj.printMatrix();
        System.out.println("size = "+adj.size());
        System.out.println("order = "+ adj.order());
        System.out.println("dergree 3 = " +adj.dergree(2));
        System.out.println("adjacency 1 = "+ adj.adjacency(0));
        int[] b = adj.djikstra(adj.matrix, 0,5);
        for(int i : b){
            System.out.print(i + " ");
        }
    }
    
}
