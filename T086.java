/**
 * Created by eric on 3/21/17.
 */
public class T086 {
    public static ListNode build(){
        ListNode l1 = new ListNode(13);
        ListNode l2 = new ListNode(22);l1.next = l2;
        ListNode l3 = new ListNode(-1);l2.next = l3;
        ListNode l4 = new ListNode(14);l3.next = l4;
        ListNode l5 = new ListNode(6);l4.next = l5;
        ListNode l6 = new ListNode(4);l5.next = l6;
        l6.next = null;
        return l1;
    }
    public static ListNode partition(ListNode head, int x){
        if(head==null || head.next==null) return head;
        ListNode left = new ListNode(0), leftCur = left;
        ListNode right = new ListNode(1), rightCur = right;
        ListNode cur = head;
        while(cur!=null){
            if(cur.val>=x){
                rightCur.next = cur;
                rightCur = rightCur.next;
            }else{
                leftCur.next = cur;
                leftCur = leftCur.next;
            }
            cur = cur.next;
        }
        rightCur.next = null;
        leftCur.next = right.next;
        return left.next;
    }

    public static void main(String[] args) {
        ListNode head = partition(build(),5);
        while(head!=null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
