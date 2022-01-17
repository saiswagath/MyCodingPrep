package com.prac.graphs;
import java.util.ArrayList;
import java.util.List;

class GraphCheckIfDirectedGraphHasCycle {
    List<List<Integer>> graph;
    boolean visited[], recursiveStack[];
    int nodes;

    GraphCheckIfDirectedGraphHasCycle(int nodes) {
        graph = new ArrayList<>();
        visited = new boolean[nodes];
        recursiveStack = new boolean[nodes];
        this.nodes = nodes;

        for (int i = 0; i < nodes; i++) {
            graph.add(i, new ArrayList<>());
        }
    }

    public void addEdge(int a, int b) {
        graph.get(a).add(b);
    }

    public boolean ifDirectedGraphHasCycle() {

        for (int i = 0; i < nodes; i++) {
            if(dfs(i)) {
                return true;
            }
        }

        return false;
    }

    public boolean dfs(int index) {
        if(recursiveStack[index]) {
            return true;
        }

        if(visited[index]) {
            return false;
        }

        visited[index] = true;
        recursiveStack[index] = true;

        List<Integer> neighboursList = graph.get(index);

        for (Integer neighbour : neighboursList) {
            if (dfs(neighbour)) {
                return true;
            }
        }

        recursiveStack[index] = false;
        return false;
    }
}

public class CheckIfDirectedGraphHasCycle {
    public static void main(String[] args) {
        int nodes = 5;

        GraphCheckIfDirectedGraphHasCycle a = new GraphCheckIfDirectedGraphHasCycle(nodes);

        a.addEdge(0, 1);
        a.addEdge(1, 2);
        a.addEdge(0, 2);
        a.addEdge(0, 3);
        a.addEdge(3, 4);
        a.addEdge(4, 0);

        System.out.println(a.ifDirectedGraphHasCycle());
    }
}
