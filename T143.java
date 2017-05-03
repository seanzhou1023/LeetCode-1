/**
 * Created by eric on 3/12/17.
 */
public class T143 {
    public static ListNode build(){
        ListNode l1 = new ListNode(1);
//        ListNode l2 = new ListNode(2);l1.next = l2;
//        ListNode l3 = new ListNode(3);l2.next = l3;
//        ListNode l4 = new ListNode(4);l3.next = l4;
//        ListNode l5 = new ListNode(5);l4.next = l5;
//        l5.next = null;
        return l1;
    }
    public static void reorderList(ListNode head){
        ListNode slow = head, fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode pre = slow, cur = slow.next;
        while(cur!=null){
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        slow.next = null;
        ListNode headRight = cur!=null?cur:pre;
        ListNode curRight = headRight, curLeft = head;
        while(curRight!=slow){
            ListNode tmpLeft = curLeft.next;
            ListNode tmpRight = curRight.next;
            curLeft.next = curRight;
            curRight.next = tmpLeft;
            curLeft = tmpLeft;
            curRight = tmpRight;
        }
    }

    public static void main(String[] args) {
        ListNode head = build();
        reorderList(head);
        while(head!=null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
