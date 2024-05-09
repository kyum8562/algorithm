import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int ans = 0;

        while(true){
            int tmp = n / c;

            if(tmp == 0) break;

            ans += tmp;
            n = n % c + tmp;
        }


        System.out.print(ans);
    }
}