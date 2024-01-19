import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
//        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N + 1];
        int idx = -1;
        boolean flag = true;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            map[i] = Integer.parseInt(st.nextToken());
            if (flag && map[i] % 2 == 0) {
                idx = i;
                flag = false;
            }
        }

        if (N == 1) System.out.println(map[0] % 2 == 0 ? 1 : 0);
        else if(idx == -1) System.out.println(0);
        else System.out.println(twoPoint(idx));
    }

    private static int twoPoint(int a) {
        int s = a, e = a+1 ;
        int max = 0; // 짝수로 이루어진 최장 부분 수열 길이
        int cnt = 1; // 짝수로 이루어진 부분 수열 길이

        while (N > e) {
            // 다음 수가 짝수라면
            if (map[e] % 2 == 0) {
                e++;
                cnt++; // 연속 부분 수열 개수 ++
            }
            // 다음 수가 홀수라면
            else {
                // K가 남아있다고 한다면
                if (K > 0) {
                    K--; // K 줄이기
                    e++;
                }
                // K가 남아있지 않을 경우
                else {
                    // map[s] 값이 다음 짝수일 때까지 이동
                    while (e > s) {
                        if (map[++s] % 2 == 0) break;
                        else K++;
                    }
                    cnt --;
                }
            }
            max = Math.max(max, cnt);
        }

        return max;
    }
}