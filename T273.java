/**
 * Created by eric on 3/15/17.
 */
public class T273 {
    public static void generate(StringBuilder res, int num){
        String[] words = {"", "One", "Two", "Three", "Four", "Five",
                "Six", "Seven", "Eight", "Nine", "Ten",
                "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen",
                "Sixteen", "Seventeen", "Eighteen", "Nineteen",
                "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        int div = (int)Math.log10(num)/3;
        int choice = div>=3?3:(div>=2?2:(div>=1?1:0));
        switch(choice){
            case 3:
                generate(res,num/(int)1e9);
                res.append(" Billion ");
                generate(res,num%(int)1e9);break;
            case 2:
                generate(res,num/(int)1e6);
                res.append(" Million ");
                generate(res,num%(int)1e6);break;
            case 1:
                generate(res,num/(int)1e3);
                res.append(" Thousand ");
                generate(res,num%(int)1e3);break;
            case 0:
                int subChoice = num>=100?2:(num>=20?1:0);
                switch(subChoice){
                    case 2:
                        generate(res,num/100);
                        res.append(" Hundred ");
                        generate(res,num%100);break;
                    case 1:
                        res.append(words[(num-20)/10+20]);
                        res.append(" " + words[num%10]);break;
                    case 0:
                        res.append(words[num]);
                }
        }
        int len = res.length();
        if(res.charAt(len-1)==' ') res.deleteCharAt(len-1);
    }
    public static String numberToWords1(int num) {
        if(num==0) {
            return "Zero";
        }
        return helper(num);
    }
    public static String helper(int num) {
        String[] words = new String[] {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
                "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        StringBuilder res = new StringBuilder();

        if(num>=1000000000) {
            res.append(helper(num/1000000000)).append(" Billion ").append(helper(num%1000000000));
        } else if(num>=1000000) {
            res.append(helper(num/1000000)).append(" Million ").append(helper(num%1000000));
        } else if(num>=1000) {
            res.append(helper(num/1000)).append(" Thousand ").append(helper(num%1000));
        } else if(num>=100) {
            res.append(helper(num/100)).append(" Hundred ").append(helper(num%100));
        } else if(num>=20) {
            res.append(words[(num-20)/10+20]).append(" ").append(words[num%10]);
        } else {
            res.append(words[num]);
        }

        return res.toString().trim();
    }
    public static String numberToWords(int num){
        if(num==0) return "Zero";
        StringBuilder res = new StringBuilder();
        generate(res,num);
        return res.toString();
    }

    public static void main(String[] args) {
        int n = 1234567;
        System.out.println(numberToWords(n));
//            numberToWords1(i);}
    }
}
