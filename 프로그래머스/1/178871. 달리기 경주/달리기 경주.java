import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> map = new LinkedHashMap<>();
        
        for(int j = 0 ; j < players.length ; j ++){
            map.put(players[j], j);   
        }
        
        for(int i = 0 ; i < callings.length ; i ++){
            String call = callings[i];
            
            int idx = map.get(call);
            
            String tmp = players[idx-1];
            players[idx-1] = players[idx];
            players[idx] = tmp;
            
            map.put(call, idx-1);
            map.put(players[idx], idx);
        }
        
        return players;
    }
}