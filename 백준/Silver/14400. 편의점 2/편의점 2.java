import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] arrR = new int[N];
        int[] arrC = new int[N];

        for(int i = 0 ; i < N ; i ++){
            st = new StringTokenizer(br.readLine());
            arrR[i] = Integer.parseInt(st.nextToken());
            arrC[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arrR);
        Arrays.sort(arrC);

        int r = 0;
        int c = 0;
        if(N %2 == 0){
            r = arrR[(N/2)-1];
            c = arrC[(N/2)-1];
        }
        else{
            r = arrR[N/2];
            c = arrC[N/2];
        }
        long sum = 0;
        for(int i = 0 ; i < N ; i ++)
            sum += Math.abs(r - arrR[i]) + Math.abs(c - arrC[i]);

        System.out.println(sum);
    }
}