import java.io.*;
import java.util.*;

public class Main {
    static boolean[] isPrime = new boolean[4000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        eratos();

        System.out.println(getAns(A, B, D+""));
    }

    private static void eratos() {
        isPrime[1] = true;
        for(int i = 2 ; i * i <= 4000000 ; i ++){
            if(isPrime[i]) continue;
            for(int j = i*i; j <= 4000000 ; j += i)
                isPrime[j] = true;
        }
    }

    private static int getAns(int A, int B, String D) {
        int ans = 0;
        for(int i = A ; i <= B ; i ++){
            if(isPrime[i]) continue;
            String s = i+"";
            if(s.contains(D)) ans ++;
        }
        return ans;
    }
}