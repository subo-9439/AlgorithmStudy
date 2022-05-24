import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String roomnum = sc.next();

        roomNumber room = new roomNumber();
        System.out.println(room.countSet(roomnum));

    }

}

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