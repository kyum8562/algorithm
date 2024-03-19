import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char[] A, B;
    static int[][] dp;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 각 문자열을 입력 받는다.
        String a = br.readLine();
        String b = br.readLine();
        // 각 문자열의 길이가 다르므로 따로 저장해둔다.
        int alength = a.length();
        int blength = b.length();
        // 각 문자열을 나눠서 저장할 char 배열.
        A = new char[alength + 1];
        B = new char[blength + 1];
        // 각 문자열을 char 배열에 문자 하나씩 옮겨 담는다.
        for(int i = 1; i <= alength; i++) {
            A[i] = a.charAt(i - 1);
        }
        for(int i = 1; i <= blength; i++) {
            B[i] = b.charAt(i - 1);
        }

        // 각 문자의 비교가 끝났을 때, 해당 위치에서 가질 수 있는 LCS의 값을 저장할 2차원 dp테이블을 정의한다.
        // 첫 행에서도 이전 문자를 참고할 수 있도록 패딩을 준다.
        dp = new int[blength + 1][alength + 1];

        // B의 모든 문자열을 A문자열과 비교
        for(int i = 1; i <= blength; i++) {
            for(int j = 1; j <= alength; j++) {
                // 만일 두 문자가 같은 경우
                if(B[i] == A[j]) {
                    // 대각선의 값을 참고하여 LCS의 값을 + 1한다.
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                // 두 문자가 다른 경우
                else {
                    // 각 문자열의 이전 문자 중 최대 LCS값을 선택.
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // 최종으로 탐색한 위치에 LCS의 최대 값이 저장되어 있을 것이다.
        System.out.println(dp[blength][alength]);
    }
}