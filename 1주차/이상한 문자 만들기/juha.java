class Solution {
    public String solution(String s) {
        String answer = "";
        int num = 0;
        for(char c: s.toCharArray()){
            if(c == ' '){
                num = 0;
                answer += " ";
                continue;
            }
            if(num%2==0)
                answer += Character.toUpperCase(c);
            else
                answer += Character.toLowerCase(c);
            num++;
        }
        return answer;
    }
}