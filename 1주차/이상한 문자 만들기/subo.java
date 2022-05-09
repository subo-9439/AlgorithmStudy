import java.util.StringTokenizer;

public class subo {
    class Solution {
        public String solution(String s) {
            String answer = "";
            char[] c = new char[s.length()];
            for(int i = 0; i <s.length(); i++){
                c[i] = s.charAt(i);
            }
            int idx = 0;
            for(char ch: c){
                //짝수 대문자
                if(ch == ' ') {
                    idx = 0;
                    answer+= Character.toString(ch);
                    continue;
                }
                if(idx %2 == 0) {
                    if (ch >= 97) {
                        answer += Character.toString(ch - 32);
                    } else {
                        answer += Character.toString(ch);
                    }
                }else {
                    if(ch < 97){
                        answer += Character.toString(ch+32);
                    }else {
                        answer += Character.toString(ch);
                    }
                }
                idx++;
            }
            return answer;
        }
    }
}

