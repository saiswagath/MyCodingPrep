package com.prac.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class GraphUndirectedConnected {
    List<List<Integer>> graph;
    boolean visited[];
    int nodes;

    GraphUndirectedConnected(int nodes) {
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

    public boolean ifGraphConnected() {
        int startIndex = 0;
        dfs(startIndex);

        for(int i = 0; i < visited.length; i++) {
            if(!visited[i]) {
                return false;
            }
        }

        return true;
    }

    public void dfs(int start) {
        Stack<Integer> stack = new Stack<>();

        stack.push(start);
        visited[start] = true;

        while(!stack.isEmpty()) {

            Integer node = stack.pop();

            List<Integer> neighboursList = graph.get(node);

            for(Integer neighbour: neighboursList) {
                if(!visited[neighbour]) {
                    stack.push(neighbour);
                    visited[neighbour] = true;
                }
            }
        }
    }
}

public class CheckIfUndirectedGraphIsConnected {

    public static void main(String[] args) {
        int nodes = 7;

        GraphUndirectedConnected a = new GraphUndirectedConnected(nodes);

        a.addEdge(0, 1);
        a.addEdge(0, 2);
        a.addEdge(1, 3);
        a.addEdge(2, 4);
        a.addEdge(3, 5);
        a.addEdge(4, 5);
        a.addEdge(4, 6); // uncomment this to return false... i.e you are deleting the edge

        System.out.println(a.ifGraphConnected());
    }
}
