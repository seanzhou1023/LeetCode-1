package language;

/**
 * Created by eric on 4/6/17.
 */
public class ThreadPractice implements Runnable{
    int start, end, step;
    public long fib(int n){
        if(n<2) return n;
        else return fib(n-1)+fib(n-2);
    }
    public ThreadPractice(int s, int e, int st){
        start = s; end = e; step = st;
    }
    public void run(){
        while(start<=end){
            System.out.println(fib(start));
            start += step;
            Thread.yield();
        }
    }

    public static void main(String[] args) {
//        long t0 = System.nanoTime();
//        ThreadPractice tp = new ThreadPractice(0,43,1);
//        tp.run();
//        long t1 = System.nanoTime();
//        System.out.println((t1-t0)/1e6+"ms");
        for(int l=0;l<100;l++){
            for(int i=0;i<20;i++)
                new Thread(new ThreadPractice(i,40,20)).start();
        }
    }
}
