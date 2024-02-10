import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int ans = 0;
        while(true){
            int cur = Integer.parseInt(br.readLine());
            if(cur == -1) break;
            ans += cur;
        }
        System.out.println(ans);
    }
}