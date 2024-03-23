import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int ans = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i ++){
            T -= Integer.parseInt(st.nextToken());
            if(T < 0) break;
            ans ++;
        }

        System.out.print(ans);
    }
}