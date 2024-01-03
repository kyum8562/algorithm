import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int ans = Integer.MIN_VALUE;
        for (int i = 0; i <= N ; i++) {
            for (int j = 0; j <= M ; j++) {
                if(i+j != K) continue; // 인턴쉽 프로그램 인원 미충족 => 패스
                ans = Math.max(ans, Math.min((N-i)/2, (M-j)));
            }
        }
        System.out.println(ans);

    }
}