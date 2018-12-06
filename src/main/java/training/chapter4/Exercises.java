package training.chapter4;

public class Exercises {

    public static double variance(int[] arr) {
        double ave = average(arr);
        double variance = 0;
        for (int a : arr)
            variance += Math.pow(a - ave, 2);

        return variance / (arr.length - 1);
    }

    public static double average(int[] arr) {
        double total = 0;
        for (int a : arr)
            total += a;

        return total / arr.length;
    }

    public static double deviation(int[] arr) {
        return Math.sqrt(variance(arr));
    }

    public static double findMedianInSortedArray(int[] sorted) {
        int mid = sorted.length / 2;
        if (sorted.length % 2 == 0)
            return (sorted[mid] + sorted[mid + 1]) / 2;

        return sorted[mid];
    }

}
