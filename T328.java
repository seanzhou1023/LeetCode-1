/**
 * Created by eric on 3/9/17.
 */
public class T328 {
    public static ListNode oddEvenList(ListNode head){
        if(head==null || head.next==null) return head;
        ListNode evenHead = head.next;
        ListNode oddCur = head, evenCur = evenHead;
        while(evenCur!=null && evenCur.next!=null && oddCur.next!=null){
            oddCur.next = oddCur.next.next;
            evenCur.next = evenCur.next.next;
            oddCur = oddCur.next;
            evenCur = evenCur.next;
        }
        oddCur.next = evenHead;
        return head;
    }
}
