import java.io.*;
import java.util.*;

public class Main {
    static long N;
    static String nString;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        nString = br.readLine();
        N = Long.parseLong(nString);

        System.out.println(isPrime() ? "yes" : "no");
    }

    private static boolean isPrime() {
        if(N == 1) return false;

        String s = "347";
        for(int i = 0 ; i < 3 ; i ++)
            if(nString.contains(s.charAt(i)+"")) return false;

        if(!isCheck(N) || !isCheck(reverseN())) return false;

        return true;
    }

    private static boolean isCheck(long n) {
        for(long i = 2 ; i * i <= N ; i ++){
            if(n%i == 0) return false;
        }
        return true;
    }

    private static long reverseN() {
        long tmp = N;
        String s = "";
        while(tmp > 0){
            long cur = tmp % 10;

            if(cur == 6) cur = 9;
            else if(cur == 9) cur = 6;

            s += cur;
            tmp /= 10;
        }

        return Long.parseLong(s);
    }
}