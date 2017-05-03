/**
 * Created by eric on 4/13/17.
 * https://discuss.leetcode.com/topic/86295/summary-for-all-the-solutions-in-java-reverse-rotate
 */
public class T186 {
    public static void reverse(char[] s, int i, int j){
        while(i<j){
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
            i++; j--;
        }
    }
    public static void rotate(char[] s, int i, int j, int k){
        reverse(s, i, j);
        reverse(s, i, k%(j-i+1)-1+i);
        reverse(s, k%(j-i+1)+i,j);
    }
    public static void rotateWords(char[] s, int i, int j, int cnt){
        if(cnt<2) return;
        int b;
        if(cnt==2){
            for(b=i+1;b<j;b++) if(s[b]==' ') break;
        }else{
            int left = cnt/2;
            for(b=i+1;b<j;b++){
                if(s[b]==' ' && left>0) left--;
                if(left==0) break;
            }
            if(cnt/2>=2) rotateWords(s,i,b-1,cnt/2);
            if(cnt-cnt/2>=2)rotateWords(s,b+1,j,cnt-cnt/2);
        }
        rotate(s,b,j,j-b);//space
        rotate(s,i,j,j-b+1);//rotate one word
    }
    public static void reverseWords(char[] s){
        if(s.length<1) return ;
        int cnt = 1;
        for(char c: s) if(c==' ') cnt++;
        rotateWords(s,0,s.length-1,cnt);
    }

    public static void reverseWordsF(char[] s){
        reverse(s,0,s.length-1);
        int r = 0;
        while(r<s.length){
            int l = r;
            while(r<s.length && s[r]!=' ') r++;
            reverse(s,l,r-1);
            r++;
        }
    }

    public static void main(String[] args) {
        String words = "I";
        char[] sc = words.toCharArray();
        reverseWords(sc);
        System.out.println(new String(sc));
    }
}
