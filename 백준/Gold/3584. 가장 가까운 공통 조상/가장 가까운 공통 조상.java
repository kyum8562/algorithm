import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1 ; t <= T ; t ++){
            int N = Integer.parseInt(br.readLine());

            list = new ArrayList[N+1];

            for(int i = 1 ; i <= N ; i ++)
                list[i] = new ArrayList<>();

            for(int i = 0 ; i < N-1 ; i ++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                list[b].add(a);
            }

            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            boolean[] v = new boolean[N+1];

            while(list[A].size() != 0){
                v[A] = true;
                A = list[A].get(0);
            }
            v[A] = true;

            int ans = 0;
            while(list[B].size() != 0){
                if(v[B]){
                    ans = B;
                    break;
                }
                B = list[B].get(0);
            }

            sb.append(ans == 0 ? B : ans).append("\n");
        }

        System.out.print(sb);
    }
}