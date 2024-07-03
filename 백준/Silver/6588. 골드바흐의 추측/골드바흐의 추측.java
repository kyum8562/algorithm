import java.io.*;

public class Main {
	//테스트 케이스의 범위가 6 <= n <= 1000000,
    //백만까지 이므로 크기가 1000001인 배열을 static으로 생성
    final static int MAX = 1000000;
    static boolean[] primeNumber = new boolean[MAX + 1];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        int[] result;
        //소수를 찾는 메소드 실행
        findPrimeNumber(primeNumber);

		//num이 0이 나올때까지 반복
        while (num != 0) {  
            result = new int[2];

			//num이하인 경우에 대해 for문으로 반복
            for (int i = num; i >= 0 ; i--) {

				//i와 num-i가 소수일 때 문제에 맞게 출력하고
                //num-i의 차이가 최대여야 하므로 break
                if (primeNumber[i] && primeNumber[num - i]) {
                    result[0] = num - i;
                    result[1] = i;
                    bw.write(num + " = " + result[0] + " + " + result[1] + "\n");
                    break;
                }
            }
			//result의 원소가 0일때는 문제에 해당하는 경우가 없다는 뜻
            if (result[0] == 0)
                bw.write("Goldbach's conjecture is wrong." + "\n");

            num = Integer.parseInt(br.readLine());
        }
        bw.close();
    }
    
    //매개변수로 주어진 배열에서 소수인 원소를 체크하여 반환하는 메소드
    static boolean[] findPrimeNumber(boolean[] arr) {

        int cnt;
        for (int i = 2; i < arr.length; i++) {
            cnt = 0;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    cnt++;
                    break;
                }                               
            }
            if (cnt == 0) {
                arr[i] = true;
            }
        }
        return arr;               
    }
}