class Solution {
    public String solution(String s) {
        String answer = "";

        //문자열 s를 배열로 각 문자별로 배열설정
        String[] arr = s.split("");     //{"t","r","y",,,,,"d"}

        // 짝수판별을 위해 count 선언
        int count = 0;

        for(int i = 0; i<arr.length; i++) {
            if(arr[i].equals(" ")) count = 0; //arr[i]가 공백이면 count=0으로 초기화
            else if(count%2==0) {
                arr[i] = arr[i].toUpperCase(); //count가 짝수이면 대문자로
                count++;
            }
            else if(count%2!=0) {
                arr[i] = arr[i].toLowerCase(); //count가 홀수이면 소문자로
                count++;
            }

            answer = answer+arr[i]; // for문이 끝나기 전 answer에 각 문자열 추가
        }
        return answer;
    }
}