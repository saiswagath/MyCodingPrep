package com.prac.graphs;

import java.util.ArrayList;
import java.util.List;

class GraphUndirectedGraphHasCycle {
    List<List<Integer>> graph;
    boolean visited[];
    int nodes;

    GraphUndirectedGraphHasCycle(int nodes) {
        graph = new ArrayList<>();
        visited = new boolean[nodes];
        this.nodes = nodes;

        for (int i = 0; i < nodes; i++) {
            graph.add(i, new ArrayList<>());
        }
    }

    public void addEdge(int a, int b) {
        graph.get(a).add(b);
        graph.get(b).add(a);
    }

    public boolean ifUndirectedGraphHasCycle() {

        for(int i = 0; i < nodes; i++) {
            if(!visited[i]) {
                if(dfs(i, -1)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean dfs(int index, int parent) {

        visited[index] = true;

        List<Integer> neighbourList = graph.get(index);

        for(Integer neighbour: neighbourList) {
            if(!visited[neighbour]) {
                dfs(neighbour, index);
            } else if(neighbour != parent) {
                return true;
            }
        }

        return false;
    }
}

public class CheckUndirectedGraphHasCycle {

    public static void main(String[] args) {
        int nodes = 3;

        GraphUndirectedGraphHasCycle a = new GraphUndirectedGraphHasCycle(nodes);

        a.addEdge(0, 1);
        a.addEdge(1, 2);
        //a.addEdge(2, 0);

        System.out.println(a.ifUndirectedGraphHasCycle());
    }
}
