import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        //1. N 입력받기
        String input = sc.nextLine().trim();
        int N = input.length();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = input.charAt(i) - '0';
        }

        //2. N을 절반으로 자르기
        int mid = N / 2;
        int[] first = Arrays.copyOfRange(arr, 0, mid);
        int[] end = Arrays.copyOfRange(arr, mid, arr.length);

        //3. 각 합 구하기
        int firstSum = Arrays.stream(first).sum();
        int endSum = Arrays.stream(end).sum();


        //4. 두 합 비교하기
        //  - 만약, 두 합이 일치한다면 LUCKY 출력
        //  - 두 합이 일치하지 않는다면 READY 출력
        if(firstSum == endSum){
            System.out.println("LUCKY");
        } else {
            System.out.println("READY");
        }
    }
}