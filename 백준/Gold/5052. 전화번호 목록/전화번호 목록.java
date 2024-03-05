import java.io.*;
import java.util.*;

class Main {
    static TrieNode root;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int t = 1 ; t <= T ; t ++){
            int N = Integer.parseInt(br.readLine());
            boolean flag = true;

            root = new TrieNode();

            for(int i = 0 ; i < N ; i ++){
                // 삽입과 접두어 판단여부
                if(!insert(br.readLine())){
                    flag = false;
                }
            }
            sb.append(flag ? "YES" : "NO").append("\n");
        }
        System.out.print(sb);
    }

    private static boolean insert(String str) {
        TrieNode cur = root;
        int len = str.length();

        for(int i = 0 ; i < len ; i ++){
            char c = str.charAt(i);

            if(cur.children.get(c) == null)
                cur.children.put(c, new TrieNode());

            cur = cur.children.get(c);

            if(cur.isLeaf) return false;
        }

        if(cur.children.size() != 0) return false;

        cur.isLeaf = true;
        return true;
    }

    static class TrieNode{
        Map<Character, TrieNode> children = new LinkedHashMap<>();
        boolean isLeaf;
    }
}