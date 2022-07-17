class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int left=10; // *
        int right=12; // #
        for(int num : numbers){
            if(num == 1 || num == 4 || num == 7){
                answer += "L";
                left = num;
            }else if(num == 3 || num == 6 || num == 9){
                answer += "R";
                right = num;
            }else{
                if(num == 0){
                    num += 11; // 0
                }
                //거리 구하기
                int leftLen = (Math.abs(num-left))/3 + (Math.abs(num-left))%3;
                int rightLen = (Math.abs(num-right))/3 + (Math.abs(num-right))%3;

                if(leftLen > rightLen){//오른쪽이 짧으면
                    answer += "R";
                    right = num;
                }else if(leftLen < rightLen){//왼쪽이 짧으면
                    answer += "L";
                    left = num;
                }else {
                    if(hand.equals("left")){
                        answer += "L";
                        left = num;
                    }else{
                        answer += "R";
                        right = num;
                    }
                }
            }
        }

        return answer;
    }
}