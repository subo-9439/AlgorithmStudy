import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num = sc.nextLine();

        List<Integer> nums = Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        for (int i = 0; i < num.length(); i ++){
            nums.set(num.charAt(i) - '0', nums.get(num.charAt(i) - '0') + 1);
        }

        // 6과 9는 따로 처리 (대체가 가능하므로 두개 개수 합 / 2)
        int avr = (nums.get(6) + nums.get(9)) / 2;
        // 나머지는 9에 더해줌
        int last = (nums.get(6) + nums.get(9)) % 2;
        nums.set(6, avr);
        nums.set(9, avr + last);

        System.out.println(nums.stream().mapToInt(i -> i).max().getAsInt());
    }
}
