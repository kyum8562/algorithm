import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] dist = new int[N+1][N+1];
        int[][] route = new int[N+1][N+1];

        for(int i = 1 ; i <= N ; i ++){
            for (int j = 1; j <= N ; j++) {
                dist[i][j] = (i == j) ? 0 : 2000001;
                route[i][j] = (i == j) ? 0 : j;
            }
        }

        for(int i = 1 ; i <= M ; i ++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            dist[a][b] = dist[b][a] = d;
        }
        for(int n = 1 ; n <= N ; n ++) {
            for (int i = 1; i <= N ; i++) {
                for (int j = 1; j <= N ; j++) {
                    if(i == j) continue;
                    if (dist[i][j]> dist[i][n] + dist[n][j]){
                        dist[i][j] = dist[i][n] + dist[n][j];
                        route[i][j] = route[i][n];
                    }
                }
            }
        }
        for(int i = 1 ; i <= N ; i ++){
            for (int j = 1; j <= N ; j++) {
                sb.append(route[i][j] == 0 ? "- " : route[i][j]+ " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}