package ebay;

import java.util.HashMap;

public class _146_LRUCache {
	
	class Node // Doubly Linkedlist node for maintaining order
    {
        int key; //key value pairs
        int val;
        Node prev;
        Node next;

        public Node(int key, int val) //constructor
        {
            this.key = key;
            this.val = val;
        }
    }
	
	HashMap<Integer, Node> map; // map to store the (key,node) pairs
    Node head; // to add most recently element to head
    Node tail; // to remove least recently used element from tail
    int capacity; // global capacity
    
    public _146_LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next = tail; // connecting head and tail initially
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1; // if key not present

        Node node = map.get(key); // getting node reference corresponding to the key value
        removeNode(node); //remove that node and move to head as it is most recently used now
        addtoHead(node);
        return node.val; //return its value
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) // if map already contains the key
        {
            Node node = map.get(key); //get then node reference from the map
            node.val = value; // update its value
            removeNode(node); // remove and add it to head as most recently used
            addtoHead(node);
        }
        else
        { //new node to be added
            if(capacity == map.size()) //check if reached the capacity of the cache
            {
                Node tailnode = map.get(tail.prev.key); //get the last node as least recently used
                removeNode(tailnode); //remove it from list
                map.remove(tailnode.key); //remove it from hashmap
            }

            Node node = new Node(key, value); //create the new node 
            map.put(key, node); //add it to map
            addtoHead(node); // add it to head as most recent used
        }
    }
    
    private void removeNode(Node node) // to remove any node
    {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    private void addtoHead(Node node) // to add most recently used node to head
    {
        node.next = head.next;
        node.prev = head;
        head.next = node;
        node.next.prev = node;
    }
	

	public static void main(String[] args) {
	}
}
