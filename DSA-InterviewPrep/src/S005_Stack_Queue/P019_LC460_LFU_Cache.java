package S005_Stack_Queue;
import java.util.HashMap;

//https://leetcode.com/problems/lfu-cache/description/

class LFUNode{
    int key;
    int value;
    int freq;
    LFUNode prev;
    LFUNode next;

    public LFUNode(int key, int value){
        this.key = key;
        this.value = value;
        this.freq = 1;
    }
}


class DoublyLinkedList{
    LFUNode head;
    LFUNode tail;
    int size = 0;

    public DoublyLinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void addToTail(LFUNode node){
        if(tail == null){
            head = node;
            tail = node;
        }else{
            tail.next = node;
            node.prev = tail;
            tail = node;
        }

        size++;
    }

    public void removeNode(LFUNode node){
        LFUNode prevNode = node.prev;
        LFUNode nextNode = node.next;

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
        node.prev = null;
        node.next = null;
        size--;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}

class LFUCache {
    int capacity;
    HashMap<Integer, LFUNode> keyNodeMap;
    HashMap<Integer, DoublyLinkedList> freqMap;
    int minFreq;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.keyNodeMap = new HashMap<>();
        this.freqMap = new HashMap<>();
        this.minFreq = 0;
    }

    public void updateNodeFreq(LFUNode node){
        int oldFreq = node.freq;
        DoublyLinkedList oldFreqList = freqMap.get(oldFreq);
        oldFreqList.removeNode(node);

        if(oldFreqList.isEmpty()){
            freqMap.remove(oldFreq);

            if(minFreq == oldFreq)  minFreq++;
        }

        node.freq++;
        freqMap.putIfAbsent(node.freq, new DoublyLinkedList());
        freqMap.get(node.freq).addToTail(node);

    }

    public int get(int key) {
        if(!keyNodeMap.containsKey(key))    return -1;

        LFUNode node = keyNodeMap.get(key);
        updateNodeFreq(node);
        return node.value;
    }

    public void put(int key, int value) {
        //if(capacity == 0)   return;
        if(keyNodeMap.containsKey(key)){
            LFUNode node = keyNodeMap.get(key);
            node.value = value;
            updateNodeFreq(node);
            return;
        }


        if(keyNodeMap.size() == capacity){
            DoublyLinkedList list = freqMap.get(minFreq);
            LFUNode evictNode = list.head;
            list.removeNode(evictNode);
            keyNodeMap.remove(evictNode.key);

            if(list.isEmpty()){
                freqMap.remove(minFreq);
            }
        }


        LFUNode node = new LFUNode(key, value);
        keyNodeMap.put(key, node);
        freqMap.putIfAbsent(node.freq, new DoublyLinkedList());
        freqMap.get(node.freq).addToTail(node);
        minFreq = 1;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */



public class P019_LC460_LFU_Cache {
    public static void main(String[] args){
        //call from here...
    }

}
