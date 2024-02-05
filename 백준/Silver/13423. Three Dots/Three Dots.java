import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int t = 1 ; t <= T ; t ++){
            N = Integer.parseInt(br.readLine());
            map = new int[N];

            st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < N ; i ++)
                map[i] = Integer.parseInt(st.nextToken());

            Arrays.sort(map);
            int ans = 0;

            for (int i = 0; i < N-2; i++) {
                for (int j = i + 1; j < N-1; j++) {
                    int gap = map[j] - map[i];
                    ans += binarySearch(gap, j, map[j]);
                }
            }
            sb.append(ans).append("\n");
        }

        System.out.println(sb);
    }

    private static int binarySearch(int T, int startPoint, int minusVal) {
        int s = startPoint;
        int e = N-1;
        int m = 0;

        while(e >= s){
            m = (s + e) / 2;
            int res = map[m] - minusVal;

            if(res > T) e = m - 1;
            else if(res < T) s = m + 1;
            else return 1;
        }

        return 0;
    }
}