public class Nick {
    
    public String solution(String m, String[] musicinfos) {
        String result = "(None)";   // 반환값
        int longestRunningTime = 0; // 일치한 곡이 재생된 시간
        m = sharpToLower(m);        // 네오가 들은 멜로디

        for (int i = 0; i < musicinfos.length; i++) {
            String[] info = musicinfos[i].split(",");

            // 필요한 변수 만들기: 재생시간, 제목, 악보, 곡 길이, 재생된 악보
            int runningTime  = getRunningTime(info[0], info[1]);
            String title     = info[2];
            String notes     = sharpToLower(info[3]);
            int songTime     = notes.length();
            String playNotes = getPlayNotes(notes, runningTime, songTime);

            // 비교
            if (playNotes.contains(m)) {
                if ("(None)".equals(result)) { // 처음 일치하는 경우, 무조건 업데이트
                    result = title;
                    longestRunningTime = runningTime;
                }
                else { // 두번째 일치부터는, 재생된 시간이 더 길 경우에만 업데이트
                    if (longestRunningTime < runningTime) {
                        result = title;
                        longestRunningTime = runningTime;
                    }
                }
            }
        }

        return result;
    }

    String sharpToLower(String str) {
        str = str.replace("C#", "c");
        str = str.replace("D#", "d");
        str = str.replace("F#", "f");
        str = str.replace("G#", "g");
        str = str.replace("A#", "a");
        return str;
    }

    int getRunningTime(String time1, String time2) {
        String[] t1 = time1.split(":");
        String[] t2 = time2.split(":");
        int startTime = (Integer.parseInt(t1[0]) * 60) + Integer.parseInt(t1[1]);
        int endTime = (Integer.parseInt(t2[0]) * 60) + Integer.parseInt(t2[1]);
        return endTime - startTime;
    }

    String getPlayNotes(String notes, int runningTime, int songTime) {
        int playCount = runningTime / songTime;
        int remainNotesCount = runningTime % songTime;

        String tmp = "";
        for (int i = 0; i < playCount; i++) {
            tmp += notes;
        }
        tmp += notes.substring(0, remainNotesCount);

        return tmp;
    }

}
