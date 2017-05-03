/**
 * Created by eric on 3/16/17.
 */
public class T082 {
    public static ListNode build(){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);l1.next = l2;
//        ListNode l3 = new ListNode(2);l2.next = l3;
//        ListNode l4 = new ListNode(3);l3.next = l4;
//        ListNode l5 = new ListNode(4);l4.next = l5;
        return l1;
    }
    public static ListNode deleteDuplicates(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head, pre = dummy;
        while(cur!=null && cur.next!=null){
            boolean repeat = false;
            while(cur!=null && cur.next!=null && cur.val==cur.next.val){
                cur.next = cur.next.next;
                repeat = true;
            }
            if(repeat){
                pre.next = cur.next;
                cur = pre.next;
            }else{
                pre = pre.next;
                cur=cur.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = build();
        head = deleteDuplicates(head);
        while(head!=null){
            System.out.println(head.val);
            head = head.next;
        }
        int[] nums = new int[2];
        char c = 'd';
        nums[0] = c;
        double n = c;
        double a = '\u1032';
        System.out.println(c);
        System.out.println("asfasf".equals("d"));
        System.out.println(String.valueOf('d'));
    }
}
