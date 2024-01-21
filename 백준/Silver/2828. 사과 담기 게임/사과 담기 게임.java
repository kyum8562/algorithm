import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int J = Integer.parseInt(br.readLine());

        int curS = 1;
        int curE = curS + M - 1;
        int ans = 0;
        for(int i = 0 ; i < J ; i ++){
            int tgt = Integer.parseInt(br.readLine());

            if(tgt > curE){
                ans += tgt - curE;
                curE = tgt;
                curS = curE - M + 1;
            }
            else if(tgt < curS){
                ans += curS - tgt;
                curS = tgt;
                curE = curS + M - 1;
            }
        }

        System.out.println(ans);
    }
}