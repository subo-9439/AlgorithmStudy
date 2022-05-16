class Solution {
    public String solution(String s) {
        String answer = "";
        int i = 0;
        int index = 0;
        
        while (index != s.length()){
            if (s.charAt(index) == ' ') {
                // 공백일 때는 i 초기화 & 공백 추가
                i = 0;
                answer += ' ';
                }
            else{
                // 공백이 아닌 경우 짝홀 판별 & 변환 및 추가
                if (i % 2 == 0){
                    answer += String.valueOf(s.charAt(index)).toUpperCase(); 
                }
                else answer += String.valueOf(s.charAt(index)).toLowerCase();
                i += 1;
            }
            index += 1;}
        
        return answer;
    }
}