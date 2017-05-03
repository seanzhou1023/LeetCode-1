import java.util.*;

/**
 * Created by eric on 4/9/17.
 * topological sort is too slow!
 * next time try something new
 */
public class T210 {
    static class Node{
        int course;
        Set<Integer> from, to;
        Node(int n){
            course = n;
            from = new HashSet<>();
            to = new HashSet<>();
        }
    }
    public int[] findOrder(int numCourses, int[][] prerequisites){
        int[] indegree = new int[numCourses];
        int[] result = new int[numCourses];
        Map<Integer,Set<Integer>> to = new HashMap<>();
        for(int[] link: prerequisites){
            indegree[link[0]]++;
            to.putIfAbsent(link[1],new HashSet<>());
            to.get(link[1]).add(link[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<numCourses;i++)
            if(indegree[i]==0) queue.offer(i);
        int pos = 0;
        while(!queue.isEmpty()){
            int cur = queue.poll();
            result[pos++] = cur;
            numCourses--;
            Set<Integer> curSet = to.get(cur);
            if(curSet!=null){
                for(int i: curSet){
                    if(--indegree[i]==0) queue.offer(i);
                }
            }
        }
        return numCourses==0?result:new int[0];
    }
    public int[] findOrderGraph(int numCourses, int[][] prerequisites){
        Node[] courses = new Node[numCourses];
        int[] result = new int[numCourses];
        for(int i=0;i<numCourses;i++)
            courses[i] = new Node(i);
        for(int[] pair: prerequisites){
            courses[pair[0]].from.add(pair[1]);
            courses[pair[1]].to.add(pair[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for(Node n: courses)
            if(n.from.isEmpty()) queue.add(n.course);
        int pos = 0;
        while(!queue.isEmpty()){
            int cur = queue.poll();
            numCourses--;
            result[pos++] = cur;
            Set<Integer> curSet = courses[cur].to;
            for(int i: curSet){
                courses[i].from.remove(cur);
                if(courses[i].from.isEmpty()) queue.add(i);
            }
        }
        return numCourses==0?result:new int[0];
    }
}
