import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = 1000 - Integer.parseInt(br.readLine());
        int[] arr = {500, 100, 50, 10, 5, 1};
        int arrCnt = 0;
        int cnt = 0;

        while(N != 0){
            if(N >= arr[arrCnt]){
                cnt += N / arr[arrCnt];
                N %= arr[arrCnt];
            }
            arrCnt++;
        }

        System.out.println(cnt);
    }
}