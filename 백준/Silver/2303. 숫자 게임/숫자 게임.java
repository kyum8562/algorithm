import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[][] arr = new String[N][5];  //N개의 행과 5개열로 구성된 2차원 배열 선언
        int[] max = new int[N]; //각 행 별 1의 자리 값의 최댓값 저장하는 배열

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            arr[i] = str.split(" ");

            int sum = 0;    //현재 1의 자리가 최댓값인 수
            int temp;       //현재 숫자들의 합

            for (int j = 0; j < 3; j++) {
                for (int k = j + 1; k < 4; k++) {
                    for (int l = k + 1; l < 5; l++) {
                        temp = Integer.parseInt(arr[i][j]) + Integer.parseInt(arr[i][k]) + Integer.parseInt(arr[i][l]);
                        if (sum <= temp % 10)   //1의 자리를 비교해야 하기 때문에 현재 숫자들의 합인 temp 에 %10을 해줌
                            sum = temp % 10;
                    }
                }
            }
            max[i] = sum;
        }

        int maxIndex = 0;
        int result = max[0];

        for (int i = 0; i < max.length; i++) {
            if (max[i] >= result) {
                result = max[i];
                maxIndex = i + 1;
            }
        }

        System.out.println(maxIndex);

    }

}
