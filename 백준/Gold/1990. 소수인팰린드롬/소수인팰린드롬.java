import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static List<Integer> list = new ArrayList<>();
    static boolean[] isPrime = new boolean[100000001];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        eratos();

        // 소수, 팰린드롬 체크
        for (int i = a; i <= b ; i++) {
            if(!isPrime[i] && palindrome(i))
                sb.append(i).append("\n");
        }
        sb.append("-1");
        System.out.println(sb);
    }

    private static boolean palindrome(int n) {
        String s = String.valueOf(n);
        int left = 0;
        int right = s.length() -1;
        while(left < right){
            char a = s.charAt(left);
            char b = s.charAt(right);
            
            if(a != b) return false;
            left ++;
            right --;
        }
        return true;
    }

    private static void eratos() {
        isPrime[1] = true;
        for(int i = 2 ; i * i <= 10000000 ; i ++){
            if(isPrime[i]) continue;
            for(int j = i * i ; j <= 100000000 ; j += i){
                isPrime[j] = true;
            }
        }
    }
}