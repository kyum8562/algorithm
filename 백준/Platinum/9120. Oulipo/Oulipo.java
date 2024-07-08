import java.io.*;
import java.util.*;

public class Main {
    static int[] table;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());
        for(int t = 1 ; t <= TC ; t ++){
            String P = br.readLine();
            String T = br.readLine();

            makeTable(P);

            sb.append(KMP(T, P)).append("\n");
        }

        System.out.print(sb);
    }

    static void makeTable(String P) {
        int len = P.length();

        // 테이블 생성
        table = new int[len];

        int idx = 0;

        // 접두사를 기준으로, kmp 알고리즘 진행
        for (int i = 1; i < len; i ++) {
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
        int tlen = T.length();
        int plen = P.length();

        int cnt = 0;
        int idx = 0;

        for(int i = 0 ; i < tlen ; i ++){
            while(idx > 0 && T.charAt(i) != P.charAt(idx))
                idx = table[idx-1];

            // P와 동일한 값이 T에 있다면
            if(T.charAt(i) == P.charAt(idx)){
                if(idx == plen - 1){
                    cnt ++;
                    idx = table[idx];
                }
                else idx += 1;
            }
        }

        return cnt;
    }
}