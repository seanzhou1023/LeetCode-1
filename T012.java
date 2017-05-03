/**
 * Created by eric on 3/7/17.
 */
public class T012 {
    public static String intToRoman(int num){
        int[] value = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] roman = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<value.length;i++){
            if(num == 0) break;
            int k = num/value[i];
            if(k>0){
                for(int loop=0;loop<k;loop++)
                    sb.append(roman[i]);
                num %= value[i];
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(41));
    }
}
