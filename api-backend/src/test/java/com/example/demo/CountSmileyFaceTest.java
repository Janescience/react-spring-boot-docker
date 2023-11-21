package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.example.demo.services.impls.CountSmileyFacesServiceImpl;


public class CountSmileyFaceTest {

    private CountSmileyFacesServiceImpl countSmileyFacesService = new CountSmileyFacesServiceImpl();

    @Test
    public void testCountSmileyFaces() {

        // Test case 1
        String[] faces1 = {":)", ";(", ";}", ":-D"};
        int result1 = countSmileyFacesService.count(faces1);
        assertEquals(2, result1);

        // Test case 2
        String[] faces2 = {";D", ":-(", ":-)", ";~)"};
        int result2 = countSmileyFacesService.count(faces2);
        assertEquals(3, result2);

        // Test case 3
        String[] faces3 = {";]", ":[", ";*", ":$", ";-D"};
        int result3 = countSmileyFacesService.count(faces3);
        assertEquals(1, result3);

        // Test case 4
        String[] faces4 = {};
        int result4 = countSmileyFacesService.count(faces4);
        assertEquals(0, result4);

        // Test case 5
        String[] faces5 = {"xsd", "888", ":(", ":|"};
        int result5 = countSmileyFacesService.count(faces5);
        assertEquals(0, result5);

    }

}
