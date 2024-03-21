import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for(int i = 0 ; i < N ; i ++)
            arr[i] = Integer.parseInt(br.readLine());

        int ans = 0;
        int curVal = arr[N-1];

        for(int i = N-2 ; i >= 0 ; i --){
            if(arr[i] >= curVal){
                int tmp = arr[i] - curVal + 1;
                arr[i] -= tmp;
                ans += tmp;
            }

            curVal = arr[i];
        }

        System.out.println(ans);
    }
}