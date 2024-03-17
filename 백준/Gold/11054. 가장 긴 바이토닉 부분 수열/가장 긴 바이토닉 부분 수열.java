import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] map = new int[N + 1];
        int[] LIS = new int[N + 1];
        int[] LDS = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++)
            map[i] = Integer.parseInt(st.nextToken());

        // LIS 구하기
        for (int i = 1; i <= N; i++) {
            LIS[i] = 1;
            for (int j = 1; j < i; j++) {
                if (map[i] > map[j])
                    LIS[i] = Math.max(LIS[j]+1, LIS[i]);
            }
        }

        // LDS 구하기 -> 오른쪽에서 시작하는 LIS라고 생각하면 쉬움
        for (int i = N; i >= 1; i--) {
            LDS[i] = 1;
            for (int j = N; j > i; j--) {
                if (map[i] > map[j])
                    LDS[i] = Math.max(LDS[j]+1, LDS[i]);
            }
        }

        int max = 0;
        for(int i = 1 ; i <= N ; i ++)
            max = Math.max(max, LDS[i] + LIS[i]);

        // 가운데 최대가 되는 중복값을 하나 제거해준다.
        System.out.println(max - 1);
    }
}