package Grap;

import java.util.LinkedList;
import java.util.List;

/*
    2 ---4---->4\
 2/ |  \       |  \2
 /  |   \2     |    \ 
1   |1    \    |3   /6
 \  |       \  |   /
 4\ |        \ |  /2
    3 ---3---->5 
 
*/
public class DjikstraMin implements Graph {
    private int[][] matrix;
    private int n;
    private int[] array;// mang
    private int[] dist;// mang chua tat ca cac duong di ngan nhat cua cac diem bat dau tu diem 0

    public DjikstraMin(int n) {
        this.n = n;
        matrix = new int[n][n];
        array = new int[n];
    }

    public void addArray(int[] a) {
        for (int i = 0; i < n; i++) {
            array[i] = a[i];
        }
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        int m = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != 0) {
                    m++;
                }
            }
        }
        return m / 2;
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
        for (int i = 0; i < n; i++) {
            if (matrix[u][i] != 0)
                d++;
        }
        return d;
    }

    @Override
    public Iterable<Integer> adjacency(int u) {
        // TODO Auto-generated method stub
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (matrix[u][i] != 0)
                list.add(array[i]);
        }

        return list;
    }

    @Override
    public void addEdge(int u, int v) {
        // TODO Auto-generated method stub
    }

    public void addEdge(int u, int v, int weithed) {
        if (matrix[u][v] == 0) {
            matrix[u][v] = weithed;
            matrix[v][u] = weithed;
        }
    }
    // tim chi so diem xuat phat ngan nhat 
    public int getMinimumVertex(int[] a, boolean[] check) {
        int min = Integer.MAX_VALUE, indext = -1;
        for (int i = 0; i < n; i++) {
            if (!check[i] && a[i] < min) {
                min = a[i];
                indext = i;
            }
        }

        return indext;

    }
    // tim diem di ngan nhat
    public int[] djikstra(int[][] a, int x, int y) {
        dist = new int[n];// mang chua tong duong di ngan nhat tu x ---> y (tat ca cac diem)
        int[] result = new int[n];
        boolean[] check = new boolean[n];// mảng kiểm tra xem điểm đã đi chưa nếu chưa qua là false còn qua r là true
        for (int i = 0; i < n; i++) {
            dist[i] = Integer.MAX_VALUE;// cho giá trị ban đầu là vô cùng
            check[i] = false;//đánh dấu tất cả các điểm là chưa đi
        }
        dist[x-1] = 0;
        for(int k = 0; k < n ; k++){
            int u = getMinimumVertex(dist, check);
            if(u == y-1){
                break;
            }
            if(u != -1){
                check[u] = true;
                //vòng lặp tính tổng đường đi ngắn nhất từ điểm x--> các điểm kề nó
                for(int i = 0; i < n; i++){
                    if(!check[i] && a[u][i] != 0 && dist[u] + matrix[u][i] < dist[i] && dist[u] != Integer.MAX_VALUE){
                        dist[i] = dist[u] + matrix[u][i];
                        if(result[k] != array[u]){
                            result[k] = array[u];
                        }
                    }
                }
            }
            
            
        }
        result[y-1] = array[y-1];
        int count = 0;
        for(int i = 0; i < n ; i++){
            if(result[i] != 0){
                count++;
            }
        }
        //mảng các số nguyên tương ứng là đường đi ngắn nhất từ x đến y.
        int[] parth = new int[count];
        int c = 0;
        for(int i = 0; i < n ; i++){
            if(result[i] != 0){
                parth[c] = result[i];
                c++;
            }
        }
        
        return parth;
    }


    public void printMatrix() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        DjikstraMin adj = new DjikstraMin(6);
        // 0:1, 1:2, 2:3, 3:4, 4:5, 5:6
        int[] a = { 1, 2, 3, 4, 5, 6 };
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
        System.out.println("size = " + adj.size());
        System.out.println("order = " + adj.order());
        System.out.println("dergree 3 = " + adj.dergree(2));
        System.out.println("adjacency 1 = " + adj.adjacency(0));
        int[] b = adj.djikstra(adj.matrix, 1, 6);
        for(int i : b){
            System.out.print(i+" ");
        }
        System.out.println();
    }

}
