import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Set<Integer> set = new LinkedHashSet<>();
        int[] map = new int[N];
        for(int i = 0 ; i < N ; i ++){
            map[i] = Integer.parseInt(br.readLine());
            set.add(map[i]);
        }
        Object[] setMap = set.toArray();
        int max = 1;
        for(Object cur: setMap){
            int cnt = 1;
            int lastVal = -1;
            for (int i = 0; i < N; i++) {
                if(cur.equals(map[i])) continue; // 뺄 수를 컨티뉴

                if(lastVal == map[i]) cnt ++;
                else cnt = 1;
                max = Math.max(max, cnt);
                lastVal = map[i];
            }
        }
        System.out.println(max);
    }
}