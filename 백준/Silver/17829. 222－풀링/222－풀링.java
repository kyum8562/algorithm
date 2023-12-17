import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N ; j ++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        while(N > 1){
            int tmp = N/2;

            divide(tmp);

            N = tmp; // 2로 나누기
        }
        System.out.println(map[0][0]);
    }

    private static void divide(int n) {
        int[][] tmp = new int[n][n];

        for(int a = 0 ; a < N ; a += 2){
            for(int b = 0 ; b < N ; b += 2){
                int[] arr = new int[4];
                int idx = 0;
                for(int i = a ; i < a+2 ; i ++){
                    for(int j = b ; j < b+2 ; j ++){
                        arr[idx++] = map[i][j];
                    }
                }
                Arrays.sort(arr);
                tmp[a/2][b/2] = arr[2];
            }
        }

        map = tmp;
    }
}