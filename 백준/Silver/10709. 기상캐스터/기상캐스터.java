import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] map;
    static int[][] ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        ans = new int[N][M];

        for(int i = 0 ; i < N ; i ++)
            map[i] = br.readLine().toCharArray();

        for(int i = 0 ; i < N ; i ++){
            boolean isCloud = false;
            int idx = 0;
            for(int j = 0 ; j < M ; j ++){
                if(map[i][j] == 'c'){
                    isCloud = true;
                    idx = 0;
                }
                if(isCloud) sb.append(idx++).append(" ");
                else sb.append(-1).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}