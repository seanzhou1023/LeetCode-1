/**
 * Created by eric on 2/15/17.
 */
public class T160 {
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB){
        if(headA == null || headB == null)
            return null;
        if(headA == headB)
            return headA;
        ListNode startA = headA, startB = headB;
        int cntA = 0, cntB = 0;
        while(startA!=null){
            startA = startA.next;
            cntA++;
        }
        while(startB!=null){
            startB = startB.next;
            cntB++;
        }
        startA = headA;
        startB = headB;
        ListNode res=null;
        if(cntA>cntB){
            for(int i=0;i<cntA-cntB;i++)
                startA = startA.next;
        }else if(cntA<cntB){
            for(int i=0;i<cntB-cntA;i++)
                startB = startB.next;
            }
        while(startB!=null){
            startA = startA.next;
            startB = startB.next;
            if(startA==startB)
                res = startA;
        }
        return res;
    }
}
