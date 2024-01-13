import java.io.*;

public class Main {
    static int[] arr;
    static int[] sosu;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 1 ; t <= T ; t ++) {
            int N = Integer.parseInt(br.readLine());

            arr = new int[N+1];
            sosu = new int[N+1]; // sosu[i]: (0.0)에서 보이는 좌표 수 계산

            // 초기값 설정
            arr[1] = 3;
            sosu[1] = 3;

            for(int i = 2 ; i <= N ; i++) {
                int cnt = arr[1];
                int newPoints = 2 * i + 1; // 좌표에서 추가되는 점의 수
                int j;

                for(j = 2 ; j * j < i ; j ++) {
                    // 소수 계산: i가 j로 나누어 떨어지면 (j, i/j)를 통과하는 직선이 있다. -> 빼주기
                    if(i % j == 0) cnt += sosu[j] + sosu[i/j];

                }
                // j*j == i인 경우 중복 계산 방지 -> 빼주기
                if(j * j == i) cnt += sosu[j];

                sosu[i] = newPoints - cnt;

                arr[i] = arr[i-1] + sosu[i];
            }
            System.out.println(arr[N]);

        }
    }
}