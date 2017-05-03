import java.util.ArrayList;
import java.util.List;

/**
 * Created by eric on 3/15/17.
 */
public class T401 {
    private static int[] hours = {1, 2, 4, 8};
    private static int[] minutes = {1, 2, 4, 8, 16, 32};
    private static final int hNum = 4, mNum = 6;

    public static void generateHours(List<List<Integer>> times, List<Integer> tmp, int start, int cnt, int choice) {
        if (cnt == 0) {
            List<Integer> res = new ArrayList<>(tmp);
            times.add(res);
            return;
        }
        for (int i = start; i < choice; i++) {
            tmp.add(i);
            generateHours(times, tmp, i + 1, cnt - 1, choice);
            tmp.remove(tmp.size() - 1);
        }
    }

    public static List<String> readBinaryWatchRecursive1(int num) {
        List<String> res = new ArrayList<>();
        if (num < 0 || num > 10) return res;
        int[] l1 = {8, 4, 2, 1};
        int[] l2 = {32, 16, 8, 4, 2, 1};
        for (int h = 0; h < 5; h++) {
            if (num - h >= 6) continue;
            else {
                int m = num - h;
                List<List<Integer>> hours = new ArrayList<>();
                List<Integer> tmp = new ArrayList<>();
                generateHours(hours, tmp, 0, h, 4);
                List<List<Integer>> minutes = new ArrayList<>();
                tmp = new ArrayList<>();
                generateHours(minutes, tmp, 0, m, 6);
                for (int i = 0; i < hours.size(); i++)
                    for (int j = 0; j < minutes.size(); j++) {
                        int hour = 0, minute = 0;
                        for (int k = 0; k < hours.get(i).size(); k++) {
                            hour += l1[hours.get(i).get(k)];
                        }
                        for (int t = 0; t < minutes.get(j).size(); t++) {
                            minute += l2[minutes.get(j).get(t)];
                        }
                        if (hour >= 0 && hour <= 11 && minute >= 0 && minute <= 59) {
                            String min = String.format("%2s", minute);
                            min = min.replace(' ', '0');
                            String s = hour + ":" + min;
                            res.add(s);
                        }
                    }
            }
        }
        return res;
    }

    public static List<String> readBinaryWatchIterative1(int num) {
        List<String> res = new ArrayList<>();
        for (int h = 0; h < 12; h++)
            for (int m = 0; m < 60; m++) {
                if (Integer.bitCount(h << 6 | m) == num) {
                    res.add(String.format("%d:%02d", h, m));
                }
            }
        return res;
    }

    public static void generateTimes(List<String> res, int hour, int minute,
                                     int hStart, int mStart, int cnt) {
        if (cnt <= 0) {
            if (cnt == 0) res.add(hour + String.format(":%02d", minute));
            return;
        }
        for (int i = hStart; i < hNum; i++) {
            if (hour + hours[i] < 12) {
                hour += hours[i];
                generateTimes(res, hour, minute, i, mStart, cnt - 1);
                hour -= hours[i];
            }
        }
        for (int i = mStart; i < mNum; i++) {
            if (minute + minutes[i] < 60) {
                minute += minutes[i];
                generateTimes(res, hour, minute, hStart, i, cnt - 1);
                minute -= minutes[i];
            }
        }
    }

    public static List<String> readBinaryWatchRecursive2(int num) {
        List<String> res = new ArrayList<>();
        if (num < 0 || num > hNum + mNum) return res;
        generateTimes(res, 0, 0, 0, 0, num);
        return res;
    }
    public static int bitCount(int var0) {
        var0 -= var0 >>> 1 & 1431655765;
        var0 = (var0 & 858993459) + (var0 >>> 2 & 858993459);
        var0 = var0 + (var0 >>> 4) & 252645135;
        var0 += var0 >>> 8;
        var0 += var0 >>> 16;
        return var0 & 63;
    }
    static int a = 0;
    public static void multiply(){
        a = 1;
        for (int i = 0; i < 10; i++) {
            int work = 0;
            for (int j = 0; j < 100000; j++)
                for (int h = 0; h < 120; h++)
                    for (int m = 0; m < 600; m++)
                        work += Integer.bitCount(h*64+m);
        }
    }
    public static void bitManipulation(){
        a = 1;
        for (int i = 0; i < 10; i++) {
            int work = 0;
            for (int j = 0; j < 100000; j++)
                for (int h = 0; h < 120; h++)
                    for (int m = 0; m < 600; m++)
                        work += Integer.bitCount((h << 6) | m);
        }
    }
    public static void doubleCall(){
        a = 1;
        for (int i = 0; i < 10; i++) {
            int work = 0;
            for (int j = 0; j < 100000; j++)
                for (int h = 0; h < 120; h++)
                    for (int m = 0; m < 600; m++)
                        work += Integer.bitCount(h) + Integer.bitCount(m);
        }
    }
    public static void warm(){
        int work = 0;
        for(int i=0;i<1000000;i++) work += i;
    }
    public static void main(String[] args) {
        warm();
        multiply();
        doubleCall();
        bitManipulation();
        warm();
    }
}