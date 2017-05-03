import java.util.Random;

/**
 * Created by eric on 3/21/17.
 */
public class T382 {
    static class Solution {
        ListNode head;
        Random random;
        /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
        public Solution(ListNode head) {
            this.head = head;
            random = new Random();
        }

        /** Returns a random node's value. */
        public int getRandom() {
            int count = 0, val = head.val;
            ListNode cur = head;
            while(cur!=null){
                if(random.nextInt(++count)==0)
                    val = cur.val;
                cur = cur.next;
            }
            return val;
        }
    }
}
