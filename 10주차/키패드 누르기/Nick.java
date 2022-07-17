import java.util.HashMap;
import java.util.Map;

public class Nick {
    int nowLeftPosition = 10;
    int nowRightPosition = 12;

    public String solution(int[] numbers, String hand) {
        StringBuilder record = new StringBuilder();

        Map<Integer, int[]> keypadMap = new HashMap<>();
        keypadMap.put(1, new int[]{0, 0});
        keypadMap.put(2, new int[]{1, 0});
        keypadMap.put(3, new int[]{2, 0});
        keypadMap.put(4, new int[]{0, 1});
        keypadMap.put(5, new int[]{1, 1});
        keypadMap.put(6, new int[]{2, 1});
        keypadMap.put(7, new int[]{0, 2});
        keypadMap.put(8, new int[]{1, 2});
        keypadMap.put(9, new int[]{2, 2});
        keypadMap.put(10, new int[]{0, 3});
        keypadMap.put(0, new int[]{1, 3});
        keypadMap.put(12, new int[]{2, 3});

        for (int number : numbers) {
            switch (number) {
                case 1: case 4: case 7: keyPress("L", number, record); break;
                case 3: case 6: case 9: keyPress("R", number, record); break;
                default: {
                    int diffL = Math.abs(keypadMap.get(number)[0] - keypadMap.get(nowLeftPosition)[0])
                            + Math.abs(keypadMap.get(number)[1] - keypadMap.get(nowLeftPosition)[1]);
                    int diffR = Math.abs(keypadMap.get(number)[0] - keypadMap.get(nowRightPosition)[0])
                            + Math.abs(keypadMap.get(number)[1] - keypadMap.get(nowRightPosition)[1]);

                    if(diffL < diffR)
                        keyPress("L", number, record);
                    else if (diffR < diffL)
                        keyPress("R", number, record);
                    else // diffL == diffR
                        keyPress("left".equals(hand) ? "L" : "R", number, record);
                }
            }
        }

        return record.toString();
    }

    void keyPress(String pressHand, int pressNum, StringBuilder record) {
        record.append(pressHand);

        if ("L".equals(pressHand))
            this.nowLeftPosition = pressNum;
        else
            this.nowRightPosition = pressNum;
    }
}
