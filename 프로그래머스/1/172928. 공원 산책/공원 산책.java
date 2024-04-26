import java.util.*;

class Solution {
    static int N, M, r, c;
    static char[][] arr;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    public int[] solution(String[] park, String[] routes) {
        StringTokenizer st;
        
        N = park.length;
        M = park[0].length();
        int queryLen = routes.length;
        
        arr = new char[N][M];
        
        for(int i = 0 ; i < N ; i ++){
            String s = park[i];
            for(int j = 0 ; j < M ; j ++){
                char cur = s.charAt(j);
                if(cur == 'S'){
                    r = i;
                    c = j;
                }
                
                arr[i][j] = cur;
            }
        }
        
        for(int i = 0 ; i < queryLen ; i ++){
            st = new StringTokenizer(routes[i]);
            
            String s = st.nextToken();
            int d = direction(s);
            int n = Integer.parseInt(st.nextToken());
            
            // 움직임
            int nr = r;
            int nc = c;
            boolean flag = true;
            
            for(int j = 0 ; j < n ; j ++){
                nr += dr[d];
                nc += dc[d];
                
                if(!isValid(nr, nc) || arr[nr][nc] == 'X'){
                    flag = false;
                    break;
                }
            }
            
            if(!flag) continue;
            
            r = nr;
            c = nc;
        }
        
        return new int[]{r, c};
    }
    static int direction(String s){
        if(s.equals("N")) return 0;
        else if(s.equals("E")) return 1;
        else if(s.equals("S")) return 2;
        else return 3;
    }
    static boolean isValid(int nr, int nc){
        return (nr>=0 && nr<N && nc>=0 && nc<M);
    }
}