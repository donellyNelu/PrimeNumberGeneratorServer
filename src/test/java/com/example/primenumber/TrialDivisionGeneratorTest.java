package com.example.primenumber;

import com.example.primenumber.Generators.TrialDivisionGenerator;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class TrialDivisionGeneratorTest {
    private TrialDivisionGenerator p = new TrialDivisionGenerator();

    /**
     * Tests for numbers between 1 and 20.
     * @throws Exception if there is an error
     */

    @Test
    @SuppressWarnings("Duplicates")
    public void generate() throws Exception {
        System.out.println("Test for numbers from 1 to 20");
        ArrayList<Integer> actual = p.generate(1, 20);
        List<Integer> expected = new ArrayList<>(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19));

        assertEquals(expected,actual);
    }

    /**
     * Tests for numbers between 2361 and 2533.
     * @throws Exception if there is an error
     */

    @Test
    @SuppressWarnings("Duplicates")
    public void generate2()throws Exception{
        System.out.println("Test for numbers from 2361 to 2533");
        ArrayList<Integer> actual = p.generate(2361, 2533);
        List<Integer> expected =  new ArrayList<>(Arrays.asList(2371, 2377, 2381, 2383, 2389, 2393, 2399, 2411, 2417, 2423, 2437, 2441, 2447, 2459, 2467, 2473, 2477, 2503, 2521, 2531));

        assertEquals(expected,actual);
    }

    /**
     * Tests for numbers between -10 and 10.
     * @throws Exception if there is an error
     */

    @Test
    @SuppressWarnings("Duplicates")
    public void generate3()throws Exception{
        System.out.println("Test for numbers from -10 to 10");
        ArrayList<Integer> actual = p.generate(-10,10);
        List<Integer> expected = new ArrayList<>(Arrays.asList(2, 3, 5, 7));

        assertEquals(expected,actual);
    }

    /**
     * Tests for numbers between -10 and 0.
     * @throws Exception if there is an error
     */

    @Test
    @SuppressWarnings("Duplicates")
    public void generate4()throws Exception{
        System.out.println("Test for numbers from -10 to 0");
        ArrayList<Integer> actual = p.generate(-20,0);
        List<Integer> expected = new ArrayList<>(Collections.emptyList());

        assertEquals(expected,actual);
    }

}
