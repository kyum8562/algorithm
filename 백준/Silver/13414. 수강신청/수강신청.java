import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new LinkedHashMap<>();
        String[] arr = new String[L];

        for(int i = 0 ; i < L ; i ++){
            arr[i] = br.readLine();
            map.put(arr[i], i);
        }

        int cnt = 0;
        for(int i = 0 ; i < L ; i ++){
            // 출력할 개수를 모두 출력했다면 break
            if(cnt == K) break;

            // map에 저장한 값과 인덱스의 값이 동일하다면
            if(i == map.get(arr[i])){
                // 출력
                sb.append(arr[i]).append("\n");
                // 출력개수 ++
                cnt ++;
            }
        }
        System.out.println(sb);
    }
}
//