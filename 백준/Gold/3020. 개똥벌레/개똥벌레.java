import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int[] high = new int[H+2];
        int[] low = new int[H+2];

        for(int i = 1 ; i <= N/2 ; i ++){
            int a = Integer.parseInt(br.readLine());
            int b = H - Integer.parseInt(br.readLine()) + 1;

            low[a] ++;
            high[b] ++;
        }

        for (int i = 1; i <= H; i++) low[i] += low[i-1];
        for (int i = H; i >= 1; i--) high[i] += high[i+1];

        int ans = N;
        int cnt = 0;
        for(int i = 1 ; i <= H ; i ++){
            int diff = (low[H] - low[i-1]) + (high[1] - high[i+1]);

            if(ans > diff){
                ans = diff;
                cnt = 1;
            }
            else if(diff == ans) cnt++;
        }
        System.out.println(ans + " " + cnt);
    }
}