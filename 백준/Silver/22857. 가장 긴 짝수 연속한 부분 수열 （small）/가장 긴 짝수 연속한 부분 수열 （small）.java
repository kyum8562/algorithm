import java.io.*;
import java.util.*;
 
public class Main {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    static int N, K;
    static int A[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        N = atoi(st.nextToken());
        K = atoi(st.nextToken());
 
        A = new int[N + 1];
 
        st = new StringTokenizer(br.readLine());
 
        for (int i = 1; i <= N; i++) {
            A[i] = atoi(st.nextToken());
        }
 
        solution();
    }
 
    static void solution() {
        int e = 0, len = 0, cnt = 0;
 
        for (int s = 1; s <= N; s++) {
            // 짝수
            if(cnt >= 1 && A[s-1] % 2 != 0) cnt--;
 
            while (e + 1 <= N && cnt <= K) {
                if(A[++e] % 2 != 0) cnt++;
            }
 
            len = Math.max(len, e - s + 1 - cnt);
        }
 
        System.out.println(len);
    }
}