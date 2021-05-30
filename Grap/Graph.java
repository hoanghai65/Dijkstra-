package Grap;
public interface Graph{
    int size(); // number of edge
    int order(); //number of vertices
    int dergree(int u);// dergree of node /vertex 
    Iterable<Integer> adjacency(int u);//get a colletion of vertices adjcent to u
    void addEdge(int u, int v);
}