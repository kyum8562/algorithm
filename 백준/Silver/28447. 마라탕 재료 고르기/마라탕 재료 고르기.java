import java.io.*;
import java.util.*;

public class Main {
    static int N, M, ans;
    static int[] choice;
    static int[][] map;
    public static void main(String[] args) throws  IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ans = Integer.MIN_VALUE;

        map = new int[N][N];
        choice = new int[M];

        if(M == 1) System.out.println(0);
        else{
            for(int i = 0 ; i < N ; i ++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0 ; j < N ; j ++)
                    map[i][j] = Integer.parseInt(st.nextToken());
            }

            comb(0, 0);

            System.out.println(ans);
        }
    }

    private static void comb(int depth, int start) {
        if(depth == M){
            int sum = 0;
            for(int i = 0 ; i < M ; i ++){
                for(int j = i+1 ; j < M ; j ++)
                    sum += map[choice[i]][choice[j]];
            }
            ans = Math.max(ans, sum);
            return;
        }

        for(int i = start ; i < N ; i ++){
            choice[depth] = i;
            comb(depth+1, i+1);
        }
    }
}