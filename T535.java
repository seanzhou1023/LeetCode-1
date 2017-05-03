import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by eric on 4/13/17.
 * method 1: using a global counter or others, it's limited
 */
public class T535 {
    static class Codec {
        String alphanum = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Map<String,String> map = new HashMap<>();
        Random rand = new Random();
        String key = getRandom();
        public String getRandom(){
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<10;i++)
                sb.append(alphanum.charAt(rand.nextInt(62)));
            return sb.toString();
        }
        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            while(map.containsKey(key))
                key = getRandom();
            map.put(key,longUrl);
            return "http://tinyurl.com/" + key;
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            String val = shortUrl.replace("http://tinyurl.com/","");
            return map.get(val);
        }
    }

    public static void main(String[] args) {
        System.out.println(Integer.bitCount(123));
    }
}
