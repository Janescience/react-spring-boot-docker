package com.example.demo.services.impls;

import java.util.regex.Pattern;
import org.springframework.stereotype.Service;
import com.example.demo.services.CountSmileyFacesService;

@Service
public class CountSmileyFacesServiceImpl implements CountSmileyFacesService{

    public int count(String[] faces){
        Pattern pt = Pattern.compile("[:;][-~]?[)D]");
        int count = 0;
        for (String face : faces) {
            if (face.matches(String.valueOf(pt))) {
                count++;
            }
        }
        return count;
    }
}
