/**
 * Created by eric on 3/20/17.
 */
public class T092 {
    public static ListNode buildList(){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
//        ListNode n4 = new ListNode(4);
//        ListNode n5 = new ListNode(5);
        n1.next = n2;n2.next = n3;
//        n3.next = n4;n4.next = n5;n5.next = null;
//        n3.next = n5;
        return n1;
    }
    public static ListNode reverseBetween(ListNode head, int m, int n){
        if(head==null || head.next==null || n-m==0) return head;
        ListNode cur = head, newHead = new ListNode(0), pre = newHead;
        newHead.next = head;
        for(int i=0;i<=m-2;i++){
            pre = pre.next;
            cur = cur.next;
        }
        ListNode last0 = pre, last1 = pre.next;
        pre = pre.next;cur = pre.next;
        for(int i=0;i<n-m;i++){
            if(cur!=null){
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
        }
        last0.next = pre;
        last1.next = cur;
        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode head = buildList();
        head = reverseBetween(head,2,3);
        while(head!=null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
