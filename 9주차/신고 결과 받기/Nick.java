package mogacko.week9;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
id_list: 유저 리스트 (2 ~ 1000)
report: "제보자 피신고자" 배열 (1 ~ 200,000)
k: 이용정지 기준 횟수 (1 ~ 200)
return - int[] mailingList: 회원 별 신고회원 정지 알림 메일 받는 횟수 배열
---
제한 사항:
- 중복 X
*/
public class Week9_3 {

    public int[] solution(String[] id_list, String[] report, int k) {
        // 중복 없애기
        // 신고처리
        // 메일받을사람 처리

        Map<String, Integer> reportCountMap = new HashMap<>();
        int[] mailingList = new int[id_list.length]; //

        Arrays.stream(report)
                .distinct() // 1. 중복 없애기
                .forEach(rpt -> {
                    String[] r = rpt.split(" ");
                    reportCountMap.put(r[1], reportCountMap.getOrDefault(r[1], 0) + 1); // 2. 신고처리
                });

        // 3. 메일받을사람 처리
        for (String rpt : report) {
            String[] r = rpt.split(" ");

            Integer reportCount = reportCountMap.get(r[1]);
            if (k <= reportCount) {
                mailingProcess(id_list, mailingList, r[0]);
            }
        }

        return mailingList;
    }

    private void mailingProcess(String[] id_list, int[] mailingList, String reporter) {
        for (int i = 0; i < id_list.length; i++) {
            if (id_list[i].equals(reporter)) {
                mailingList[i]++;
            }
        }
    }

}
