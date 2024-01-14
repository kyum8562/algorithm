import java.io.*;
import java.util.*;
public class Main {
    static StringBuilder sb = new StringBuilder();
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while(T -- > 0){
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();

            if(s.equals("push")){
                int N = Integer.parseInt(st.nextToken());
                list.add(N);
                continue;
            }
            else if(s.equals("pop")){
                if(list.size() >= 1){
                    int a = list.remove(0);
                    sb.append(a);
                }
                else sb.append(-1);
            }
            else if(s.equals("size"))
                sb.append(list.size());
            else if(s.equals("empty")){
                if(list.size() == 0) sb.append(1);
                else sb.append(0);
            }
            else if(s.equals("front")){
                if(list.size() == 0) sb.append(-1);
                else sb.append(list.get(0));
            }
            else if(s.equals("back")) {
                if(list.size() == 0) sb.append(-1);
                else sb.append(list.get(list.size()-1));
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}