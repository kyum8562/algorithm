import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < T ; i ++){
            int N = Integer.parseInt(br.readLine());

            int max = 0;
            String ans = "";

            for(int j = 0 ; j < N ; j ++){
                st = new StringTokenizer(br.readLine());
                int n = Integer.parseInt(st.nextToken());
                String cur = st.nextToken();
                if(n > max){
                    max = n;
                    ans = cur;
                }
            }

            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }
}