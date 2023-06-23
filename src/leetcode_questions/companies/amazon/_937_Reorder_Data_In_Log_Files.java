package leetcode_questions.companies.amazon;

import java.util.*;

public class _937_Reorder_Data_In_Log_Files {
    private record Info(boolean isDigitLog, String header, String content){ }
    Map<String, Info> isDigitLog;
    FileComparator fileComparator;
    public String[] reorderLogFiles(String[] logs) {
        this.isDigitLog = new HashMap<>();
        this.fileComparator = new FileComparator();
        for (int i = 0; i < logs.length; i++) {
            int N = logs[i].length();
            if (Character.isDigit(logs[i].charAt(N - 1))) {
                isDigitLog.put(logs[i], new Info(true, null, null));
            } else {
                String[] strArr = logs[i].split(" ", 2);
                isDigitLog.put(logs[i], new Info(false, strArr[0], strArr[1]));
            }
        }
        sort(logs, 0, logs.length - 1);
        return logs;
    }

    private void sort(String[] arr, int lo, int hi) {
        if (hi == lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(arr, lo, mid);
        sort(arr, mid + 1, hi);
        merge(arr, lo, mid, mid + 1, hi);
    }

    private void merge(String[] arr, int leftPtr, int leftEnd, int rightPtr, int rightEnd) {
        String[] aux = new String[arr.length];
        for (int i = leftPtr; i <= rightEnd; i++) {
            aux[i] = arr[i];
        }
        for (int i = leftPtr; i <= rightEnd; i++) {
            if (leftPtr > leftEnd) {
                arr[i] = aux[rightPtr++];
            } else if (rightPtr > rightEnd) {
                arr[i] = aux[leftPtr++];
            } else if (fileComparator.compare(aux[leftPtr], aux[rightPtr]) <= 0) {
                arr[i] = aux[leftPtr++];
            } else {
                arr[i] = aux[rightPtr++];
            }
        }
    }

    private class FileComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            Info o1Info = isDigitLog.get(o1);
            Info o2Info = isDigitLog.get(o2);
            boolean o1IsDigitLog = o1Info.isDigitLog;
            boolean o2IsDigitLog = o2Info.isDigitLog;
            if (o1IsDigitLog && !o2IsDigitLog) {
                return 1;
            }
            if (o2IsDigitLog && !o1IsDigitLog) {
                return -1;
            }
            if (o1IsDigitLog && o2IsDigitLog) {
                return -1;
            }
            int res = o1Info.content.compareTo(o2Info.content);
            if (res != 0) return res;
            return o1Info.header.compareTo(o2Info.header);
        }
    }
}
