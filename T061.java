/**
 * Created by eric on 3/12/17.
 */
public class T061 {
    public static ListNode build(){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);l1.next = l2;
        ListNode l3 = new ListNode(3);l2.next = l3;
////        ListNode l4 = new ListNode(4);l3.next = l4;
////        ListNode l5 = new ListNode(5);l4.next = l5;
////        l5.next = null;
        return l1;
    }
    public static ListNode rotateRight(ListNode head, int k){
        if(head==null || head.next==null) return head;
        ListNode start = head;
        int cnt = 0;
        while(start!=null){
            cnt++;
            start = start.next;
        }
        for(int i=0;i<k%cnt;i++){
            ListNode walk = head, behind = head;
            walk = walk.next;
            while(walk.next!=null){
                behind = behind.next;
                walk = walk.next;
            }
            ListNode headRotate = behind.next;
            behind.next = null;
            walk.next = head;
            head = headRotate;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = build();
        head = rotateRight(head,2000000);
        while(head!=null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
