import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int cnt = 0;
        if (N == 1) {
            cnt = 1;
        } else if (N == 2) {
            cnt = Math.min(4, ((M + 1) / 2));
        } else if (M < 7) {
            cnt = Math.min(4, M);
        } else if(M >= 7){
            cnt = M - 2;
        }

        System.out.println(cnt);
    }
}