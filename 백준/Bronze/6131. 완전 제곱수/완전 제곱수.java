import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        for (int i = 1; i <= 500 ; i++) {
            for (int j = 1; j <= 500 ; j++) {
                if(i*i == j*j + n) cnt ++;
            }
        }
        System.out.println(cnt);

    }
}