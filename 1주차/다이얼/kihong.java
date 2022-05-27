import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int sec = 0;
        // 그냥 다 조건 처리!
        for(char c : str.toCharArray()){
            if(c=='A'||c=='B'||c=='C') sec+=3;
            if(c=='D'||c=='E'||c=='F') sec+=4;
            if(c=='G'||c=='H'||c=='I') sec+=5;
            if(c=='J'||c=='K'||c=='L') sec+=6;
            if(c=='M'||c=='N'||c=='O') sec+=7;
            if(c=='S'||c=='P'||c=='Q'||c=='R') sec+=8;
            if(c=='V'||c=='T'||c=='U') sec+=9;
            if(c=='W'||c=='X'||c=='Y'||c=='Z') sec+=10;
        }
        System.out.println(sec);
    }
}
