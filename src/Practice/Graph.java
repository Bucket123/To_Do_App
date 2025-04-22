package Practice;

import java.util.ArrayList;

public class Graph {

    public static class Edge{
        Vertex u;
        Vertex v;
        public Edge(Vertex u, Vertex v){
            this.u = u;
            this.v = v;
        }
    }
    public static class Vertex{
        int vtx;
        ArrayList<Edge> nbrs;
        public Vertex(int vtx){
            this.vtx = vtx;
        }
    }

    public static void main(String[] args) {
        Vertex a = new Vertex(0);
        Vertex b = new Vertex(1);
        Vertex c = new Vertex(2);
        Vertex d = new Vertex(3);

        // a---b & a---c
        Edge atb = new Edge(a,b);
        Edge atc = new Edge(a,c);
        ArrayList<Edge> atbC = new ArrayList<>();
        atbC.add(atb);
        atbC.add(atc);
        a.nbrs=atbC;

        // b---d & b---a
        Edge bta = new Edge(b,a);
        Edge btd = new Edge(b,d);
        ArrayList<Edge> btaC = new ArrayList<>();
        atbC.add(bta);
        atbC.add(atc);
        a.nbrs=btaC;
    }
}
