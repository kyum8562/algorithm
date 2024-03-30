import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] dist = new int[N+1][N+1];
        for(int i = 1 ; i <= N ; i ++)
            Arrays.fill(dist[i], 1 << 20);

        for(int i = 0 ; i < M ; i ++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            dist[a][b] = 1;
            dist[b][a] = 1;
        }

        for(int i = 1 ; i <= N ; i ++){
            dist[i][i] = 0;

            for(int j = 1 ; j <= N ; j ++){
                for(int k = 1 ; k <= N ; k ++){
                    if(dist[j][k] > dist[j][i] + dist[i][k]){
                        dist[j][k] = dist[j][i] + dist[i][k];
                    }
                }
            }
        }

        int min = 1 << 20;
        int ansIdx = -1;
        for(int i = N ; i >= 1 ; i --){
            int bakenCnt = 0;
            for(int j = 1 ; j <= N ; j ++)
                bakenCnt += dist[i][j];

            if(min > bakenCnt){
                min = bakenCnt;
                ansIdx = i;
            }
            else if(min == bakenCnt) ansIdx = i;
        }

        System.out.println(ansIdx);
    }
}