import java.io.*;
import java.util.*;

public class Main {
    static int winnerGroupSum, min;
    static int[] prefixSum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        prefixSum = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++)
            prefixSum[i] = prefixSum[i-1] + Integer.parseInt(st.nextToken());

        min = Integer.MAX_VALUE;

        for (int i = 1; i < N; i++) {
            for (int j = i+1; j <= N; j++)
                binarySearch(i, j); // 그룹 나누기 위한 지점 찾기
        }
        System.out.println(winnerGroupSum);
    }

    private static void binarySearch(int i, int j) {
        int s = i;
        int e = j;
        int m = 0, res = 0;

        // 나누기 전의 그룹의 총 합
        int bigGroupSum = prefixSum[j] - prefixSum[i-1];

        while(e >= s){
            // 기준점 선정
            m = (s + e) / 2;

            int leftGroupSum = prefixSum[m] - prefixSum[i-1];
            int rightGroupSum = prefixSum[j] - prefixSum[m];

            // left와 right 그룹 합의 차
            res = Math.abs(leftGroupSum - rightGroupSum);

            // 최솟값 갱신
            // 그룹 간 합의 차가 작다면
            if(min > res){
                min = res;
                winnerGroupSum = bigGroupSum;
            }
            // 그룹 간 합의 차가 같다면
            else if(min == res)
                winnerGroupSum = Math.max(winnerGroupSum, bigGroupSum);

            /**
             * Q. 어떤 값이랑 비교할거야?(지금 배열에서 정렬이 안되어 있어)
             * A. 우리가 구해야 하는 것은 '두 그룹간 차의 최솟값'이기 때문에 최솟값을 줄여주면 됨
             * 따라서, 그룹1의합 > 그룹2의합 이라면 기준이 더이상 오른쪽으로 갈 필요가 없기 때문에 격차를 줄이려면 왼쪽으로 이동해서 그룹1의합을 줄여나가야 함
             * 반대로 그룹1의합 < 그룹2의합 이라면 기준이 더인상 왼쪽으로 갈 필요가 없기 때문에 격차를 줄이려면 오른쪽으로 이동해서 그룹2의합을 줄여나가야 함
             */
            if(leftGroupSum > rightGroupSum) e = m - 1;
            else s = m + 1;
        }
    }
}