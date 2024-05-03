import java.io.*;
import java.util.*;

class Main {
    static int N;
    static char[] choice;
    static long[][][] dp;
    static Map<String, Boolean> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true){
            N = Integer.parseInt(br.readLine()) * 2;
//            set = new LinkedHashSet<>();
            map = new LinkedHashMap<>();
            choice = new char[N+1];
            dp = new long[N+1][N+1][N+1];

            if(N == 0) break;

            sb.append(recur(0, N/2, 0)).append("\n");
        }

        System.out.print(sb);
    }

    private static long recur(int depth, int defCnt, int brokenCnt) {
        if (depth == N) {

            StringBuilder s = new StringBuilder();
            for(int i = 0 ; i < N ; i ++)
                s.append(choice[i]);

            if(!map.getOrDefault(s.toString(), false)){
                map.put(s.toString(), true);
                return 1;
            }
            else return 0;
        }

        if(dp[depth][defCnt][brokenCnt] != 0) return dp[depth][defCnt][brokenCnt];

        long ret = 0;

        // 쪼갠약이 없을때 => 약을 쪼개어 먹어야만 할 경우
        if(brokenCnt == 0 && defCnt > 0){
            choice[depth] = 'W';
            ret += recur(depth + 1, defCnt-1, brokenCnt + 1);
        }
        else{
            // 쪼갤 경우
            if(defCnt > 0){
                choice[depth] = 'W';
                ret += recur(depth + 1, defCnt-1, brokenCnt + 1);
            }
            // 쪼개지 않을 경우(쪼갠거 먹을 경우)
            choice[depth] = 'S';
            ret += recur(depth + 1, defCnt, brokenCnt - 1);
        }

        return dp[depth][defCnt][brokenCnt] = ret;
    }
}