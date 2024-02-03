import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int[] map = new int[5];
        for (int i = 0; i < 5; i++)
            map[i] = Integer.parseInt(st.nextToken());

        String res = "1 2 3 4 5";
        while (true) {
            int cnt = 0;
            boolean flag = true;
            String cur = "";

            for (int i = 0; i < 4; i++) {
                if (map[i + 1] < map[i]){
                    int tmp = map[i];
                    map[i] = map[i+1];
                    map[i+1] = tmp;
                    flag = false;
                    for(int j = 0 ; j < 5 ; j ++)
                        sb.append(map[j]).append(" ");
                    sb.append("\n");
                }
            }

            if(flag) break;
        }
        System.out.println(sb);
    }
}