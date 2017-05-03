import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * Created by eric on 3/13/17.
 * priority queue couldn't get through the last test case; m*n*log(m)
 */
public class T023 {
    public static ListNode build1(){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);l1.next = l2;
        ListNode l3 = new ListNode(2);l2.next = l3;
//        ListNode l4 = new ListNode(16);l3.next = l4;
        return l1;
    }
    public static ListNode build2(){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);l1.next = l2;
        ListNode l3 = new ListNode(2);l2.next = l3;
//        ListNode l4 = new ListNode(17);l3.next = l4;
//        l4.next = null;
        return l1;
    }
    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length<1) return null;
        ListNode cur = new ListNode(0), head = cur, first;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            public int compare(ListNode l1, ListNode l2) {
                return l1.val-l2.val;
            }
        });
        for(ListNode l:lists)
            if(l!=null) pq.add(l);
        while(!pq.isEmpty()){
            first = pq.poll();
            cur.next = first;
            cur = cur.next;
            if(first.next!=null) pq.add(first.next);
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode h1 = build1();
        ListNode h2 = build2();
        ListNode[] lists = {h1,h2};
        ListNode h = mergeKLists(lists);
        while(h!=null){
            System.out.println(h.val);
            h = h.next;
        }
    }
}
