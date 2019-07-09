package com.example.primenumber.Generators;

import com.example.primenumber.Interface.PrimeNumberGeneratorInterface;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;

//Runs in O(k × log^2(n) × log log n × log log log n)
public class MillerRabinGenerator implements PrimeNumberGeneratorInterface {
    private static final int MAX_ITERATIONS = 20;
    private Random rand = new Random();


    @Override
    @SuppressWarnings("Duplicates")
    public ArrayList<Integer> generate(int lowerLimit, int upperLimit) {
        ArrayList<Integer> result = new ArrayList<>();
        // change start to 2 if it is less than 2.
        lowerLimit = lowerLimit < 2 ? 2 : lowerLimit;
        // if it is a range such as (-100, 1), return empty list
        if (upperLimit < lowerLimit) return result;

        for (int i = lowerLimit; i <= upperLimit; i++) {
            if (isPrime(i)) result.add(i);
        }

        return result;

    }


    /**
     * Check number's primality.
     *
     * @param number to test for primality
     * @return if number is prime or not
     */

    //check number's primality
    private boolean isPrime(int number) {
        if (number < 2) return false;
        if (number == 2 || number == 3) return true;
        // return false for even numbers
        if (number % 2 == 0) return false;

        return millerRabinCheck(number);
    }

    // put number for miller rabin check
    private boolean millerRabinCheck(int number) {

        //replace r with p
        // write number as num - 1 = (2^p)*q
        int p = 0;
        int q = number - 1;

        while (q % 2 == 0) {
            p += 1;
            q /= 2;
        }

        OuterLoop:
        for (int k = 0; k < MAX_ITERATIONS; k++) {
            int a = generateRandomNumberForTest(number);

            // calculate a^d mod num
            BigInteger xBig = BigInteger.valueOf(a).modPow(BigInteger.valueOf(q), BigInteger.valueOf(number));
            int x = xBig.intValue();

            if (x == 1 || x == number - 1)
                continue;

            for (int iterNum = 0; iterNum < p - 1; iterNum++) {
                x = (int) (Math.pow(x, 2) % number);

                if (x == 1)
                    return false;
                if (x == number - 1)
                    continue OuterLoop;
            }

            return false;
        }

        return true;
    }

    //Generate a random number in range [2, num - 2]
    //return random integer between 2 and num - 2.
    private int generateRandomNumberForTest(int number) {
        return rand.nextInt((number - 2) + 1 - 2) + 2;
    }

}

