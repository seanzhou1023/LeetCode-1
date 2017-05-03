import java.util.*;

/**
 * Created by eric on 2/21/17.
 */
public class T146 {
    static class CacheNode{
        int key;
        int value;
        CacheNode pre,next;
        CacheNode(int key, int value){
            this.key = key;
            this.value = value;
            pre = next = null;
        }
    }
    static class LRUCache{
        private int capacity;
        private HashMap<Integer,CacheNode> cacheMap;
        private CacheNode head = new CacheNode(-1,-1);
        private CacheNode tail = new CacheNode(-1,-1);
        public LRUCache(int capacity){
            this.capacity = capacity;
            head.next = tail;
            tail.pre = head;
            cacheMap = new HashMap<>();
        }
        public int get(int key) {
            if(!cacheMap.containsKey(key))
                return -1;
            CacheNode cn = cacheMap.get(key);
            cn.pre.next = cn.next;
            cn.next.pre = cn.pre;

            add_to_tail(cn);

            return cn.value;
        }
        public void add_to_tail(CacheNode cn){
            CacheNode tailPre = tail.pre;
            tailPre.next = cn;
            cn.pre = tailPre;
            cn.next = tail;
            tail.pre = cn;
        }
        public void put(int key, int value) {
            if(get(key)!=-1){
                cacheMap.get(key).value = value;
                return;
            }
            if(cacheMap.size() == capacity){
                cacheMap.remove(head.next.key);
                head.next = head.next.next;
                head.next.pre = head;
            }
            CacheNode cn = new CacheNode(key,value);
            add_to_tail(cn);
            cacheMap.put(key,cn);
        }
    }
    public static void main(String[] args) {
        LRUCache obj = new LRUCache(2);
        obj.put(1,1);
        obj.put(2,2);
        obj.get(1);
        obj.put(3,3);
    }
}
