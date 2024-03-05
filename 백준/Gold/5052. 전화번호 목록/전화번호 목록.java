import java.io.*;
import java.util.*;

class Main {
    static TrieNode root;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            root = new TrieNode();
            int N = Integer.parseInt(br.readLine());
            String[] strs = new String[N];
            boolean flag = true;

            for(int i = 0 ; i < N ; i ++){
                strs[i] = br.readLine();
                if(!insert(strs[i]))
                    flag = false;
            }

            sb.append(flag ? "YES" : "NO").append("\n");
        }
        System.out.print(sb);
    }

    private static boolean insert(String str) {
        TrieNode cur = root;
        int len = str.length();

        for(int j = 0 ; j < len ; j ++){
            char c = str.charAt(j);
            if(cur.childNode.get(c) == null)
                cur.childNode.put(c, new TrieNode());

            cur = cur.childNode.get(str.charAt(j));

            if(cur.isLeaf) return false;
        }

        if(cur.childNode.size() != 0) return false;

        cur.isLeaf = true;
        return true;
    }

    static class TrieNode{
        boolean isLeaf;
        Map<Character, TrieNode> childNode = new LinkedHashMap<>();
    }
}