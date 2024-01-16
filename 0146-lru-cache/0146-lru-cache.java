import java.util.HashMap;

class LRUCache {
    class Node{
        int key;
        int value;
        Node prev;
        Node next;
        
        Node(int key,int value){
            this.key = key;
            this.value = value;
        }
    }
    HashMap<Integer,Node> map;
    int capacity;
    Node left;
    Node right;

    public LRUCache(int capacity) {
    map = new HashMap<>(capacity);
    
    Node left = new Node(0, 0);
    Node right = new Node(0, 0);    
    
    this.left = left;
    this.right = right;
        
    this.capacity = capacity;   
        
    left.next = right;
    right.prev = left;    
    }

    private void remove(Node node){
       node.prev.next = node.next;
       node.next.prev = node.prev;

    }

    private void insert(Node node){
       node.next = right;
       node.prev = right.prev;
       right.prev.next = node;
       right.prev = node;
    }


    public int get(int key) {
        if(map.containsKey(key)){
            Node temp = map.get(key);

            remove(temp);
            insert(temp);

            return map.get(key).value;
        }
            return -1;
        }
    


    public void put(int key, int value) {
    if(map.containsKey(key)){
        remove(map.get(key));
    }else if(capacity<= map.size()){
        Node toDelete = left.next;
        remove(toDelete);
        map.remove(toDelete.key);
    }
    Node temp = new Node(key,value);
    map.put(key,temp);
    insert(temp);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */