package training;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Arya Pishgah (pishgah@gamelectronics.com) 23/07/2018
 */
public class Chapter1 {

    private static final Logger LOG = LoggerFactory.getLogger(Chapter1.class);

    /*
        // Find the greatest common divisor of a and b.
        // GCD(a, b) = GCD(b, a Mod b).
        Integer: Gcd(Integer: a, Integer: b)
            While (b != 0)
                // Calculate the remainder.
                Integer: remainder = a Mod b
                // Calculate GCD(b, remainder).
                a = b
                b = remainder
            End While
            // GCD(a, 0) is a.
            Return a
        End Gcd
     */
    public static int greatestCommonDivisor(int a, int b) {
        while (b != 0) {
            int reminder = a % b;
            LOG.info("{} mod {} is {}", a, b, reminder);
            a = b;
            b = reminder;
        }
        return a;
    }

    /*
    Integer: FindLargest(Integer: array[])
        Integer: largest = array[0]
        For i = 1 To <largest index>
            If (array[i] > largest) Then largest =
                array[i]
            Next i
        Return largest
    End FindLargest
     */
    public static int findLargest(int[] array) {
        int largest = array[0];                                         // O(1)
        for (int num : array) {                                         // O(n)
            if (num > largest) {                                        // O(1) * O(n)
                LOG.info("{} is larger than {}", num , largest);
                largest = num;                                          // O(1) * O(n)
            }
        }
        return largest;                                                 // O(1)
        // O(1) + O(n) + O(n) + O(n) + O(1) = O(2 + 3n) ~ O(n)
    }

    /*
    Boolean: ContainsDuplicates(Integer: array[])
        // Loop over all of the array's items.
        For i = 0 To <largest index>
            For j = 0 To <largest index>
                // See if these two items are duplicates.
                If (i != j) Then
                    If (array[i] == array[j]) Then
                        Return True
                End If
                Next j
            Next i
        // If we get to this point, there are no duplicates.
        Return False
    End ContainsDuplicates
     */
    public static boolean isContainsDuplicates(int[] array) {
        for (int i = 0; i < array.length; i++) {                            // O(n)
            for (int j = 0; j < array.length; j++)                          // O(n) * O(n)
                if (i != j && array[i] == array[j]) {                       // O(1) * O(n) * O(n)
                    LOG.info("{}(index {}) and {}(index {}) are equal"
                            , array[i], i, array[j], j);
                    return true;                                            // O(1) * O(n) * O(n)
                }
        }
        return false;                                                       // O(1)
        // O(n) + O(n.n) + O(n.n) + O(n.n) + O(1) = O(n + 3n.n + 1) ~ O(n.n)
    }

    /*
    Boolean: ContainsDuplicates(Integer: array[])
        // Loop over all of the array's items except the last one.
        For i = 0 To <largest index> - 1
            // Loop over the items after item i.
            For j = i + 1 To <largest index>
            // See if these two items are duplicates.
                If (array[i] == array[j]) Then
                    Return True
                Next j
            Next i
        // If we get to this point, there are no duplicates.
        Return False
    End ContainsDuplicates
     */
    public static boolean isContainsDuplicatesV2(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {                        // O(n - 1)
            for (int j = i + 1; j < array.length; j++)                      // O(n - 1) * O(n - 1)
                if (array[i] == array[j]) {                                 // O(n - 1) * O(n - 1) + O(1)
                    LOG.info("{}(index {}) and {}(index {}) are equal"
                            , array[i], i, array[j], j);
                    return true;                                            // O(n - 1) * O(n - 1) + O(1)
                }
        }
        return false;                                                       // O(1)
        // O(n - 1) * O(n - 1) + O(1) = 2 * O(n - 1) + O(1) ~ O(n)
    }
}
