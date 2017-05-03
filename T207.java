import java.util.*;

/**
 * Created by eric on 3/5/17.
 * topological sort
 * must be a DAG if exists a topological order
 * bfs is too slow for this problem
 * topological sort fast version: reverse dfs postorder
 */
public class T207 {
    public static void moveIndex(int cur, HashSet<Integer> from, HashSet<Integer> to){
        from.remove(cur);
        to.add(cur);
    }
    public static boolean testCycle(int cur, HashSet<Integer> white,
                              HashSet<Integer> gray, HashSet<Integer> black,
                              HashMap<Integer,List<Integer>> hm){
        moveIndex(cur,white,gray);
        if(hm.get(cur)!=null){
            for(int idx: hm.get(cur)){
                if(black.contains(idx))
                    continue;
                if(gray.contains(idx))
                    return true;
                if(testCycle(idx,white,gray,black,hm))
                    return true;
            }
        }
        moveIndex(cur,gray,black);
        return false;
    }
    public static boolean canFinishCycle(int numCourses, int[][] prerequisites){
        HashMap<Integer,List<Integer>> hm = new HashMap<>();
        HashSet<Integer> white = new HashSet<>();
        HashSet<Integer> gray = new HashSet<>();
        HashSet<Integer> black = new HashSet<>();
        for(int i=0;i<prerequisites.length;i++){
            int cur = prerequisites[i][0];
            if(!hm.containsKey(cur))
                hm.put(cur,new ArrayList<>());
            hm.get(cur).add(prerequisites[i][1]);
            white.add(i);
        }
        while(white.size()>0){
            int cur = white.iterator().next();
            if(testCycle(cur,white,gray,black,hm))
                return false;
        }
        return true;
    }
    public static boolean canFinishTS(int numCourses, int[][] prerequisites){
        int[] indegree = new int[numCourses];
        Map<Integer,Set<Integer>> to = new HashMap<>();
        for(int[] link: prerequisites){
            indegree[link[0]]++;
            to.putIfAbsent(link[1],new HashSet<>());
            to.get(link[1]).add(link[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<numCourses;i++)
            if(indegree[i]==0) queue.offer(i);
        while(!queue.isEmpty()){
            int cur = queue.poll();
            numCourses--;
            Set<Integer> curSet = to.get(cur);
            if(curSet!=null){
                for(int i: curSet){
                    if(--indegree[i]==0) queue.offer(i);
                }
            }
        }
        return numCourses==0;
    }

    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{0,1}};
        System.out.println(canFinishTS(numCourses,prerequisites));
    }
}
