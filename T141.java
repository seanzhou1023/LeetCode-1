/**
 * Created by eric on 2/14/17.
 */
public class T141 {
    public static ListNode buildCycle(){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = null;
        return l1;
    }
    public static boolean hasCycle(ListNode head){
        if(head==null)
            return false;
        ListNode fast, slow;
        fast=slow=head;
        while(true){
            if(slow==null || slow.next==null || fast==null || fast.next==null)
                return false;
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow)
                return true;
        }
    }

    public static void main(String[] args) {
        ListNode head = buildCycle();
        System.out.println(hasCycle(head));
    }
}
