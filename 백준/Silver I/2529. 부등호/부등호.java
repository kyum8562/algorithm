import java.io.*;
import java.util.*;

// 중복 조합(주어진 배열), 사전 순
public class Main {
    static int N, K;
    static long max, min;
    static int[] choice;
    static String[] giho;
    static boolean[] v;
//    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws  IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        K = N+1;
        max = Long.MIN_VALUE;
        min = Long.MAX_VALUE;

        giho = new String[K];
        choice = new int[K];
        v = new boolean[10];

        st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= N ; i ++)
            giho[i] = st.nextToken();

        perm(0);

        System.out.println(getAns(max));
        System.out.println(getAns(min));
    }

    private static String getAns(long s) {
        String cur = s+"";
        String ans = "";

        int cnt = K - cur.length();
        while(cnt -- > 0) ans += "0";

        return ans+cur;
    }

    private static void perm(int depth) {
        if(depth == K){
            int val = choice[0];
            boolean flag = true;
            for(int i = 1 ; i < K ; i ++){
                if(!isCheck(val, i)){
                    flag = false;
                    break;
                }

                val = choice[i];
            }

            if(flag){
                String s = "";
                for(int i: choice)
                    s += i;

                Long cur = Long.parseLong(s);

                max = Math.max(max, cur);
                min = Math.min(min, cur);
            }
            return;
        }

        for(int i = 0 ; i <= 9 ; i ++){
            if(v[i]) continue;
            v[i] = true;
            choice[depth] = i;
            perm(depth+1);
            v[i] = false;
        }
    }

    private static boolean isCheck(int val, int i) {
        String curGiho = giho[i];
        int curTgt = choice[i];

        if(curGiho.equals(">")){
            if(val > curTgt) return true;
        }
        else{
            if(val < curTgt) return true;
        }
        return false;
    }
}