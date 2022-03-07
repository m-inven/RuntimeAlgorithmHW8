package tcss321;

import java.util.Random; // Used to fill int array with random numbers.

public class Main {

    public static void main(String[] args) {
        Random rdm = new Random();

        /* Create an array filled with random integers between -1000000
        and 1000000. (Note: number of element varies.) Print how long it takes
        for rangeV1, rangeV2, and rangeV3 to execute on the array.
         */
        int[] numArray1 = rdm.ints(1_000, -1_000_000,1_000_000).toArray();
        printRuntimeOfRangeV1(numArray1);
        printRuntimeOfRangeV2(numArray1);
        printRuntimeOfRangeV3(numArray1);

        numArray1 = rdm.ints(2_000, -1_000_000,1_000_000).toArray();
        printRuntimeOfRangeV1(numArray1);
        printRuntimeOfRangeV2(numArray1);
        printRuntimeOfRangeV3(numArray1);

        numArray1 = rdm.ints(4_000, -1_000_000,1_000_000).toArray();
        printRuntimeOfRangeV1(numArray1);
        printRuntimeOfRangeV2(numArray1);
        printRuntimeOfRangeV3(numArray1);

        numArray1 = rdm.ints(8_000, -1_000_000,1_000_000).toArray();
        printRuntimeOfRangeV1(numArray1);
        printRuntimeOfRangeV2(numArray1);
        printRuntimeOfRangeV3(numArray1);

        numArray1 = rdm.ints(16_000, -1_000_000,1_000_000).toArray();
        printRuntimeOfRangeV1(numArray1);
        printRuntimeOfRangeV2(numArray1);
        printRuntimeOfRangeV3(numArray1);

        numArray1 = rdm.ints(32_000, -1_000_000,1_000_000).toArray();
        printRuntimeOfRangeV1(numArray1);
        printRuntimeOfRangeV2(numArray1);
        printRuntimeOfRangeV3(numArray1);

        numArray1 = rdm.ints(64_000, -1_000_000,1_000_000).toArray();
        printRuntimeOfRangeV1(numArray1);
        printRuntimeOfRangeV2(numArray1);
        printRuntimeOfRangeV3(numArray1);

        numArray1 = rdm.ints(128_000, -1_000_000,1_000_000).toArray();
        printRuntimeOfRangeV3(numArray1);

        numArray1 = rdm.ints(256_000, -1_000_000,1_000_000).toArray();
        printRuntimeOfRangeV3(numArray1);

        numArray1 = rdm.ints(512_000, -1_000_000,1_000_000).toArray();
        printRuntimeOfRangeV3(numArray1);

        numArray1 = rdm.ints(1_000_000, -1_000_000,1_000_000).toArray();
        printRuntimeOfRangeV3(numArray1);

        numArray1 = rdm.ints(2_000_000, -1_000_000,1_000_000).toArray();
        printRuntimeOfRangeV3(numArray1);

        numArray1 = rdm.ints(4_000_000, -1_000_000,1_000_000).toArray();
        printRuntimeOfRangeV3(numArray1);

        numArray1 = rdm.ints(8_000_000, -1_000_000,1_000_000).toArray();
        printRuntimeOfRangeV3(numArray1);

        numArray1 = rdm.ints(16_700_000, -1_000_000,1_000_000).toArray();
        printRuntimeOfRangeV3(numArray1);

        numArray1 = rdm.ints(33_000_000, -1_000_000,1_000_000).toArray();
        printRuntimeOfRangeV3(numArray1);

        numArray1 = rdm.ints(65_000_000, -1_000_000,1_000_000).toArray();
        printRuntimeOfRangeV3(numArray1);

        numArray1 = rdm.ints(130_000_000, -1_000_000,1_000_000).toArray();
        printRuntimeOfRangeV3(numArray1);

        numArray1 = rdm.ints(260_000_000, -1_000_000,1_000_000).toArray();
        printRuntimeOfRangeV3(numArray1);
    }

    // Returns the range of values in the given array (slowest).
    public static int rangeV1(int[] numbers) {
        int maxDiff = 0;     // look at each pair of values
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                int diff = Math.abs(numbers[j] - numbers[i]);
                if (diff > maxDiff) {
                    maxDiff = diff;
                }
            }
        }
        return maxDiff;
    }

    // Returns the range of values in the given array.
    public static int rangeV2(int[] numbers) {
        int maxDiff = 0;     // look at each pair of values
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int diff = Math.abs(numbers[j] - numbers[i]);
                if (diff > maxDiff) {
                    maxDiff = diff;
                }
            }
        }
        return maxDiff;
    }

    // Returns the range of values in the given array (fastest).
    public static int rangeV3(int[] numbers) {
        int max = numbers[0];     // find max/min values
        int min = max;
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        return max - min;
    }

    // Run rangeV1 on the given array. Measure its runtime in milliseconds and print.
    public static void printRuntimeOfRangeV1(int[] numbers){
        long startTime = System.currentTimeMillis();
        rangeV1(numbers);
        long endTime = System.currentTimeMillis();
        System.out.println("rangeV1 with array of size " + numbers.length + " took " +
                (endTime - startTime) + " milliseconds.");
    }

    // Run rangeV2 on the given array. Measure its runtime in milliseconds and print.
    public static void printRuntimeOfRangeV2(int[] numbers){
        long startTime = System.currentTimeMillis();
        rangeV2(numbers);
        long endTime = System.currentTimeMillis();
        System.out.println("rangeV2 with array of size " + numbers.length + " took " +
                (endTime - startTime) + " milliseconds.");
    }

    // Run rangeV3 on the given array. Measure its runtime in milliseconds and print.
    public static void printRuntimeOfRangeV3(int[] numbers){
        long startTime = System.currentTimeMillis();
        rangeV3(numbers);
        long endTime = System.currentTimeMillis();
        System.out.println("rangeV3 with array of size " + numbers.length + " took " +
                (endTime - startTime) + " milliseconds.\n");
    }

}
