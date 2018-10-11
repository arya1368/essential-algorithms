package training.chapter4;

public class Chapter4 {

    /*
    Integer: IndexOf(Integer: array[], Integer: target)
        For i = 0 to array.Length - 1
            If (array[i] == target) Return i
            Next i
        // The target isn't in the array.
        Return -1
    End IndexOf
     */
    public static int indexOf(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {              // n
            if (arr[i] == target)                           // 1 * n
                return i;                                   // 1
        }
        return -1;                                          // 1
                                                            // O(n)
    }

    /*
    Integer: FindMinimum(Integer: array[])
        Integer: minimum = array[0]
        For i = 1 To array.Length - 1
            If (array[i] < minimum) Then minimum = array[i]
            Next i
        Return minimum
    End FindMinimum
     */
    public static int findMinimum(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {              // n
            if (arr[i] < min)
                min = arr[i];
        }
        return min;
                                                            // O(n)
    }

    /*
    Integer: FindMaximum(Integer: array[])
        Integer: maximum = array[0]
        For i = 1 To array.Length - 1
            If (array[i] > maximum) Then
            array[i]
            Next i
        Return maximum
    End FindMaximum
     */
    public static int findMaximum(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
        }
        return max;
                                                    // O(n)
    }

    /*
    Float: FindAverage(Integer: array[])
        Integer: total = 0
        For i = 0 To array.Length - 1
            total = total + array[i]
            Next i
        Return total / array.Length
    End FindMaximum
     */
    public static int findAverage(int[] arr) {
        int total = 0;
        for (int num : arr)
            total += num;

        return total / arr.length;
                                                    // O(n)
    }

    /*
    Integer: FindMedian(Integer: array[])
        For i = 0 To array.Length - 1
            // Find the number of values greater than and
            less than array[i].
            Integer: num_larger = 0
            Integer: num_smaller = 0
            For j = 0 To array.Length - 1
                If (array[j] < array[i]) Then num_smaller
                    = num_smaller + 1
                If (array[j] > array[i]) Then num_larger
                    = num_larger + 1
                Next j
            If (num_smaller = num_larger) Then
            Return array[i]
            End If
            Next i
    End FindMedian
     */
    public static int findMedian(int[] arr) {
        for (int test : arr) {                                          // n
            int largerCounter = 0;                                      // n
            int smallerCounter = 0;                                     // n
            for (int num : arr) {                                       // n * n
                if (test > num)                                         // n * n
                    largerCounter++;                                    // n * n
                else if (test < num)                                    // n * n
                    smallerCounter++;                                   // n * n
            }
            if (largerCounter == smallerCounter)                        // n
                return test;                                            // 1
        }
        throw new RuntimeException("couldn't find median.");
                                                                        // O(n^2)
    }
}
