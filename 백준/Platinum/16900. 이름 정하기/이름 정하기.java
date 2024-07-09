import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] table;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String s = st.nextToken();
        N = s.length();
        int K = Integer.parseInt(st.nextToken());

        // 접두사와 접미사가 같아지는 최대 길이를 담는 값
        // table[N-1] = 문자열 마지막 인덱스 위치까지, 사이에 겹쳐지는 길이의 최댓값
        // 문자열 두개를 최대한 많이 겹쳐낼 수록 길이가 짧아짐
        table = new int[N];

        makeTable(s);

        long res = N + (K - 1L) * (N - table[N-1]);
        System.out.println(res);
    }

    public static void makeTable(String s) {
        int idx = 0;
        for (int i = 1; i < N; i++) {
            while (idx > 0 && s.charAt(idx) != s.charAt(i)) {
                idx = table[idx - 1];
            }
            if (s.charAt(idx) == s.charAt(i)) {
                table[i] = ++idx;
            }
        }
    }
}