import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        StringBuilder sb = new StringBuilder();

        int sum = 0;
        int ans = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i < 10 ; i ++){
            sum += Integer.parseInt(br.readLine());
            int res = Math.abs(100 - sum);
            if(min > res){
                min = res;
                ans = sum;
            }
            else if(min == res)
                ans = sum;
        }
        System.out.println(ans);
    }
}