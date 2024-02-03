import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer sub = new StringTokenizer(br.readLine(), "-");

        int ans = Integer.MAX_VALUE;
        while(sub.hasMoreTokens()){
            int res = 0;

            StringTokenizer add = new StringTokenizer(sub.nextToken(), "+");

            while(add.hasMoreTokens())
                res += Integer.parseInt(add.nextToken());

            if(ans == Integer.MAX_VALUE)
                ans = res;
            else
                ans -= res;
        }

        System.out.println(ans);
    }
}