import java.util.Arrays;
import java.util.Scanner;

class dokyung {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String N = sc.next();
        char[] chars = N.toCharArray();
        int[] numSet = new int[10];
        for(char c : chars) {
            int num = c - '0';
            if(num==9) {
                num = 6;
            }
            numSet[num]++;
        }

        // 6과 9는 바꿀 수 있으므로 2로 나눔
        numSet[6] = numSet[6]/2 + numSet[6]%2;

        Arrays.sort(numSet);
        // 오름차순 정렬이므로 마지막 요소 출력
        System.out.println(numSet[9]);

    }
}












