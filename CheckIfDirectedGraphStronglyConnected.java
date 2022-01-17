package com.prac.graphs;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class GraphStronglyConnected {
    List<List<Integer>> graph;
    boolean visited[];
    int nodes;

    GraphStronglyConnected(int nodes) {
        graph = new ArrayList<>();
        visited = new boolean[nodes];
        this.nodes = nodes;

        for (int i = 0; i < nodes; i++) {
            graph.add(i, new ArrayList<>());
        }
    }

    public void addEdge(int a, int b) {
        graph.get(a).add(b);
    }

    public boolean ifDirectedGraphStronglyConnected() {

        for(int i = 0; i < nodes; i++) {
            dfs(i);

            for(int j = 0; j < nodes; j++) {
                if(!visited[j]) {
                    return false;
                }
            }

            Arrays.fill(visited, false);
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

    public void dfsAnother(int start) {
        visited[start] = true;

        List<Integer> neighboursList = graph.get(start);

        for (Integer neighbour : neighboursList) {
            if (!visited[neighbour]) {
                dfsAnother(neighbour);
            }
        }
    }
}

public class CheckIfDirectedGraphStronglyConnected {

    public static void main(String[] args) {
        int nodes = 4;

        //Given directed graph is strongly connected if we can reach from any point to any other point in graph.
        GraphStronglyConnected a = new GraphStronglyConnected(nodes);

        a.addEdge(0, 1);
        a.addEdge(1, 2);
        a.addEdge(2, 0);
        a.addEdge(0, 3);
        a.addEdge(3, 2);

        System.out.println(a.ifDirectedGraphStronglyConnected());
    }
}
