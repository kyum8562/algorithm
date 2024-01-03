import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[9];
		int tmp = 0;
		for(int i = 0; i < arr.length ; i ++) {
			arr[i] = Integer.parseInt(br.readLine());
			tmp += arr[i];
		}
		
		outer : for(int i = 0 ; i < arr.length-1; i ++) {
			for(int j = i+1 ; j < arr.length ; j ++) {
				if((arr[i] + arr[j]) == (tmp - 100)) {
					arr[i] *= 0;
					arr[j] *= 0;
					break outer;
				}
			}
		}
		Arrays.sort(arr);
		for(int k = 2; k < arr.length; k++) {
				System.out.println(arr[k]);
		}
		br.close();
		return;
	}
}