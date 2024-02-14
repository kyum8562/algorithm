import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][3];

        for(int i = 0 ; i < N ; i ++){
            st = new StringTokenizer(br.readLine());

            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
            map[i][2] = Integer.parseInt(st.nextToken());
        }

        int ans = Integer.MAX_VALUE;
        for(int i = 0 ; i < N ; i ++){ // 마을 1 결정
            int min1 = 10000, min2 = 10000;
            for(int j = 0 ; j < N ; j ++){ // 마을1 이외의 마을을 탐색하면서 마을1과 가장가까운 마을과 그다음으로 가까운 마을을 찾음
                if(i == j) continue;
                int dist = Math.abs(map[i][0] - map[j][0]) + Math.abs(map[i][1] - map[j][1]) + Math.abs(map[i][2] - map[j][2]);

                if(min1 > dist){
                    min2 = min1;
                    min1 = dist;
                }
                else if(min2 > dist)
                    min2 = dist;
            }
            ans = Math.min(ans, min1+min2);
        }
        System.out.println(ans);
    }
}