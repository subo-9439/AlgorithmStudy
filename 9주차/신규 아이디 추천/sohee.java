class Solution {
    public String solution(String new_id) {
        String answer = "";
        char s;
        int i;
        
        //Stage1
        new_id = new_id.toLowerCase();
        
        //Stage2
        for (i = 0; i < new_id.length(); i++){
            s = new_id.charAt(i);
            if (((97 <= s) && (s <= 122)) || ((48 <= s) && (s <= 57)) || (s==95) || (s==45) || (s==46)){
                answer += s;
            }
        }
        new_id = answer;
        answer = "";
        
        //Stage3 & 4;
        int count = 0;
        for (i = 0; i < new_id.length(); i++){
            s = new_id.charAt(i);
            if (s==46){
                if ((count == 0) && (i!=0)) {
                    answer += s;
                }
                count += 1;
            }
            else{
                answer += s;
                count = 0;
            }
        }
        
        if ((answer.length() > 0) && (answer.charAt(answer.length()-1) == 46)){
            answer = answer.substring(0, answer.length()-1);
        }
        
        //Stage 5
        if (answer == ""){
            answer += "a";
        }
        //Stage 6
        if (answer.length() >= 16){
            answer = answer.substring(0, 15); 
            if (answer.charAt(14) == 46){
                answer = answer.substring(0, 14);
            }
        }
        
        //Stage 7
        if (answer.length() <= 2){
            s = answer.charAt(answer.length()-1);
            while (answer.length() != 3){
                answer += s;
            }
        }
        
        return answer;
    }
}