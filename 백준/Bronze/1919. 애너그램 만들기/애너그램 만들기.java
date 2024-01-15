import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();

        Map<Character, Integer> map1 = new LinkedHashMap<>();
        Map<Character, Integer> map2 = new LinkedHashMap<>();
        Set<Character> set = new LinkedHashSet<>();

        int aLen = a.length();
        int bLen = b.length();

        for(int i = 0 ; i < aLen ; i ++){
            char cur = a.charAt(i);
            map1.put(cur, map1.getOrDefault(cur, 0) + 1);
            set.add(cur);
        }
        for(int i = 0 ; i < bLen ; i ++){
            char cur = b.charAt(i);
            map2.put(cur, map2.getOrDefault(cur, 0) + 1);
            set.add(cur);
        }

        int ans = 0;
        for(Character cur: set){
            int cnt1 = map1.getOrDefault(cur, 0);
            int cnt2 = map2.getOrDefault(cur, 0);

            int res = Math.abs(cnt1 - cnt2);
            ans += res;
        }

        System.out.println(ans);
    }
}