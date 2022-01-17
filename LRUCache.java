package com.prac.design;
import java.util.*;

public class LRUCache {
    final Node head = new Node();
    final Node tail = new Node();
    HashMap<Integer,Node> nodemap;
    int cache_capacity;

    public LRUCache(int capacity) {
        nodemap = new HashMap(capacity);
        this.cache_capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        int result = -1;
        Node node = nodemap.get(key);
        if(node != null){
            result = node.val;
            remove(node);
            add(node);
        }
        return result;
    }

    public void put(int key, int value) {
        Node node = nodemap.get(key);
        if(node != null){
            remove(node);
            node.val = value;
            add(node);
        }else{
            if(nodemap.size() == cache_capacity){
                nodemap.remove(tail.prev.key);
                remove(tail.prev);
            }

            Node newnode = new Node();
            newnode.key = key;
            newnode.val = value;
            nodemap.put(key,newnode);
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

    public static void main(String[] args) {
        int capacity = 2;
        LRUCache lRUCache = new LRUCache(capacity);
        lRUCache.put(1, 1);
        lRUCache.put(2, 2);
        System.out.println(lRUCache.get(1));
        lRUCache.put(3, 3);
        System.out.println(lRUCache.get(2));
        lRUCache.put(4, 4);
        System.out.println(lRUCache.get(1));
        System.out.println(lRUCache.get(3));
        System.out.println(lRUCache.get(3));
    }

    class Node{
        int key;
        int val;
        Node next;
        Node prev;

    }
}
