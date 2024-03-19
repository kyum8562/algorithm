import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];
        
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(br.readLine());
        
        Arrays.sort(arr, Collections.reverseOrder());
        
        int ans = 0;
        for (int i = 0; i < n; i++)
            ans = Math.max(ans, arr[i] * (i+1));
        
        System.out.print(ans);
    }
}