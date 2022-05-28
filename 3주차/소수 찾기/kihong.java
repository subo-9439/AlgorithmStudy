import java.util.*;

class Solution {
    /*
    1. String타입의 수를 받아와 만들 수 있는 모든 수를 만들어 줍니다.(중복허용)
    2. 전역 변수에 Set<Integer>타입의 Hashset에 누적시킵니다 (중복제거 및 011->11로 변환)
    3. set에 담겨진 수를 소수인지 체크 후 맞다면 answer의 값을 증가
     */
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
    /*
    정수를 만들고 set에 누적시킵니다.
    1. 종료조건 :  num의 길이가 1일 때 반환
    2. head와 tail로 나누어서 진행
    3. head : for문 안에서 num.charAt(i)
    4. tail : 재귀 num.charAt(i)를 제외한 다른 인덱스의 글자를 합쳐서 매개변수로 제공
    5. tail을 가져와서 다시 head에 하나씩 붙여준 후 set에 넣어줌
     */
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
    /*
    소수를 판단합니다.
    1. 매개변수로 받아온 수를 사용
    2. 0or1은 소수가 아니니 바로 제외해줍니다.
    3. 그 수의 제곱근까지 나눠지는 수가 없을 시 소수로 판단합니다.
     */
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