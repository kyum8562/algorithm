import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] DP;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        DP = new int[100001];
        DP[1] = 1;

        for(int i=2;i<=N;i++) {	 // dp 2부터 채우기 시작
            DP[i]=i; //우선 자기자신으로 초기화 해둔다.
            for(int j=1;j*j<=i;j++) { // j는 1부터 제곱 수가 i보다 작을 경우 반복한다.
                DP[i] = Math.min(DP[i-(j*j)]+1,DP[i]); // 최소항의 개수를 찾기 위해서 저장 된 값과 점화식값을 비교하여 최솟값을 취한다.
            }
        }
        System.out.println(DP[N]);
    }
}