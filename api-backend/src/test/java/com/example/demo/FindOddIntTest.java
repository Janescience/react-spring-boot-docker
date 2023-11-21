package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.example.demo.models.dto.FindOddIntDTO;
import com.example.demo.services.impls.FindOddIntServiceImpl;


class FindOddIntTest {

    private FindOddIntServiceImpl findOddIntService = new FindOddIntServiceImpl();

    @Test
    void testFindOddInt() {

        // Test case 1
        int[] numbers1 = {7};
        FindOddIntDTO result1 = findOddIntService.find(numbers1);
        assertEquals(7, result1.getNum());
        assertEquals(1, result1.getOcc());

        // Test case 2
        int[] numbers2 = {0};
        FindOddIntDTO result2 = findOddIntService.find(numbers2);
        assertEquals(0, result2.getNum());
        assertEquals(1, result2.getOcc());

        // Test case 3
        int[] numbers3 = {1,1,2};
        FindOddIntDTO result3 = findOddIntService.find(numbers3);
        assertEquals(2, result3.getNum());
        assertEquals(1, result3.getOcc());

        // Test case 4
        int[] numbers4 = {1,2,2,3,3,3,4,3,3,3,2,2,1};
        FindOddIntDTO result4 = findOddIntService.find(numbers4);
        assertEquals(4, result4.getNum());
        assertEquals(1, result4.getOcc());
    }

}
