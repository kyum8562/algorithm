import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[7][2];

        for(int i = 0 ; i < N ; i ++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a == 0) map[b][0]++;
            else map[b][1]++;
        }

        int ans = 0;
        for(int i = 1 ; i <= 6 ; i ++){
            for(int j = 0 ; j < 2 ; j ++){
                if(map[i][j] == 0) continue;
                else{
                    ans += map[i][j]/K;
                    if(map[i][j]%K !=0) ans ++;
                }
            }
        }
        System.out.println(ans);
    }
}