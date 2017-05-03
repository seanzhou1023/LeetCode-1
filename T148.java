/**
 * Created by eric on 3/13/17.
 * problems met when trying to end a list with null:
 * @cqy0118 prev points to the ListNode before slow. If we do slow.next = null
 * then when there are only two elements left, it will be a infinite loop,
 * since slow will always point to the second node and sort(head)
 * will fail to divide the last two nodes and always result in the last two nodes,
 * hence the stack overflow error.
 */
public class T148 {
    public static ListNode build(){
        ListNode l1 = new ListNode(123);
        ListNode l2 = new ListNode(5);l1.next = l2;
        ListNode l3 = new ListNode(66);l2.next = l3;
        ListNode l4 = new ListNode(3);l3.next = l4;
//        ListNode l5 = new ListNode(2);l4.next = l5;
//        ListNode l6 = new ListNode(1);l5.next = l6;
//        ListNode l7 = new ListNode(121);l6.next = l7;
//        l7.next = null;
        return l1;
    }
    public static ListNode merge(ListNode left, ListNode right){
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while(left!=null && right!=null){
            if(left.val<=right.val){
                cur.next = left;
                left = left.next;
            }else{
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        cur.next = left!=null?left:right;
        return head.next;
    }
    public static ListNode sortList(ListNode head){
        if(head==null || head.next==null) return head;
        ListNode pre = null, slow = head, fast = head;
        while(fast!=null && fast.next!=null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(slow);
        return merge(left,right);
    }

    public static void main(String[] args) {
        ListNode head = build();
        ListNode newHead = sortList(head);
        while(newHead!=null){
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }
}
