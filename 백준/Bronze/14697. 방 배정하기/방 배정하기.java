import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N/a ; i++) {
            for (int j = 0; j <= N/b ; j++) {
                for (int k = 0; k <= N/c ; k++) {
                    if(a*i + b*j + c*k != N) continue;
                    System.out.println(1);
                    return;
                }
            }
        }
        System.out.println(0);

    }
}