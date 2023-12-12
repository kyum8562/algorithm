import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for(int i = 0 ; i < N ; i ++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N ; j ++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        for(int i = 0 ; i < N ; i ++){
            boolean flag = true;
            boolean[] isSet = new boolean[N];
            outer: for(int j = 0 ; j < N-1 ; j ++){
                if(map[i][j] < map[i][j+1]){ // 작 -> 큰
                    if(map[i][j+1] - map[i][j] >= 2){
                        flag = false;
                        break outer;
                    }
                    int k = j;
                    int cnt = 1;
                    if(K > 1) {
                        while (k-- > 0) {
                            if (map[i][j] == map[i][k]) cnt++;
                            else break;
                            if (cnt == K) {
                                for (int l = k; l < k + K; l++) {
                                    if (isSet[l]) {
                                        flag = false;
                                        break outer;
                                    }
                                    isSet[l] = true;
                                }
                                break;
                            }
                        }
                    }
                    if(K == 1 && cnt == 1){
                        if (isSet[k]) {
                            flag = false;
                            break outer;
                        }
                        isSet[k] = true;
                    }

                    if(cnt != K){
                        flag = false;
                        break;
                    }
                }
                else if(map[i][j] > map[i][j+1]) { // 큰 -> 작
                    if(map[i][j] - map[i][j+1] >= 2){
                        flag = false;
                        break outer;
                    }
                    int k = j+1;
                    int cnt = 1;
                    if(K > 1) {
                        while (k++ < N - 1) {
                            if (map[i][k - 1] == map[i][k]) cnt++;
                            else break;
                            if (cnt == K) {
                                for (int l = k; l > k - K; l--) {
                                    if (isSet[l]) {
                                        flag = false;
                                        break outer;
                                    }
                                    isSet[l] = true;
                                }
                                break;
                            }
                        }
                    }
                    if(K == 1 && cnt == 1){
                        if (isSet[k]) {
                            flag = false;
                            break outer;
                        }
                        isSet[k] = true;
                    }
                    if(cnt != K){
                        flag = false;
                        break;
                    }
                }
            }
            if(flag) ans++;
        }
        for(int j = 0 ; j < N ; j ++){
            boolean flag = true;
            boolean[] isSet = new boolean[N];
            outer: for(int i = 0 ; i < N-1 ; i ++){
                if(map[i][j] < map[i+1][j]){ // 작 -> 큰
                    if(map[i+1][j] - map[i][j] >= 2){
                        flag = false;
                        break outer;
                    }
                    int k = i;
                    int cnt = 1;
                    if(K > 1) {
                        while (k-- > 0) {
                            if (map[i][j] == map[k][j]) cnt++;
                            else break;
                            if (cnt == K) {
                                for (int l = k; l < k + K; l++) {
                                    if (isSet[l]) {
                                        flag = false;
                                        break outer;
                                    }
                                    isSet[l] = true;
                                }
                                break;
                            }
                        }
                    }
                    if(K == 1 && cnt == 1){
                        if (isSet[k]) {
                            flag = false;
                            break outer;
                        }
                        isSet[k] = true;
                    }
                    if(cnt != K){
                        flag = false;
                        break;
                    }
                }
                else if(map[i][j] > map[i+1][j]) { // 큰 -> 작
                    if(map[i][j] - map[i+1][j] >= 2){
                        flag = false;
                        break outer;
                    }
                    int k = i+1;
                    int cnt = 1;
                    if(K > 1) {
                        while (k++ < N - 1) {
                            if (map[k - 1][j] == map[k][j]) cnt++;
                            else break;
                            if (cnt == K) {
                                for (int l = k; l > k - K; l--) {
                                    if (isSet[l]) {
                                        flag = false;
                                        break outer;
                                    }
                                    isSet[l] = true;
                                }
                                break;
                            }
                        }
                    }
                    if(K == 1 && cnt == 1){
                        if (isSet[k]) {
                            flag = false;
                            break outer;
                        }
                        isSet[k] = true;
                    }
                    if(cnt != K){
                        flag = false;
                        break;
                    }
                }
            }
            if(flag) ans++;
        }
        System.out.println(ans);
    }
}