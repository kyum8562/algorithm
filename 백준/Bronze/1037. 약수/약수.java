import java.io.*;
import java.util.*;
 
public class Main {
 
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
        
		while(T-- > 0) {
			int N = Integer.parseInt(st.nextToken());
			max = N > max ? N : max;
			min = N < min ? N : min;
		}
		System.out.println(max * min);
	}
 
}