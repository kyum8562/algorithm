import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	/**
	 * 01258 -> 01258
	 * 69 -> 96
	 * 347 -> XXXXXX
	 */
	static long n;
	public static void main(String[] args) throws IOException {
		// 원래 수가 소수 && 뒤집혀도 소수 ? yes : no
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        n = Long.parseLong(N);
        
        // 원래 수에서 회전이 가능한 수인지 판별
    	if(!isChecked(N)) {
    		System.out.println("no");
        	return;
    	}
        
        // 원래 수가 소수 판별 && 뒤집혀도 소수 판별
        if(!isPrime(n) || !isPrime(reverse(N))) {
        	System.out.println("no");
        	return;
        }
        
        System.out.println("yes");
        
	}

	public static boolean isChecked(String n) {
		String tmp = "347";
		for(int i = 0 ; i < tmp.length() ; i ++){
			if(n.contains(tmp.charAt(i)+""))
				return false;
		}
		return true;
	}

	public static long reverse(String N) {
		long tmp = 0;
		long reverseN = n;
		while(reverseN > 0) {
			if(reverseN % 10 == 6)
				tmp = tmp*10 + 9;
			else if(reverseN % 10 == 9)
				tmp = tmp*10 + 6;
			else
				tmp = tmp*10 + reverseN%10;
			reverseN /= 10;
		}
		return tmp;
	}

	public static boolean isPrime(long n) {
		if(n == 1)
			return false;
		
		for(long i = 2 ; i*i <= n ; i ++) 
			if(n % i == 0) return false;
	
		return true;
	}
	
}