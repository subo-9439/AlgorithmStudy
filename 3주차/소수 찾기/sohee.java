import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    static Set<Integer> set = new HashSet<>();
    
    void permulation(String input, String output, boolean[] visited, int limit){
        // 길이가 모두 채워지면 return
        if (output.length() == limit) {
            set.add(Integer.parseInt(output));
            return;
        }

        for (int i = 0; i < input.length(); i ++){
            if (!visited[i]){
                visited[i] = true; // 방문 처리
                permulation(input, output + input.charAt(i), visited, limit);
                visited[i] = false; // 방문 해제
            }
        }
    }
    
    public int solution(String numbers) {
        int answer = 0;

        // 주어진 numbers로 만들 수 있는 모든 경우의 수 구하기
        boolean[] visited = new boolean[numbers.length()];
        for (int i = 0; i < numbers.length(); i++){
            permulation(numbers, "", visited, i + 1);
        }

        // 소수 리스트 만들기
        boolean[] li = new boolean[set.stream().mapToInt(i -> i).max().getAsInt() + 1];
        Arrays.fill(li, false);

        for (int i = 2; i < li.length; i ++) {
            for (int j = 2; i * j < li.length; j++) {
                if (li[i * j] == false) {
                    li[i * j] = true;
                }
            }
        }

        // 만들 수 있는 숫자가 소수인지 확인하고 count 증가
        for (Integer num : set){
            if (num != 0 && num != 1 && li[num] == false) {
                answer += 1;
            }
        }

        return answer;
    }
}