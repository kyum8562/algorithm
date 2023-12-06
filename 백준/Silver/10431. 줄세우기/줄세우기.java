import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while(T -- > 0) {
			int ans = 0;
			int[] map = new int[20];
			StringTokenizer st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken());
			for(int i = 0 ; i < 20 ; i ++)
				map[i] = Integer.parseInt(st.nextToken());
			for(int i = 1 ; i < 20 ; i ++) {
				for(int j = i-1 ; j >= 0 ; j --) {
					if(map[j] > map[i]) ans++;
				}
			}
			System.out.println(idx + " " + ans);
		}
	}
}