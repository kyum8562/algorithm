import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws  IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();

        int[] prefix = new int[str.length() + 1];
        int[] s = new int[str.length() + 1];
        int num;
        for (int i = 1; i <= str.length(); i++) {
            if (str.charAt(i - 1) == 'S') {
                num = 2;
                s[i] = s[i - 1] + num;
            } else if (str.charAt(i - 1) == 'K') {
                num = -1;
                s[i] += s[i - 1];
            } else {
                num = 0;
                s[i] += s[i - 1];
            }
            prefix[i] = prefix[i - 1] + num;
        }

        int answer = -1;
        Map<Integer, Integer> map = new TreeMap<>(); // <value, idx>
        for (int i = 1; i < prefix.length; i++) {
            if (prefix[i] == 0) {
                if (s[i] != 0) answer = Math.max(answer, i);
            } else {
                if (map.containsKey(prefix[i])) {
                    if(s[i] - s[map.get(prefix[i])] != 0) answer = Math.max(answer, i - map.get(prefix[i]));
                }
                if(!map.containsKey(prefix[i])) map.put(prefix[i], i);
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}