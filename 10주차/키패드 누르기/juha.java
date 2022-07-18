class Solution {
    public String solution(int[] numbers, String hand) {
        int left = 10;
        int right = 12;
        String result = "";
        for(int number : numbers){
            if(number == 0)
                number = 11;
            if(number%3 == 0){  // right
                right = number;
                result += "R";
            }else if(number%3 == 1){    // left
                left = number;
                result += "L";
            }else{  // middle
                int leftDist = Math.abs(number - left)/3 + Math.abs(number - left)%3;
                int rightDist = Math.abs(number - right)/3 + Math.abs(number - right)%3;
                if(leftDist < rightDist){
                    left = number;
                    result += "L";
                }else if(leftDist > rightDist){
                    right = number;
                    result += "R";
                }else{  // leftDist == rightDist
                    if(hand.equals("left")){
                        left = number;
                        result += "L";
                    }else{
                        right = number;
                        result += "R";
                    }
                }
            }
        }
        return result;
    }
}