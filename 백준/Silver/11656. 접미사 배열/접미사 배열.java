import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();
        int len = s.length();
        String[] arr = new String[len];

        for (int i = 0; i < len; i++)
            arr[i] = s.substring(i, len);

        Arrays.sort(arr);

        for (int i = 0; i < len; i++)
            sb.append(arr[i]).append("\n");

        System.out.print(sb);
    }
}