/**
 * Created by eric on 4/12/17.
 */
public class T445 {
    private ListNode reverse(ListNode head){
        if(head==null || head.next==null) return head;
        ListNode pre = null, cur = head;
        while(cur!=null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        if(l1==null) return l2;
        if(l2==null) return l1;
        ListNode h1 = reverse(l1), h2 = reverse(l2);
        ListNode head = new ListNode(0), cur = head;
        int carry = 0;
        while(h1!=null || h2!=null){
            int num = (h1!=null?h1.val:0) + (h2!=null?h2.val:0) + carry;
            cur.next = new ListNode(num%10);
            carry = num/10;
            h1 = h1!=null?h1.next:null;
            h2 = h2!=null?h2.next:null;
            cur = cur.next;
        }
//        ListNode tail = (h1!=null?h1:h2);
//        while(carry!=0 || tail!=null){
//            int num = (tail!=null?tail.val:0) + carry;
//            tail = tail!=null?tail.next:null;
//            carry = num/10;
//            cur.next = new ListNode(num%10);
//            cur = cur.next;
//        }
        cur.next = null;
        return reverse(head.next);
    }
}
