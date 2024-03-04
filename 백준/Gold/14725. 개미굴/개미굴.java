import java.io.*;
import java.util.*;

class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        TrieNode root = new TrieNode();

        for(int i = 0 ; i < N ; i ++){
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            TrieNode cur = root;
            for(int j = 0 ; j < M ; j ++){
                String s = st.nextToken();

                if(!cur.childNode.containsKey(s))
                    cur.childNode.put(s, new TrieNode());

                cur = cur.childNode.get(s);
            }
        }
        print(root, "");
        System.out.print(sb);
    }
    static class TrieNode{
        Map<String, TrieNode> childNode = new LinkedHashMap<>();
    }
    private static void print(TrieNode root, String s) {
        Object[] key = root.childNode.keySet().toArray();
        Arrays.sort(key);

        for(Object cur: key){
            sb.append(s).append(cur).append("\n");
            print(root.childNode.get(cur), s+"--");
        }
    }
}