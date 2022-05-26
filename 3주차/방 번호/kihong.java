import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String roomnum = sc.next();

        roomNumber room = new roomNumber();
        System.out.println(room.countSet(roomnum));

    }

}
/*
방번호를 만드는 클래스
1. 사용한 세트수를 확인하기 위해서 Map을 생성 후 key:0~9,value: 세트수 로 사용합니다.
2. 받아온 매개변수를 하나씩 쪼개서 판단합니다.
3. 6 또는 9일 시 바꿔서 사용이 가능하니 적은 곳을 판단 후 value의 값을 증가시킵니다.
4. 나머지 수도 판단 후 value의 값을 증가 시킵니다.
5. 해당 수의 value의 값이 max(최대값)보다 크다면 max를 value값으로 변경해줍니다.
 */
class roomNumber{
    public int countSet(String rnumber){
        HashMap<Integer,Integer> setnum = new HashMap<>();
        for(int i =0; i<10; i++){
            setnum.put(i,0);
        }
        int max = 0;
        int num = 0;
        for(int i = 0; i<rnumber.length(); i++){

            num = rnumber.charAt(i)-'0';
            if(num==6||num==9) {
                num = (setnum.get(6) > setnum.get(9)) ? 9:6;
            }
            setnum.put(num,setnum.get(num)+1);
            if(setnum.get(num)>max) max=setnum.get(num);
        }
        return max;
    }

}