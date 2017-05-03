/**
 * Created by eric on 2/13/17.
 */
public class T234 {
    public static boolean isPalindrome(ListNode head){
        if(head == null || head.next == null)
            return true;
        ListNode fast = head, slow = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode rightHead=slow;
        ListNode curNode = null;
        while(rightHead!=null){
            ListNode temp = rightHead.next;
            rightHead.next = curNode;
            curNode = rightHead;
            rightHead = temp;
        }
        while(curNode!=slow){
            if(head.val!=curNode.val)
                return false;
            curNode = curNode.next;
            head = head.next;
        }
        return curNode.val==head.val;
    }
    public static ListNode buildList(){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(7);
        ListNode l7 = new ListNode(3);
        ListNode l8 = new ListNode(2);
        ListNode l9 = new ListNode(1);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        l7.next = l8;
        l8.next = l9;
        l9.next = null;
        return l1;
    }
    public static void printList(ListNode head){
        while(head.next!=null){
            System.out.print(head.val+"->");
            head = head.next;
        }
        System.out.print(head.val+"\n");
    }
    public static void main(String[] args) {
        ListNode head = buildList();
        System.out.println(isPalindrome(head));
    }
}
