package S005_Stack_Queue;
import java.util.HashMap;

//https://leetcode.com/problems/lru-cache/
class LRUCache {

    class Node{
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }

    int capacity = 0;
    int currCapacity = 0;
    HashMap<Integer, Node> map;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.capacity = capacity;
        this.head = null;
        this.tail = null;
    }

    private void removeNode(Node node){
        Node prevNode = node.prev;
        Node nextNode = node.next;

        if(prevNode != null){
            prevNode.next = nextNode;
        }else{
            head = nextNode;
        }


        if(nextNode != null){
            nextNode.prev = prevNode;
        }else{
            tail = prevNode;
        }

        //means removing link of that removing node
        node.next = null;
        node.prev = null;
    }


    private void addToTail(Node node){
        if(tail == null){
            head = node;
            tail = node;
        }else{
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
    }

    public int get(int key) {
        if(!map.containsKey(key))   return -1;

        Node node = map.get(key);
        int value = node.value;
        removeNode(node);
        addToTail(node);

        return value;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
            removeNode(node);
            addToTail(node);
            return;
        }

        Node node = new Node(key,value);
        addToTail(node);
        currCapacity++;
        map.put(key, node);

        if(currCapacity > capacity){
            Node oldHead = head;
            removeNode(oldHead);
            map.remove(oldHead.key);
            currCapacity--;
        }
    }
}


public class P018_LC146_LRU_Cache {
    public static void main(String[] args){
        //call from here...
    }
}
