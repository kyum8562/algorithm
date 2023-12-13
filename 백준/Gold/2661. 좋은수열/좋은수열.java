import java.io.*;
import java.util.*;
public class Main {
    static String s;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        perm("");
    }

    private static void perm(String s) {
        if(s.length() == N){
            System.out.println(s);
            System.exit(0);
        }
        for(int i = 1 ; i <= 3 ; i ++){
            if(isGood(s+i)) perm(s+i);
        }
    }

    private static boolean isGood(String s) {
        int len2 = s.length()/2;
        int len = s.length();
        for(int i = 1 ; i <= len2 ; i ++){
            String front = s.substring(len-i*2, len-i);
            String back = s.substring(len-i, len);
            if(front.equals(back)) return false;
        }
        return true;
    }
}