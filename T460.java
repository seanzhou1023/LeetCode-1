import java.util.*;

/**
 * Created by eric on 4/6/17.
 * last recently used include the put situation? YEEEEESSS!!!!
 * notice that the property of LRU gets changed when LFU gets changed
 * corner case 1: capacity is 0
 * corner case 2: put the value will update the recently used!
 * change priorityqueue to double linked list
 */
public class T460 {
    static class LFUCache {
        static class FreqNode{
            LinkedHashSet<CacheNode> cacheLR;
            FreqNode pre, next;
            FreqNode(){
                cacheLR = new LinkedHashSet<>();
                pre = next = null;
            }
        }
        static class CacheNode{
            int key;
            int val;
            int freq;
            CacheNode(int k, int v){
                key = k; val = v; freq = 0;
            }
        }
        int capacity;
        Map<Integer,FreqNode> freqMap;
        PriorityQueue<Integer> pq;//sort the freq
        Map<Integer,CacheNode> cacheMap;
        public LFUCache(int capacity) {
            this.capacity = capacity;
            cacheMap = new HashMap<>();
            freqMap = new HashMap<>();
            pq = new PriorityQueue<>();
        }
        public int get(int key) {
            if(capacity==0) return -1;
            if(cacheMap.containsKey(key)){//change freq, change recently used
                CacheNode cur = cacheMap.get(key);
                LinkedHashSet<CacheNode> old = freqMap.get(cur.freq).cacheLR;
                old.remove(cur);//remove from the old freq
                if(old.size()==0) {
                    freqMap.remove(cur.freq);//if no cache has this freq, delete this freq node
                    pq.remove(cur.freq);
                }
                cur.freq++;//freq gets up by one
                if(!freqMap.containsKey(cur.freq))//check if the FreqNode exist
                {
                    freqMap.put(cur.freq,new FreqNode());//add FreqNode with new freq
                    pq.offer(cur.freq);
                }
                freqMap.get(cur.freq).cacheLR.add(cur);//add to the new freq with LRU order
                return cur.val;
            }else return -1;
        }

        public void put(int key, int value) {
            if(capacity==0) return;
            if(cacheMap.containsKey(key)){
                CacheNode cur = cacheMap.get(key);
                cur.val = value;
            }else{
                if(cacheMap.size()>=capacity) {//most important part
                    int lowewestFreq = pq.peek();
                    LinkedHashSet<CacheNode> curCache = freqMap.get(lowewestFreq).cacheLR;
                    CacheNode lru = null;
                    for(CacheNode cn: curCache){
                        lru = cn;//get the least recently used(with the lowest frequency, of course) cache in O(1)
                        break;
                    }
                    curCache.remove(lru);//remove the LRU+LFU
                    cacheMap.remove(lru.key);//don't forget to remove the cacheNode in cacheMap
                    if(curCache.size()==0) {
                        freqMap.remove(lowewestFreq);//if this frequency has zero element, delete
                        pq.remove(lowewestFreq);
                    }
                }
                CacheNode cache = new CacheNode(key,value);
                cacheMap.put(key,cache);
                if(!freqMap.containsKey(cache.freq)) {
                    freqMap.put(cache.freq,new FreqNode());
                    pq.offer(cache.freq);
                }
                freqMap.get(cache.freq).cacheLR.add(cache);//add to the new freq with LRU order
            }
            get(key);
        }
    }

    public static void main(String[] args) {
        LFUCache lfu = new LFUCache(2);
        lfu.put(2,1);lfu.put(1,1);
        lfu.put(2,3);
        lfu.put(3,1);
        int res0 = lfu.get(1);
        int res = lfu.get(2);
        System.out.println(res0+":"+res);
    }
}
