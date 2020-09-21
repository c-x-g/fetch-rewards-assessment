package com.example.fetchrewardsassessment.service;

import org.springframework.stereotype.Service;

@Service
public class CompareVersionService {

    public String compareVersion(String version1, String version2) {

        if (!version1.matches("[0-9\\.]*") || !version2.matches("[0-9\\.]*"))
            return "Version1 or Version2 or both are badly formatted!\n";

        String[] v1 = version1.split("\\."),
                v2 = version2.split("\\.");

        int num1 = 0, num2 = 0;
        for(int i = 0; i < Math.max(v1.length, v2.length); i++) {
            num1 = 0;
            num2 = 0;

            if (i < v1.length)
                for (char c: v1[i].toCharArray())
                    num1 = num1*10 + (c-'0');


            if (i < v2.length)
                for (char c: v2[i].toCharArray())
                    num2 = num2*10 + (c-'0');

            if (num1 < num2) return "before";
            if (num1 > num2) return "after";
        }

        return num1 == num2 ? "equal" : (num1 > num2 ? "after" : "before");

    }


}
