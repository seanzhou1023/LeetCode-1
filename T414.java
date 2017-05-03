import java.util.Arrays;

/**
 * Created by eric on 3/26/17.
 */
public class T414 {
    public static int thirdMax(int[] nums){
        Integer[] max = new Integer[3];
        for(int num:nums){
            if(max[0]==null || num>=max[0].intValue()){
                if(max[0]==null) max[0] = num;
                else if(num==max[0].intValue()) ;
                else{
                    max[2] = max[1];
                    max[1] = max[0];
                    max[0] = num;
                }
            }else if(max[1]==null || num>=max[1].intValue()){
                if(max[1]==null) max[1] = num;
                else if(num==max[1].intValue()) ;
                else{
                    max[2] = max[1];
                    max[1] = num;
                }
            }else if(max[2]==null || num>=max[2].intValue()) {
                if (max[2] == null) max[2] = num;
                else if (num == max[2].intValue()) ;
                else {
                    max[2] = num;
                }
            }
        }
        return max[2]!=null?max[2]:max[0];
    }
    public static int thirdMaxState(int[] nums){
        //max[0-2] == null state1 0
        //max[1-2] == null state1 1
        //max[2] == null state1 2
        //max[0~2] != null state1 3
        //.....
        //num == one of the max[] state2 1 continue;
        //num == none of the max[] state2 0
        //> num>max[0] state3 0
        //> max[0]>num>max[1] state3 1
        //> max[1]>num>max[2] state3 2
        //> max[2]>num> state3 3
        int state1 = 0;
        Integer[] max = new Integer[3];
        for(int num:nums){
            if((max[0]!=null && num==max[0].intValue())
                    || (max[1]!=null && num==max[1].intValue())
                    || (max[2]!=null && num==max[2].intValue())) continue;
            switch(state1){
                case 0:{
                    max[0]=num;state1=1;break;
                }
                case 1:{
                    if(num>max[0].intValue()){
                        max[1]=max[0];max[0]=num;
                    }else if(num<max[0]) max[1]=num;
                    state1 = 2;break;
                }
                case 2:{
                    if(num>max[0].intValue()){
                        max[2]=max[1];max[1]=max[0];max[0]=num;
                    }else if(num>max[1].intValue()){
                        max[2] = max[1];max[1]=num;
                    }else max[2]=num;
                    state1 = 3;break;
                }
                case 3:{
                    if(num>max[0].intValue()){
                        max[2]=max[1];max[1]=max[0];max[0]=num;
                    }else if(num>max[1].intValue()){
                        max[2] = max[1];max[1]=num;
                    }else if(num>max[2].intValue()) max[2]=num;
                    break;
                }
                default:;
            }
        }
        return state1==3?max[2]:max[0];
    }

    public static void main(String[] args) {
        int[] nums = {2,2,3,1};
        System.out.println(thirdMaxState(nums));
        Integer i1 = 299;
        Integer i2 = 299;
        System.out.println(i1.intValue()==i2.intValue());
    }
}
