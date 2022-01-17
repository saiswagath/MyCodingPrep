package com.prac.graphs;

import java.util.*;

class GraphCheckIfDirectedGraphHasCycleInDegreeBFS {
    List<List<Integer>> graph;
    HashMap<Integer, Integer> incomingDegree;
    int visitedNodes;
    int nodes;
    Queue<Integer> sourceQueue;


    GraphCheckIfDirectedGraphHasCycleInDegreeBFS(int nodes) {
        graph = new ArrayList<>();
        incomingDegree = new HashMap<>();
        sourceQueue = new LinkedList<>();
        this.nodes = nodes;
        visitedNodes = 0;


        for (int i = 0; i < nodes; i++) {
            graph.add(i, new ArrayList<>());
            incomingDegree.put(i, 0);
        }
    }

    public void addEdge(int a, int b) {
        graph.get(a).add(b);
        incomingDegree.put(b, incomingDegree.get(b) + 1);
    }
    public boolean checkIfGraphHasCycle(){

        for(Map.Entry<Integer, Integer> entry: incomingDegree.entrySet()) {
            if(entry.getValue() == 0) {
                sourceQueue.add(entry.getKey());
            }
        }

        while(!sourceQueue.isEmpty()) {
            visitedNodes++;
            int source = sourceQueue.remove();

            List<Integer> childrenList = graph.get(source);

            for(Integer child: childrenList) {
                incomingDegree.put(child, incomingDegree.get(child) - 1);

                if(incomingDegree.get(child) == 0) {
                    sourceQueue.add(child);
                }
            }
        }

        return nodes != visitedNodes;
}

}

public class CheckIfDirectedGraphHasCycleInDegreeBFS {
    public static void main(String[] args) {
        int nodes = 4;

        GraphCheckIfDirectedGraphHasCycleInDegreeBFS a = new GraphCheckIfDirectedGraphHasCycleInDegreeBFS(nodes);

        a.addEdge(0, 1);
        a.addEdge(1, 2);
        a.addEdge(2, 0);
        a.addEdge(3, 0);

        System.out.println(a.checkIfGraphHasCycle());
    }
}
