import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < N ; i ++){
            String cur = br.readLine();
            String cur2 = "";

            for(int j = cur.length()-1 ; j >= 0 ; j --)
                cur2 += cur.charAt(j);

            int res = Integer.parseInt(cur) + Integer.parseInt(cur2);
            String res2 = String.valueOf(res);

            int l = 0;
            int r = res2.length()-1;
            boolean flag = true;
            while(r > l){
                if(res2.charAt(l++) != res2.charAt(r--)){
                    flag = false;
                    break;
                }
            }

            sb.append(flag ? "YES" : "NO").append("\n");
        }

        System.out.println(sb);
    }
}