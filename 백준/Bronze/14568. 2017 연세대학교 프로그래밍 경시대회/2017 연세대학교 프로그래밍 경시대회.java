import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        for(int i = 1 ; i <= n ; i ++){ // 택희
            for (int j = 1; j <= n ; j++) { // 영훈
                for (int k = 1; k <= n ; k++) { // 남규
                    if(i+j+k != n) continue; // 남는 사탕 개수가 0이어야 함
                    if(k < j+2) continue; // 남규는 영훈이보다 2개 많아야 함
                    if(i %2 == 1) continue; // 택희는 짝수 개를 받아야 함

                    cnt ++;
                }
            }
        }
        System.out.println(cnt);
    }
}