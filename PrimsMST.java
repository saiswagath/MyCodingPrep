package com.prac.graphs;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class EdgePrimsMST {
    int targetNode;
    int distanceFromNode;

    EdgePrimsMST(int targetNode, int distance) {
        this.targetNode = targetNode;
        this.distanceFromNode = distance;
    }
}

class GraphPrimsMST {
    List<List<EdgePrimsMST>> graph;
    boolean visited[];
    int nodes;

    GraphPrimsMST(int nodes) {
        graph = new ArrayList<>();
        visited = new boolean[nodes];
        this.nodes = nodes;

        for (int i = 0; i < nodes; i++) {
            graph.add(i, new ArrayList<>());
        }
    }

    public void addEdge(int sourceNode, int targetNode, int distance) {
        graph.get(sourceNode).add(new EdgePrimsMST(targetNode, distance));
        graph.get(targetNode).add(new EdgePrimsMST(sourceNode, distance));
    }

    public int mst() {
        int minCost = 0;

        for(int i = 0; i < nodes; i++) {
            if(!visited[i]) {
                minCost = minCost + minimumSpanningTreeUnweightedGraph(i);
            }
        }

        return minCost;
    }

    public int minimumSpanningTreeUnweightedGraph(int source) {

        PriorityQueue<EdgePrimsMST> minEdgeHeap = new PriorityQueue<>((e1, e2) -> e1.distanceFromNode - e2.distanceFromNode);

        visited[source] = true;
        List<EdgePrimsMST> childOfSource = graph.get(source);

        for(EdgePrimsMST edge: childOfSource) {
            minEdgeHeap.add(edge);
        }

        int minimumCost = 0;
        while (!minEdgeHeap.isEmpty()) {

            EdgePrimsMST minValueEdge = minEdgeHeap.poll();

            if (visited[minValueEdge.targetNode]) {
                continue;
            }

            visited[minValueEdge.targetNode] = true;

            minimumCost = minimumCost + minValueEdge.distanceFromNode;

            List<EdgePrimsMST> childList = graph.get(minValueEdge.targetNode);

            for (EdgePrimsMST edge : childList) {
                if (!visited[edge.targetNode]) {
                    minEdgeHeap.add(edge);
                }
            }
        }

        return minimumCost;
    }
}
public class PrimsMST {

    public static void main(String[] args) {
        int nodes = 5;

        GraphPrimsMST a = new GraphPrimsMST(nodes);

        a.addEdge(0, 1, 6);
        a.addEdge(0, 3, 4);
        a.addEdge(1, 2, 10);
        a.addEdge(1, 3, 7);
        a.addEdge(1, 4, 7);
        a.addEdge(2, 3, 8);
        a.addEdge(2, 4, 5);
        a.addEdge(3, 4, 12);

        System.out.println(a.mst());
    }
}
