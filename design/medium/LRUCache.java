package design.medium;

import java.util.HashMap;

public class LRUCache {
	HashMap<Integer, Node> cache = new HashMap<>();
    final int capacity;
    Node head, tail;
    
	class Node{
		int key;
		int val;
		Node prev;
		Node next;
	}

    public LRUCache(int capacity) {
    	this.capacity = capacity;
    	head = new Node();
    	tail = new Node();
    	head.next = tail;
    	tail.prev = head;
    }
    
    public void removeNode(Node node) {
    	Node prev = node.prev;
    	Node next = node.next;    	
    	prev.next = next;
    	next.prev = prev;
		cache.remove(node.key, node);
    }
    
    public void addToFront(Node node) {
    	Node next = head.next;
    	head.next = node;
    	next.prev = node;
    	node.next = next;
    	node.prev = head;
		cache.put(node.key, node);
    }
    
    public int get(int key) {
    	if(!cache.containsKey(key)) return -1;
    	Node node = cache.get(key);
    	removeNode(node);
    	addToFront(node);
    	return node.val;
    }
    
    public void removeLRU() {
    	Node node = tail.prev;
		removeNode(node);
    }
    
    public void put(int key, int value) {
    	
    	if(cache.containsKey(key)) {
    		Node node = cache.get(key);
    		node.val = value;
    		removeNode(node);
    		addToFront(node);
    	} else {
        	Node node = new Node();
        	node.key = key;
        	node.val = value;
        	
        	if(cache.size() == capacity) {
        		removeLRU();
        		addToFront(node);
        	} else {
        		addToFront(node);
        	}
    	}
    }
    
    public static void main(String args[]) {
    	LRUCache cache = new LRUCache(2);
    	cache.put(2, 1);
    	cache.put(2, 2);

    	System.out.println(cache.get(2));
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */