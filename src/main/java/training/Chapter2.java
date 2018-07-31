package training;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static java.lang.Math.sqrt;

/**
 * @author Arya Pishgah (pishgah@gamelectronics.com) 30/07/2018
 */
public class Chapter2 {

    private static final Logger LOG = LoggerFactory.getLogger(Chapter2.class);

    /*
    RandomizeArray(String: array[])
        Integer: max_i = <Upper bound of array>
        For i = 0 To max_i - 1
            // Pick the item for position i in the array.
            Integer: j = <pseudorandom number between i
            and max_i inclusive>
            <Swap the values of array[i] and array[j]>
            Next i
    End RandomizeArray
     */
    public static void randomizeArray(String[] array) {
        for (int i = 0; i < array.length; i++) {                                        // n
            int randomIndex = ThreadLocalRandom.current().nextInt(i, array.length);     // n
            String temp = array[i];                                                     // n
            array[i] = array[randomIndex];                                              // n
            array[randomIndex] = temp;                                                  // n
            LOG.trace("swapped index {} and index {}.", i, randomIndex);
        }

        // n + n + n + n + n = O(5n) ~ O(n)
    }

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
    public static int greatestCommonDivisorRecursiveVersion(int a, int b) {
        if (b == 0)
            return a;

        return greatestCommonDivisorRecursiveVersion(b, a % b);
        // Because the size of B decreases by a factor of at least 1/2 for every two iterations, the
        // algorithm runs in time at most O(log B)
    }

    /*
        // Calculate A to the power P.
        Float: RaiseToPower(Float: A, Integer: P)
             <Use the first fact to quickly calculate A, A2, A4, A8, and so on until you get to a value AN where N + 1 > P>
             <Use those powers of A and the second fact to calculate AP>
             Return AP
        End RaiseToPower
     */
    public static float raiseToPower(float a, int p) {
        float result = a;                       // 1
        int n = 1;                              // 1
        for (;n * 2 + 1 < p; n *= 2)            // log p
            result *= result;                   // log p

        int dif = p - n;                        // 1
        if (dif > 0)                            // 1
            result *= raiseToPower(a, dif);     // log dif

        return result;                          // 1
        // log p + log dif ~ O(log p)
    }

    /*
         List Of Integer: FindFactors(Integer: number)
             List Of Integer: factors
             Integer: i = 2
             While (i < number)
                 // Pull out factors of i.
                 While (number Mod i == 0)
                     // i is a factor. Add it to the list.
                     factors.Add(i)
                     // Divide the number by i.
                     number = number / i
                 End While
                 // Check the next possible factor.
                 i = i + 1
             End While
             // If there's anything left of the number, it is a factor, too.
             If (number > 1) Then factors.Add(number)
             Return factors
         End FindFactors
     */
    public static List<Integer> findFactors(int num) {
        List<Integer> factors = new ArrayList<>();  // 1
        for (int factor = 2; factor <= num;  factor++) {           // num
            for (; num % factor == 0; num /= factor)               // num * ?
                factors.add(factor);
        }

        return factors;
        // O(num)
    }

    /*
         List Of Integer: FindFactors(Integer: number)
             List Of Integer: factors
             // Pull out factors of 2.
             While (number Mod 2 == 0)
                 factors.Add(2)
                 number = number / 2
             End While
             // Look for odd factors.
             Integer: i = 3
             Integer: max_factor = Sqrt(number)
             While (i <= max_factor)
                 // Pull out factors of i.
                 While (number Mod i == 0)
                     // i is a factor. Add it to the list.
                     factors.Add(i)
                     // Divide the number by i.
                     number = number / i
                     // Set a new upper bound.
                     max_factor = Sqrt(number)
                End While
                 // Check the next possible odd factor.
                 i = i + 2
             End While
             // If there's anything left of the number, it is a factor, too.
             If (number > 1) Then factors.Add(number)
             Return factors
         End FindFactors
     */
    public static List<Integer> findFactorsV2(int num) {
        List<Integer> factors = new ArrayList<>();
        for (; num % 2 == 0; num /= 2)                                      // log num
            factors.add(2);                                                 // log num

        for (int factor = 3; factor <= sqrt(num); factor += 2) {       // sqrt num
            for (;num % factor == 0; num /= factor)                         // sqrt num * ?
                factors.add(factor);                                        // sqrt num * ?
        }

        if (num > 1)
            factors.add(num);

        return factors;
        // log num + srt num * ? ~ O(sqrt num)
    }

    /*
     // Find the primes between 2 and max_number (inclusive).
     List Of Integer: FindPrimes(long max_number)
         // Allocate an array for the numbers.
         Boolean: is_composite = new bool[max_number + 1]
         // "Cross out" multiples of 2.
         For i = 4 to max_number Step 2
            is_composite[i] = true
         Next i
         // "Cross out" multiples of primes found so far.
         Integer: next_prime = 3
         Integer: stop_at = Sqrt(max_number)
         While (next_prime < stop_at)
             // "Cross out" multiples of this prime.
             For i = next_prime * 2 To max_number Step next_prime Then
                is_composite[i] = true
             Next i
             // Move to the next prime, skipping the even numbers.
             next_prime = next_prime + 2
             While (next_prime <= max_number) And (is_composite[next_prime])
                next_prime = next_prime + 2
             End While
         End While
         // Copy the primes into a list.
         List Of Integer: primes
         For i = 2 to max_number
            If (Not is_composite[i]) Then primes.Add(i)
         Next i
         // Return the primes.
         Return primes
     End FindPrimes
     */
    public static List<Integer> findPrimes(long maxNumber) {
        boolean[] isComposite = new boolean[(int) (maxNumber + 1)];
        for (int evenNumbers = 4; evenNumbers < isComposite.length; evenNumbers += 2)
            isComposite[evenNumbers] = true;

        for (int nextPrime = 3; nextPrime < sqrt(maxNumber); ) {
            for (int i = nextPrime * 2; i < maxNumber; i += nextPrime)
                isComposite[i] = true;

            for (nextPrime += 2; nextPrime <= maxNumber && isComposite[nextPrime]; nextPrime += 2) {
                LOG.trace("jump {} we already crossed it from list.", nextPrime);
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i < maxNumber; i++) {
            if (!isComposite[i])
                primes.add(i);
        }
        return primes;
        // O(n * log(log n))
    }
}
