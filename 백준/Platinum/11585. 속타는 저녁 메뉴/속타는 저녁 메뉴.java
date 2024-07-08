import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] table;
    static StringTokenizer st;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        String T = makeString(br.readLine());
        String P = makeString(br.readLine());

        makeTable(P);

        int res = KMP(T+T, P);

        int gcd = getGCD(N, res);

        System.out.print((res/gcd) + "/" + (N/gcd));
    }

    static void makeTable(String P) {
        // 테이블 생성
        table = new int[N];

        int idx = 0;

        // 접두사를 기준으로, kmp 알고리즘 진행
        for (int i = 1; i < N; i ++) {
            while (idx > 0 && P.charAt(i) != P.charAt(idx))
                idx = table[idx - 1];

            if (P.charAt(i) == P.charAt(idx)) {
                // 부분 문자열 길이 1 증가
                idx += 1;
                table[i] = idx;
            }
        }
    }

    private static int KMP(String T, String P) {
        int len = T.length();
        int cnt = 0;
        int idx = 0;

        for(int i = 1 ; i < len ; i ++){
            while(idx > 0 && T.charAt(i) != P.charAt(idx))
                idx = table[idx-1];

            // P와 동일한 값이 T에 있다면
            if(T.charAt(i) == P.charAt(idx)){
                if(idx == N - 1){
                    cnt ++;
                    idx = table[idx];
                }
                else idx += 1;
            }
        }

        return cnt;
    }

    private static int getGCD(int a, int b) {
        int r;
        while(b > 0){
            r = a % b;
            a = b;
            b = r;
        }

        return a;
    }

    static String makeString(String s){
        sb = new StringBuilder();
        st = new StringTokenizer(s);

        for(int i = 0 ; i < N ; i ++)
            sb.append(st.nextToken());

        return sb.toString();
    }
}