import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int tokenNum = st.countTokens();
            for(int j = 0; j < tokenNum; j++) {
                StringBuilder sb = new StringBuilder(st.nextToken());
                System.out.print(sb.reverse() + " ");
            }
        }
    }
}