package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import com.example.demo.services.impls.PermutationServiceImpl;


class PermutationTest {

    private PermutationServiceImpl permutationService = new PermutationServiceImpl();

    @Test
    void testShufflings() {

        
        // Test case 2: String with one character
        String input1 = "a";
        Set<String> result1 = permutationService.shufflings(input1);
        Set<String> expect1 = new HashSet<String>();
        expect1.add("a");
        assertEquals(expect1, result1);

        // Test case 2: String with one character
        String input2 = "ab";
        Set<String> result2 = permutationService.shufflings(input2);
        Set<String> expect2 = new HashSet<String>();
        expect2.add("ab");
        expect2.add("ba");
        assertEquals(expect2, result2);

        // Test case 3: String with distinct characters
        String input3 = "abc";
        Set<String> result3 = permutationService.shufflings(input3);
        Set<String> expect3 = new HashSet<String>();
        expect3.add("bca");
        expect3.add("acb");
        expect3.add("abc");
        expect3.add("cba");
        expect3.add("bac");
        expect3.add("cab");
        assertEquals(expect3, result3);

        // Test case 4: String with repeated characters
        String input4 = "aabb";
        Set<String> result4 = permutationService.shufflings(input4);
        Set<String> expect4 = new HashSet<String>();
        expect4.add("baba");
        expect4.add("aabb");
        expect4.add("abba");
        expect4.add("bbaa");
        expect4.add("baab");
        expect4.add("abab");
        assertEquals(expect4, result4);


        // Test case 5: Empty string
        String input5 = "";
        Set<String> result5 = permutationService.shufflings(input5);
        Set<String> expect5 = new HashSet<String>();
        expect5.add("");
        assertEquals(expect5, result5);
    }

}
