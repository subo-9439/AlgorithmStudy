import java.util.*;

public class Nick {

    public static void main(String[] args) {

        Week3_1 w = new Week3_1();
        System.out.println(w.solution("0003"));

    }

    public int solution(String numbers) {
        if (numbers.length() == 0
                || numbers.replace("0", "").length() == 0
                || numbers.equals("1")) {
            return 0;
        }

        Set<Integer> permSet = new HashSet<Integer>();
        permutation("", numbers, permSet);

        int countPrime = 0;
        for (Integer num : permSet) {
            if (isPrime(num)) {
                countPrime++;
            }
        }

        return countPrime;
    }

    private boolean isPrime(int n) {
        if (n == 0 || n == 1) {
            return false;
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    private void permutation(String prefix, String str, Set<Integer> store) {
        if (!prefix.equals("")) {
            store.add(Integer.valueOf(prefix));
        }
        for (int i = 0; i < str.length(); i++) {
            permutation(prefix + str.charAt(i),
                    str.substring(0, i) + str.substring(i + 1),
                    store);
        }
    }

}
