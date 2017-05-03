import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by eric on 4/24/17.
 * using one stack!
 * https://discuss.leetcode.com/topic/4953/share-my-java-solution-with-only-one-stack
 */
public class T155 {
    static class MinStack {
        Deque<Integer> stack, aux;
        /** initialize your data structure here. */
        public MinStack() {
            stack = new LinkedList<>();
            aux = new LinkedList<>();
        }

        public void push(int x) {
            if(aux.isEmpty()) aux.addFirst(x);
            else{
                if(x<=aux.peek()) aux.addFirst(x);
            }
            stack.addFirst(x);
        }

        public void pop() {
            if(stack.isEmpty()){
                throw new NullPointerException("the stack is empty!");
            }
            int pop = stack.removeFirst();
            if(aux.peek()==pop) aux.removeFirst();
        }

        public int top() {
            if(stack.isEmpty()){
                throw new NullPointerException("the stack is empty!");
            }
            return stack.peek();
        }

        public int getMin() {
            if(stack.isEmpty()){
                throw new NullPointerException("the stack is empty!");
            }
            return aux.peek();
        }
    }
    static class MinStackOneStack{
        Deque<Long> stack;
        long min;
        /** initialize your data structure here. */
        public MinStackOneStack() {
            stack = new LinkedList<>();
        }

        public void push(int x) {
            if(stack.isEmpty()){
                stack.addFirst(0L);
                min = x;
            }else{
                stack.addFirst((long)x-min);
                if(x<min) min = x;
            }
        }

        public void pop() {
            if(stack.isEmpty()) throw new NullPointerException();
            long pop = stack.poll();
            if(pop<0) min -= pop;
        }

        public int top() {
            if(stack.isEmpty()) throw new NullPointerException();
            long peek = stack.peek();
            if(peek>0) return (int)(peek+min);
            else return (int)min;
        }

        public int getMin() {
            return (int)min;
        }
    }

    public static void main(String[] args) {
        MinStackOneStack minStack = new MinStackOneStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        int n1 = minStack.getMin();
        minStack.pop();
        int n2 = minStack.top();
        int n3 = minStack.getMin();
        System.out.println(n1+":"+n2+":"+n3);
    }
}
