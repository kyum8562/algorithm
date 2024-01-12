import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        long ans = 0;

        for(int i = 2 ; i < K ; i ++) {
            if(K/i*i - i == 0) break;
            ans += K/i*i - i; // i의 배수가 몇개 있는지 확인
        }
        System.out.println(ans%1000000);
    }
}