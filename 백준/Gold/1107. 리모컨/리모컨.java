import java.io.*;
import java.util.*;

public class Main {
    static int N, ans, sLen;
    static boolean[] breakNum;
    static int[] choice;
    public static void main(String[] args) throws  IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String s = br.readLine();
        sLen = s.length();
        N = Integer.parseInt(s);
        int M = Integer.parseInt(br.readLine());
        ans = Math.abs(N-100);

        breakNum = new boolean[11];
        choice = new int[sLen];
        if(M > 0){
            st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < M ; i ++)
                breakNum[Integer.parseInt(st.nextToken())] = true;
        }

        perm(0, new StringBuilder());

        System.out.println(ans);
    }

    private static void perm(int depth, StringBuilder sb) {
        if(depth == sLen+1){
            int res = Integer.parseInt(sb.toString());
            ans = Math.min(ans, sb.length() + Math.abs(N-res));
            return;
        }

        if (!"".equals(sb.toString())) {
            int now = Integer.parseInt(sb.toString());
            ans = Math.min((depth) + Math.abs(now - N), ans);
        }

        for(int i = 0 ; i <= 9 ; i ++){
            if(breakNum[i]) continue;
            sb.append(i);
            perm(depth+1, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}