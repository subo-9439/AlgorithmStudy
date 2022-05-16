import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int min_time = 0;

        for(char c: str.toCharArray()){
            switch (c){
                case 'A':
                case 'B':
                case 'C':
                    min_time += 3;
                    break;
                case 'D':
                case 'E':
                case 'F':
                    min_time += 4;
                    break;
                case 'G':
                case 'H':
                case 'I':
                    min_time += 5;
                    break;
                case 'J':
                case 'K':
                case 'L':
                    min_time += 6;
                    break;
                case 'M':
                case 'N':
                case 'O':
                    min_time += 7;
                    break;
                case 'P':
                case 'Q':
                case 'R':
                case 'S':
                    min_time += 8;
                    break;
                case 'T':
                case 'U':
                case 'V':
                    min_time += 9;
                    break;
                case 'W':
                case 'X':
                case 'Y':
                case 'Z':
                    min_time += 10;
            }
        }

        System.out.println(min_time);
    }
}
