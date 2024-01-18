import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        map = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i ++)
            map[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(map);

        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j ++){
                if(i == j) continue;
                min = Math.min(min, twoPoint(i, j));
            }
        }
        System.out.println(min);
    }

    private static int twoPoint(int a, int b) {
        int s = 0, e = N-1;

        int T = map[a] + map[b];
        int min = Integer.MAX_VALUE;
        while(e > s){
            if(s == a || s == b){
                s++;
                continue;
            }
            if(e == a || e == b){
                e--;
                continue;
            }

            int sum = map[s] + map[e];
            min = Math.min(min, Math.abs(sum-T));

            if(sum > T) e --;
            else if(sum == T){
                s ++;
                e --;
            }
            else s ++;
        }

        return min;
    }
}