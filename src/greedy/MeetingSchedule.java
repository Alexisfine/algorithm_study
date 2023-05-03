package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingSchedule {
    public static class Meeting {
        public int start;
        public int end;
        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static class MeetingComparator implements Comparator<Meeting> {
        @Override
        public int compare(Meeting o1, Meeting o2) {
            return o1.end - o2.end;
        }
    }

    public static int bestArrange(Meeting[] meetings, int timePoint) {
        Arrays.sort(meetings, new MeetingComparator());
        int result = 0;
        for (int i = 0; i < meetings.length; i++) {
            if (timePoint < meetings[i].start) {
                result++;
                timePoint = meetings[i].end;
            }
        }
        return result;
    }
}
