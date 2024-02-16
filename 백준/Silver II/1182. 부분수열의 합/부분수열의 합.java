import java.io.*;
import java.util.*;

// 부분 수열(공집합 제외)
public class Main {
    static int N, S, ans;
    static int[] map;
    static boolean[] v;
    public static void main(String[] args) throws  IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        v = new boolean[N];
        map = new int[N];
        ans = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i ++)
            map[i] = Integer.parseInt(st.nextToken());

        subSet(0);
        System.out.println(ans);
    }

    private static void subSet(int depth) {
        if(depth == N){
            int sum = 0;
            boolean flag = false; // 공집합 필터링
            for(int i = 0 ; i < N ; i ++)
                if(v[i]){
                    sum += map[i];
                    flag = true;
                }
            
            if(sum == S && flag) ans ++;
            return;
        }
        
        v[depth] = true;
        subSet(depth+1);

        v[depth] = false;
        subSet(depth+1);
    }
}