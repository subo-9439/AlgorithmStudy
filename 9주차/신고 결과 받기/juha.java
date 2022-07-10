import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        HashMap<String,Integer> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        for(String rep : report){
            if(set.add(rep)){
                String[] temp = rep.split(" ");
                map.put(temp[1], map.getOrDefault(temp[1],0)+1);
            }
        }
        set = new HashSet<>();
        int[] result = new int[id_list.length];
        for(String rep : report){
            String[] temp = rep.split(" ");
            if(map.get(temp[1]) >= k && set.add(rep)){
                for(int j = 0; j < id_list.length; j++){
                    if(id_list[j].equals(temp[0])){
                        result[j]++;
                        break;
                    }
                }
            }
        }
        return result;
    }
}