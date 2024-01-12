import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static boolean[] isPrime;
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        isPrime = new boolean[2000000+1];
        eratos();

        while(T -- > 0){
            st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            long n = a+b;

            if(n < 4) sb.append("NO");
            // [골드바흐] 합이 짝수가 만들어 지는 경우(홀+홀, 짝+짝)
            else if(n % 2 == 0) sb.append("YES");
            // 홀수가 만들어지는 경우(2[유일한 짝수 소수] + 홀수 소수)
            else{
                //a+b-2가 소수인지만 판별하면 됨
                // n이 2,000,000 보다 작은 경우 판별
                if(check(n-2))
                    sb.append("YES");
                else
                    sb.append("NO");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static boolean check(long n) {
        if(n <= 2000000) return !isPrime[(int) n];

        // 소수로 나누어 떨어지는지 확인
        for(int i = 0 ; i < list.size() ; i ++){
            if(n % list.get(i) == 0){
                return false; // 소수로 나누어 떨어지면, 소수가 아님
            }
        }
        return true;
    }

    private static void eratos() {
        isPrime[1] = true;
        for(int i = 2 ; i <= 2000000 ; i ++){
            if(isPrime[i]) continue;
            list.add(i);
            for(int j = i*2 ; j <= 2000000 ; j += i){
                isPrime[j] = true;
            }
        }
    }
}