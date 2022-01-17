package com.prac.design;

import java.util.*;

public class LFUCache {

    Node head = new Node();
    Node tail = new Node();
    Map<Integer,Node> nodemap;
    Map<Integer,Integer> countmap;
    int cache_capacity;

    public LFUCache(int capacity) {
        nodemap = new HashMap(capacity);
        countmap = new HashMap(capacity);
        this.cache_capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        int result = -1;
        Node node = nodemap.get(key);
        Integer countMapKey = countmap.get(key);
        if(node != null && countMapKey != null){
            result = node.val;
            remove(node);
            add(node);
            countmap.put(key, countMapKey + 1);
        }
        return result;
    }

    public void put(int key, int value) {
        Node node = nodemap.get(key);
        Integer countMapKey = countmap.get(key);
        if(node != null && countMapKey != null){
            remove(node);
            node.val = value;
            countmap.put(key, countMapKey + 1);
            add(node);
        }else{
            if(nodemap.size() == cache_capacity){
                int minVal = Collections.min(countmap.keySet());
                for (Map.Entry<Integer, Integer> entry : countmap.entrySet()) {  // Itrate through hashmap
                    if (entry.getValue()==minVal) {
                        minVal = entry.getKey();
                    }
                }
                Node tempNode = nodemap.get(minVal);
                nodemap.remove(minVal);
                countmap.remove(minVal);
                remove(tempNode);
            }

            Node newnode = new Node();
            newnode.key = key;
            newnode.val = value;
            nodemap.put(key,newnode);
            countmap.put(key,1);
            add(newnode);

        }
    }

    public void add(Node node){
        Node head_next = head.next;
        head.next = node;
        node.prev = head;
        node.next = head_next;
        head_next.prev = node;
    }

    public void remove(Node node){
        Node next_node = node.next;
        Node prev_node = node.prev;
        next_node.prev = prev_node;
        prev_node.next = next_node;
    }

    class Node{
        int key;
        int val;
        Node next;
        Node prev;

    }

    public static void main(String[] args) {
        LFUCache  lfuCache = new LFUCache(3);
        lfuCache.put(2,2);
        lfuCache.put(1,1);
        System.out.println(lfuCache.get(2));
        System.out.println(lfuCache.get(1));
        System.out.println(lfuCache.get(2));
        lfuCache.put(3,3);
        lfuCache.put(4,4);
        System.out.println(lfuCache.get(3));
        System.out.println(lfuCache.get(2));
        System.out.println(lfuCache.get(1));
        System.out.println(lfuCache.get(4));
    }
}
