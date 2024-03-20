import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = 1000 - Integer.parseInt(br.readLine());
        int cnt = 0;
        int ans = 0;
        int[] arr = {500, 100, 50, 10, 5, 1};

        while(cnt < 6){
            if(N >= arr[cnt]) {
                ans += N / arr[cnt];
                N %= arr[cnt];
            }

            cnt ++;
        }

        System.out.print(ans);
    }
}