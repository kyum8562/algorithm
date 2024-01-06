import java.io.*;
import java.util.*;

public class Main {
    static int ans, N, K;
    static int[][] RGB;
    static int[][] DP;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 집 수

        RGB = new int[N][3];
        DP = new int[N][3];

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                RGB[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        DP[0][0] = RGB[0][0];
        DP[0][1] = RGB[0][1];
        DP[0][2] = RGB[0][2];


        for (int i = 1; i < N; i++){
            for (int j = 0; j < 3; j++) {
                play(i, j);
            }
        }
        int a = Math.min(play(N-1, 0), play(N-1, 1));
        System.out.println(Math.min(a, play(N-1, 2)));
    }


    static int play(int n, int color) {
        if(n == N){
            return 1000000;
        }

        if(DP[n][color] == 0) {

            if(color == 0) {
                DP[n][0] = Math.min(play(n - 1, 1), play(n - 1, 2)) + RGB[n][0];
            }
            else if(color == 1) {
                DP[n][1] = Math.min(play(n - 1, 0), play(n - 1, 2)) + RGB[n][1];
            }
            else {
                DP[n][2] = Math.min(play(n - 1, 0), play(n - 1, 1)) + RGB[n][2];
            }

        }

        return DP[n][color];
    }
}