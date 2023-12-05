import java.io.*;
import java.util.*;

public class Main {
    static int N, ans = Integer.MAX_VALUE;
    static int[][] map;
    static boolean[] v;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        v = new boolean[N];
        for(int i = 0 ; i < N ; i ++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N ; j ++){
                map[i][j] += Integer.parseInt(st.nextToken());
                map[j][i] += map[i][j];
            }
        }

        perm(0, 0);
        System.out.println(ans);
    }

    private static void perm(int depth, int start) {
        if(depth == N/2){
            play();
            return;
        }
        for(int i = start ; i < N ; i ++){
            if(v[i]) continue;
            v[i] = true;

            perm(depth+1, i+1);
            v[i] = false;
        }
    }

    private static void play() {
        int[] arr1 = new int[N/2];
        int[] arr2 = new int[N/2];
        int idx1 = 0, idx2 = 0;
        for(int i = 0 ; i < N ; i ++){
            if(v[i]) arr1[idx1++] = i;
            else arr2[idx2++] = i;
        }
        int res = Math.abs(calculating(arr1) - calculating(arr2));
        ans = Math.min(ans, res);
    }

    private static int calculating(int[] arr) {
        int res = 0;
        for(int i = 0 ; i < N/2 ; i ++){
            for(int j = 0 ; j < i ; j ++){
                res += map[arr[i]][arr[j]];
            }
        }
        return res;
    }
}