import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        while(N-- > 0){
            st = new StringTokenizer(br.readLine());
            int cnt = st.countTokens();
            int[] map = new int[cnt];
            for(int i = 0 ; i < cnt ; i ++)
                map[i] = Integer.parseInt(st.nextToken());

            int ans = 0;
            for(int i = 0 ; i < cnt ; i ++){
                for(int j = i+1 ; j < cnt ; j ++){
                    ans = Math.max(ans, gcd(map[i], map[j]));
                }
            }

            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }

    private static int gcd(int a, int b) {
        // 두 수 정렬(a > b)
        if(b > a){
            int tmp = a;
            a = b;
            b = tmp;
        }
        // 유클리드 호제법
        while(b != 0){
            int tmp = a%b;
            a = b;
            b = tmp;
        }
        // 최대공약수 리턴
        return a;
    }
}