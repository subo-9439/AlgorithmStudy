import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class prosecution {
    public int[] solution(String[] id_list, String[] report, int k) {
        // report의 중복 제거
        // Arraylist 생성 : 잘라낸 report의 배열을 담을
        // report를 "," 단위로 잘라 만든 리스트에 담는다
        // 리스트에는 report의 중복이 제거된, 각 유저가 신고한 ID가 담긴 배열이 담긴다
        // 각 유저의 신고횟수를 담을 INT 배열 생성(크기 = id_list) == cnt
        // 리스트를 순회하며, 각 리스트에 담긴 String 배열의 요소 == id_list 배열의 요소인 인덱스 저장
        // 해당 인덱스의 int 배열 요소를 증가시킨다.
        // 순회 끝 -> cnt에는 해당 유저가 신고당한 횟수가 저장되있다.
        // cnt를 순회하며, cnt >= k이면, 해당 인덱스를 가진 유저에 대해,
        // 리스트를 순회하여 해당 유저를 1번째 요소로 가진 리스트에 담긴 배열의 0번째가, 신고를 한 사람이므로
        // 그 유저와 동일한 이름을 가진 id 리스트의 인덱스에 해당하는 answer의 값을 1증가시킨다.
        // 순회 끝
        // 리턴 answer

        int[] answer = {};
        int index = 0;
        int[] cnt = new int[id_list.length];
        answer = new int[id_list.length];
        List<String[]> list = new ArrayList<>();
        List<String> id = Arrays.asList(id_list);

        String[] report2 = Arrays.stream(report).distinct().toArray(String[]::new);

        for(String val : report2){
            list.add(val.split(" "));
        }
        for(String[] arr : list){
            for (int i = 1; i < arr.length; i++) {
                if(id.contains(arr[i])) cnt[id.indexOf(arr[i])]++;
            }
        }

        for (int i = 0; i < cnt.length; i++) {
            if(cnt[i] >= k) {
                for(String[] arr2 : list) {
                    if (!arr2[1].equals(id_list[i])) {
                        continue;
                    }
                    answer[id.indexOf(arr2[0])]++;
                }
            }
        }
        return answer;
    }
}