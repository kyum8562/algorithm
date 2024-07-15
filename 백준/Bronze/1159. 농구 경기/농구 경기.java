import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[26];

        for(int i = 0 ; i < N ; i ++)
            arr[br.readLine().charAt(0) - 97] ++;

        for(int i = 0 ; i < 26 ; i ++){
            if(arr[i] >= 5) sb.append((char) (i + 97));
        }
        
        if(sb.length() == 0) System.out.println("PREDAJA");
        else System.out.println(sb);
    }
}