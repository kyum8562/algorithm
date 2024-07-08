import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(makeTable(br.readLine()));
    }

    static int makeTable(String s) {
        int N = s.length();
        int res = 0;

        for(int i = 0 ; i < N ; i ++){
            // 접두사 설정
            String s2 = s.substring(i);
            int s2Len = s2.length();

            // 테이블 생성
            int[] table = new int[s2Len];

            // kmp 진행에 필요한 인덱스
            int idx = 0;

            // 접두사를 기준으로, kmp 알고리즘 진행
            for(int j = 1 ; j < s2Len ; j ++){
                while(idx > 0 && s2.charAt(j) != s2.charAt(idx))
                    idx = table[idx-1];

                if(s2.charAt(j) == s2.charAt(idx)){
                    // 부분 문자열 길이 1 증가
                    idx += 1;
                    table[j] = idx;

                    // 정답 갱신(부분 문자열 중 가장 긴 길이)
                    res = Math.max(res, idx);
                }
            }
        }

        return res;
    }
}