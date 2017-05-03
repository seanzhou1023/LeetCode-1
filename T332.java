import java.util.*;

/**
 * Created by eric on 3/24/17.
 * normal dfs gets TLE
 * priority queue + hashmap
 */
public class T332 {
//    public static boolean isSmaller(List<String> l1, List<String> l2){
//        for(int i=1;i<l1.size();i++){
//            int comp = l1.get(i).compareTo(l2.get(i));
//            if(comp==0) ;
//            else if(comp <0) return true;
//            else return false;
//        }
//        return false;
//    }
//    public static void dfs(List<List<String>> res, List<String> tmp, String from,
//                           String[][] tickets, Set<Integer> visited){
//        if(tmp.size()==tickets.length+1){
//            if(res.size()==0) res.add(new ArrayList<>(tmp));
//            else if(isSmaller(tmp,res.get(0))){
//                res.clear();
//                res.add(new ArrayList<>(tmp));
//            }
//        }
//        for(int i=0;i<tickets.length;i++){
//            if(!visited.contains(i) && from.equals(tickets[i][0])){
//                if(res.size()!=0 && tmp.size()!=0
//                        && res.get(0).get(tmp.size()).compareTo(tickets[i][1])<0) continue;
//                tmp.add(tickets[i][1]);
//                visited.add(i);
//                dfs(res,tmp,tickets[i][1],tickets,visited);
//                tmp.remove(tmp.size()-1);
//                visited.remove(i);
//            }
//        }
//    }
//    public static List<String> findItinerary(String[][] tickets){
//        List<List<String>> res = new ArrayList<>();
//        List<String> tmp = new ArrayList<>();
//        Set<Integer> visited = new HashSet<>();
//        tmp.add("JFK");
//        dfs(res,tmp,"JFK",tickets,visited);
//        System.out.println(res);
//        return tmp;
//    }
    static Map<String,PriorityQueue<String>> flights;
    static List<String> path;
    public static void dfs(String departure){
        PriorityQueue<String> arrivals = flights.get(departure);
        while(arrivals!=null && !arrivals.isEmpty())
            dfs(arrivals.poll());
        path.add(0,departure);
    }
    public static List<String> findItinerary(String[][] tickets){
        flights = new HashMap<>();
        path = new LinkedList<>();//
        for(String[] ticket:tickets){
            flights.putIfAbsent(ticket[0],new PriorityQueue<>());
            flights.get(ticket[0]).add(ticket[1]);
        }
        dfs("JFK");
        return path;
    }

    public static void main(String[] args) {
        String[][] tickets= {{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};
        System.out.println(findItinerary(tickets));
    }
}
