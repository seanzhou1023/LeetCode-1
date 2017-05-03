import java.util.*;

/**
 * Created by eric on 4/7/17.
 * //bfs version + hashmap not so fast?
 * why recursion(DFS) faster than iterative version?
 * utilize the hashmap instead of creating new visited set
 */
public class T133 {
    static class UndirectedGraphNode {
         int label;
         List<UndirectedGraphNode> neighbors;
         UndirectedGraphNode(int x) {
             label = x; neighbors = new ArrayList<UndirectedGraphNode>();
         }
     }

    public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node){
        if(node==null) return null;
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        Map<Integer,UndirectedGraphNode> hm = new HashMap<>();
        queue.offer(node);
        hm.put(node.label,new UndirectedGraphNode(node.label));
        while(!queue.isEmpty()){
            UndirectedGraphNode curNode = queue.poll();
            for(UndirectedGraphNode uGN: curNode.neighbors){
                if(!hm.containsKey(uGN.label)){
                    hm.put(uGN.label,new UndirectedGraphNode(uGN.label));
                    queue.offer(uGN);
                }
                hm.get(curNode.label).neighbors.add(hm.get(uGN.label));
            }
        }
        return hm.get(node.label);
    }
    private static Map<Integer,UndirectedGraphNode> hm = new HashMap<>();
    public static UndirectedGraphNode cloneGraphRe(UndirectedGraphNode node){
        if(node==null) return null;
        if(hm.containsKey(node.label))
            return hm.get(node.label);
        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        hm.put(node.label, clone);
        for(UndirectedGraphNode uGN: node.neighbors){
            clone.neighbors.add(cloneGraphRe(uGN));
        }
        return clone;
    }
}
