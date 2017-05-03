import java.util.HashMap;
import java.util.Random;

/**
 * Created by eric on 3/8/17.
 * try not to use extra memory: copy to the next! don't forget to modify back the original one
 */
public class T138 {
    static class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode(int x) { this.label = x; }
    }
    public static RandomListNode copyRandomList(RandomListNode head){
        if(head==null) return head;
        HashMap<RandomListNode,RandomListNode> hm = new HashMap<>();
        RandomListNode cur = new RandomListNode(head.label);
        RandomListNode newHead = cur;
        hm.put(head,newHead);
        cur.random = head.random;
        head = head.next;
        while(head!=null){
            cur.next = new RandomListNode(head.label);
            cur = cur.next;
            hm.put(head,cur);
            cur.random = head.random;
            head = head.next;
        }
        RandomListNode startNode = newHead;
        while(startNode!=null){
            startNode.random = hm.get(startNode.random);
            startNode = startNode.next;
        }
        return newHead;
    }
    public static RandomListNode copyRandomListB(RandomListNode head){
        if(head==null) return null;
        RandomListNode cur = head;
        while(cur!=null){
            RandomListNode next = cur.next;
            cur.next = new RandomListNode(cur.label);
            cur.next.next = next;
            cur = next;
        }
        cur = head;
        while(cur!=null){
            if(cur.random!=null){
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        RandomListNode copyHead = head.next, copyCur = copyHead;
        cur = head;
        while(copyCur.next!=null){
            cur.next = cur.next.next;
            cur = cur.next;
            copyCur.next = copyCur.next.next;
            copyCur = copyCur.next;
        }
        cur.next = null;
        return copyHead;
    }

    public static void main(String[] args) {

    }
}
