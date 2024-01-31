import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        long[] sum1 = new long[N+1];
        long[] sum2 = new long[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= N ; i ++)
            sum1[i] = sum1[i-1] + Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= N ; i ++)
            sum2[i] = sum2[i-1] + Integer.parseInt(st.nextToken());

        long ans = 0;
        Map<Long, Long> map = new LinkedHashMap<>();
        Map<Long, Long> map2 = new LinkedHashMap<>();
//        map.put(0L, 1L);


        for(int i = 1 ; i <= N ; i ++){
            if(sum1[i] == sum2[i]) ans ++;

            ans += map.getOrDefault(sum2[i] - sum1[i], 0L);

            map.put(sum2[i] - sum1[i], map.getOrDefault(sum2[i] - sum1[i], 0L) + 1);
        }

        System.out.println(ans);
    }
}
