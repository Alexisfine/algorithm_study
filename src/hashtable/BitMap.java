package hashtable;

public class BitMap {
    public static void main(String[] args) {
        int a = 0;
        int[] arr = new int[10]; // 32 bit * 10 = 320 bit

        int i = 178;
        int numIndex = i / 32;
        int bitIndex = i % 32;

        // get status for i-th position
        int s = ((arr[numIndex] >> (bitIndex)) & 1);

        // change i-th status to 1
        arr[numIndex] = arr[numIndex] | (1 << (bitIndex));

        // change i-th status to 0
        arr[numIndex] = arr[numIndex] & (~ (1 << (bitIndex)));
    }
}
