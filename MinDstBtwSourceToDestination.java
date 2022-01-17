package com.prac.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class GraphMinDstBtwSourceToDestination {
    List<List<Integer>> graph;
    boolean visited[];

    GraphMinDstBtwSourceToDestination(int nodes) {
        graph = new ArrayList<>();
        visited = new boolean[nodes];

        for(int i = 0; i < nodes; i++) {
            graph.add(i, new ArrayList<>());
        }
    }

    public void addEdge(int a, int b) {
        graph.get(a).add(b);
        graph.get(b).add(a);
    }

    public int minimumDistanceBetweenTwoNodes(int source, int destination) {
        if(source == destination) {
            return 0;
        }

        Queue<Integer> queue = new LinkedList<>();
        int minDistance = 0;

        queue.add(source);
        visited[source] = true;

        while(!queue.isEmpty()) {
            int size = queue.size(); // number of nodes to process in specific level

            while(size > 0) {
                Integer node = queue.poll();

                List<Integer> childList = graph.get(node);

                for(Integer child: childList) {
                    if(child == destination) {
                        return ++minDistance;
                    }
                    if(!visited[child]) {
                        queue.add(child);
                        visited[child] = true;
                    }
                }

                size--;
            }

            minDistance++;
        }

        return -1;
    }

}
public class MinDstBtwSourceToDestination {
    public static void main(String[] args) {
        int nodes = 6;

        GraphMinDstBtwSourceToDestination a = new GraphMinDstBtwSourceToDestination(nodes);

        a.addEdge(0, 1);
        a.addEdge(0, 3);
        a.addEdge(1, 2);
        a.addEdge(3, 4);
        a.addEdge(2, 4);
        a.addEdge(4, 5);

        System.out.println(a.minimumDistanceBetweenTwoNodes(0, 5));
    }
}
