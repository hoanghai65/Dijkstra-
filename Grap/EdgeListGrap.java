package Grap;
import java.util.LinkedList;
import java.util.List;

import javax.xml.namespace.QName;

public class EdgeListGrap implements Graph {
    private int n;
    private List<Edge> edge;
    

    class Edge{
        int u;
        int v;

        public Edge(int u, int v){
            this.u = u;
            this.v = v;
        }
    }

    public EdgeListGrap(int n){
        this.n = n;
        edge = new LinkedList<>();
    }
    @Override
    public int size() {
        // TODO Auto-generated method stub
        return edge.size();
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
        for(Edge edge: edge){
            if(edge.u == u || edge.v == u){
                d++;
            }
        } 
        return d;
    }

    @Override
    public Iterable<Integer> adjacency(int u) {
        // TODO Auto-generated method stub
        List<Integer> list = new LinkedList<>();
		for (Edge edge : edge)
			if (edge.u == u)
				list.add(edge.v);
			else if (edge.v == u)
				list.add(edge.u);
		return list;
    }

    @Override
    public void addEdge(int u, int v) {
        // TODO Auto-generated method stub
        if(!edge.contains(new Edge(u, v))){
            edge.add(new Edge(u, v));
        }
        
    }

    public static void main(String[] args) {
        EdgeListGrap adj = new EdgeListGrap(5);
        adj.addEdge(0, 1);
        adj.addEdge(0, 2);
        adj.addEdge(0, 3);
        adj.addEdge(0, 4);;

        adj.addEdge(3, 4);
        adj.addEdge(2, 3);
        adj.addEdge(1, 3);

        System.out.println("Size = "+ adj.size());
        System.out.println("order = "+ adj.order());
        System.out.println("Dergree = "+ adj.dergree(4) );
        System.out.println("Adjacency 4 = "+  adj.adjacency(4));
        System.out.println("Adjacency 0 = "+  adj.adjacency(0));
    }
    
}
