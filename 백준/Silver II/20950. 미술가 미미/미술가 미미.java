import java.io.*;
import java.util.*;

// 순열
public class Main {
    static int N, newN, R, G, B, ans;
    static Node[] map;
    static boolean[] v;
    public static void main(String[] args) throws  IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        v = new boolean[N];
        map = new Node[N];
        ans = Integer.MAX_VALUE;
        newN = N > 7 ? 7 : N;

        for(int i = 0 ; i < N ; i ++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map[i] = new Node(r, g, b);
        }

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        for(int i = 2 ; i <= newN ; i ++){
            perm(0, 0, i);
        }
        System.out.println(ans);
    }

    private static void perm(int depth, int start, int height) {
        if(depth == height){
            int rSum = 0, gSum = 0, bSum = 0;

            for(int i = 0 ; i < N ; i ++){
                if(v[i]){
                    rSum += map[i].r;
                    gSum += map[i].g;
                    bSum += map[i].b;
                }
            }

            rSum /= height;
            gSum /= height;
            bSum /= height;

            int res = Math.abs(R-rSum) + Math.abs(G-gSum) + Math.abs(B-bSum);
            if(ans > res) ans = res;
            return;
        }
        for(int i = start ; i < N ; i ++){
            v[i] = true;
            perm(depth+1, i+1, height);
            v[i] = false;
        }
    }
    static class Node{
        int r, g, b;
        public Node(int r, int g, int b){
            this.r = r;
            this.g = g;
            this.b = b;
        }
    }
}