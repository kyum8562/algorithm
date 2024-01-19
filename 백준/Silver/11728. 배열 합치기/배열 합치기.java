import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] map = new int[N];
        int[] map2 = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i ++)
            map[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < M ; i ++)
            map2[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(map);
        Arrays.sort(map2);

        int p1 = 0, p2 = 0, cnt = 0;
        int max = N+M;
        while(max > cnt){
            if(p1 >= N){
                sb.append(map2[p2++]).append(" ");
                cnt++;
                continue;
            }
            else if(p2 >= M){
                sb.append(map[p1++]).append(" ");
                cnt++;
                continue;
            }

            int res = map[p1] - map2[p2];
            if(res > 0){
                sb.append(map2[p2++]);
            }
            else if(res < 0)
                sb.append(map[p1++]);
            else{
                sb.append(map[p1++]).append(" ").append(map2[p2++]);
                cnt++;
            }

            sb.append(" ");
            cnt++;
        }
        System.out.println(sb);
    }
}