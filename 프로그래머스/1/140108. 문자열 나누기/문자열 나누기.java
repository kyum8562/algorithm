class Solution {
    public int solution(String s) {
        int ans = 0;
        
        int aCnt = 0;
        int bCnt = 0;
        char tgt = '-';
        int len = s.length();
        int idx = 0;
        while(idx != len){
            char cur = s.charAt(idx);
            
            // 메인 값이 없을 때
            if(tgt == '-'){
                tgt = cur;
                aCnt ++;

            }
            // 메인 값이 있을 때
            else{
                if(cur == tgt) aCnt ++;
                else bCnt ++;
                
                // 메인 값의 수와 서브 값의 수가 같을 때
                if(aCnt == bCnt){
                    tgt = '-';
                    aCnt = 0;
                    bCnt = 0;
                    ans ++;
                }
            }
            
            idx ++;
        }
        
        if(aCnt > 0) ans ++;
        
        return ans;
    }
}