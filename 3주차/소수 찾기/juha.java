import java.util.ArrayList;
import java.util.HashSet;
import java.util.OptionalInt;
import java.util.stream.Collectors;

class Solution {
    HashSet<Integer> set;
    public int solution(String numbers) {
        char[] num_array = numbers.toCharArray();
        int[] output = new int[num_array.length];
        boolean[] visited = new boolean[num_array.length];
        set = new HashSet<>();
        for(int i = 1; i<= num_array.length; i++){
            permutation(num_array, output, visited, 0, num_array.length, i);
        }
        return find_prime_count_in_set();
    }

    private int find_prime_count_in_set() {
        ArrayList<Integer> list = (ArrayList<Integer>) set.stream().collect(Collectors.toList());
        boolean[] arr = set_prime(list.stream().mapToInt(Integer::intValue).max().getAsInt());
        int cnt = 0;
        for(int i : list){
            if(!arr[i])
                cnt++;
        }
        return cnt;
    }

    private boolean[] set_prime(int n) {
        boolean[] prime = new boolean[n+1];
        prime[0] = true;
        prime[1] = true;
        for(int j = 2; j<=Math.sqrt(n); j++){
            if(prime[j])
                continue;
            for(int k = j*j; k<prime.length; k+=j){
                prime[k] = true;
            }
        }
        return prime;
    }

    private void permutation(char[] num_array, int[] output, boolean[] visited, int depth, int n, int r) {
        if(depth==r){
            add_set(output,r);
            return;
        }
        for(int i = 0; i<n; i++){
            if(!visited[i]){
                visited[i] = true;
                output[depth] = Character.getNumericValue(num_array[i]);
                permutation(num_array, output, visited, depth+1, n, r);
                visited[i] = false;
            }
        }
    }

    private void add_set(int[] output, int r) {
        String s = "";
        for(int i = 0; i<r; i++){
            s += output[i];
        }
        set.add(Integer.valueOf(s));
    }

}