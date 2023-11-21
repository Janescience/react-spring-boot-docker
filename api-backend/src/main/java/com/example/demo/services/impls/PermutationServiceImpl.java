package com.example.demo.services.impls;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;
import com.example.demo.services.PermutationService;

@Service
public class PermutationServiceImpl implements PermutationService {

    public Set<String> shufflings(String str) {
        Set<String> perm = new HashSet<>();

        if (str == null) {
            return Collections.emptySet();
        } else if (str.length() == 0) {
            perm.add("");
            return perm;
        }

        char initial = str.charAt(0); 

        String rem = str.substring(1); 
        Set<String> words = shufflings(rem);
        for (String strNew : words) {
            for (int i = 0;i<=strNew.length();i++){
                perm.add(charInsert(strNew, initial, i));
            }
        }
        return perm;
    }

    private String charInsert(String str, char c, int i) {
        String begin = str.substring(0, i);
        String end = str.substring(i);
        return begin + c + end;
    }
    

}
