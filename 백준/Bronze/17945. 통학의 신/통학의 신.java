import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        for (int i = -1000; i <= 1000 ; i++) {
            for (int j = -1000; j <= 1000 ; j++) {
                if((i+j) == -2*A && i*j == B){
                    if(i==j) sb.append(i);
                    else{
                        if(i > j) sb.append(j).append(" ").append(i);
                        else sb.append(i).append(" ").append(j);
                    }
                    System.out.println(sb);
                    return;
                }
            }
        }
    }
}