import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N+1][N+1];

        // 가로기준 누적합
        for(int i = 1 ; i <= N ; i ++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1 ; j <= N ; j ++) {
                int tmp = Integer.parseInt(st.nextToken());
                map[i][j] = map[i][j-1] + tmp;
            }
        }
        // 가로기준 누적합을 바탕으로 한 세로 누적합
        for(int i = 1 ; i <= N ; i ++) {
            for(int j = 1 ; j <= N ; j ++)
                map[i][j] += map[i-1][j];
        }

        for(int i = 0 ; i < M ; i ++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int ans = map[x2][y2] - map[x2][y1-1] - map[x1-1][y2] + map[x1-1][y1-1];
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}