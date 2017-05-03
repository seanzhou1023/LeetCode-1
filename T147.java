/**
 * Created by eric on 3/13/17.
 * actually this is the bubble sort at first place
 */
public class T147 {
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
    public static ListNode bubbleSortList(ListNode head){
        //in place insertion sort
        if(head==null || head.next==null) return head;
        ListNode cur = head, pre = null;
        while(cur!=null){
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
            ListNode curOp = pre, compOp = curOp.next, preOp = new ListNode(0);
            preOp.next = curOp;
            boolean flag = true;
            while(compOp!=null && curOp.val>compOp.val){
                curOp.next = compOp.next;
                compOp.next = curOp;
                preOp.next = compOp;
                if(flag){
                    pre = compOp;
                    flag = false;
                }
                compOp = curOp.next;
                preOp = preOp.next;
            }
        }
        return pre;
    }
    public static ListNode insertionSortListSlow(ListNode head){
        if(head==null || head.next==null) return head;
        ListNode newHead = new ListNode(0), opNode = newHead;
        while(head!=null){
            ListNode curHead = head, preMinHead = curHead, preHead = curHead;
            int min = preMinHead.val;
            curHead = curHead.next;
            boolean minIsHead = true;
            while(curHead!=null){
                if(curHead.val<min){
                    min = curHead.val;
                    preMinHead = preHead;
                    minIsHead = false;
                }
                preHead = curHead;
                curHead = curHead.next;
            }
            if(minIsHead){
                opNode.next = preMinHead;
                head = head.next;
            }else{
                opNode.next = preMinHead.next;
                preMinHead.next = preMinHead.next.next;
            }
            opNode = opNode.next;
        }
        return newHead.next;
    }
    public static ListNode insertionSortList(ListNode head){
        if(head==null || head.next==null) return head;
        return null;
        //
    }
    public static void main(String[] args) {
        ListNode head = build();
        ListNode res = insertionSortList(head);
        while(res!=null){
            System.out.println(res.val);
            res = res.next;
        }
    }
}
