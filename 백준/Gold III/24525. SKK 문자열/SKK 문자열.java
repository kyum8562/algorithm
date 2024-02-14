import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws  IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String cur = br.readLine();
        int len = cur.length();
        int num;
        int ans = -1;

        int[] prefix = new int[len + 1];
        int[] s = new int[len + 1];
        Map<Integer, Integer> map = new TreeMap<>();

        for (int i = 1; i <= len; i++) {
            if (cur.charAt(i - 1) == 'S') {
                num = 2;
                s[i] = s[i - 1] + num;
            } else if (cur.charAt(i - 1) == 'K') {
                num = -1;
                s[i] += s[i - 1];
            } else {
                num = 0;
                s[i] += s[i - 1];
            }
            prefix[i] = prefix[i - 1] + num;
        }

        for (int i = 1; i < prefix.length; i++) {
            if (prefix[i] == 0) {
                if (s[i] != 0) ans = Math.max(ans, i);
            } else {
                if (map.containsKey(prefix[i])) {
                    if(s[i] - s[map.get(prefix[i])] != 0) ans = Math.max(ans, i - map.get(prefix[i]));
                }
                if(!map.containsKey(prefix[i])) map.put(prefix[i], i);
            }
        }
        System.out.println(ans);
    }
}