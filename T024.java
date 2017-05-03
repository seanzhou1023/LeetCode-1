/**
 * Created by eric on 3/11/17.
 */
public class T024 {
    public static ListNode buildList(){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
//        ListNode n3 = new ListNode(3);
//        ListNode n4 = new ListNode(4);
        n1.next = n2;n2.next = null;
//        n3.next = n4;n4.next = null;
        return n1;
    }
    public static ListNode swapPairs(ListNode head){
        if(head==null || head.next==null) return head;
        ListNode pre = new ListNode(0), cur = head.next;
        pre.next = head; head = cur;
        while(cur!=null){
            pre.next.next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            pre = pre.next.next;
            if(pre.next == null) break;
            cur = pre.next.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = buildList();
        head = swapPairs(head);
        while(head!=null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
