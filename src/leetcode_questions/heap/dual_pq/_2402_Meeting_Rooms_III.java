package leetcode_questions.heap.dual_pq;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.PriorityQueue;

public class _2402_Meeting_Rooms_III {
    public record Pair(long availableTime, int room) {}
    public int mostBooked(int n, int[][] meetings) {
        PriorityQueue<Integer> freeRooms = new PriorityQueue<>();
        PriorityQueue<Pair> busyRooms = new PriorityQueue<>((a, b) -> Long.compare(a.availableTime, b.availableTime));
        long[] roomCount = new long[n];

        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        for (int i = 0; i < n; i++) {
            freeRooms.offer(i);
        }

        for (int i = 0; i < meetings.length; i++) {
            long start = meetings[i][0];
            long end = meetings[i][1];
            while (!busyRooms.isEmpty() && busyRooms.peek().availableTime <= start) {
                freeRooms.offer(busyRooms.peek().room);
                busyRooms.poll();
            }
            if (!freeRooms.isEmpty()) {
                int room = freeRooms.poll();
                roomCount[room]++;
                busyRooms.offer(new Pair(end, room));
            } else {
                var nextRoom = busyRooms.poll();
                roomCount[nextRoom.room]++;
                busyRooms.offer(new Pair( nextRoom.availableTime + (end - start), nextRoom.room));
            }
        }
        int maxRoomIndex = 0;
        long maxRoom = 0;
        for (int i = 0; i < n; i++) {
            if (maxRoom < roomCount[i]) {
                maxRoom = roomCount[i];
                maxRoomIndex = i;
            }
            System.out.println(roomCount[i]);
        }
        return maxRoomIndex;
    }

    /*
    public int mostBooked2(int n, int[][] meetings) {
        PriorityQueue<Integer> freeRooms = new PriorityQueue<>();
        PriorityQueue<Pair> busyRooms = new PriorityQueue<>((a, b) -> a.availableTime.compareTo(b.availableTime));
        long[] roomCount = new long[n];

        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        for (int i = 0; i < n; i++) {
            freeRooms.offer(i);
        }

        for (int i = 0; i < meetings.length; i++) {
            long start = meetings[i][0];
            long end = meetings[i][1];
            while (!busyRooms.isEmpty() && busyRooms.peek().availableTime.compareTo(BigInteger.valueOf(start)) <= 0) {
                freeRooms.offer(busyRooms.peek().room);
                busyRooms.poll();
            }
            if (!freeRooms.isEmpty()) {
                int room = freeRooms.poll();
                roomCount[room]++;
                busyRooms.offer(new Pair(BigInteger.valueOf(end), room));
            } else {
                var nextRoom = busyRooms.poll();
                roomCount[nextRoom.room]++;
                BigInteger nextEnd = nextRoom.availableTime.add(BigInteger.valueOf(end - start));

                busyRooms.offer(new Pair( nextEnd, nextRoom.room));
            }
        }
        int maxRoomIndex = 0;
        long maxRoom = 0;
        for (int i = 0; i < n; i++) {
            if (maxRoom < roomCount[i]) {
                maxRoom = roomCount[i];
                maxRoomIndex = i;
            }
            System.out.println(roomCount[i]);
        }
        return maxRoomIndex;
    }

     */
}
