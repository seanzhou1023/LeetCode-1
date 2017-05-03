import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by eric on 2/15/17.
 * if its unsorted, then use a hashset
 */
public class T083 {
    public static ListNode deleteDuplicates(ListNode head){
        if(head==null || head.next==null)
            return head;
        ListNode pre = head, cur = pre.next;
        while(cur!=null){
            while(cur!=null && cur.val==pre.val){
               pre.next = cur.next;
               cur = cur.next;
            }
            if(cur!=null){
                pre = cur;
                cur = cur.next;
            }
        }
        return head;
    }
    public static void printList(ListNode head){
        while(head.next!=null){
            System.out.print(head.val+"->");
            head = head.next;
        }
        System.out.print(head.val+"\n");
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(2);
        head.next = l1;
        l1.next = l2;
        l2.next = null;
        deleteDuplicates(head);
        printList(head);
    }
}
