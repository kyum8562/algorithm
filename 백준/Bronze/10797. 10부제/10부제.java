import java.io.*;
import java.util.*;

class Main {
    static int N;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        int ans = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < 5 ; i ++){
            if(Integer.parseInt(st.nextToken()) == N) ans ++;
        }

        System.out.println(ans);
    }
}