import java.util.Scanner;

public class Nick {
/*
* 문제
다솜이는 은진이의 옆집에 새로 이사왔다. 다솜이는 자기 방 번호를 예쁜 플라스틱 숫자로 문에 붙이려고 한다.

다솜이의 옆집에서는 플라스틱 숫자를 한 세트로 판다. 한 세트에는 0번부터 9번까지 숫자가 하나씩 들어있다. 다솜이의 방 번호가 주어졌을 때, 필요한 세트의 개수의 최솟값을 출력하시오. (6은 9를 뒤집어서 이용할 수 있고, 9는 6을 뒤집어서 이용할 수 있다.)

입력
첫째 줄에 다솜이의 방 번호 N이 주어진다. N은 1,000,000보다 작거나 같은 자연수이다.
* */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        scanner.close();
        int length = String.valueOf(input).length();
        int n = length;

        int[] set = new int[10];
        int count = 0;

        int number;
        for (int i = n; i > 0; i--) {
            number = getNthNumber(input, i);

            if (number == 6 || number == 9) {
                int other = number == 6 ? 9 : 6;

                if (isExhausted(set, number)) {
                    if (isExhausted(set, other)) {
                        addSet(set);
                        count++;
                    }
                    set[other]--;
                } else {
                    set[number]--;
                }
            } else {
                if (isExhausted(set, number)) {
                    addSet(set);
                    count++;
                }
                set[number]--;
            }
        }

        System.out.println(count);
    }

    private static boolean isExhausted(int[] set, int number) {
        if (set[number] == 0) return true;
        return false;
    }

    private static int getNthNumber(int input, int n) {
        return (input / pow10byN(n - 1)) % 10;
    }

    private static int pow10byN(int n) {
        if (n == 0) {
            return 1;
        }

        int result = 10;
        for (int i = 1; i < n; i++) {
            result *= 10;
        }

        return result;
    }

    public static void addSet(int[] set) {
        for (int i = 0; i < 10; i++) {
            set[i] += 1;
        }
    }

}
