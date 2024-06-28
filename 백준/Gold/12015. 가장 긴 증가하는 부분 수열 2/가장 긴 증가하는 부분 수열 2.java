import java.io.*;
import java.util.*;

/**
 * LIS(최장 증가 부분 수열) - [이분탐색]
 * 해당 문제는 기본 LIS만 사용해서 풀 경우, 입력값이 10000 이상의 큰 값이기 때문에
 * 공간/시간 복잡도가 터지는 문제이다. 따라서 O(N*N)이 아닌
 * 이분탐색을 이용해서 O(N*logN) 시간 복잡도를 줄여서 푼다.
 * ex)
 * 2322 - 반도체 설계
 * 13711 - LCS4
 */
public class Main {
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        list.add(0);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i ++){
            arr[i] = Integer.parseInt(st.nextToken());
            binarySearch(arr[i]);
        }

        System.out.println(list.size()-1);
    }
    private static void binarySearch(int target){
        if(target > list.get(list.size()-1)) list.add(target);
        else{
            int left = 0;
            int right = list.size()-1;

            while(left < right){
                int mid = (left + right) / 2;

                if(list.get(mid) < target) left = mid + 1;
                else right = mid;
            }
            list.set(right, target);
        }
    }
}