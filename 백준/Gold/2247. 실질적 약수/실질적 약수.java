import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long K = Long.parseLong(br.readLine());
        long ans = 0;
        long sum = 0;

        for(long i = 1 ; i <= K ; i ++) {
            if(K/i*i - i == 0) break;
            sum += K/i*i - i;
        }
        ans = sum + 1 - K;
        System.out.println(ans%1000000);
    }
}