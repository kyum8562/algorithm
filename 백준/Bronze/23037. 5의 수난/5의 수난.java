import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();

        long ans = 0;
        for(int i = 0 ; i < s.length() ; i ++){
            int cur = s.charAt(i) -'0';
            int sum = 1;
            for(int j = 0 ; j < 5 ; j ++){
                sum *= cur;
            }
            ans += sum;
        }
        System.out.println(ans);
    }
}