import java.util.*;

class Solution {
    Set<Integer> set = new HashSet<>();
    public int solution(String numbers) {
        int answer = 0;
        makeNum(numbers);
        for(int i : set){
            if(chkSosu(i)){
                answer++;
            }
        }
        return answer;
    }
    public ArrayList<String> makeNum(String num){
        ArrayList<String> result = new ArrayList<>();
        if(num.length()==1){
            result.add(num);
            set.add(Integer.parseInt(num));
            return result;
        }
        for(int i= 0; i<num.length(); i++){
            ArrayList<String> tail = makeNum(num.substring(0,i)+num.substring(i+1,num.length()));
            for(int j =0; j<tail.size(); j++){
                result.add(num.charAt(i)+tail.get(j));
                set.add(Integer.parseInt(num.charAt(i)+tail.get(j)));
            }
        }
        return result;
    }
    public boolean chkSosu(int num){
        if(num==0||num==1) return false;
        int cnt =0;
        for(int i = 2; i*i<=num; i++){
            if(num%i==0) cnt++;
        }
        if(cnt==0) return true;
        return false;
    }

}