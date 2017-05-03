/**
 * Created by eric on 2/14/17.
 */
public class T142 {
    public static ListNode detectCycle(ListNode head){
        if(head==null)
            return null;
        ListNode slow, fast;
        slow = fast = head;
        while(true){
            if(slow==null || slow.next==null || fast==null || fast.next==null)
                return null;
            fast = fast.next.next;
            slow = slow.next;
            if(slow==fast){
                ListNode start = head;
                while(start!=fast){
                    start = start.next;
                    fast = fast.next;
                }
                return start;
            }
        }
    }

}
