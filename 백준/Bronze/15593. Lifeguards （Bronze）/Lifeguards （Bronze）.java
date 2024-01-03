import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
//        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] map = new int[1001];
        int sum = 0;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.add(new int[]{a, b});
            for (int j = a; j < b ; j++) map[j] ++;
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < N ; i ++){
            for(int j = list.get(i)[0] ; j < list.get(i)[1] ; j ++){
                map[j] --;
            }
            int cnt = 0;
            for(int j = 0 ; j <= 1000 ; j ++){
                if(map[j] >= 1) cnt ++;
            }
            max = Math.max(max, cnt);
            for(int j = list.get(i)[0] ; j < list.get(i)[1] ; j ++){
                map[j] ++;
            }
        }
            
        System.out.println(max);
    }
}