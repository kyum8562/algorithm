import java.io.*;
import java.util.*;

public class Main {
    static int R, C;
    static char[][] map;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        for(int i = 0 ; i < R ; i ++){
            map[i] = br.readLine().toCharArray();
        }

        binarySearch();
    }

    private static void binarySearch() {
        int s = 0;
        int e = R-1;
        int m;

        while(e >= s){
            m = (s + e) / 2;

            boolean isValid = true;

            Map<String, Integer> check = new LinkedHashMap<>();
            for(int j = 0 ; j < C ; j ++){
                String tmp = "";
                for(int i = m ; i < R ; i ++)
                    tmp += map[i][j];

                // 없을 경우
                if(check.getOrDefault(tmp, 0) == 0){
                    check.put(tmp, 1);
                }
                else{
                    isValid = false;
                    break;
                }
            }

            // 있을 경우
            if(isValid){
                s = m + 1;
            }

            // 없을 경우
            else{
                e = m - 1;
            }
        }

        System.out.println(s-1);
    }
}