import java.io.*;
import java.util.*;

public class Main {
    static int C;
    static int[] mapC;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int s = 1, e = 0, m = 0, sum = 0, ans = 0;
        int[] map = new int[M];

        for(int i = 0 ; i < M ; i ++){
            map[i] = Integer.parseInt(br.readLine());
            e = Math.max(e, map[i]);
        }

        while(e >= s){
            m = (s + e) / 2;
            sum = 0;

            for(int i = 0 ; i < M ; i ++){
                sum += map[i] / m;
                // 나머지가 있는 경우
                if(map[i] % m != 0) sum ++;
            }

            // 나눠 줄 수 없는 경우
            if(sum > N) s = m + 1;
            // 나눠 줄 수 있는 경우
            else{
                e = m - 1;
                ans = m;
            }
        }

        System.out.println(ans);
    }
}