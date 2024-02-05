import java.io.*;
import java.util.*;

public class Main {
    static int N, C, start, end;
    static int[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[N];
        for (int i = 0; i < N; i++) map[i] = Integer.parseInt(br.readLine());

        Arrays.sort(map);

        start = 1;   // 최소 거리가 가질 수 있는 최솟값
        end = map[N-1] - map[0] + 1; // 최대 거리가 가질 수 있는 최댓값

        while (start < end) {
            int mid = (end + start) / 2;

            // 설치 가능한 공유기 수가 C보다 작다면, 거리를 좁혀야 하기 때문에 end를 줄임
            if(canInstall(mid) < C) end = mid;
            // 크거나 같은 경우, 거리를 넓히면서 최소거리가 가질 수 있는 최대거리를 찾아낸다.
            else start = mid + 1;
        }

        System.out.println(start - 1);
    }

    private static int canInstall(int dist) {
        // 첫 번째 집은 무조건 설치한다고 가정
        int lastLocate = map[0];
        int cnt = 1;

        for(int i = 1 ; i < N ; i ++){
            int locate = map[i];

            /*
            * 현재 탐색하는 집의 위치와 직전에 설치했던 집의 위치간 거리가
            *  최소 거리(dist)보다 크거나 같을 때 공유기 설치 개수를 늘려주고
            * 마지막 설치 위치를 갱신해준다.
            * */
            if(locate - lastLocate >= dist){
                cnt++;
                lastLocate = locate;
            }
        }
        return cnt;
    }

}