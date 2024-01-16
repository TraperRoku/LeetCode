import java.util.HashMap;

public class LRUCache {
    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

    }

    HashMap<Integer, Node> map;
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

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);

            remove(node);
            insert(node);

            return node.value;
        }
        return -1;
    }

    public void remove(Node node) {
       node.prev.next = node.next;
       node.next.prev = node.prev;
    }

    public void insert(Node node) {
         node.next = right;
         node.prev = right.prev;
         right.prev.next = node;
         right.prev = node;

    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));

        } else if (map.size() >= capacity) {
            Node toDelete = left.next;
            remove(toDelete);
            map.remove(toDelete.key);
        }
            Node temp = new Node(key,value);
            insert(temp);
            map.put(key, temp);
    }
}
