import java.util.*;

/**
 * Created by eric on 3/7/17.
 * how to get faster?
 * remove item happened more than two times if it's not zero
 */
public class T015 {
    public static List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums.length<3) return res;
        HashMap<Integer,Integer> count = new HashMap<>();
        int len = 0;
        for(int i=0;i<nums.length;i++){
            if(count.containsKey(nums[i])){
                if(nums[i]==0 && count.get(nums[i])<3){
                    count.put(nums[i],count.get(nums[i])+1);
                    len++;
                }
                else if(count.get(nums[i])<2){
                    count.put(nums[i],count.get(nums[i])+1);
                    len++;
                }
            }
            else{
                count.put(nums[i],1);
                len++;
            }
        }
        int[] nnums = new int[len];
        int idx = 0;
        Iterator it = count.entrySet().iterator();
        while(it.hasNext()){
            HashMap.Entry pair = (HashMap.Entry)it.next();
            for(int i=0;i<(int)pair.getValue();i++){
                nnums[idx++] = (int)pair.getKey();
            }
        }
        Arrays.sort(nnums);
        for(int i=0;i<nnums.length-2;i++){
            if(nnums[i]>0) break;
            else if(i!=0 && nnums[i]==nnums[i-1]) continue;
            else{
                int low = i+1, high = nnums.length-1;
                while(low<high){
                    int sum = nnums[i]+nnums[low]+nnums[high];
                    if(sum==0){
                        List<Integer> newList = new ArrayList<>(
                                Arrays.asList(nnums[i],nnums[low],nnums[high]));
                        res.add(newList);
                        low++;
                        high--;
                        while(low<high && nnums[low]==nnums[++low]);
                        while(low<high && nnums[high]==nnums[--high]);
                    }
                    while(low<high & nnums[i]+nnums[low]+nnums[high]<0) low++;
                    while(low<high & nnums[i]+nnums[low]+nnums[high]>0) high--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
    }
}
