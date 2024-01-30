import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N + 1];
        Map<Integer, Integer> map = new LinkedHashMap<>();

        long ans = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken()) + arr[i - 1];
            if (arr[i] == K) ans++;

            ans += map.getOrDefault(arr[i] - K, 0);
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        System.out.println(ans);
    }
}