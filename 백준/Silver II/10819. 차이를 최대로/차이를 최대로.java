import java.io.*;
import java.util.*;

// 순열
public class Main {
    static int N, ans;
    static int[] map, choice;
    static boolean[] v;
    public static void main(String[] args) throws  IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        v = new boolean[N];
        map = new int[N];
        choice = new int[N];
        ans = Integer.MIN_VALUE;

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i ++)
            map[i] = Integer.parseInt(st.nextToken());

        perm(0);
        System.out.println(ans);
    }

    private static void perm(int depth) {
        if(depth == N){
            int sum = 0;
            for(int i = 0 ; i < N-1 ; i ++)
                sum += Math.abs(choice[i] - choice[i+1]);

            ans = Math.max(ans, sum);
            return;
        }
        
        for(int i = 0 ; i < N ; i ++){
            if(v[i]) continue;
            v[i] = true;
            choice[depth] = map[i];
            perm(depth+1);
            v[i] = false;
        }
    }
}