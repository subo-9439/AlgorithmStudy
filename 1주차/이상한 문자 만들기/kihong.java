class Solution {
    public String solution(String s) {

        String answer = "";
        int chk =0;
        String temp ="";
        for(char a : s.toCharArray()){
            //공백이 나올 시 순서 다시 시작.
            if(a==' '){
                answer+=a;
                chk=0;
                continue;
            }
            /*공백으로 나눠진 하나의 문자열에서 짝수 인덱스 일 시
              1. temp에 넣어서 String 타입으로 바꾸어 줌
              2. 대문자로 변경
              3. 리턴 할 answer에 추가
            */
            if(chk==0){
                temp+=a;
                temp=temp.toUpperCase();
                answer+=temp;
                temp="";
                chk=1;
                continue;
            }
            /*공백으로 나눠진 하나의 문자열에서 홀수 인덱스 일 시
              1. temp에 넣어서 String 타입으로 바꾸어 줌
              2. 대문자로 변경
              3. 리턴 할 answer에 추가
            */
            if(chk==1){
                temp+=a;
                temp=temp.toLowerCase();
                answer+=temp;
                temp="";
                chk=0;
                continue;
            }

        }
        return answer;
    }
}
