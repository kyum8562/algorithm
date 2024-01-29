import java.io.*;
import java.util.*;
public class Main {
    static int[] prefixSum_A, prefixSum_B;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        int N = Integer.parseInt(br.readLine());
        prefixSum_A = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++)
            prefixSum_A[i] = prefixSum_A[i-1] + Integer.parseInt(st.nextToken());

        int M = Integer.parseInt(br.readLine());
        prefixSum_B = new int[M+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= M; i++)
            prefixSum_B[i] = prefixSum_B[i-1] + Integer.parseInt(st.nextToken());

        List<Integer> aList = new ArrayList<>();
        for(int i = 1 ; i <= N ; i ++){
            for(int j = i ; j <= N ; j ++)
                aList.add(prefixSum_A[j] - prefixSum_A[i-1]);
        }

        List<Integer> bList = new ArrayList<>();
        for(int i = 1 ; i <= M ; i ++){
            for(int j = i ; j <= M ; j ++)
                bList.add(prefixSum_B[j] - prefixSum_B[i-1]);
        }

        Collections.sort(aList);
        Collections.sort(bList);

        int aLen = aList.size();
        int bLen = bList.size();

        long cnt = 0;
        int point_A = 0, point_B = bLen - 1;
        while(aLen > point_A && point_B >= 0){
            int a = aList.get(point_A);
            int b = bList.get(point_B);
            int res = a + b;

            if(res > T) point_B --;
            else if(res < T) point_A ++;
            else{
                long cnt_A = 0;
                long cnt_B = 0;

                while(aLen > point_A && aList.get(point_A) == a){
                    cnt_A ++;
                    point_A ++;
                }

                while(point_B >= 0 && bList.get(point_B) == b){
                    cnt_B ++;
                    point_B --;
                }

                cnt += cnt_A * cnt_B;
            }
        }
        System.out.print(cnt);
    }
}