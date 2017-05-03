/**
 * Created by eric on 3/20/17.
 */
public class T369 {
    public static ListNode build(){
        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(9);l1.next = l2;
        ListNode l3 = new ListNode(9);l2.next = l3;
        ListNode l4 = new ListNode(9);l3.next = l4;
        ListNode l5 = new ListNode(9);l4.next = l5;
        l5.next = null;
        return l1;
    }
    public static ListNode plusOne(ListNode head){
        ListNode pre = head, cur = pre.next;
        pre.next = null;
        while(cur!=null){//reverse one
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        ListNode rightHead = pre;
        int carry = 1;
        while(pre!=null){
            int val = pre.val+carry;
            pre.val = val%10;
            carry = val/10;
            if(pre.next == null) break;
            pre = pre.next;
        }
        ListNode newHead;
        if(carry==1){
            newHead = new ListNode(carry);
            pre.next = newHead;
        }else newHead = pre;
        pre = rightHead;cur = rightHead.next;
        pre.next = null;
        while(cur!=null){//reverse back
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = build();
        head = plusOne(head);
        while(head!=null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
