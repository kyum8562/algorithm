import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(arr);
        int[] counts = new int[n];
        counts[0] = 1;
        int maxCount = 1;
        long maxNum = arr[0];
        for (int i = 1; i < n; i++) {
            counts[i] = 1;
            if (arr[i] == arr[i-1]) counts[i] = counts[i-1] + 1;
            if (counts[i] > maxCount) {
                maxCount = counts[i];
                maxNum = arr[i];
            }
        }
        System.out.println(maxNum);
    }

}