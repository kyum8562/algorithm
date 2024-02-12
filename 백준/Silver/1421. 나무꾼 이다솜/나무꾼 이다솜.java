import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken()); // 나무의 개수
        int C = Integer.parseInt(st.nextToken()); // 나무 자를 때 비용
        int W = Integer.parseInt(st.nextToken()); // 나무 한 단위의 가격

        int max = Integer.MIN_VALUE;
        int[] treeHeight = new int[N];

        for(int i = 0 ; i < N ; i ++){
            treeHeight[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, treeHeight[i]);
        }

        long ans = Integer.MIN_VALUE;

        // treeCut 위치에서 나무를 자름
        for(int treeCut = 1 ; treeCut <= max ; treeCut ++){
            long sum = 0;
            for(int j = 0 ; j < N ; j ++){ // N개의 나무 탐색

                // 현재 트리의 높이가 자를 위치보다 크거나 같을 때
                if(treeHeight[j] >= treeCut){
                    int cnt = 0;
                    int divide = treeHeight[j] / treeCut;

                    // 딱 떨어진다면
                    if(treeHeight[j] % treeCut == 0)
                        cnt = divide - 1;
                    else
                        cnt = divide;

                    int res = W * treeCut * divide - cnt * C;

                    if(res > 0) sum += res;
                }
            }

            ans = Math.max(ans, sum);
        }
        System.out.println(ans);
    }
}