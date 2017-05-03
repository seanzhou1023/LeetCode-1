/**
 * Created by eric on 3/7/17.
 */
public class T203 {
    public static ListNode removeElements(ListNode head, int val){
        while(head!=null && head.val==val){
            head = head.next;
        }
        if(head==null) return head;
        ListNode cur = head.next, pre = head;
        while(cur!=null){
            if(cur.val==val) pre.next = cur.next;
            else pre = pre.next;
            cur = cur.next;
        }
        return head;
    }
}
