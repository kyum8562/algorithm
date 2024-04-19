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

            String res = String.valueOf(Integer.parseInt(cur) + Integer.parseInt(cur2));

            int l = 0;
            int r = res.length()-1;
            boolean flag = true;

            while(r > l){
                if(res.charAt(l++) != res.charAt(r--)){
                    flag = false;
                    break;
                }
            }

            sb.append(flag ? "YES" : "NO").append("\n");
        }

        System.out.print(sb);
    }
}