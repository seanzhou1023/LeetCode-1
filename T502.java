import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by eric on 4/11/17.
 */
public class T502 {
    static class Project{
        int profit, capital;
        Project(int p, int c){
            profit = p;
            capital = c;
        }
    }
    public static int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital){
        int cap = W;
        PriorityQueue<Project> pq = new PriorityQueue<>(new Comparator<Project>() {
            public int compare(Project p1, Project p2) {
                return p2.profit-p1.profit;
            }
        });
        Project[] prj = new Project[Profits.length];
        for(int i=0;i<prj.length;i++){
            prj[i] = new Project(Profits[i],Capital[i]);
        }
        Arrays.sort(prj, new Comparator<Project>() {
            public int compare(Project p1, Project p2) {
                return p1.capital-p2.capital;
            }
        });
        int pos = 0;
        for(int i=0;i<k;i++){
            for(int j=pos;j<prj.length;j++,pos++){
                if(prj[j].capital<=cap) pq.add(prj[j]);
                else break;
            }
            if(!pq.isEmpty()){
                Project cur = pq.poll();
                cap += cur.profit;
//                pq.remove(cur);
            }
        }
        return cap;
    }

    public static void main(String[] args) {
        int k = 10, w = 0;
        int[] profits = {1,2,3};
        int[] capitals = {0,1,2};
        System.out.println(findMaximizedCapital(k,w,profits,capitals));
    }
}
