import java.io.*;
import java.util.*;

public class Main {
    static String T, P;
    static int tLen, pLen;
    static int[] table;
    static List<Integer> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = br.readLine();
        P = br.readLine();

        tLen = T.length();
        pLen = P.length();

        // 정답이 담길 리스트(T 내에 P가 있다면 몇번째 인덱스에서 시작되는지 저장)
        list = new ArrayList<>();

        makeTable();

        comparison();

        sb.append(list.size()).append("\n");

        for(int res: list)
            sb.append(res).append("\n");

        System.out.print(sb);
    }

    private static void comparison() {
        int idx = 0;

        for(int i = 0 ; i < tLen ; i ++){
            while(idx > 0 && T.charAt(i) != P.charAt(idx))
                idx = table[idx-1];

            if(T.charAt(i) == P.charAt(idx)){
                // P와 동일한 값이 T에 있다면
                if(idx == pLen - 1){
                    list.add(i - idx + 1);
                    idx = table[idx];
                }
                else idx += 1;
            }
        }
    }

    static void makeTable() {
        // 테이블 생성
        table = new int[pLen];

        // kmp 진행에 필요한 인덱스
        int idx = 0;

        // 접두사를 기준으로, kmp 알고리즘 진행
        for(int i = 1 ; i < pLen ; i ++){
            while(idx > 0 && P.charAt(i) != P.charAt(idx))
                idx = table[idx-1];

            if(P.charAt(i) == P.charAt(idx)){
                // 부분 문자열 길이 1 증가
                idx += 1;
                table[i] = idx;
            }
        }
    }
}