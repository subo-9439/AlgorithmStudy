public class Nick {
    public static void main(String[] args) {
        Nick w = new Nick();
        System.out.println(w.solution("xababcdcdababcdcd"));
    }

    /*
    * 반복문을 겹겹이 돌아야할 것 같은 느낌이 든다. 어떤 반복문이 필요할 지 생각해보자.
    *   - 기준문자열의 길이를 늘려나가기 위한 loop / 원하는 길이의 범위는 1 ~ length()/2 / 1자씩 늘려나갈 것
    *   - 기준문자열을 이동하기 위한 loop        /  ? ~ length()                    / 기준문자열 길이만큼씩 늘려나갈 것
    *   - 비교문자열을 이동하기 위한 loop        /  ? ~ length()                    / 기준문자열 길이만큼씩 늘려나갈 것
    * */
    public int solution(String s) {
        int resultLength = s.length();

        for (int i = 1; i <= s.length() / 2; i++) { // 기준문자열의 길이를 늘려나가기 위한 loop
            int pos = 0; // (기준/비교)문자열의 시작 위치
            int compressLength = s.length();

            while (pos + i <= s.length()) { // 기준문자열을 이동하기 위한 loop
                String baseString = s.substring(pos, pos + i);

                int appear = 1; // 등장 횟수 (중복횟수 X)
                while (pos + i <= s.length()) { // 비교문자열을 이동하기 위한 loop
                    pos += i;
                    String compareString = pos + i <= s.length()
                            ? s.substring(pos, pos + i)
                            : null;

                    if (baseString.equals(compareString)) {
                        appear++;
                    } else {
                        if (1 < appear) {
                            compressLength -= i * appear;
                            compressLength += String.valueOf(appear).length(); // (int)Math.log10(appear) + 1
                            compressLength += baseString.length();
                        }
                        break;
                    }
                }

            }
            resultLength = Math.min(resultLength, compressLength);

        }

        return resultLength;
    }

}
/*
*  개선(변경)의 여지 :
*   1. 반복문 수를 줄이거나, 재귀로 변경할 수 있다.
*   2. compressLength의 값을 한 줄로 조작하거나,
*   3. 보기 좋게 리팩토링(따로 메서드로 뽑기) 할 수 있다.
* */





/* 실제로 압축된 문자열을 구하는 방법 */
class Solution {
    private int zippedNumber = 1;
    private StringBuilder zippedString;

    private boolean addZipNum(String cursor, String forwardCursor) {
        boolean tf = cursor.equals(forwardCursor);
        if (tf) zippedNumber += 1;
        return tf;
    }

    private void appendZipStr(String cursor) {
        if (zippedNumber == 1)
            zippedString.append(cursor);
        else
            zippedString.append(zippedNumber).append(cursor);
    }

    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        if (s.length() <= 2) return s.length();

        // 비교 기준이 되는 문자열을 커서, 비교할 대상이 되는 문자열을 포워드커서(i만큼 앞선 문자열)라고 부른다.
        // i : 반복할 커서의 길이. 한번의 대조가 끝날때마다 한 자리씩 늘린다.
        for (int i = 1; i <= s.length() / 2; i += 1) {
            zippedString = new StringBuilder();
            String cursor = s.substring(0, i); //최초 커서 초기화. 이후에는 내부 for문 속에서 갱신.
            String forwardCursor = null;

            // j : i개만큼씩 반복 비교하기 위해 문자열을 substring()할 때, slicing index를 담는 변수.
            int j = i;
            while (j <= s.length()) {

                if (j + i <= s.length()) {
                    forwardCursor = s.substring(j, j + i);

                    if (!addZipNum(cursor, forwardCursor)) {
                        appendZipStr(cursor);
                        this.zippedNumber = 1;
                        cursor = forwardCursor;
                    }
                }
                else {
                    appendZipStr(cursor);
                }

                j += i;
            }

            zippedString.append(s.substring(j - i));
            answer = answer > zippedString.length() ? zippedString.length() : answer;
        }

        return answer;
    }
}