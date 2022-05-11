import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String words = sc.nextLine();

        int ans = 0;
        for (int i = 0; i < words.length(); i++){
            switch (words.charAt(i)){
                case 'P': case 'Q': case 'R': case 'S':
                    ans += 8;
                    break;
                case 'T': case 'U': case 'V':
                    ans += 9;
                    break;
                case 'W': case 'X': case 'Y': case 'Z':
                    ans += 10;
                    break;
                default:
                    ans += ((words.charAt(i) - 'A')/3 + 3);
            }
        }
        System.out.println(ans);
    }
}
