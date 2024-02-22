import java.io.*;
import java.util.*;

// 중복 순열
public class Main {
    static int N, ans;
    static boolean[] v;
    static List<int []> list = new ArrayList();
    public static void main(String[] args) throws  IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        ans = Integer.MAX_VALUE;
        v = new boolean[N];

        for(int i = 0 ; i < N ; i ++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // 신맛
            int b = Integer.parseInt(st.nextToken()); // 쓴맛

            list.add(new int[] {a, b});
        }

        subSet(0);

        System.out.println(ans);
    }

    private static void subSet(int depth) {
        if(depth == N){
            int allS = 1;
            int allB = 0;
            boolean flag = false;
            for(int i = 0 ; i < N ; i ++){
                if(!v[i]) continue;
                int[] cur = list.get(i);
                allS *= cur[0];
                allB += cur[1];
                flag = true;
            }

            if(flag)
                ans = Math.min(ans, Math.abs(allS - allB));
            return;
        }

        v[depth] = true;
        subSet(depth+1);

        v[depth] = false;
        subSet(depth+1);
    }
}