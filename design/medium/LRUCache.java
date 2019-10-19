package design.medium;

import java.util.HashMap;

/*
 * For LRU, we need to maintain the latest item that was used whenever get is called. Also we need to add elements in our DS until it is full capacity.
 * A DLL DS complements this idea, since we can delete the node with only that node's reference.
 * If we maintain that data structure, and keep all the references to Node with their integer key in the HashMap<Integer, Node> ,
 * we will be able to get instant access to that node whenever we want. Then we can delete it at will.
 * 
 * Also, maintaining two extra nodes is crucial to this - the head and tail.
 * They serve two purposes, first we get instant access to the front and end of the linkedlist,
 * and second we dont need to do any null checks that saves us implementation effort.
 * 
 * Any time a node is accessed, if it is not present we simply return -1 
 * if it is present we remove the node from it's position, remember we only need that node reference to get its prev and next references.
 * then we and simply move it to the front of the linkedlist using our reference to the head node.
 * 
 * The least recently used element goes to the end of the linkedlist, just before the tail.
 * 
 * So if we want to put another item in the list and list is at full capacity,
 * we can just remove that particular node using it's reference only.
 * 
 * 
 * 
 * Another great implementation is using APIs for LinkedHashMap.
 * In the LinkedHashMap, every time the put function is called, another function called removeEldestEntry is also called.
 * 
 * The removeEldestEntry removes an entry based on some boolean parameter we give it.
 * It has two options, to remove the eldest element in insertion order, or to remove in access order which we can turn on the flag to do.
 * 
 * for the boolean function to know whether to remove eldest entry, we can simply say if our capacity variable is equal to LHM size then remove it.
 * 
 * import java.util.LinkedHashMap;
    public class LRUCache {
        private LinkedHashMap<Integer, Integer> map;
        private final int CAPACITY;
        public LRUCache(int capacity) {
            CAPACITY = capacity;
            map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true){
                protected boolean removeEldestEntry(Map.Entry eldest) {
                    return size() > CAPACITY;
                }
            };
        }
        public int get(int key) {
            return map.getOrDefault(key, -1);
        }
        public void set(int key, int value) {
            map.put(key, value);
        }
    }
 */

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



