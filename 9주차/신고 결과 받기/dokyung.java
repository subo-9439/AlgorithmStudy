import java.util.*;

class Solution {
    public  int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        Map<String, HashSet<String>> map = new HashMap<>();

        Map<String, Integer> idxMap = new HashMap<>();

        for (int i = 0; i < id_list.length; i++) {
            String name = id_list[i];
            map.put(name, new HashSet<>());
            //인덱스 저장
            idxMap.put(name, i);
        }
        // 신고정보 나눠 저장
        for (String s : report) {
            String[] str = s.split(" ");
            String from = str[0];
            String to = str[1];
            map.get(to).add(from);
        }

        for (int i = 0; i < id_list.length; i++) {
            //해시셋 가져와서
            HashSet<String> send = map.get(id_list[i]);
            //신고대상이면
            if (send.size() >= k) {
                //숫자 증가시키기
                for (String name : send) {
                    answer[idxMap.get(name)]++;
                }
            }
        }
        return answer;

        /** 실패한 나의 시도
        // 이용자 아이디와
        // "신고자 신고대상"이 담긴 리스트와
        // 정지기준 신고횟수 가 주어진다.

        // 바로 드는 생각은 맵을 활용하는 것
        // 각 id가 Key, 신고당한 횟수가 Value가 되면 계산하기 쉬워진다
        // 단 같은 아이디가 여러번 같은 신고를 한 것은 빼야한다. 이걸 미리 뺀다면?

        // 분류된 배열
        String[] distinctReport = Arrays.stream(report).distinct().toArray(String[]::new);

        Map<String,Integer> counts = new HashMap<>();

        for (String name : id_list) {
            counts.put(name,0);
        }

        Arrays.stream(distinctReport)
                .map(m-> counts.replace(m.split(" ")[1],counts.get(m.split(" ")[1])+1))
                .toArray();

        ArrayList<String> criminal = new ArrayList<>();

        // 결과값은 각 사람이 받은 신고횟수가 아니라
        // 각 사람이 신고해서 정지를 받은 사람의 수

        // 그래서 현재 맵에 들어가있는 숫자는 각 사람이 신고받은 횟수니 거의 다 온거임

        // 그러니까 이제 신고받은 사람을 언급한 사람의 카운트를 올려주면 된다.

        for (String s : counts.keySet()) {
            if(counts.get(s)>=k){
                criminal.add(s);
            }
        }

        int[] answer = new int[id_list.length];

        // 지금까지 계산한것
        // 1. 정지 대상

        // 해야할 것
        // 정지 대상을 지목한 사람의 카운트를 올린다.

        Map<String,String> answerMap = new HashMap<>();

        for (String name : id_list) {
            answerMap.put(name,);
        }

        return answer;
        **/
    }
}
