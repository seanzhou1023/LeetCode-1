/**
 * Created by eric on 2/14/17.
 * avoided the head(removing) and null head perfectly
 */
public class T019 {
    public static ListNode removeNthFromEnd(ListNode head, int n){
        ListNode start = new ListNode(0);
        ListNode slow = start, fast = start;
        slow.next = head;
        for(int i=0;i<=n;i++)
            fast = fast.next;
        while(fast!=null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return start.next;
    }
}
