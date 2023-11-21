package com.example.demo.services.impls;

import org.springframework.stereotype.Service;

import com.example.demo.models.dto.FindOddIntDTO;
import com.example.demo.services.FindOddIntService;

@Service
public class FindOddIntServiceImpl implements FindOddIntService{

    public FindOddIntDTO find(int[] nums){
        FindOddIntDTO result = new FindOddIntDTO();
        for(int i = 0; i < nums.length; i++){
			int num = nums[i];
			int occurences = 0;
			for (int j = 0; j < nums.length; j++){
				if (nums[j] == num){
					occurences++;
				}
			}
            result.setOcc(occurences);
 
			if (occurences % 2 != 0){
				result.setNum(num);
                return result;
			}
		
		}
        return result;
    }
}
