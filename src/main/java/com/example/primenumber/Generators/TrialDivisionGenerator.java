package com.example.primenumber.Generators;

import com.example.primenumber.Interface.PrimeNumberGeneratorInterface;

import java.util.ArrayList;

/**
 * A prime number generation algorithm working in O(n*log(n)).
 * Checks if numbers between limits are prime by dividing it by
 * integers up to half of those numbers.
 */
public class TrialDivisionGenerator implements PrimeNumberGeneratorInterface {

    @Override
    @SuppressWarnings("Duplicates")
    public ArrayList<Integer> generate(int lowerLimit, int upperLimit) {
        ArrayList<Integer> result = new ArrayList<>();

        // change lower limit to 2 if is less than 2.
        lowerLimit = lowerLimit < 2 ? 2 : lowerLimit;

        // if it is a range such as (-100, 1), return empty list
        if (upperLimit < lowerLimit) return result;

        // loop continues so long as lower limit less or equal to the upper limit...
        for (int i = lowerLimit; i <= upperLimit; i++) {
            if (isPrime(i)) result.add(i);
        }

        return result;
    }

    //checks if the number is prime..
    private boolean isPrime(int num) {
        int upperBoundary = findUpperBoundary(num);

        if (num < 2) return false;

        // divide the number we want to check the primality by the numbers <= its square root starting from 2
        for (int i = 2; i <= upperBoundary; i++) {
            if (num % i == 0) return false;
        }

        return true;
    }

    // this method returns the square root of the provided number...
    private int findUpperBoundary(int num) {
        return (int) Math.sqrt(num);
    }


}

