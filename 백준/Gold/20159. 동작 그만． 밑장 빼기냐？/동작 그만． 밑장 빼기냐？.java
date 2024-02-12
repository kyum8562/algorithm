import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 상대편 카드 누적합
        int[] evenSum = new int[N / 2];
        // 내 카드 누적합
        int[] oddSum = new int[N / 2];
        int z = 2;

        // 첫 번째 카드 넣어줌
        oddSum[0] = Integer.parseInt(st.nextToken());
        evenSum[0] = Integer.parseInt(st.nextToken());

        // 카드가 2장일 때
        if(N == 2){
            System.out.print(Math.max(evenSum[0], oddSum[0]));
            return;
        }

        // 입력받은 카드를 내카드, 상대카드 누적합 구하기
        for (int i = 2; i < N; i++) {
            if (i % 2 == 0) {
                oddSum[i / 2] += oddSum[i - z] + Integer.parseInt(st.nextToken());
                z++;
            } else {
                evenSum[i / 2] += evenSum[i - z] + Integer.parseInt(st.nextToken());
            }
        }

        // 내 카드 시작할때 밑장
        int reuslt = evenSum[N / 2 - 1];

        // 내꺼 밑장빼기
        for (int i = 0; i < N / 2; i++) {
            int temp = 0;
            temp = oddSum[i] + (evenSum[N / 2 - 1] - evenSum[i]);
            if (temp > reuslt) {
                reuslt = temp;
            }
        }

        // 상대카드 처음할 때 밑장
        if (reuslt < oddSum[0] + evenSum[N / 2 - 2]) {
            reuslt = oddSum[0] + evenSum[N / 2 - 2];
        }

        // 너꺼 밑장빼기
        for (int i = 0; i < N / 2 - 1; i++) {
            int temp = 0;
            temp = evenSum[N / 2 - 2] - evenSum[i] + oddSum[i + 1];
            if (temp > reuslt) {
                reuslt = temp;
            }
        }
        System.out.print(reuslt);
    }
}