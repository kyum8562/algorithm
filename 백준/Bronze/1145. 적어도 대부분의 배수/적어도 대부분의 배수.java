import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] arr = new int[5];
		int tgt = 1;
		int cnt = 0;
		
		for(int i = 0 ; i < arr.length; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		while(true) {
			for(int i = 0 ; i < arr.length; i++) {
				if(tgt >= arr[i] && tgt%arr[i] == 0) cnt++;
			}
			if(cnt >=3) break;
			cnt = 0;
			tgt++;
		}
		System.out.println(tgt);
	}

}