package Grap;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

@SuppressWarnings({ "unchecked", "deprecation" })
public class AdjMatrix {

    private int[][] matrix;// ma trận kề
    private String[] v;// danh sách các đỉnh
    private int n;// số đỉnh

    public void loadGraphFromFile(String fileName) {
        try {
            Scanner sc = new Scanner(new File(fileName));
            n = sc.nextInt();
            matrix = new int[n][n];
            v = new String[n];
            sc.nextLine();
            for (int i = 0; i < n; i++) {
                v[i] = sc.nextLine();
            }

            for (int u = 0; u < n; u++) {
                for (int v = 0; v < n; v++) {
                    matrix[u][v] = sc.nextInt();
                }
            }
            
            sc.close();
           
        } catch (Exception e) {
            System.out.println("can't open file");
        }

    }

    public List<String> getAdjList() {
        List<String> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            String adj = v[i];
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    adj += "->" + v[j];
                }
            }
            list.add(adj);
        }
        return list;
    }

    public static void main(String[] args) {
        String input = "INP.txt";
        AdjMatrix adj = new AdjMatrix();
        adj.loadGraphFromFile(input);
        for(String list : adj.getAdjList()){
            System.out.println(list);
        }
    }

}
